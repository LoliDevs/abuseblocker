package lolidevs.abuseblocker;

import lolidevs.abuseblocker.listeners.DropListener;
import lolidevs.abuseblocker.listeners.GamemodeChangeListener;
import lolidevs.abuseblocker.listeners.InteractListener;
import org.bukkit.event.HandlerList;
import org.bukkit.plugin.java.JavaPlugin;

public final class Abuseblocker extends JavaPlugin {

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new GamemodeChangeListener(), this);
        getServer().getPluginManager().registerEvents(new InteractListener(), this);
        getServer().getPluginManager().registerEvents(new DropListener(), this);
    }

    @Override
    public void onDisable() {
    }
 }
