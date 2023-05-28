package us.drullk.umbralskies;

import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import us.drullk.umbralskies.client.EmissiveGlovesRenderer;
import us.drullk.umbralskies.item.UmbralItems;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UmbralClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        registerCuriosRenderers();
    }

    private static void registerCuriosRenderers() {
        CuriosRendererRegistry.register(UmbralItems.NAGA_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.IRONWOOD_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.FIERY_GLOVES.get(), EmissiveGlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.STEELEAF_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.KNIGHTMETAL_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.PHANTOM_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.ARCTIC_GLOVES.get(), GlovesRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.YETI_GLOVES.get(), GlovesRenderer::new);
    }
}
