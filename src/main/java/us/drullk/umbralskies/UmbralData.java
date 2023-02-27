package us.drullk.umbralskies;

import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.util.random.WeightedEntry;
import net.minecraft.util.random.WeightedRandomList;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.data.event.GatherDataEvent;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.data.tags.CustomTagGenerator;
import twilightforest.init.custom.WoodPalettes;
import twilightforest.util.WoodPalette;

import java.util.Collections;
import java.util.concurrent.CompletableFuture;

public class UmbralData {
    private static final RegistrySetBuilder DATA_BUILDER = new RegistrySetBuilder()
            .add(WoodPalettes.WOOD_PALETTE_TYPE_KEY, UmbralKeys::generateWoodPalettes)
            .add(Registries.CONFIGURED_FEATURE, UmbralKeys::generateFeatureConfigurations)
            .add(Registries.PLACED_FEATURE, UmbralKeys::generatePlacedFeatures)
            .add(ForgeRegistries.Keys.BIOME_MODIFIERS, UmbralKeys::generateBiomeModifiers);

    public static WeightedRandomList<WeightedEntry.Wrapper<HolderSet<WoodPalette>>> buildPaletteChoices(HolderGetter<WoodPalette> paletteHolders) {
        var skyroot = WeightedEntry.<HolderSet<WoodPalette>>wrap(HolderSet.direct(paletteHolders.getOrThrow(UmbralKeys.SKYROOT_PALETTE)), 20);
        var holystone = WeightedEntry.<HolderSet<WoodPalette>>wrap(HolderSet.direct(paletteHolders.getOrThrow(UmbralKeys.HOLYSTONE_PALETTE)), 9);
        var treasure = WeightedEntry.<HolderSet<WoodPalette>>wrap(paletteHolders.getOrThrow(CustomTagGenerator.WoodPaletteTagGenerator.TREASURE_PALETTES), 1);

        return WeightedRandomList.create(skyroot, holystone, treasure);
    }

    public static void gatherData(GatherDataEvent event) {
        boolean isServer = event.includeServer();
        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();

        generator.addProvider(isServer, new DatapackBuiltinEntriesProvider(output, provider, DATA_BUILDER, Collections.singleton(UmbralSkies.MODID)));
        generator.addProvider(isServer, new UmbralTags.UmbralPlacedFeatureTag(output, provider.thenApply(p -> DATA_BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), p)), event.getExistingFileHelper()));
    }
}
