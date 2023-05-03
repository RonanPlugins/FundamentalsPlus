package com.ronanplugins.fundamentals.references.settings;

import com.ronanplugins.fundamentals.FundamentalsPlus;
import com.ronanplugins.fundamentals.references.file.FileOther;
import lombok.Getter;

import java.util.List;

public class Settings {
    @Getter
    private boolean debug;
    @Getter private boolean featureEnabled;
    @Getter private String featureMessage;
    @Getter private List<String> featureList;
//    TELEPORT
    @Getter private int teleportPrice;

    public void load() { //Load Settings
        FileOther.FILETYPE config = FundamentalsPlus.getInstance().getFiles().getType(FileOther.FILETYPE.CONFIG);
        debug = config.getBoolean("Settings.Debugger");
        featureEnabled = config.getBoolean("Settings.Feature.Enabled");
        featureMessage = config.getString("Settings.Feature.Message");
        featureList = config.getStringList("Settings.Feature.List");

//        TELEPORT
        teleportPrice = config.getInt("Teleport.Price");

    }
}