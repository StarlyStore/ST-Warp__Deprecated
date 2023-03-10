package net.starly.warp.command;

import net.starly.warp.data.StringData;
import net.starly.warp.data.WarpData;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SpawnCommand implements CommandExecutor {


    @Override
    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        WarpData warpData = new WarpData();
        StringData stringData = new StringData();

        if(sender instanceof Player player) {

            if(args.length == 0) {
                warpData.teleportSpawn(player);
                player.sendMessage(ChatColor.translateAlternateColorCodes('&', stringData.msgWarpSpawn()));
                return true;
            }

        }


        return false;
    }
}
