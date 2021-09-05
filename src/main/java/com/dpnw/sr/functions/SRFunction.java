package com.dpnw.sr.functions;

import com.dpnw.sr.SimpleRPG;
import com.dpnw.sr.enums.StatType;
import com.dpnw.sr.utils.InitGlobalValue;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Map;
import java.util.UUID;

public class SRFunction {
    private static final SimpleRPG plugin = SimpleRPG.getInstance();
    private static final YamlConfiguration config = SimpleRPG.config;
    private static final Map<UUID, YamlConfiguration> udata = SimpleRPG.getUdata();

    public static void openStatsMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§6스텟 정보");
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        for(int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, item);
        }

        item.setType(Material.DIAMOND_SWORD);
        ItemMeta im = item.getItemMeta();
    }





    public static void addStats(Player p, StatType statType, int point) {
        YamlConfiguration data = udata.get(p.getUniqueId());
        int stat = data.getInt("Player.Stats." + statType.getRaw());
        data.set("Player.Stats." + statType.getRaw(), stat + point);
        Bukkit.getScheduler().runTask(plugin, () -> saveData(p.getUniqueId()));
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.5F, 2F);
    }

    public static void updateStats(Player p) {
        YamlConfiguration data = udata.get(p.getUniqueId());
        int damage = 0, armor = 0, maxHealth = 0, speed = 0, jumpPower = 0;
        if(config.getBoolean("Settings.uses.DAMAGE")) {
            damage = data.getInt("Player.Stats.DAMAGE");
        }
        if(config.getBoolean("Settings.uses.ARMOR")) {
            armor = data.getInt("Player.Stats.ARMOR");
        }
        if(config.getBoolean("Settings.uses.MAXHEALTH")) {
            maxHealth = data.getInt("Player.Stats.MAXHEALTH");
        }
        if(config.getBoolean("Settings.uses.SPEED")) {
            speed = data.getInt("Player.Stats.SPEED");
        }
        if(config.getBoolean("Settings.uses.JUMPPOWER")) {
            jumpPower = data.getInt("Player.Stats.JUMPPOWER");
        }
        if(!(damage == 0)) {
            AttributeInstance at = p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
            at.setBaseValue(at.getBaseValue()+damage);
        }
    }


    public static void saveData(UUID uuid) {
        try {
            udata.get(uuid).save(new File(plugin.getDataFolder() + "/data/", uuid + ".yaml"));
        } catch (Exception ignored) {
        }
    }


    public static void reloadGlobalStatsAndConfig() {
        SimpleRPG.config = YamlConfiguration.loadConfiguration(new File(plugin.getDataFolder(), "config.yml"));
        InitGlobalValue.init();
    }
}
