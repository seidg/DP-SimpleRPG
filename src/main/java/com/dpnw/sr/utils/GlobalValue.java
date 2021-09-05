package com.dpnw.sr.utils;

public record GlobalValue(double damage, double armor, double maxhealth, double speed, double jumppower, boolean useDamage, boolean useArmor, boolean useMaxHealth, boolean useSpeed, boolean useJumpPower) {

    @Override
    public double damage() {
        return damage;
    }

    @Override
    public double armor() {
        return armor;
    }

    @Override
    public double maxhealth() {
        return maxhealth;
    }

    @Override
    public double speed() {
        return speed;
    }

    @Override
    public double jumppower() {
        return jumppower;
    }

    @Override
    public boolean useDamage() {
        return useDamage;
    }

    @Override
    public boolean useArmor() {
        return useArmor;
    }

    @Override
    public boolean useMaxHealth() {
        return useMaxHealth;
    }

    @Override
    public boolean useSpeed() {
        return useSpeed;
    }

    @Override
    public boolean useJumpPower() {
        return useJumpPower;
    }
}

