package com.dpnw.sr;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleRPG extends JavaPlugin {
    private static SimpleRPG plugin;
    private static final String prefix = "§f[ §bDPSR §f] ";
    private static final Map<UUID, YamlConfiguration> udata = new HashMap<>();

    public static SimpleRPG getInstance() {
        return plugin;
    }

    public static String getPrefix() {
        return prefix;
    }

    public static Map<UUID, YamlConfiguration> getUdata() {
        return udata;
    }

    @Override
    public void onEnable() {
        plugin = this;

    }
}
