package com.ronanplugins.fundamentals;

import com.ronanplugins.fundamentals.player.commands.CommandList;
import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.player.commands.CommandExecutor;
import com.ronanplugins.fundamentals.references.depends.DepPlaceholderAPI;
import com.ronanplugins.fundamentals.references.file.Files;
import com.ronanplugins.fundamentals.references.messages.MessagesCore;
import com.ronanplugins.fundamentals.references.permissions.Permissions;
import com.ronanplugins.fundamentals.references.settings.Settings;
import lombok.Getter;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandMap;
import org.bukkit.command.CommandSender;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.plugin.SimplePluginManager;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

public class FundamentalsPlus extends JavaPlugin {
    private static FundamentalsPlus instance;
    @Getter private final Permissions perms = new Permissions();
    @Getter private final Files files = new Files();
    @Getter private final Settings settings = new Settings();
    @Getter private final CommandExecutor commandExecutor = new CommandExecutor();
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
        CommandList.FUNDAMENTALS.getCmd().run(sendi, label, args);
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender sendi, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        return CommandList.FUNDAMENTALS.getCmd().tab(sendi, label, args);
    }

    public static FundamentalsPlus getInstance() { return instance; }

    private void loadConfigurations() {
        // Load your configurations here
        files.loadAll();
        perms.register();
        settings.load();
        commandExecutor.load();
    }

    public static void debug(Level level, String str) {
        getInstance().getLogger().log(level, str);
    }

    //COMMANDS
    public void registerCommands(FunCommandRegisterable... commands) {
        Arrays.stream(commands).forEach(command -> {
            Field commandMapField;
            CommandMap commandMap = null;
            try {
                commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
                commandMapField.setAccessible(true);
                commandMap = (CommandMap) commandMapField.get(Bukkit.getServer());
            } catch (final Exception e) {
                e.printStackTrace();
            }
            if (commandMap != null) {
                commandMap.register(command.getName(), command);
            }
        });
    }
}
