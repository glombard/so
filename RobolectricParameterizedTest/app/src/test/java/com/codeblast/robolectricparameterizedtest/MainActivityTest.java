package com.codeblast.robolectricparameterizedtest;

import android.graphics.RectF;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.ParameterizedRobolectricTestRunner;

import java.util.Arrays;
import java.util.Collection;

import static org.junit.Assert.assertEquals;

@RunWith(ParameterizedRobolectricTestRunner.class)
public class MainActivityTest {

    private RectF mRect;

    // This results in:
    //   java.lang.IllegalArgumentException: argument type mismatch
    //
    // See: https://github.com/robolectric/robolectric/issues/871
    public MainActivityTest(RectF rect) {
        mRect = rect;
    }

    @ParameterizedRobolectricTestRunner.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{
                {new RectF(1f, 1f, 1f, 1f)}
        });
    }

    @Test
    public void testRect() {
        assertEquals(1f, mRect.top, 0.001);
    }
}
