package net.starly.warp.command;

import net.starly.warp.data.StringData;
import net.starly.warp.data.WarpData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetSpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        WarpData warpData = new WarpData();
        StringData stringData = new StringData();

        if(sender instanceof Player player) {

            if(args.length == 0) {
                if(player.isOp()) {
                    warpData.setSpawn(player);
                } else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.errorMsgNotPermission()));
                }
                return true;
            }

        }


        return false;
    }
}