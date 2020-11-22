package me.evilterabite.astraquests.events;

import me.evilterabite.astraquests.files.playerdata;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class playerJoin implements Listener {

    @EventHandler
    void onPlayerJoin(PlayerJoinEvent e){
        Player player = e.getPlayer();
        if(!player.hasPlayedBefore()) {
            String uuid = player.getUniqueId().toString();
            FileConfiguration playerConfig = playerdata.get();
            playerConfig.addDefault("Players.{UUID}.Quests_Completed".replace("{UUID}", uuid), 0);
            Bukkit.getLogger().info(player.getDisplayName() + "config entry created successfully.");
        }

    }
}
