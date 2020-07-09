package me.roridev.abuseblocker.listeners

import me.roridev.abuseblocker.data.load
import me.roridev.abuseblocker.data.save
import org.bukkit.GameMode
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.player.PlayerGameModeChangeEvent

class GamemodeListener : Listener {
    @EventHandler
    fun GamemodeChange(event : PlayerGameModeChangeEvent){
        if(event.newGameMode == GameMode.SURVIVAL) {
            Clear(event.player)
            LoadItems(event.player)
            event.player.sendActionBar("Loaded SURVIVAL data successfully")
        }else if(event.player.gameMode == GameMode.SURVIVAL &&
                event.newGameMode != GameMode.SURVIVAL){
            StoreItems(event.player)
            Clear(event.player)
            event.player.sendActionBar("Stored SURVIVAL data successfully")
        }
    }
    fun LoadItems(player : Player) {
        var data = load(player.name)
        var inv = player.inventory
        inv.setArmorContents(data.armorContents)
        inv.contents = data.contents
        player.enderChest.contents = data.enderchest
        player.totalExperience = data.exp
        player.teleport(data.location)
    }
    fun StoreItems(player : Player) {
        save(player)
    }
    fun Clear(player : Player){
        player.inventory.clear()
    }
}