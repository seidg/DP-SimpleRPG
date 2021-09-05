package com.dpnw.sr.events;

import com.dpnw.sr.SimpleRPG;
import com.dpnw.sr.functions.SRFunction;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryCloseEvent;

public class InventoryCloseEvents implements Listener {
    private final SimpleRPG plugin = SimpleRPG.getInstance();


    @EventHandler
    public void onInventoryClose(InventoryCloseEvent e) {
        if(!e.getView().getTitle().contains("스텟 정보")) return;
        Player p = (Player) e.getPlayer();
        SRFunction.updateStats(p);
    }


}
