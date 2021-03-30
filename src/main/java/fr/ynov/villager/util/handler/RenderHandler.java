package fr.ynov.villager.util.handler;


import fr.ynov.villager.entity.EntityCweep;
import fr.ynov.villager.entity.EntityMayor;
import fr.ynov.villager.entity.render.RenderCweep;
import fr.ynov.villager.entity.render.RenderMayor;
import net.minecraftforge.fml.client.registry.RenderingRegistry;

public class RenderHandler {
    public static void registerEntityRenders() {
        RenderingRegistry.registerEntityRenderingHandler(EntityCweep.class, RenderCweep::new);
        RenderingRegistry.registerEntityRenderingHandler(EntityMayor.class, RenderMayor::new);
    }
}
