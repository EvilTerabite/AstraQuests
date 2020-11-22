package me.evilterabite.astraquests.commands.questcommands.qsubcommands;

import me.evilterabite.astraquests.commands.questcommands.QuestSubCommands;
import me.evilterabite.astraquests.quests.questList;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

import java.util.List;

public class questHelp extends QuestSubCommands {
    @Override
    public String getName() {
        return "help";
    }

    @Override
    public String getDescription() {
        return "Lets you know what to do in the current quest.";
    }

    @Override
    public String getSyntax() {
        return "/quest help";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length > 1) {
            String questName = args[1];
            List<String> qList = questList.get();
            if(qList.contains(questName)) {
                questList.help(player, questName);
            }
            else{
                player.sendMessage(ChatColor.RED + "Could not find a quest under that name. Try again.");
            }
        }
    }
}
