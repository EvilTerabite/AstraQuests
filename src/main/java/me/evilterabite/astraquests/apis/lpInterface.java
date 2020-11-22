package me.evilterabite.astraquests.apis;

import net.luckperms.api.LuckPermsProvider;
import net.luckperms.api.model.user.User;
import net.luckperms.api.model.user.UserManager;
import net.luckperms.api.node.Node;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.Collection;

public class lpInterface {
    private static final UserManager userManager = LuckPermsProvider.get().getUserManager();

    public static void removeNode(Player player, String node){
        User user = userManager.getUser(player.getUniqueId());
        assert user != null;
        Collection<Node> nodeCollection = user.getNodes();
        if (nodeCollection.contains(Node.builder("{node}".replace("{node}", node)).build())) {
            user.data().remove(Node.builder("{node}".replace("{node}", node)).build());
        }
        else {
            Bukkit.getLogger().severe("[ERROR] Player node not removed." + node);
        }
    }

    public static void addNode(Player player, String node){
        User user = userManager.getUser(player.getUniqueId());
        assert user != null;
        Collection<Node> nodeCollection = user.getNodes();
        if (nodeCollection.contains(Node.builder("{node}".replace("{node}", node)).build())) {
            user.data().add(Node.builder("{node}".replace("{node}", node)).build());
        }
        else {
            Bukkit.getLogger().severe("[ERROR] Player already has node." + node);
        }
    }
}
