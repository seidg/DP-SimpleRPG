package com.dpnw.sr.enums;

public enum StatType {
    DAMAGE("DAMAGE"),
    ARMOR("ARMOR"),
    MAXHEALTH("MAXHEALTH"),
    SPEED("SPEED"),
    JUMPPOWER("JUMPPOWER"),
    ;

    private final String raw;

    StatType(String raw) {
        this.raw = raw;
    }

    public String getRaw() {
        return raw;
    }
}
