package me.evilterabite.astraquests.quests;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

public class questGUI implements Listener {
    private static Inventory inv;

    public questGUI() {
        inv = Bukkit.createInventory(null,27, ChatColor.RED + "Quests");
        initializeItems();
    }

    public void initializeItems(){
        inv.addItem(tutorialQuest.displayItem());
    }


    @EventHandler
    void onDragItem(InventoryClickEvent e){
        if(e.getView().getTitle().equalsIgnoreCase(ChatColor.RED + "Quests")) {
            ItemStack clickedItem = e.getCurrentItem();
            if(clickedItem == null || clickedItem.getType() == Material.AIR) return;
            if(clickedItem == tutorialQuest.displayItem()) {
                tutorialQuest.join((Player) e.getWhoClicked());
            }
            e.setCancelled(true);
        }
    }
}
