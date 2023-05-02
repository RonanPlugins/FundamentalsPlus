package com.ronanplugins.fundamentals;

import com.ronanplugins.fundamentals.player.commands.Commands;
import com.ronanplugins.fundamentals.player.commands.FundamentalsCommand;
import com.ronanplugins.fundamentals.references.depends.DepPlaceholderAPI;
import com.ronanplugins.fundamentals.references.file.Files;
import com.ronanplugins.fundamentals.references.permissions.Permissions;
import com.ronanplugins.fundamentals.references.settings.Settings;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

public class FundamentalsPlus extends JavaPlugin {
    private static FundamentalsPlus instance;
    @Getter private final Permissions perms = new Permissions();
    @Getter private final Files files = new Files();
    @Getter private final Settings settings = new Settings();
    @Getter private final Commands commands = new Commands(this);
    //Booleans
    @Getter private boolean PlaceholderAPI;

    @Override
    public void onEnable() {
        instance = this;

        registerDependencies();
        // Load configuration files
        loadConfigurations();

        try {
            new DepPlaceholderAPI().register();
        } catch (NoClassDefFoundError e) {
            //No placeholder api :(
        }
    }

    private void registerDependencies() {
        PlaceholderAPI = Bukkit.getPluginManager().isPluginEnabled("PlaceholderAPI");
    }

    @Override
    public void onDisable() {
        // Perform cleanup tasks, if necessary
        getLogger().info("FundamentalsPlus has been disabled.");
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sendi, @NotNull Command cmd, @NotNull String label, @NotNull String[] args) {
        commands.commandExecuted(sendi, label, args);
        return true;
    }

    public static FundamentalsPlus getInstance() {
        return instance;
    }

    private void loadConfigurations() {
        // Load your configurations here
        files.loadAll();
        perms.register();
        settings.load();
        commands.load();
    }
}
