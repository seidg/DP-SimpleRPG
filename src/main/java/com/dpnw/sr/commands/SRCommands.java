package com.dpnw.sr.commands;

import com.dpnw.sr.SimpleRPG;
import com.dpnw.sr.functions.SRFunction;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.List;

public class SRCommands implements CommandExecutor, TabCompleter {
    private final String prefix = SimpleRPG.getPrefix();

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player p)) {
            sender.sendMessage(prefix + "플레이어만 사용 가능한 명령어 입니다.");
            return false;
        }
        if (!p.isOp()) {
            p.sendMessage(prefix + "관리자 전용 명령어 입니다.");
            return false;
        }
        if (args.length == 0) {
            p.sendMessage(prefix + "/sr lv add <player> <value>");
            p.sendMessage(prefix + "/sr lv sub <player> <value>");
            p.sendMessage(prefix + "/sr lv set <player> <value>");
            p.sendMessage(prefix + "/sr exp add <player> <value>");
            p.sendMessage(prefix + "/sr exp sub <player> <value>");
            p.sendMessage(prefix + "/sr exp set <player> <value>");
        }
        if (args[0].equals("lv")) {
            if (args.length == 1) {
                p.sendMessage(prefix + "/sr lv add <player> <value>");
                p.sendMessage(prefix + "/sr lv sub <player> <value>");
                p.sendMessage(prefix + "/sr lv set <player> <value>");
                return false;
            }
            if (args[1].equals("add")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    int i = Integer.parseInt(args[3]);
                    if(i < 0) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.addLevel(Bukkit.getPlayer(args[2]) , Integer.parseInt(args[3]));
                return false;
            }
            if (args[1].equals("sub")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    int i = Integer.parseInt(args[3]);
                    if(i < 0) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.subLevel(Bukkit.getPlayer(args[2]) , Integer.parseInt(args[3]));
                return false;
            }
            if (args[1].equals("set")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    int i = Integer.parseInt(args[3]);
                    if(i < 0) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.setLevel(Bukkit.getPlayer(args[2]) , Integer.parseInt(args[3]));
                return false;
            }
        }
        if (args[0].equals("exp")) {
            if (args.length == 1) {
                p.sendMessage(prefix + "/sr exp add <player> <value>");
                p.sendMessage(prefix + "/sr exp sub <player> <value>");
                p.sendMessage(prefix + "/sr exp set <player> <value>");
                return false;
            }
            if (args[1].equals("add")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    BigInteger i = new BigInteger(args[3]);
                    if(i.compareTo(new BigInteger("0")) == -1) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.addExp(Bukkit.getPlayer(args[2]) , new BigInteger(args[3]));
                return false;
            }
            if (args[1].equals("sub")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    BigInteger i = new BigInteger(args[3]);
                    if(i.compareTo(new BigInteger("0")) == -1) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.subExp(Bukkit.getPlayer(args[2]) , new BigInteger(args[3]));
                return false;
            }
            if (args[1].equals("set")){
                if(args.length == 2) {
                    p.sendMessage(prefix + "플레이어를 입력해주세요.");
                    return false;
                }
                if(args.length == 3) {
                    p.sendMessage(prefix + "값을 입력해주세요.");
                    return false;
                }
                if(Bukkit.getPlayer(args[2]) == null) {
                    p.sendMessage(prefix + "존재하는 플레이어를 입력해주세요.");
                    return false;
                }
                try{
                    BigInteger i = new BigInteger(args[3]);
                    if(i.compareTo(new BigInteger("0")) == -1) {
                        p.sendMessage(prefix + "양수만 입력해주세요.");
                        return false;
                    }
                }catch (NumberFormatException e) {
                    p.sendMessage(prefix + "숫자를 입력해주세요.");
                    return false;
                }
                SRFunction.setExp(Bukkit.getPlayer(args[2]) , new BigInteger(args[3]));
                return false;
            }
        }
        return false;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sender, @NotNull Command command, @NotNull String alias, @NotNull String[] args) {
        if (args.length == 0) {
            return Arrays.asList("lv", "exp");
        }
        if (args.length == 1) {
            return Arrays.asList("add", "sub", "set");
        }
        return null;
    }
}
