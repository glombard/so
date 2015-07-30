package com.codeblast.daggeruserscope;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import javax.inject.Inject;

// see: Dagger v2: Inject 2 different scopes into one object - http://stackoverflow.com/questions/29037821/

public class MainActivity extends AppCompatActivity {

    @Inject
    Bus bus;

    @Inject
    UserManager userManager;

    private ComponentA mComponentA;

    private ComponentB mComponentB;

    private User mUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mUser = new User();

        getComponentA().inject(this); // Note: it isn't actually necessary to inject both components...
        getComponentB().inject(this);

        if (bus == null || userManager == null) {
            throw new IllegalStateException("members not injected correctly?");
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public ComponentA getComponentA() {
        if (mComponentA == null) {
            mComponentA = DaggerComponentA.create();
        }
        return mComponentA;
    }

    public ComponentB getComponentB() {
        if (mComponentB == null) {
            mComponentB = DaggerComponentB.builder()
                    .componentA(getComponentA())
                    .moduleB(new ModuleB(mUser))
                    .build();
        }
        return mComponentB;
    }
}
