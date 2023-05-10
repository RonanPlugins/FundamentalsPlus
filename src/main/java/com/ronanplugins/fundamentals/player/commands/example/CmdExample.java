package com.ronanplugins.fundamentals.player.commands.example;

import com.ronanplugins.fundamentals.player.commands.FunCommandRegisterable;
import com.ronanplugins.fundamentals.references.permissions.PermissionNode;
import org.bukkit.command.CommandSender;

import java.util.List;

public class CmdExample extends FunCommandRegisterable {

    protected CmdExample() {
        super("example", "ex");
    }

    @Override
    public void run(CommandSender sendi, String label, String[] args) {

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
    public boolean consoleCanRun() { //OPTIONAL
        return super.consoleCanRun();
    }
}