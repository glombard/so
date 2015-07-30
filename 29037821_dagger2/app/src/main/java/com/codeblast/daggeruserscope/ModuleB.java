package com.codeblast.daggeruserscope;

import dagger.Module;
import dagger.Provides;

@Module
public class ModuleB {

    private final User user;

    public ModuleB(User user) {
        this.user = user;
    }

    @Provides
    @UserScope
    User provideUser() {
        return user;
    }

    @Provides
    @UserScope
    UserManager provideUserManager() {
        return new UserManager();
    }
}
