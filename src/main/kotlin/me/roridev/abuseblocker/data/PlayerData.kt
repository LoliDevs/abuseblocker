package me.roridev.abuseblocker.data
import me.roridev.abuseblocker.AbuseBlocker
import org.bukkit.Location
import org.bukkit.configuration.file.YamlConfiguration
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack
import java.io.File
import java.util.*

class PlayerData {
    var name: String = String()
    var armorContents: Array<ItemStack> = arrayOf()
    var contents: Array<ItemStack> = arrayOf()
    var enderchest: Array<ItemStack> = arrayOf()
    var exp : Int = 0
    var location: Location  = Location(AbuseBlocker.overworld,0.0,0.0,0.0)
    constructor(p : Player){
        name = p.name
        armorContents = p.inventory.armorContents
        contents = p.inventory.contents
        enderchest = p.enderChest.contents
        exp = p.totalExperience
        location = p.location
    }
    constructor()
}
fun save(player : Player){
    val data = PlayerData(player)
    val file = File(AbuseBlocker.configFolder, "${data.name}.yml")
    val config = YamlConfiguration.loadConfiguration(file)
    config.set("armorContents",data.armorContents)
    config.set("contents",data.contents)
    config.set("enderchest",data.enderchest)
    config.set("exp",data.exp)
    config.set("location",data.location)
    config.save(file)
}
fun load(name : String) : PlayerData {
    var data = PlayerData()
    var file = File(AbuseBlocker.configFolder, "$name.yml")
    if(!file.exists()){
        AbuseBlocker.logger.warning("Attempted to load data that didn't exist : $name.yml")
        return data
    }
    val config = YamlConfiguration.loadConfiguration(file)
    data.armorContents = (config.get("armorContents") as List<ItemStack>?)!!.toTypedArray()
    data.contents = (config.get("contents") as List<ItemStack>?)!!.toTypedArray()
    data.enderchest = (config.get("enderchest") as List<ItemStack>?)!!.toTypedArray()
    data.exp = config.get("exp") as Int
    data.location = config.get("location") as Location
    return data
}