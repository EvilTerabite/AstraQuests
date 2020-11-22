package me.evilterabite.astraquests;

import me.evilterabite.astraquests.commands.questcommands.QuestCommandManager;
import me.evilterabite.astraquests.events.playerJoin;
import me.evilterabite.astraquests.files.playerdata;
import me.evilterabite.astraquests.quests.questGUI;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.logging.Logger;

public final class AstraQuests extends JavaPlugin {
    public static Logger logger = Bukkit.getLogger();

    @Override
    public void onEnable() {
        //Setting up config.yml
        saveDefaultConfig();
        getConfig().options().copyDefaults(true);
        //Setting up playerdata.yml
        playerdata.setup();
        playerdata.get().options().copyDefaults(true);
        playerdata.save();

        //Events
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents(new playerJoin(), this);
        pm.registerEvents(new questGUI(), this);
        //Commands
        Objects.requireNonNull(getCommand("quest")).setExecutor(new QuestCommandManager());
        //Final loaded message.
        logger.info("AstraQuests Started!");

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
