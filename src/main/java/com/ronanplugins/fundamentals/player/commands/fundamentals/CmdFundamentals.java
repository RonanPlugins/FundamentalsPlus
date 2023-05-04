package com.ronanplugins.fundamentals.player.commands.fundamentals;

import com.ronanplugins.fundamentals.player.commands.FunCommand;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CmdFundamentals implements FunCommand {
    @Override
    public void run(CommandSender sendi, String label, String[] args) {
        sendi.sendMessage("Fundamentals command runs!");
    }

    @Override
    public List<String> tab(CommandSender sendi, String label, String[] args) {
        return null;
    }

    @Override
    public PermissionNode permission() {
        return null;
    }

    @Override
    public String name() {
        return null;
    }
}
