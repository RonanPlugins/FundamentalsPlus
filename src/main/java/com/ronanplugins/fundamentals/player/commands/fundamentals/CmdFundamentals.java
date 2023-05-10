package com.ronanplugins.fundamentals.player.commands.fundamentals;

import com.ronanplugins.fundamentals.player.commands.CommandExecutor;
import com.ronanplugins.fundamentals.player.commands.FunCommandCore;
import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class CmdFundamentals implements FunCommandCore {
    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        if (PermissionNode.CORE_USE.check(sendi).isPassed()) {
            if (args != null && args.length > 0) {
                for (CommandList_Fundamentals cmd : CommandList_Fundamentals.values()) {
                    if (cmd.name().equalsIgnoreCase(args[0])) {
                        if (sendi instanceof Player || cmd.getCmd().consoleCanRun()) {
                            if (cmd.getCmd().permission() == null || cmd.getCmd().permission().check(sendi).isPassed()) {
                                //FundamentalsPlus.debug(sendi.getName() + " executed: /" + label + " " + String.join(" ", args));
                                cmd.getCmd().run(sendi, label, args);
                            } else
                                MessagesCore.NOPERMISSION.send(sendi, cmd);
                            return;
                        } else {
                            //Console cant run this command
                            CommandExecutor.consoleCantExecuteMessage(sendi, label);
                        }
                    }
                }
            }
            MessagesCore.INVALID.send(sendi, label);
            //} else {
            //DEFAULT COMMAND IF NONE
            //RTP_CommandEvent event = new RTP_CommandEvent(sendi, new CmdTeleport());
            //Bukkit.getServer().getPluginManager().callEvent(event);
            //if (!event.isCancelled())
            //    event.getCmd().execute(sendi, label, args);
            //}
        } else
            MessagesCore.NOPERMISSION.send(sendi, PermissionNode.CORE_USE);
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        List<String> list = new ArrayList<>();
        if (args.length == 1) {
            for (CommandList_Fundamentals cmd : CommandList_Fundamentals.values()) {
                if (!(cmd.getCmd() instanceof FunCommandRegisterable) && cmd.name().toLowerCase().startsWith(args[0].toLowerCase()))
                    if (cmd.getCmd().permission().check(sendi).isPassed())
                        list.add(cmd.name().toLowerCase());
            }
        } else if (args.length > 1) {
            for (CommandList_Fundamentals cmd : CommandList_Fundamentals.values()) {
                if (cmd.name().equalsIgnoreCase(args[0]))
                    if (cmd.getCmd().permission().check(sendi).isPassed()) {
                        List<String> _cmdlist = cmd.getCmd().tab(sendi, label, args);
                        if (_cmdlist != null)
                            list.addAll(_cmdlist);
                    }
            }
        }
        return list;
    }

    @Override
    public PermissionNode permission() {
        return null;
    }
}
