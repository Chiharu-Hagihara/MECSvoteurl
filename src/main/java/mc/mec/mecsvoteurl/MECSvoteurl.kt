package mc.mec.mecsvoteurl

import org.bukkit.plugin.java.JavaPlugin
import java.util.*

class MECSvoteurl : JavaPlugin() {
    override fun onEnable() {
        // Plugin startup logic
        getCommand("vote")?.setExecutor(VoteCommand)
        EventListener(this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}