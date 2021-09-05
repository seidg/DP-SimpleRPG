package com.dpnw.sr;

import com.dpnw.sr.commands.SRCommands;
import com.dpnw.sr.commands.StatCommand;
import com.dpnw.sr.events.InventoryClickEvents;
import com.dpnw.sr.events.InventoryCloseEvents;
import com.dpnw.sr.events.PlayerEvents;
import com.dpnw.sr.utils.GlobalValue;
import com.dpnw.sr.utils.InitGlobalValue;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class SimpleRPG extends JavaPlugin {
    private static SimpleRPG plugin;
    public static YamlConfiguration config;
    private static final String prefix = "§f[ §bDPSR §f] ";
    private static final Map<UUID, YamlConfiguration> udata = new HashMap<>();
    public static GlobalValue globalValue;

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

        File fconfig = new File(getDataFolder(), "config.yml");
        if (!fconfig.exists()) {
            saveResource("config.yml", false);
        }
        config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
        plugin.getServer().getPluginManager().registerEvents(new InventoryClickEvents(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new InventoryCloseEvents(), plugin);
        plugin.getServer().getPluginManager().registerEvents(new PlayerEvents(), plugin);
        getCommand("sr").setExecutor(new SRCommands());
        getCommand("스텟").setExecutor(new StatCommand());
        InitGlobalValue.init();
    }
}

