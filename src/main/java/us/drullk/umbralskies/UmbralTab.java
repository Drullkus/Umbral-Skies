package us.drullk.umbralskies;

import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;

@Mod.EventBusSubscriber(bus = Mod.EventBusSubscriber.Bus.MOD)
public class UmbralTab {
    public static final String TAB_LOCALE = "itemGroup.umbral_skies";

    @SubscribeEvent
    public static void registerTab(CreativeModeTabEvent.Register event) {
        event.registerCreativeModeTab(UmbralSkies.prefix("items"), UmbralTab::configureTab);
    }

    private static void configureTab(CreativeModeTab.Builder builder) {
        builder
                .title(Component.translatable(TAB_LOCALE))
                .icon(() -> new ItemStack(UmbralItems.FIERY_GLOVES.get()))
                .displayItems(UmbralTab::generateItems);
    }

    private static void generateItems(CreativeModeTab.ItemDisplayParameters parameters, CreativeModeTab.Output output) {
        output.accept(UmbralBlocks.SKYROOT_BANISTER.get());

        output.accept(UmbralItems.NAGA_GLOVES.get());
        output.accept(UmbralItems.IRONWOOD_GLOVES.get());
        output.accept(UmbralItems.FIERY_GLOVES.get());
        output.accept(UmbralItems.STEELEAF_GLOVES.get());
        output.accept(UmbralItems.KNIGHTMETAL_GLOVES.get());
        output.accept(UmbralItems.PHANTOM_GLOVES.get());
        output.accept(UmbralItems.ARCTIC_GLOVES.get());
        output.accept(UmbralItems.YETI_GLOVES.get());

        output.accept(UmbralItems.SLIDER_TROPHY.get());
        output.accept(UmbralItems.VALKYRIE_QUEEN_TROPHY.get());
        output.accept(UmbralItems.SUN_SPIRIT_TROPHY.get());
    }
}
