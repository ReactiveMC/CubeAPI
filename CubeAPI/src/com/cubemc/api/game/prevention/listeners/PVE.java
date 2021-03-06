package com.cubemc.api.game.prevention.listeners;

import com.cubemc.api.CubeAPI;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;

/**
 * Created by william_burns.
 * All the code and any API's associated with it
 * are not to be used anywhere else without written
 * consent of William Burns. 2014.
 * 07/04/2015
 */
public class PVE implements Listener {

    @EventHandler
    public void onPVE(EntityDamageByEntityEvent e){

        if (CubeAPI.getGameManager().getGame() == null) return;
        if (CubeAPI.getGameManager().getGame().getSet().isCanPVE()) return;

        if ((e.getDamager() instanceof Player) || (e.getEntity() instanceof Player)){
            e.setCancelled(true);

            if (e.getDamager() instanceof Player){
                ((Player)e.getDamager()).sendMessage("§4§lNO! » §cPVE is disabled.");
                return;
            }
        }
    }

}
