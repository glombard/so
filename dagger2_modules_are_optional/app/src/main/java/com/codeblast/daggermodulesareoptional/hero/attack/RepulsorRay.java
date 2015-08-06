package com.codeblast.daggermodulesareoptional.hero.attack;

import javax.inject.Inject;

public class RepulsorRay implements SuperPower {

    @Inject
    public RepulsorRay() {
    }

    @Override
    public String getSoundEffect() {
        return "Blast!";
    }

    @Override
    public int attackDamage() {
        return 6;
    }
}
