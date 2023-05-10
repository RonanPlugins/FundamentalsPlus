package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public abstract class FunCommandRegisterable extends Command implements PluginIdentifiableCommand, FunCommandCore {

    protected FunCommandRegisterable(String name, String... alias) {
        super(name);
        if (alias != null)
            setAliases(Arrays.asList(alias));
    }

    @Override //Sets the plugin to our plugin, so it shows up in /help
    public @NotNull Plugin getPlugin() {
        return FundamentalsPlus.getInstance();
    }

    @Override
    public boolean execute(@NotNull CommandSender sendi, @NotNull String label, String[] args) {
        if (!(sendi instanceof Player) && consoleCanRun())
            if (permission() == null || permission().check(sendi).isPassed())
                run(sendi, label, args); //actually run the command.
            else
                MessagesCore.NOPERMISSION.send(sendi);
        else
            CommandExecutor.consoleCantExecuteMessage(sendi, label);
        return true;
    }

    @Override
    public @NotNull List<String> tabComplete(@NotNull CommandSender sender, @NotNull String alias, @NotNull String[] args) throws IllegalArgumentException {
        return tab(sender, alias, args);
    }

    @Override
    public @NotNull Command setAliases(@NotNull List<String> aliases) {
        return super.setAliases(aliases);
    }
}
