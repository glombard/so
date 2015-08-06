package com.codeblast.daggermodulesareoptional.hero.attack;

public class HandToHandCombat implements SuperPower {

    @Override
    public String getSoundEffect() {
        return "Pow!";
    }

    @Override
    public int attackDamage() {
        return 3;
    }
}
