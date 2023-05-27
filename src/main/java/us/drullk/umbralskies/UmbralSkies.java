package us.drullk.umbralskies;

import com.mojang.logging.LogUtils;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import org.slf4j.Logger;
import us.drullk.umbralskies.data.DataGeneration;

// The value here should match an entry in the META-INF/mods.toml file
@Mod(UmbralSkies.MODID)
public class UmbralSkies {
    public static final String MODID = "umbral_skies";
    private static final Logger LOGGER = LogUtils.getLogger();

    public UmbralSkies() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        UmbralBlocks.BLOCKS.register(modEventBus);
        UmbralItems.ITEMS.register(modEventBus);

        modEventBus.addListener(UmbralBlocks::registerItemsForBlocks);
        modEventBus.addListener(DataGeneration::gatherData);

        MinecraftForge.EVENT_BUS.register(this);
    }

    public static ResourceLocation prefix(String name) {
        return new ResourceLocation(MODID, name);
    }
}
