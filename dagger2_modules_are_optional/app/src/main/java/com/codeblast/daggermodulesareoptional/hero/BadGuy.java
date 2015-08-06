package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;
import com.codeblast.daggermodulesareoptional.util.RandomNumberSupplier;

public class BadGuy {

    private static int sNumber = 1;

    private final int mId;

    private int mStrength;

    public BadGuy(RandomNumberSupplier random) {
        mStrength = 8 + random.nextInt(8);
        mId = sNumber++;
    }

    public void takeHit(SuperPower attack) {
        mStrength -= attack.attackDamage();
    }

    public String getName() {
        return "Bad Guy #" + mId;
    }

    public boolean isDead() {
        return mStrength <= 0;
    }
}
