package com.codeblast.daggermodulesareoptional.hero.attack;

public class WidowBite implements SuperPower {

    @Override
    public String getSoundEffect() {
        return "Zap!";
    }

    @Override
    public int attackDamage() {
        return 4;
    }
}
