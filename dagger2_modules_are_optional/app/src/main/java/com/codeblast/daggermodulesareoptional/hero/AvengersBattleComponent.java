package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.MainActivity;
import com.codeblast.daggermodulesareoptional.util.ActivityScope;
import com.codeblast.daggermodulesareoptional.util.UtilComponent;

import dagger.Component;

@ActivityScope
@Component(dependencies = UtilComponent.class)
public interface AvengersBattleComponent {
    void initialize(MainActivity mainActivity);
}
