package me.evilterabite.astraquests.quests;

import org.bukkit.entity.Player;

import java.util.ArrayList;
import java.util.List;

public class questList {

    public static List<String> get() {
        List<String> questList = new ArrayList<>();
        questList.add("tutorial");
        return questList;
    }

    public static void help(Player player, String questName){
        if(questName.equalsIgnoreCase("tutorial")) {
            tutorialQuest.hint(player);
        }
    }
}
