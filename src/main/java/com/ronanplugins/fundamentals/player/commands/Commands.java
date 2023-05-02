package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import com.ronanplugins.player.commands.types.*;
import org.bukkit.Bukkit;
import org.bukkit.command.CommandSender;

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

    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        if (PermissionNode.USE.check(sendi).isPassed()) {
            if (args != null && args.length > 0) {
                for (FundamentalsCommand cmd : commands) {
                    if (cmd.getName().equalsIgnoreCase(args[0])) {
                        if (cmd.permission().check(sendi).isPassed()) {
                            //FundamentalsPlus.debug(sendi.getName() + " executed: /" + label + " " + String.join(" ", args));
                            cmd.execute(sendi, label, args);
                        } else
                            MessagesCore.NOPERMISSION.send(sendi, cmd);
                        return;
                    }
                }
                MessagesCore.INVALID.send(sendi, label);
            } else {
                //DEFAULT COMMAND IF NONE
                //RTP_CommandEvent event = new RTP_CommandEvent(sendi, new CmdTeleport());
                //Bukkit.getServer().getPluginManager().callEvent(event);
                //if (!event.isCancelled())
                //    event.getCmd().execute(sendi, label, args);
            }
        } else
            MessagesCore.NOPERMISSION.send(sendi, PermissionNode.USE);
    }

    public List<String> onTabComplete(CommandSender sendi, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (FundamentalsCommand cmd : commands) {
                if (cmd.getName().toLowerCase().startsWith(args[0].toLowerCase()))
                    if (cmd.permission().check(sendi).isPassed())
                        list.add(cmd.getName().toLowerCase());
            }
        } else if (args.length > 1) {
            for (FundamentalsCommand cmd : commands) {
                if (cmd.getName().equalsIgnoreCase(args[0]))
                    if (cmd.permission().check(sendi).isPassed()) {
                        List<String> _cmdlist = cmd.tabComplete(sendi, args);
                        if (_cmdlist != null)
                            list.addAll(_cmdlist);
                    }
            }
        }
        return list;
    }
}
