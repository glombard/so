package com.codeblast.daggermodulesareoptional.hero.attack;

public class RepulsorRay implements SuperPower {

    @Override
    public String getSoundEffect() {
        return "Blast!";
    }

    @Override
    public int attackDamage() {
        return 6;
    }
}
