package us.drullk.umbralskies.client;

import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderers;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.neoforge.client.event.ModelEvent;
import net.neoforged.neoforge.client.event.RenderLivingEvent;
import top.theillusivec4.curios.api.CuriosApi;
import top.theillusivec4.curios.api.SlotResult;
import top.theillusivec4.curios.api.client.CuriosRendererRegistry;
import twilightforest.compat.curios.renderer.CurioHeadRenderer;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.client.renderer.EmissiveGlovesRenderer;
import us.drullk.umbralskies.client.renderer.SliderTrophyRenderer;
import us.drullk.umbralskies.client.renderer.SunSpiritTrophyRenderer;
import us.drullk.umbralskies.client.renderer.ValkyrieQueenTrophyRenderer;
import us.drullk.umbralskies.item.AetherTrophyItem;
import us.drullk.umbralskies.item.UmbralItems;

import java.util.Optional;

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

        CuriosRendererRegistry.register(UmbralItems.SLIDER_TROPHY.get(), CurioHeadRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.VALKYRIE_QUEEN_TROPHY.get(), CurioHeadRenderer::new);
        CuriosRendererRegistry.register(UmbralItems.SUN_SPIRIT_TROPHY.get(), CurioHeadRenderer::new);
    }

    @Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.FORGE)
    public static class Events {
        @SubscribeEvent
        public static void renderLiving(RenderLivingEvent.Pre<?, ?> event) {
            ItemStack stack = event.getEntity().getItemBySlot(EquipmentSlot.HEAD);

            if (!(stackIsTrophy(stack) || isWearingTrophyCurio(event))) return;
            if (!(event.getRenderer().getModel() instanceof HeadedModel headedModel)) return;

            headedModel.getHead().visible = false;

            if (!(headedModel instanceof HumanoidModel<?> humanoidModel)) return;

            humanoidModel.hat.visible = false;
        }

        private static boolean stackIsTrophy(ItemStack stack) {
            return stack.getItem() instanceof AetherTrophyItem;
        }

        private static boolean isWearingTrophyCurio(RenderLivingEvent<?, ?> event) {
            @SuppressWarnings({"UnstableApiUsage", "removal"})
            Optional<SlotResult> slot = CuriosApi.getCuriosHelper().findFirstCurio(event.getEntity(), Events::stackIsTrophy);
            return slot.isPresent() && slot.get().slotContext() != null && slot.get().slotContext().visible();
        }
    }
}
