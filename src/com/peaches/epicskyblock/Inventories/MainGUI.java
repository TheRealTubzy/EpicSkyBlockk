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
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;

public class MainGUI implements Listener {

    public static Inventory inv(Island island) {
        Inventory inv = Bukkit.createInventory(null, 27, ChatColor.translateAlternateColorCodes('&', "&7&lIsland Settings"));
        for (int i = 0; i < 9; i++) {
            inv.setItem(i, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            inv.setItem(i + 18, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 15, " "));
            inv.setItem(i + 9, EpicSkyBlock.getSkyblock.makeItem(Material.STAINED_GLASS_PANE, 1, 8, " "));
        }
        if (island == null) {
            inv.setItem(4, EpicSkyBlock.getSkyblock.makeItem(Material.GRASS, 1, 0, "&a&lCREATE ISLAND"));
        }
        inv.setItem(9, EpicSkyBlock.getSkyblock.makeItem(Material.SIGN, 1, 0, "&d&lISLAND &f&lMODERATION"));
        inv.setItem(11, EpicSkyBlock.getSkyblock.makeItem(Material.ANVIL, 1, 0, "&b&lISLAND &f&lMISSIONS"));
        inv.setItem(13, EpicSkyBlock.getSkyblock.makeItem(Material.EXP_BOTTLE, 1, 0, "&a&lISLAND &f&lBOOSTERS"));
        inv.setItem(15, EpicSkyBlock.getSkyblock.makeItem(Material.BEACON, 1, 0, "&e&lISLAND &f&lUPGRADES"));
        inv.setItem(17, EpicSkyBlock.getSkyblock.makeItem(Material.ENDER_PORTAL_FRAME, 1, 0, "&2&lISLAND &f&lTOOLS"));
        return inv;
    }

    @EventHandler
    public void onclick(InventoryClickEvent e) {
        Player p = (Player) e.getWhoClicked();
        User user = User.getbyPlayer(p);
        if (e.getClickedInventory().getTitle().equals(inv(null).getTitle())) {
            if (e.getSlot() == 9) {
                if (user.getIsland() != null) {
                    p.openInventory(Moderation.inv(user.getIsland()));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lSkyBlock &8» &eYou do not have an island"));
                }
            }
            if (e.getSlot() == 17) {
                if (user.getIsland() != null) {
                    p.openInventory(Tools.inv(user.getIsland()));
                } else {
                    p.sendMessage(ChatColor.translateAlternateColorCodes('&', "&6&lSkyBlock &8» &eYou do not have an island"));
                }
            }
        }
        e.setCancelled(true);
    }
}


