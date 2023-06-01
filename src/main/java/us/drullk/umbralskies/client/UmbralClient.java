package us.drullk.umbralskies.client;

import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.ModelEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.client.renderer.EmissiveGlovesRenderer;
import us.drullk.umbralskies.client.renderer.SliderTrophyRenderer;
import us.drullk.umbralskies.client.renderer.SunSpiritTrophyRenderer;
import us.drullk.umbralskies.client.renderer.ValkyrieQueenTrophyRenderer;
import us.drullk.umbralskies.item.UmbralItems;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UmbralClient {
    @SubscribeEvent
    public static void clientSetup(FMLClientSetupEvent event) {
        BlockEntityRenderers.register(UmbralBlocks.SLIDER_TROPHY_ENTITY.get(), SliderTrophyRenderer::new);
        BlockEntityRenderers.register(UmbralBlocks.VALKYRIE_TROPHY_ENTITY.get(), ValkyrieQueenTrophyRenderer::new);
        BlockEntityRenderers.register(UmbralBlocks.SUN_SPIRIT_TROPHY_ENTITY.get(), SunSpiritTrophyRenderer::new);
        registerCuriosRenderers();
    }

    @SubscribeEvent
    public static void registerExtraModels(ModelEvent.RegisterAdditional event) {
        event.register(new ModelResourceLocation(UmbralSkies.prefix("trophy_bronze"), "inventory"));
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
