package me.danybv.projectilebugfix;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

public class ProjectileBugFix extends JavaPlugin implements Listener {
	
	public void onEnable()
	{
		saveDefaultConfig();
		getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onEntityDamage(EntityDamageByEntityEvent e)
	{
		if(e.getEntity() instanceof Player)
		{
			Player p1 = (Player) e.getEntity();
			if(e.getDamager() instanceof Snowball)
			{
				Snowball s = (Snowball) e.getDamager();
				if(s.getShooter() instanceof Player)
				{
					Player p2 = (Player) s.getShooter();
					if(p1.equals(p2))
					{
						e.setCancelled(true);
						if(getConfig().getBoolean("message.enabled"))
							p1.sendMessage(ChatColor.translateAlternateColorCodes('&', getConfig().getString("message.text")));
						p1.setVelocity(new Vector(0, 0, 0));
					}
				}
			}
		}
	}
	
}
