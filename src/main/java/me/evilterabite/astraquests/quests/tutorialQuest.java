package me.evilterabite.astraquests.quests;

import me.evilterabite.astraquests.apis.lpInterface;
import me.evilterabite.astraquests.files.playerdata;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class tutorialQuest {
    public static ItemStack displayItem(){
        ItemStack displayItem = new ItemStack(Material.OAK_WOOD, 20);
        ItemMeta itemMeta = displayItem.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GREEN + "Tutorial Quest");
        displayItem.setItemMeta(itemMeta);

        return displayItem;
    }

    public static void join(Player player){
        if(player.hasPermission("quest.tutorial.start")) {
            lpInterface.removeNode(player, "quest.tutorial.start");
            lpInterface.addNode(player, "quest.tutorial.stepOne");
            FileConfiguration pConfig = playerdata.get();
            pConfig.addDefault("Players.{UUID}.Active_Quests".replace("{UUID}", player.getUniqueId().toString()), "tutorialQuest");
        }
        else {
            player.sendMessage(ChatColor.translateAlternateColorCodes('&', "&cYou cannot complete this quest. (This is a tutorial quest, you can't do it again!"));
        }
    }

    public static void hint(Player player){
        if(player.hasPermission("quest.tutorial.stepOne")) {
            player.sendMessage(ChatColor.YELLOW + "Looks like Ameth wants to see you in the tavern!");
        }
        else if(player.hasPermission("quest.tutorial.start")) {
            player.sendMessage("Hmm, try activating the quest again?");
        }
        else{
            player.sendMessage(ChatColor.RED + "Hmm, you cant see hints for the tutorial quest anymore... ");
        }
    }
}
