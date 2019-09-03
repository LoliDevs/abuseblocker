package lolidevs.abuseblocker.utils;

import org.bukkit.ChatColor;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Logger {
    public static void LogOPEN(Inventory inv, Player p)
    {
        p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Opening " +ChatColor.GRAY+ inv.getType().name() + ChatColor.WHITE+" is disabled in CREATIVE");
    }
    public static void LogINTERACT(Entity e, Player p)
    {
        p.sendMessage(ChatColor.WHITE + "["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Interactions with "+ChatColor.GRAY + e.getType().name() + ChatColor.WHITE+" are disabled in CREATIVE");
    }
    public static void LogDROP(Player p)
    {
        p.sendMessage(ChatColor.WHITE + "["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Dropping is disabled in CREATIVE");

    }
    public static void LogCONTAINERHASITEM(Player p, Block b)
    {
        p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] This " +ChatColor.GRAY+ b.getType().name() + ChatColor.WHITE+" has items.");
    }
}
