package me.roridev.abuseblocker

import me.roridev.abuseblocker.listeners.*
import org.bukkit.Bukkit
import org.bukkit.World
import org.bukkit.WorldType
import org.bukkit.plugin.java.JavaPlugin

class AbuseBlocker : JavaPlugin() {
    override fun onEnable() {
        server.pluginManager.registerEvents(ItemDropListener(),this)
        server.pluginManager.registerEvents(GamemodeListener(), this)
        server.pluginManager.registerEvents(ItemPickupListener(), this)
        server.pluginManager.registerEvents(BlockBreakListener(), this)
        server.pluginManager.registerEvents(BlockInteractListener(), this)
        super.onEnable()
    }

    override fun onDisable() {
        super.onDisable()
    }
    companion object{
        val bukkitConfig get() = Bukkit.getPluginManager().getPlugin("abuseblocker")!!.config
        val logger get() = Bukkit.getPluginManager().getPlugin("abuseblocker")!!.logger
        val configFolder get() = Bukkit.getPluginManager().getPlugin("abuseblocker")!!.dataFolder
        val overworld: World get() = Bukkit.getWorlds().first()
        val server get() = Bukkit.getServer()
    }
}