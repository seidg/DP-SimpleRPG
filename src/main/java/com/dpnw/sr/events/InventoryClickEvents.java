package com.dpnw.sr.events;

import com.dpnw.sr.SimpleRPG;
import com.dpnw.sr.enums.StatType;
import com.dpnw.sr.functions.SRFunction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.PlayerInventory;

public class InventoryClickEvents implements Listener {
    private final SimpleRPG plugin = SimpleRPG.getInstance();

    @EventHandler
    public void onInventoryClickStat(InventoryClickEvent e) {
        if(!e.getView().getTitle().contains("스텟")) return;
        Player p = (Player) e.getWhoClicked();
        e.setCancelled(true);
        if(e.getClickedInventory() instanceof PlayerInventory) return;
        int slot = e.getSlot();
        if(slot == 11) {
            SRFunction.addStats(p, StatType.DAMAGE, 1);
        }
         if(slot == 13) {
            SRFunction.addStats(p, StatType.ARMOR, 1);
        }
         if(slot == 15) {
            SRFunction.addStats(p, StatType.SPEED, 1);
        }
         if(slot == 30) {
            SRFunction.addStats(p, StatType.MAXHEALTH, 1);
        }
         if(slot == 32) {
            SRFunction.addStats(p, StatType.JUMPPOWER, 1);
        }

    }
}
