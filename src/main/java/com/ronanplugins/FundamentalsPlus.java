package com.ronanplugins;

import com.ronanplugins.references.permissions.Permissions;
import com.ronanplugins.references.settings.Settings;
import org.bukkit.plugin.java.JavaPlugin;

public class FundamentalsPlus extends JavaPlugin {
    private static FundamentalsPlus instance;
    private final Permissions perms = new Permissions();
    private final Settings settings = new Settings();

    @Override
    public void onEnable() {
        instance = this;

        // Load configuration files
        loadConfigurations();

        // Register commands
        registerCommands();

        // Register event listeners
        registerListeners();

        // Print a message to the console indicating the plugin has started successfully
        getLogger().info("FundamentalsPlus has been enabled.");
    }

    @Override
    public void onDisable() {
        // Perform cleanup tasks, if necessary
        getLogger().info("FundamentalsPlus has been disabled.");
    }

    public static FundamentalsPlus getInstance() {
        return instance;
    }

    private void loadConfigurations() {
        // Load your configurations here
    }

    private void registerCommands() {
        // Register your commands here
    }
    public Settings getSettings() {
        return settings;
    }

    private void registerListeners() {
        // Register your event listeners here
    }
    public Permissions getPerms() {
        return perms;
    }
}
