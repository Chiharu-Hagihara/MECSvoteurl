package mc.mec.mecsvoteurl

import org.bukkit.Material
import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack

object VoteCommand : CommandExecutor {
    val util = Util()
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        val player = (sender as? Player)
        if ((sender as? Player) != null) {
            player?.sendMessage("§l§nアイテムをクリックすると投票URLを表示します。")
            val guiList: Map<Int, ItemStack?> = mapOf(
                    1 to util.createItem(ItemStack(Material.REDSTONE_BLOCK), "§c§l全表示", listOf()),
                    4 to util.createItem(ItemStack(Material.DIAMOND), "§b§lJMS", listOf()),
                    7 to util.createItem(ItemStack(Material.GRASS_BLOCK), "§2§lmonocraft", listOf()))
            val inventory = util.createInventoryGUI("VOTEURL", 9, guiList)

            player?.openInventory(inventory)

        }
        return true
    }
}