package us.drullk.umbralskies.data;

import net.minecraft.DetectedVersion;
import net.minecraft.core.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.PackOutput;
import net.minecraft.data.metadata.PackMetadataGenerator;
import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraftforge.common.data.DatapackBuiltinEntriesProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.data.event.GatherDataEvent;
import us.drullk.umbralskies.UmbralSkies;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.stream.Collectors;

public class UmbralData {
    public static void generateData(GatherDataEvent event) {
        boolean isServer = event.includeServer();
        boolean isClient = event.includeClient();

        DataGenerator generator = event.getGenerator();
        PackOutput output = generator.getPackOutput();
        CompletableFuture<HolderLookup.Provider> provider = event.getLookupProvider();
        ExistingFileHelper existingFileHelper = event.getExistingFileHelper();

        generator.addProvider(isClient, new UmbralLocaleData(output));
        generator.addProvider(isClient, new UmbralBlockStateModels(output, existingFileHelper));
        generator.addProvider(isClient, new UmbralItemModels(output, existingFileHelper));
        UmbralTags.UmbralBlockTags blockTags = new UmbralTags.UmbralBlockTags(output, provider, existingFileHelper);
        generator.addProvider(isServer, blockTags);
        generator.addProvider(isServer, new UmbralTags.UmbralItemTags(output, provider, blockTags.contentsGetter(), existingFileHelper));
        generator.addProvider(isServer, new DatapackBuiltinEntriesProvider(output, provider, UmbralDataPack.DATA_BUILDER, Collections.singleton(UmbralSkies.MODID)));
        generator.addProvider(isServer, new UmbralTags.UmbralPlacedFeatureTags(output, provider.thenApply(p -> UmbralDataPack.DATA_BUILDER.buildPatch(RegistryAccess.fromRegistryOfRegistries(BuiltInRegistries.REGISTRY), p)), existingFileHelper));
        generator.addProvider(isServer, new UmbralRecipes(output));
        generator.addProvider(isServer, new UmbralLootModifiers(output));
        generator.addProvider(isServer, new UmbralLoot(output));

        generator.addProvider(true, new PackMetadataGenerator(output).add(PackMetadataSection.TYPE, new PackMetadataSection(
                Component.literal("Umbral Skies resources"),
                DetectedVersion.BUILT_IN.getPackVersion(PackType.CLIENT_RESOURCES),
                Arrays.stream(PackType.values()).collect(Collectors.toMap(Function.identity(), DetectedVersion.BUILT_IN::getPackVersion)))));
    }
}
