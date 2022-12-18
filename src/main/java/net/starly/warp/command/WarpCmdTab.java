package net.starly.warp.command;

import net.starly.warp.WarpMain;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.util.StringUtil;
import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WarpCmdTab implements TabCompleter {


    @Nullable
    @Override
    public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
        if (args.length == 1) {
            return sender.isOp() ? List.of("생성", "제거", "목록") : Collections.emptyList();
        } else if (args.length == 2) {
            if (sender.isOp()) {
                if (List.of("제거", "remove", "이동", "teleport").contains(args[0])) {
                    return Arrays
                            .asList(Arrays.stream(new File(WarpMain.getPlugin().getDataFolder(), "warp").list())
                            .map(s -> s.replace(".yml", ""))
                            .toArray(String[]::new));
                }
            } else return Collections.emptyList();
        } else if (args.length == 3) {
            if (sender.isOp()) {
                if (List.of("이동", "teleport").contains(args[0])) return null;
            } else return Collections.emptyList();
        }

        return Collections.emptyList();
    }
}
