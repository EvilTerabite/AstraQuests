package me.evilterabite.astraquests.files;

import me.evilterabite.astraquests.AstraQuests;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;
import java.io.IOException;

public class playerdata {

    private static File file;
    private static FileConfiguration playerFile;

    public static void setup(){
        Plugin plugin = AstraQuests.getProvidingPlugin(AstraQuests.class);
        file = new File(plugin.getDataFolder(), "playerdata.yml");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException ignored) {

            }
        }
        playerFile = YamlConfiguration.loadConfiguration(file);
    }

    public static FileConfiguration get(){
        return playerFile;
    }

    public static void save(){
        try{
            playerFile.save(file);
        } catch (IOException e){
            Bukkit.getLogger().severe("Could not save playerdata.yml, this is a serious issue, please report it!");
        }
    }

    public static void reload(){
        playerFile = YamlConfiguration.loadConfiguration(file);
    }
}
