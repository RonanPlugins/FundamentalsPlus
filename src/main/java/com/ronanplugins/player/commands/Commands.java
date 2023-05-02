package com.ronanplugins.player.commands;

import com.ronanplugins.FundamentalsPlus;
import com.ronanplugins.player.commands.types.*;

import java.util.ArrayList;
import java.util.List;

public class Commands {

    private final FundamentalsPlus plugin;
    private final List<FundamentalsCommand> commands = new ArrayList<>();

    public Commands(FundamentalsPlus plugin) {
        this.plugin = plugin;
    }

    public void load() {
        commands.clear();
        for (FundamentalsCommandType cmd : FundamentalsCommandType.values()) {
            registerCommand(cmd.getCmd(), false);
        }
    }

    private void registerCommand(FundamentalsCommand cmd, boolean forced) {
        if (!cmd.isDebugOnly() || plugin.getSettings().isDebug() || forced) {
            commands.add(cmd);
        }
    }

    public void commandExecuted() {
        // TODO: implement command execution
    }

    public List<String> onTabComplete() {
        // TODO: implement tab completion
        return null;
    }
}
