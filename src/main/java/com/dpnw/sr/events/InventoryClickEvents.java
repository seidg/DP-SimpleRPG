package com.dpnw.sr.events;

import com.dpnw.sr.SimpleRPG;
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


    }
}
