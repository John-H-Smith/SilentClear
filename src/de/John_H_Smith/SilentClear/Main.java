package de.John_H_Smith.SilentClear;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	public Logger log = this.getLogger();
	
	@Override
	public void onEnable() {
		log.info("[SilentClear] by John_H_Smith enabled!");
	}
	
	@Override
	public void onDisable() {
		log.info("[SilentClear] by John_H_Smith disabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String label,
			String[] args) {
		if(sender instanceof Player) {
			Player player = (Player) sender;
			
			if(cmd.getName().equalsIgnoreCase("silentclear")) {
				
				if(args.length == 0) {
					if(player.hasPermission("sclear.self")) {
						player.getInventory().clear();
						return true;
					}
				}
				
				if(args.length == 1) {
					if(player.hasPermission("sclear.others")) {
						Player ziel = Bukkit.getPlayer(args[0]);
						if(ziel != null) {
							ziel.getInventory().clear();
							player.sendMessage("Cleared the inventory of "+args[0]);
						}
						else player.sendMessage("The player is not online!");
						return true;
					}
				}
			}
			
		} else { sender.sendMessage("This is a player only command!"); return true; }
		
		
		return false;
	}

}
