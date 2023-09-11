package us.drullk.umbralskies.client;

import net.minecraft.client.renderer.BiomeColors;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.level.FoliageColor;
import net.minecraft.world.level.GrassColor;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import twilightforest.block.HollowLogClimbable;
import twilightforest.enums.HollowLogVariants;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UmbralColors {
    @SubscribeEvent
    public static void blockColors(RegisterColorHandlersEvent.Block event) {
        event.register((state, tintGetter, pos, index) -> (index & 1) == 0 ? 0xFF_FF_FF : GrassColor.get(0.5, 1), UmbralBlocks.HOLLOW_SKYROOT_LOG_HORIZONTAL.get(), UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_HORIZONTAL.get());
        event.register((state, tintGetter, pos, index) -> {
            if (state.getValue(HollowLogClimbable.VARIANT) != HollowLogVariants.Climbable.VINE || (index & 1) == 0)
                return 0xFF_FF_FF;

            if (tintGetter != null && pos != null)
                return BiomeColors.getAverageFoliageColor(tintGetter, pos);

            return FoliageColor.getDefaultColor();
        }, UmbralBlocks.HOLLOW_SKYROOT_LOG_CLIMBABLE.get(), UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_CLIMBABLE.get());
    }

    @SubscribeEvent
    public static void itemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, layer) -> (layer & 1) == 0 ? stack.getItem() instanceof DyeableLeatherItem leatherItem ? leatherItem.getColor(stack) : 0xFFFFFF : 0xFFFFFF, UmbralItems.ARCTIC_GLOVES.get());
    }
}
