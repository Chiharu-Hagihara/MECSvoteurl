package mc.mec.mecsvoteurl

import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.inventory.InventoryClickEvent
import org.bukkit.event.inventory.InventoryType
import java.util.logging.Logger

class EventListener(var plg : MECSvoteurl, val log : Logger = plg.getLogger()) : Listener {
    init {
        plg.server.pluginManager.registerEvents(this,plg)
    }
    @EventHandler
    fun playerInteractEvent(e: InventoryClickEvent) {
        val player: Player? = e.whoClicked as? Player
        when (e.whoClicked.openInventory.title) {
            "VOTEURL" -> {
                e.isCancelled = true

                if (e.clickedInventory?.type == InventoryType.CHEST) {
                    when (e.currentItem?.itemMeta?.displayName) {
                        "§c§l全表示" -> {
                            player?.sendMessage("§b[JMS] comming soon...")
                            player?.sendMessage("§2[monocraft] comming soon...")
                            player?.closeInventory()
                        }

                        "§b§lJMS" -> {
                            player?.sendMessage("§b[JMS] comming soon...")
                            player?.closeInventory()
                        }
                        "§2§lmonocraft" -> {
                            player?.sendMessage("§2[monocraft] comming soon...")
                            player?.closeInventory()
                        }
                    }
                }
            }
        }
    }
}