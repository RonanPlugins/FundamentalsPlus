package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.ArrayList;
import java.util.List;

public class CommandExecutor {

    public void load() {
        for (CommandList cmd : CommandList.values()) {
            registerCommand(cmd.getCmd());
        }
    }

    private void registerCommand(FunCommand cmd) {
        if (cmd instanceof FunCommandRegisterable)
            FundamentalsPlus.getInstance().registerCommands((FunCommandRegisterable) cmd);
    }

    public void commandExecuted(CommandSender sendi, String label, String[] args) {
        if (PermissionNode.USE.check(sendi).isPassed()) {
            if (args != null && args.length > 0) {
                for (CommandList cmd : CommandList.values()) {
                    if (!(cmd.getCmd() instanceof FunCommandRegisterable) && cmd.name().equalsIgnoreCase(args[0])) {
                        if (cmd.getCmd().permission().check(sendi).isPassed()) {
                            //FundamentalsPlus.debug(sendi.getName() + " executed: /" + label + " " + String.join(" ", args));
                            cmd.getCmd().run(sendi, label, args);
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

    public List<String> onTabComplete(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (CommandList cmd : CommandList.values()) {
                if (!(cmd.getCmd() instanceof FunCommandRegisterable) && cmd.name().toLowerCase().startsWith(args[0].toLowerCase()))
                    if (cmd.getCmd().permission().check(sendi).isPassed())
                        list.add(cmd.name().toLowerCase());
            }
        } else if (args.length > 1) {
            for (CommandList cmd : CommandList.values()) {
                if (!(cmd.getCmd() instanceof FunCommandRegisterable) && cmd.name().equalsIgnoreCase(args[0]))
                    if (cmd.getCmd().permission().check(sendi).isPassed()) {
                        List<String> _cmdlist = cmd.getCmd().tab(sendi, label, args);
                        if (_cmdlist != null)
                            list.addAll(_cmdlist);
                    }
            }
        }
        return list;
    }
}
