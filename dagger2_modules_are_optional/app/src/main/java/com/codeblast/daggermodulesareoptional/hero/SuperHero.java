package com.codeblast.daggermodulesareoptional.hero;

import com.codeblast.daggermodulesareoptional.hero.attack.SuperPower;

public interface SuperHero {

    String getName();

    SuperPower getSuperPower();

    void attack(BadGuy badGuy);
}
