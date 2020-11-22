package me.evilterabite.astraquests.commands.questcommands;

import org.bukkit.entity.Player;

public abstract class QuestSubCommands {
    public abstract String getName();
    public abstract String getDescription();
    public abstract String getSyntax();
    public abstract void perform(Player player, String[] args);
}
