package com.codeblast.daggeruserscope;

import dagger.Component;

@Component(modules={ModuleB.class})
@UserScope
public interface ComponentB {
    User getUser();
    UserManager getUserManager();
    void inject(MainActivity target);
}
