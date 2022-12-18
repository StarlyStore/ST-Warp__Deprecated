package net.starly.warp.command;

import net.starly.warp.WarpMain;
import net.starly.warp.data.StringData;
import net.starly.warp.data.WarpData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.io.File;
import java.util.Arrays;
import java.util.List;


public class WarpCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        WarpData warpData = new WarpData();
        StringData stringData = new StringData();
        String name;
        Player target;

        if (sender instanceof Player player) {

            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgMain()));
                return true;
            }


            switch (args[0]) {


                case "도움말", "help", "?" -> {
                    stringData.msgWarpHelp(player);
                    return true;
                }

                case "이동", "teleport" -> {
                    if (args.length < 2) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExactly()));
                        return true;
                    }

                    if (args.length == 3) {
                        target = player.getServer().getPlayer(args[2]);
                        name = args[1];
                        warpData.teleportWarp(player, target, name);
                        return true;

                    } else if (args.length == 2) {
                        name = args[1];
                        warpData.teleportWarp(player, name);
                        return true;
                    }
                }

                case "생성", "create" -> {
                    if (player.isOp()) {
                        if (args.length < 2) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExactly()));
                        }

                        name = args[1];
                        warpData.createWarp(player, name);
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPermission()));
                        return true;
                    }
                }

                case "제거", "delete" -> {
                    if (player.isOp()) {
                        if (args.length < 2) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExactly()));
                            return true;
                        }

                        name = args[1];
                        warpData.deleteWarp(player, name);
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPermission()));
                        return true;
                    }
                }

                case "목록", "list" -> {
                    if (player.isOp()) {
                        File file = new File(WarpMain.getPlugin().getDataFolder(), "warp");
                        List<String> warpList = Arrays.asList(Arrays.stream(file.list()).map(s -> s.replace(".yml", "")).toArray(String[]::new));

                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpList(warpList)));

                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPermission()));
                        return true;
                    }
                    return true;
                }


                default -> {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgMain()));
                    return true;
                }
            }
        }
        return false;
    }
}
