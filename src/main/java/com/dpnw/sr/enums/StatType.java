package com.dpnw.sr.enums;

public enum StatType {
    DAMAGE("Damage"),
    ARMOR("Armor"),
    MAXHEALTH("MaxHealth"),
    SPEED("Speed"),
    JUMPPOWER("JumpPower"),
    ;

    private final String raw;

    StatType(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }
}
