package me.evilterabite.astraquests.commands.questcommands;

import me.evilterabite.astraquests.commands.questcommands.qsubcommands.questHelp;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.ArrayList;

public class QuestCommandManager implements CommandExecutor {
    private ArrayList<QuestSubCommands> subcommands = new ArrayList<>();

    public QuestCommandManager(){
        subcommands.add(new questHelp());
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if(sender instanceof Player) {
            Player player = (Player) sender;
            if(args.length > 0) {
                for(int i = 0; i < getQuestSubCommands().size(); i++){
                    if(args[0].equalsIgnoreCase(getQuestSubCommands().get(i).getName())){
                        getQuestSubCommands().get(i).perform(player, args);
                    }
                }
            }
            else {
                player.sendMessage("You did not specify a subcommand.");
            }
        }
        return true;
    }

    public ArrayList<QuestSubCommands> getQuestSubCommands(){
        return subcommands;
    }
}
