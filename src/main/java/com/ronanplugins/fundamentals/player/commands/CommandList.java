package com.ronanplugins.fundamentals.player.commands;


import com.ronanplugins.fundamentals.player.commands.fundamentals.CmdFundamentals;
import com.ronanplugins.fundamentals.player.commands.teleport.CmdTeleport;

public enum CommandList {
    FUNDAMENTALS(new CmdFundamentals()),
    TELEPORT(new CmdTeleport()),
    // Add more commands here
    ;

    private final FunCommand cmd;

    CommandList(FunCommand cmd) {
        this.cmd = cmd;
    }

    public FunCommand getCmd() {
        return cmd;
    }
}