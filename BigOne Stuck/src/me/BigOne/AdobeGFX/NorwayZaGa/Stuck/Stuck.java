
package me.BigOne.AdobeGFX.NorwayZaGa.Stuck;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;


public class Stuck extends JavaPlugin
{
	public ChatColor red = ChatColor.RED;
	public ChatColor gray = ChatColor.GRAY;
	public ChatColor green = ChatColor.GREEN;
	String console = red + "Denne kommandoen kan bare bli kjørt av en spiller!";
	String permission = red + "Du har ikke permission til dette!";
	String message1 = green + "Du ble teleportert til topps.";

  
  public void onDisable() {
    System.out.println("=========( BigOne Stuck )=========");
    System.out.println("[BigOne Stuck] is disabled!");
  }

  public void onEnable() {
    System.out.println("=========( BigOne Stuck )=========");
    System.out.println("[BigOne Stuck] is enabled!");
  }
  public boolean onCommand(CommandSender sender, Command command, String label, String[] args)
  {
	  if (!(sender instanceof Player)) {
		  sender.sendMessage(ChatColor.RED + console);
		  return true;
	  }
	  Player p = (Player) sender;
	  Location loc = p.getLocation();
	  Block b = p.getWorld().getHighestBlockAt(loc.getBlockX(), loc.getBlockZ());
	  Location l = new Location(p.getWorld(), b.getX() + 0.5D, b.getY(), b.getZ() + 0.5D, p.getLocation().getYaw(), p.getLocation().getPitch());
	  if (command.getName().equalsIgnoreCase("stuck")) {
		  if (!p.hasPermission("BigOne.stuck")) {
			  p.sendMessage(permission);
			  return true;
		  }
		  if (args.length >= 0) {
			  p.teleport(l);
			  p.sendMessage(message1);
			  return true;
		  }
	  }
	  return true;
}
}