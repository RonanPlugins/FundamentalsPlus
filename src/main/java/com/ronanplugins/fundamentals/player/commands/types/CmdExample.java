package com.ronanplugins.fundamentals.player.commands.types;

import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import com.ronanplugins.fundamentals.player.commands.FundamentalsCommand;
import org.bukkit.command.CommandSender;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class CmdExample implements FundamentalsCommand {

    @Override
    public void execute(CommandSender sender, String label, String[] args) {
        // Your command logic goes here
    }

    @Override
    public List<String> tabComplete(CommandSender sendi, String[] args) {
        // Return possible tab completions for this command
        return new ArrayList<>();
    }

    @Override
    public @NotNull PermissionNode permission() {
        return PermissionNode.EXAMPLE_PERMISSION;
    }

    @Override
    public String getName() {
        return "example";
    }
}