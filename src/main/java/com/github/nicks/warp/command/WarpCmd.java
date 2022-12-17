package com.github.nicks.warp.command;

import com.github.nicks.nicklib.data.Config;
import com.github.nicks.warp.data.StringData;
import com.github.nicks.warp.data.WarpData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;


public class WarpCmd implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        WarpData warpData = new WarpData();
        StringData stringData = new StringData();
        String name;

        if (sender instanceof Player player) {

            if (args.length == 0) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgMain()));
                return true;
            }


            switch (args[0]) {

                case "이동" -> {
                    if(args.length < 2) {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExactly()));
                        return true;
                    }
                    name = args[1];
                    warpData.teleportWarp(player, name);
                    return true;
                }

                case "생성", "create" -> {
                    if (player.isOp()) {

                        if(args.length < 2) {
                            player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgExactly()));
                        }

                        name = args[1];
                        warpData.createWarp(player, name);
                    } else {
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPermission()));
                        return true;
                    }

                }

                case "제거", "delete", "삭제" -> {
                    if (player.isOp()) {

                        if(args.length < 2) {
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

                case "목록" -> {
                    if (player.isOp()) {
                        Config config = new Config("warp/");
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.getWarpList(config.fileListName())));

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
