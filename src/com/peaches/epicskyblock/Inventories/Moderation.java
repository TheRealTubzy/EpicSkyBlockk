package com.peaches.epicskyblock.Inventories;

import com.peaches.epicskyblock.EpicSkyBlock;
import com.peaches.epicskyblock.Island;
import com.peaches.epicskyblock.User;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.Inventory;

public class Moderation implements Listener {

    public static Inventory inv(Island island) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&7&lIsland Moderation"));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            inv.setItem(i + 18, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            inv.setItem(i + 9, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 8, " "));
        }
        inv.setItem(9, EpicSkyBlock.getSkyblock.makeItem(Material.PAPER, 1, 0, "&2&lISLAND &f&lMembers"));;
        inv.setItem(11, EpicSkyBlock.getSkyblock.makeItem(Material.DIAMOND_AXE, 1, 0, "&b&lISLAND &f&lKick"));
        inv.setItem(13, EpicSkyBlock.getSkyblock.makeItem(Material.DIAMOND_SWORD, 1, 0, "&e&lISLAND &f&lBan"));
        inv.setItem(15, EpicSkyBlock.getSkyblock.makeItem(Material.DIAMOND_CHESTPLATE, 1, 0, "&c&lISLAND &f&lMute"));
        inv.setItem(17, EpicSkyBlock.getSkyblock.makeItem(Material.ENDER_CHEST, 1, 0, "&6&lISLAND &f&lPermissions"));
        return inv;
    }

    @EventHandler
    public void onclick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        User user = User.getbyPlayer(p);
        if (e.getClickedInventory().getTitle().equals(inv(null).getTitle())){
            if (e.getSlot()==9){
                if(user.getIsland() != null){
                    p.openInventory(Members.inv(user.getIsland()));
                }else{
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lSkyBlock &8» &eYou do not have an island"));
                }

            }
            e.setCancelled(true);
        }
    }

}
