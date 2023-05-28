package us.drullk.umbralskies.client;

import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterColorHandlersEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import us.drullk.umbralskies.item.UmbralItems;

@Mod.EventBusSubscriber(value = Dist.CLIENT, bus = Mod.EventBusSubscriber.Bus.MOD)
public class UmbralColors {
    @SubscribeEvent
    public static void itemColors(RegisterColorHandlersEvent.Item event) {
        event.register((stack, layer) -> (layer & 1) == 0 ? stack.getItem() instanceof DyeableLeatherItem leatherItem ? leatherItem.getColor(stack) : 0xFFFFFF : 0xFFFFFF, UmbralItems.ARCTIC_GLOVES.get());
    }
}
