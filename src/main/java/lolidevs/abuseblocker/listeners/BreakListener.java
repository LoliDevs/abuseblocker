package lolidevs.abuseblocker.listeners;

import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.block.Barrel;
import org.bukkit.block.Chest;
import org.bukkit.block.ShulkerBox;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;


public class BreakListener implements Listener {
    @EventHandler
    public void onBreak (BlockBreakEvent event)
    {
        Player p = event.getPlayer();
        if(p.getGameMode().equals(GameMode.CREATIVE))
        {
            if(event.getBlock().getState() instanceof Chest)
            {
                Chest c = (Chest) event.getBlock().getState();
                Inventory inv = c.getBlockInventory();
                if(isInvEmpty(inv))
                {
                    event.setCancelled(false);
                }
                else
                {
                    event.setCancelled(true);
                    p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Parece que este " +ChatColor.GRAY+ event.getBlock().getType().name() + ChatColor.WHITE+" possui items.");
                }
            }
            else if(event.getBlock().getState() instanceof ShulkerBox)
            {
                ShulkerBox c = (ShulkerBox) event.getBlock().getState();
                Inventory inv = c.getInventory();
                if(isInvEmpty(inv))
                {
                    event.setCancelled(false);
                }
                else
                {
                    event.setCancelled(true);
                    p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Parece que este " +ChatColor.GRAY+ event.getBlock().getType().name() + ChatColor.WHITE+" possui items.");
                }
            }
            else if(event.getBlock().getState() instanceof Barrel)
            {
                Barrel c = (Barrel) event.getBlock().getState();
                Inventory inv = c.getInventory();
                if(isInvEmpty(inv))
                {
                    event.setCancelled(false);
                }
                else
                {
                    event.setCancelled(true);
                    p.sendMessage(ChatColor.WHITE+"["+ChatColor.RED+"AbuseBlocker"+ChatColor.WHITE+"] Parece que este " +ChatColor.GRAY+ event.getBlock().getType().name() + ChatColor.WHITE+" possui items.");
                }
            }

        }
    }

    private boolean isInvEmpty(Inventory inv) {
        for (ItemStack item : inv.getContents()) {
            if (item != null) {
                return false;
            }
        }
        return true;
    }
}
