package com.dpnw.sr.utils;

import com.dpnw.sr.SimpleRPG;
import org.bukkit.configuration.file.YamlConfiguration;

public class InitGlobalValue {
    private static final YamlConfiguration config = SimpleRPG.config;

    public static void init() {
        double damageMultiplier = config.getDouble("Settings.multiplier.DAMAGE");
        double armorMultiplier = config.getDouble("Settings.multiplier.ARMOR");
        double maxhealthMultiplier = config.getDouble("Settings.multiplier.MAXHEALTH");
        double speedMultiplier = config.getDouble("Settings.multiplier.SPEED");
        double jumppowerMultiplier = config.getDouble("Settings.multiplier.JUMPPOWER");
        boolean useDamage = config.getBoolean("Settings.uses.DAMAGE");
        boolean useArmor = config.getBoolean("Settings.uses.ARMOR");
        boolean useMaxHealth = config.getBoolean("Settings.uses.MAXHEALTH");
        boolean useSpeed = config.getBoolean("Settings.uses.SPEED");
        boolean useJumpPower = config.getBoolean("Settings.uses.JUMPPOWER");
        SimpleRPG.globalValue = new GlobalValue(damageMultiplier, armorMultiplier, maxhealthMultiplier, speedMultiplier, jumppowerMultiplier, useDamage, useArmor,useMaxHealth, useSpeed, useJumpPower);
        System.out.println("데미지 승수 : " + damageMultiplier +"\n방어력 승수 : " + armorMultiplier + "\n최대 체력 승수 : " + maxhealthMultiplier + "\n이동속도 승수 : " + speedMultiplier + "\n점프강화 승수 : " + jumppowerMultiplier);
        System.out.println("데미지 스텟 사용 : " + useDamage +"\n방어력 스텟 사용 : " + useArmor + "\n최대 체력 스텟 사용 : " + useMaxHealth + "\n이동속도 스텟 사용 : " + useSpeed + "\n점프강화 스텟 사용 : " + useJumpPower);
    }
}
