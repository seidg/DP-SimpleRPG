package com.dpnw.sr.commands;

import com.dpnw.sr.SimpleRPG;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class SRCommands implements CommandExecutor, TabCompleter {
    private final String prefix = SimpleRPG.getPrefix();
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if(!(sender instanceof Player p)) {
            sender.sendMessage(prefix + "플레이어만 사용 가능한 명령어 입니다.");
            return false;
        }
        if(!p.isOp()){
            p.sendMessage(prefix + "관리자 전용 명령어 입니다.");
            return false;
        }
        if(args.length == 0) {
            p.sendMessage(prefix + "/sr ");
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        return null;
    }
}
