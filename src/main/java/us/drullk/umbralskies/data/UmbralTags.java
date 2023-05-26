package us.drullk.umbralskies.data;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import twilightforest.data.tags.BlockTagGenerator;
import us.drullk.umbralskies.UmbralContent;
import us.drullk.umbralskies.UmbralSkies;

import java.util.concurrent.CompletableFuture;

public class UmbralTags {
    public static final TagKey<Block> AETHER_WORLDGEN = TagKey.create(Registries.BLOCK, UmbralSkies.prefix("generation_replaceable"));
    public static final TagKey<PlacedFeature> ADDED_AETHER_FEATURES = TagKey.create(Registries.PLACED_FEATURE, UmbralSkies.prefix("twilight_to_aether_features"));

    public static class UmbralPlacedFeatureTags extends TagsProvider<PlacedFeature> {
        protected UmbralPlacedFeatureTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.PLACED_FEATURE, provider, UmbralSkies.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ADDED_AETHER_FEATURES).add(UmbralContent.AETHER_DRUID_HUT, UmbralContent.PLACEABLE_AETHER_WELL);
        }
    }

    public static class UmbralBlockTags extends BlockTagsProvider {
        public UmbralBlockTags(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, provider, UmbralSkies.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(AETHER_WORLDGEN).addTags(BlockTags.SCULK_REPLACEABLE_WORLD_GEN, Tags.Blocks.STONE, BlockTags.DIRT)
                    // Tag isn't available during datagen, using regular addTag crashes datagen
                    .addOptionalTag(BlockTagGenerator.WORLDGEN_REPLACEABLES.location());
        }
    }
}
