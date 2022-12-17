package com.github.nicks.warp.command.tabcomplete;

import com.github.nicks.nicklib.data.Config;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class WarpTabCompl implements TabCompleter {


    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {

        List<String> completions = new ArrayList<>();

        if (sender instanceof Player player) {
            if (args.length == 1) {
                if (player.isOp()) {
                    StringUtil.copyPartialMatches(args[0], List.of("생성", "제거", "목록"), completions);
                }
            } else if (args.length == 2) {
                if (player.isOp()) {
                    if (args[0].equals("제거") || args[0].equals("이동")) {
                        Config config = new Config("warp/");
                        StringUtil.copyPartialMatches(args[1], config.fileListName(), completions);
                    }
                }
            }
        }
        return completions;
    }
}
