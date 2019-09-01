package lolidevs.abuseblocker.listeners;

import lolidevs.abuseblocker.Abuseblocker;
import org.bukkit.GameMode;
import org.bukkit.Material;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerGameModeChangeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class GamemodeChangeListener implements Listener {
    @EventHandler
    public void onGamemodeChange(PlayerGameModeChangeEvent event) throws IOException {
        Player p = event.getPlayer();
        if(event.getNewGameMode() == GameMode.CREATIVE)
        {
            saveInv(p);
            bone(p);
        }
        else if (event.getNewGameMode() == GameMode.SURVIVAL)
        {
            loadInv(p);
        }
    }

    public void saveInv(Player p) throws IOException
    {
        File f = new File(Abuseblocker.getPlugin(Abuseblocker.class).getDataFolder().getAbsolutePath(), p.getName()+".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        c.set("inventory.armor", p.getInventory().getArmorContents());
        c.set("inventory.offhand", p.getInventory().getItemInOffHand());
        c.set("inventory.contents", p.getInventory().getContents());
        c.set("enderchest.contents",p.getEnderChest().getContents());
        c.set("player.xp",p.getTotalExperience());
        c.save(f);
    }
    @SuppressWarnings("unchecked")
    public void loadInv(Player p) throws  IOException
    {
        File f = new File(Abuseblocker.getPlugin(Abuseblocker.class).getDataFolder().getAbsolutePath(),p.getName()+".yml");
        FileConfiguration c = YamlConfiguration.loadConfiguration(f);
        ItemStack[] load = ((List<ItemStack>) c.get("inventory.armor")).toArray(new ItemStack[0]);
        p.getInventory().setArmorContents(load);
        load = ((List<ItemStack>) c.get("inventory.contents")).toArray(new ItemStack[0]);
        p.getInventory().setContents(load);
        load = ((List<ItemStack>) c.get("enderchest.contents")).toArray(new ItemStack[0]);
        p.getEnderChest().setContents(load);
        ItemStack iload = ((ItemStack) c.get("inventory.offhand"));
        p.getInventory().setItemInOffHand(iload);
        int xp = ((int) c.get("player.xp"));
        p.setTotalExperience(xp);
    }
    public void bone(Player p)
    {
        p.getInventory().clear();
        p.setTotalExperience(0);
        p.getEnderChest().clear();
    }
}
