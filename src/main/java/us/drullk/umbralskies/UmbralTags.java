package us.drullk.umbralskies;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.data.tags.TagsProvider;
import net.minecraft.tags.TagKey;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;

import java.util.concurrent.CompletableFuture;

public class UmbralTags {
    public static final TagKey<PlacedFeature> ADDED_AETHER_FEATURES = TagKey.create(Registries.PLACED_FEATURE, UmbralSkies.prefix("aether_features"));

    public static class UmbralPlacedFeatureTag extends TagsProvider<PlacedFeature> {
        protected UmbralPlacedFeatureTag(PackOutput output, CompletableFuture<HolderLookup.Provider> provider, @Nullable ExistingFileHelper existingFileHelper) {
            super(output, Registries.PLACED_FEATURE, provider, UmbralSkies.MODID, existingFileHelper);
        }

        @Override
        protected void addTags(HolderLookup.Provider provider) {
            tag(ADDED_AETHER_FEATURES).add(UmbralKeys.AETHER_DRUID_HUT, UmbralKeys.PLACEABLE_AETHER_WELL);
        }
    }
}
