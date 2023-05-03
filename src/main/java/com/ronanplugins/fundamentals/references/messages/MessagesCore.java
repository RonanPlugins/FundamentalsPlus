package com.ronanplugins.fundamentals.references.messages;

import org.bukkit.command.CommandSender;

import java.util.HashMap;
import java.util.List;

public enum MessagesCore {
    RELOAD("Reload"),
    NOPERMISSION("NoPermission.Basic"),
    NOPERMISSION_WORLD("NoPermission.World"),
    DISABLED_WORLD("DisabledWorld"),
    COOLDOWN("Cooldown"),
    INVALID("Invalid"),
    NOTONLINE("NotOnline"),
    DELAY("Delay"),
    SIGN("Sign"),
    MOVED("Moved"),
    ALREADY("Already"),
    //EDIT
    EDIT_ERROR("Edit.Error"),
    EDIT_SET("Edit.Set"),
    EDIT_REMOVE("Edit.Remove"),

      //////////////////////
     //  TELEPORTATION
    //////////////////

    TELEPORT_SUCCESS_PAID("Teleportation.Success.Paid"),
    TELEPORT_SUCCESS_BYPASS("Teleportation.Success.Bypass"),
    TELEPORT_SUCCESS_LOADING("Teleportation.Success.Loading"),
    TELEPORT_SUCCESS("Teleportation.Success"),
    TELEPORT_TO_PLAYER_SUCCESS("Teleportation.ToPlayer.Success"),
    TELEPORT_PLAYER_NOT_FOUND("Teleportation.Failed.PlayerNotFound"),
    TELEPORT_FAILED_NOT_SAFE("Teleportation.Failed.NotSafe"),
    TELEPORT_FAILED_PRICE("Teleportation.Failed.Price"),
    TELEPORT_FAILED_HUNGER("Teleportation.Failed.Hunger"),
    TELEPORT_OTHER_NOT_SAFE("Teleportation.Other.NotSafe"),
    TELEPORT_OTHER_SUCCESS("Teleportation.Other.Success"),
    TELEPORT_DOES_NOT_EXIST("Teleportation.DoesNotExist"),
    INVALID_ARGUMENTS("Teleportation.InvalidArguments"),
    INVALID_COORDINATES_FORMAT("Teleportation.InvalidCoordinatesFormat"),
    TELEPORTATION_NOT_ALLOWED_WORLD("Teleportation.WorldNotAllowed"),
    TELEPORTATION_NOT_ALLOWED_COORDINATES("Teleportation.CoordinatesNotAllowed"),
    TELEPORTATION_FAILED("Teleportation.Failed"),
    ;

    final String section;

    MessagesCore(String section) {
        this.section = section;
    }

    private static final String pre = "Messages.";

    public void send(CommandSender sendi) {
        Message.sms(sendi, Message.getLang().getString(pre + section));
    }

    public void send(CommandSender sendi, Object placeholderInfo) {
        Message.sms(sendi, Message.getLang().getString(pre + section), placeholderInfo);
    }

    public void send(CommandSender sendi, List<Object> placeholderInfo) {
        Message.sms(sendi, Message.getLang().getString(pre + section), placeholderInfo);
    }

    public String get(CommandSender p, Object placeholderInfo) {
        return Message.placeholder(p, Message.getLang().getString(pre + section), placeholderInfo);
    }

    public void send(CommandSender sendi, HashMap<String, String> placeholder_values) {
        String msg = Message.getLang().getString(pre + section);
        for (String ph : placeholder_values.values())
            msg = msg.replace(ph, placeholder_values.get(ph));
        Message.sms(sendi, msg);
    }

}
