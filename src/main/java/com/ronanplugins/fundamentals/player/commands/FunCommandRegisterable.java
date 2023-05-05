package com.ronanplugins.fundamentals.player.commands;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginIdentifiableCommand;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.List;

public abstract class FunCommandRegisterable extends Command implements PluginIdentifiableCommand, FunCommandCore {
    CommandSender sender;//So you can mess with this inside this class
    FundamentalsPlus plugin = FundamentalsPlus.getInstance();
    protected FunCommandRegisterable(String name, String... alias) {
        super(name);
        if (alias != null)
            setAliases(Arrays.asList(alias));
    }

    @Override//Sets the plugin to our plugin so it shows up in /help
    public @NotNull Plugin getPlugin() {
        return plugin;
    }

    @Override
    public boolean execute(@NotNull CommandSender sender, @NotNull String commandLabel, String[] arguments) {
        this.sender = sender;
        run(sender, commandLabel, arguments);//actually run the command.
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
