package org.test.test;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.text.DecimalFormat;
import java.util.Collections;

public class ServerStatsCommand implements CommandExecutor {

    private static final double MEMORY_CONVERSION_FACTOR = 1024 * 1024;

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player && !sender.hasPermission("serverstats.view")) { // Checks if the player has necessary permission
            sender.sendMessage(ChatColor.RED + "You do not have permission to view server stats.");
            return true;
        }
        Inventory playerInventory = null;
        if (sender instanceof Player) {
            Player player = (Player) sender;
            playerInventory = Bukkit.createInventory(player, 9, "Server Stats");
            createAndAddItemToInventory(playerInventory, 0, Material.PLAYER_HEAD,
                    "Online Players", "Online players: " + Bukkit.getOnlinePlayers().size());
            player.openInventory(playerInventory);
        }
        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;
        double usedMemoryInMB = usedMemory / MEMORY_CONVERSION_FACTOR;
        double totalMemoryInMB = totalMemory / MEMORY_CONVERSION_FACTOR;
        // format to 2 decimal places
        DecimalFormat df = new DecimalFormat("0.00");
        createAndAddItemToInventory(playerInventory, 1, Material.REDSTONE,
                "RAM Usage", "Used memory: " + df.format(usedMemoryInMB) + " MB / " + df.format(totalMemoryInMB) + " MB");
        return true;
    }

    private void createAndAddItemToInventory(Inventory inventory, int position, Material material, String displayName, String lore) {
        ItemStack item = new ItemStack(material);
        ItemMeta itemMeta = item.getItemMeta();
        assert itemMeta != null;
        itemMeta.setDisplayName(ChatColor.GREEN + displayName);
        itemMeta.setLore(Collections.singletonList(ChatColor.WHITE + lore));
        item.setItemMeta(itemMeta);
        assert inventory != null;
        inventory.setItem(position, item);
    }
}
