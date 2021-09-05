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

import java.io.File;
import java.util.*;

public class SRFunction {

    private static final SimpleRPG plugin = SimpleRPG.getInstance();
    private static final YamlConfiguration config = SimpleRPG.config;
    private static final Map<UUID, YamlConfiguration> udata = SimpleRPG.getUdata();

    public static void openStatsMenu(Player p) {
        Inventory inv = Bukkit.createInventory(null, 54, "§6스텟 정보");
        ItemStack item = new ItemStack(Material.BLACK_STAINED_GLASS_PANE);
        for (int i = 0; i < inv.getSize(); i++) {
            inv.setItem(i, item);
        }

        item.setType(Material.DIAMOND_SWORD);
        ItemMeta im = item.getItemMeta();
        im.setDisplayName("§6데미지 증가");
        im.setLore(Arrays.asList("", "§e스텟 포인트 1당 : " + SimpleRPG.globalValue.damage() + " 증가"));
        item.setItemMeta(im);
        inv.setItem(11, item);

        item.setType(Material.DIAMOND_CHESTPLATE);
        im = item.getItemMeta();
        im.setDisplayName("§6방어력 증가");
        im.setLore(Arrays.asList("", "§e스텟 포인트 1당 : " + SimpleRPG.globalValue.armor() + " 증가"));
        item.setItemMeta(im);
        inv.setItem(13, item);

        item.setType(Material.DIAMOND_BOOTS);
        im = item.getItemMeta();
        im.setDisplayName("§6이동속도 증가");
        im.setLore(Arrays.asList("", "§e스텟 포인트 1당 : " + SimpleRPG.globalValue.speed() + " 증가"));
        item.setItemMeta(im);
        inv.setItem(15, item);

        item.setType(Material.APPLE);
        im = item.getItemMeta();
        im.setDisplayName("§6최대체력 증가");
        im.setLore(Arrays.asList("", "§e스텟 포인트 1당 : " + SimpleRPG.globalValue.maxhealth() + " 증가"));
        item.setItemMeta(im);
        inv.setItem(30, item);

        item.setType(Material.RABBIT_FOOT);
        im = item.getItemMeta();
        im.setDisplayName("§6점프력 증가");
        im.setLore(Arrays.asList("", "§e스텟 포인트 1당 : " + SimpleRPG.globalValue.jumppower() + " 증가"));
        item.setItemMeta(im);
        inv.setItem(32, item);

        item.setType(Material.BOOK);
        im = item.getItemMeta();

        YamlConfiguration data = udata.get(p.getUniqueId());


        im.setDisplayName("§6보유 스텟 포인트 : " + data.getInt("Player.StatPoint"));
        im.setLore(Arrays.asList("", ""));
        item.setItemMeta(im);
        inv.setItem(49, item);


        p.openInventory(inv);
    }


    public static void addStats(Player p, StatType statType, int point) {
        YamlConfiguration data = udata.get(p.getUniqueId());

        int statPoint = data.getInt("Player.StatPoint");

        if(!(statPoint > 0)) {
            p.sendMessage(SimpleRPG.getPrefix() + "보유 스텟 포인트가 부족합니다.");
            return;
        }
        data.set("Player.StatPoint",statPoint-1);
        int stat = data.getInt("Player.Stats." + statType.getRaw());
        data.set("Player.Stats." + statType.getRaw(), stat + point);
        Bukkit.getScheduler().runTask(plugin, () -> saveData(p.getUniqueId()));
        p.playSound(p.getLocation(), Sound.UI_BUTTON_CLICK, 0.5F, 2F);
    }

    public static void updateStats(Player p) {
        YamlConfiguration data = udata.get(p.getUniqueId());
        int damage = 0, armor = 0, maxHealth = 0, speed = 0, jumpPower = 0;
        if (config.getBoolean("Settings.uses.DAMAGE")) {
            damage = data.getInt("Player.Stats.DAMAGE");
        }
        if (config.getBoolean("Settings.uses.ARMOR")) {
            armor = data.getInt("Player.Stats.ARMOR");
        }
        if (config.getBoolean("Settings.uses.MAXHEALTH")) {
            maxHealth = data.getInt("Player.Stats.MAXHEALTH");
        }
        if (config.getBoolean("Settings.uses.SPEED")) {
            speed = data.getInt("Player.Stats.SPEED");
        }
        if (config.getBoolean("Settings.uses.JUMPPOWER")) {
            jumpPower = data.getInt("Player.Stats.JUMPPOWER");
        }
        if (!(damage == 0)) {
            AttributeInstance at = p.getAttribute(Attribute.GENERIC_ATTACK_DAMAGE);
            at.setBaseValue(at.getBaseValue() + damage);
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

    public static void createNewData(Player p) {
        try {
            File file = new File(plugin.getDataFolder() + "/data/", p.getUniqueId() + ".yaml");
            if (!file.exists()) {
                YamlConfiguration data = new YamlConfiguration();
                data.set("Player.Level", 0);
                data.set("Player.Exp", 0);
                data.set("Player.StatPoint", 0);
                data.set("Player.Stats.DAMAGE", 0);
                data.set("Player.Stats.ARMOR", 0);
                data.set("Player.Stats.MAXHEALTH", 0);
                data.set("Player.Stats.SPEED", 0);
                data.set("Player.Stats.JUMPPOWER", 0);
                SimpleRPG.getUdata().put(p.getUniqueId(), data);
                return;
            }
            YamlConfiguration data = YamlConfiguration.loadConfiguration(file);
            SimpleRPG.getUdata().put(p.getUniqueId(), data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
