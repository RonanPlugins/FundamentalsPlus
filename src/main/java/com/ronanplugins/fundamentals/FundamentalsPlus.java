package com.ronanplugins.fundamentals;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.player.commands.CommandExecutor;
import com.ronanplugins.fundamentals.references.depends.DepPlaceholderAPI;
import com.ronanplugins.fundamentals.references.file.Files;
import com.ronanplugins.fundamentals.references.permissions.Permissions;
import com.ronanplugins.fundamentals.references.settings.Settings;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;
import java.util.Arrays;

public class FundamentalsPlus extends JavaPlugin {
    private static FundamentalsPlus instance;
    @Getter private final Permissions perms = new Permissions();
    @Getter private final Files files = new Files();
    @Getter private final Settings settings = new Settings();
    @Getter private final CommandExecutor commandExecutor = new CommandExecutor();
    //Booleans
    @Getter private boolean PlaceholderAPI;
    //Commands
    private static SimpleCommandMap scm;
    private SimplePluginManager spm;

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
        commandExecutor.commandExecuted(sendi, label, args);
        return true;
    }

    public static FundamentalsPlus getInstance() { return instance; }

    private void loadConfigurations() {
        // Load your configurations here
        files.loadAll();
        perms.register();
        settings.load();
        commandExecutor.load();
    }

    //COMMANDS
    public void registerCommands(FunCommandRegisterable... commands) {
        Arrays.stream(commands).forEach(command -> scm.register(getPluginMeta().getName(), command));//Register the plugin
    }

    private void setupSimpleCommandMap() {
        spm = (SimplePluginManager) this.getServer().getPluginManager();
        Field f = null;
        try {
            f = SimplePluginManager.class.getDeclaredField("commandMap");
        } catch (Exception e) {
            e.printStackTrace();
        }
        f.setAccessible(true);
        try {
            scm = (SimpleCommandMap) f.get(spm);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SimpleCommandMap getCommandMap() {
        return scm;
    }
}
