package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.List;

//Use this interface if a command is support to be listed under CoreCommands and want it to be run under the `/fundamentals <cmd>` command
public interface FunCommandCore {

    void run(CommandSender sendi, String label, String[] args);

    List<String> tab(CommandSender sendi, String label, String[] args);

    PermissionNode permission();

    default boolean consoleCanRun() {
        return true;
    }
}
