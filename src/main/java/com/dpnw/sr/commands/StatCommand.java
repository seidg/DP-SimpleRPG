package com.dpnw.sr.commands;

import com.dpnw.sr.SimpleRPG;
import com.dpnw.sr.functions.SRFunction;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class StatCommand implements CommandExecutor {
    private final String prefix = SimpleRPG.getPrefix();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(prefix + "플레이어만 사용 가능한 명령어 입니다.");
            return false;
        }
        SRFunction.openStatsMenu(p);
        return false;
    }
}
