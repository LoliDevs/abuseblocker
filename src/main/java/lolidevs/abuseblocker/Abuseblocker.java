package lolidevs.abuseblocker;

import lolidevs.abuseblocker.listeners.*;
import org.bukkit.plugin.java.JavaPlugin;

public final class Abuseblocker extends JavaPlugin {

    @Override
    public void onEnable()
    {
        getServer().getPluginManager().registerEvents(new GamemodeChangeListener(), this);
        getServer().getPluginManager().registerEvents(new InteractListener(), this);
        getServer().getPluginManager().registerEvents(new DropListener(), this);
        getServer().getPluginManager().registerEvents(new BreakListener(), this);
        getServer().getPluginManager().registerEvents(new GrimReaper(),this);
    }

    @Override
    public void onDisable() {
    }
 }
