package us.drullk.umbralskies;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.fml.Bindings;
import net.neoforged.fml.common.Mod;
import org.slf4j.Logger;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.data.UmbralData;
import us.drullk.umbralskies.item.PhantomGloves;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.loottables.UmbralLootModifiers;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UmbralSkies.MODID)
public class UmbralSkies {
    public static final String MODID = "umbral_skies";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UmbralSkies(IEventBus modEventBus) {
        UmbralBlocks.BLOCKS.register(modEventBus);
        UmbralBlocks.BLOCK_ENTITIES.register(modEventBus);
        UmbralItems.ITEMS.register(modEventBus);
        UmbralLootModifiers.LOOT_MODIFIERS.register(modEventBus);
        UmbralTab.TABS.register(modEventBus);

        modEventBus.addListener(UmbralBlocks::registerItemsForBlocks);
        modEventBus.addListener(UmbralData::generateData);

        Bindings.getForgeBus().get().addListener(PhantomGloves::keepPhantomGloves);
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name);
    }
}
