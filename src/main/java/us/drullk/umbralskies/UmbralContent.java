package us.drullk.umbralskies;

import com.gildedgames.aether.AetherTags;
import com.gildedgames.aether.block.AetherBlocks;
import com.gildedgames.aether.world.placementmodifier.DungeonBlacklistFilter;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.HolderSet;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.GenerationStep;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.WeightedPlacedFeature;
import net.minecraft.world.level.levelgen.feature.configurations.RandomFeatureConfiguration;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraft.world.level.levelgen.placement.RarityFilter;
import net.minecraftforge.common.world.BiomeModifier;
import net.minecraftforge.common.world.ForgeBiomeModifiers;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.init.TFBlocks;
import twilightforest.init.TFFeatures;
import twilightforest.init.custom.WoodPalettes;
import twilightforest.util.WoodPalette;
import twilightforest.world.components.feature.config.SwizzleConfig;

import java.util.List;

public class UmbralContent {
    public static final ResourceKey<WoodPalette> SKYROOT_PALETTE = ResourceKey.create(WoodPalettes.WOOD_PALETTE_TYPE_KEY, UmbralSkies.prefix("skyroot"));
    public static final ResourceKey<WoodPalette> HOLYSTONE_PALETTE = ResourceKey.create(WoodPalettes.WOOD_PALETTE_TYPE_KEY, UmbralSkies.prefix("holystone"));

    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_HUT_PALETTE = ResourceKey.create(Registries.CONFIGURED_FEATURE, UmbralSkies.prefix("aether_palette_hut"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_SIMPLE_WELL_PALETTE = ResourceKey.create(Registries.CONFIGURED_FEATURE, UmbralSkies.prefix("aether_palette_simple_well"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> AETHER_FANCY_WELL_PALETTE = ResourceKey.create(Registries.CONFIGURED_FEATURE, UmbralSkies.prefix("aether_palette_fancy_well"));
    public static final ResourceKey<ConfiguredFeature<?, ?>> RANDOMIZED_AETHER_WELL = ResourceKey.create(Registries.CONFIGURED_FEATURE, UmbralSkies.prefix("randomized_aether_well"));

    public static final ResourceKey<PlacedFeature> AETHER_DRUID_HUT = ResourceKey.create(Registries.PLACED_FEATURE, UmbralSkies.prefix("aether_druid_hut"));
    public static final ResourceKey<PlacedFeature> PLACEABLE_AETHER_WELL = ResourceKey.create(Registries.PLACED_FEATURE, UmbralSkies.prefix("aether_well"));

    public static final ResourceKey<BiomeModifier> AETHER_MODIFIER = ResourceKey.create(ForgeRegistries.Keys.BIOME_MODIFIERS, UmbralSkies.prefix("aether_modifier"));

    static void generateWoodPalettes(BootstapContext<WoodPalette> context) {
        context.register(SKYROOT_PALETTE, new WoodPalette(
                AetherBlocks.SKYROOT_PLANKS.get(),
                AetherBlocks.SKYROOT_STAIRS.get(),
                AetherBlocks.SKYROOT_SLAB.get(),
                AetherBlocks.SKYROOT_BUTTON.get(),
                AetherBlocks.SKYROOT_FENCE.get(),
                AetherBlocks.SKYROOT_FENCE_GATE.get(),
                AetherBlocks.SKYROOT_PRESSURE_PLATE.get(),
                TFBlocks.CANOPY_BANISTER.get() // FIXME new block
        ));

        context.register(HOLYSTONE_PALETTE, new WoodPalette(
                AetherBlocks.HOLYSTONE.get(),
                AetherBlocks.HOLYSTONE_STAIRS.get(),
                AetherBlocks.HOLYSTONE_SLAB.get(),
                AetherBlocks.HOLYSTONE_BUTTON.get(),
                AetherBlocks.HOLYSTONE_WALL.get(),
                Blocks.AIR, // No gate for you
                AetherBlocks.HOLYSTONE_PRESSURE_PLATE.get(),
                TFBlocks.MANGROVE_BANISTER.get() // FIXME new block
        ));
    }

    static void generateFeatureConfigurations(BootstapContext<ConfiguredFeature<?, ?>> context) {
        HolderGetter<WoodPalette> woodPaletteGetter = context.lookup(WoodPalettes.WOOD_PALETTE_TYPE_KEY);

        var paletteList = UmbralData.buildPaletteChoices(woodPaletteGetter);

        SwizzleConfig aetherHutSwizzle = SwizzleConfig.generateForHut(woodPaletteGetter, paletteList);
        context.register(AETHER_HUT_PALETTE, new ConfiguredFeature<>(TFFeatures.DRUID_HUT.get(), aetherHutSwizzle));

        SwizzleConfig aetherWellSwizzle = SwizzleConfig.generateForWell(woodPaletteGetter, paletteList);
        context.register(AETHER_SIMPLE_WELL_PALETTE, new ConfiguredFeature<>(TFFeatures.SIMPLE_WELL.get(), aetherWellSwizzle));
        context.register(AETHER_FANCY_WELL_PALETTE, new ConfiguredFeature<>(TFFeatures.FANCY_WELL.get(), aetherWellSwizzle));

        context.register(RANDOMIZED_AETHER_WELL, new ConfiguredFeature<>(Feature.RANDOM_SELECTOR, new RandomFeatureConfiguration(List.of(new WeightedPlacedFeature(PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(AETHER_FANCY_WELL_PALETTE)), 0.05f)), PlacementUtils.inlinePlaced(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(AETHER_SIMPLE_WELL_PALETTE)))));
    }

    static void generatePlacedFeatures(BootstapContext<PlacedFeature> context) {
        context.register(AETHER_DRUID_HUT, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(AETHER_HUT_PALETTE), List.of(RarityFilter.onAverageOnceEvery(32), new DungeonBlacklistFilter())));
        context.register(PLACEABLE_AETHER_WELL, new PlacedFeature(context.lookup(Registries.CONFIGURED_FEATURE).getOrThrow(RANDOMIZED_AETHER_WELL), List.of(RarityFilter.onAverageOnceEvery(32), new DungeonBlacklistFilter())));
    }

    static void generateBiomeModifiers(BootstapContext<BiomeModifier> context) {
        HolderSet<Biome> aetherBiomeTarget = context.lookup(Registries.BIOME).getOrThrow(AetherTags.Biomes.IS_AETHER);
        HolderSet<PlacedFeature> twilightFeatures = context.lookup(Registries.PLACED_FEATURE).getOrThrow(UmbralTags.ADDED_AETHER_FEATURES);

        context.register(AETHER_MODIFIER, new ForgeBiomeModifiers.AddFeaturesBiomeModifier(aetherBiomeTarget, twilightFeatures, GenerationStep.Decoration.SURFACE_STRUCTURES));
    }
}
