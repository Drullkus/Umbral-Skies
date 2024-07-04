package us.drullk.umbralskies.data;

import com.aetherteam.aether.Aether;
import com.aetherteam.nitrogen.data.providers.NitrogenItemModelProvider;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.armortrim.TrimMaterial;
import net.minecraft.world.level.block.Block;
import net.neoforged.neoforge.client.model.generators.ItemModelBuilder;
import net.neoforged.neoforge.client.model.generators.ModelFile;
import net.neoforged.neoforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.neoforged.neoforge.common.data.ExistingFileHelper;
import net.neoforged.neoforge.registries.DeferredHolder;
import twilightforest.TwilightForestMod;
import twilightforest.block.HollowLogHorizontal;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.UmbralKeys;
import us.drullk.umbralskies.UmbralSkies;

import java.util.function.Consumer;

public class UmbralItemModels extends NitrogenItemModelProvider {
    public UmbralItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UmbralSkies.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.withExistingParent(UmbralBlocks.SKYROOT_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item")).texture("texture", UmbralKeys.SKYROOT_BANISTER_TEX);

        this.glovesItem(UmbralItems.NAGA_GLOVES.get());
        this.glovesItem(UmbralItems.IRONWOOD_GLOVES.get());
        this.glovesItem(UmbralItems.FIERY_GLOVES.get(), builder -> builder.customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0));
        this.glovesItem(UmbralItems.STEELEAF_GLOVES.get());
        this.glovesItem(UmbralItems.KNIGHTMETAL_GLOVES.get());
        this.glovesItem(UmbralItems.PHANTOM_GLOVES.get());
        this.glovesItem(UmbralItems.YETI_GLOVES.get());

        this.arcticGlovesItem(UmbralItems.ARCTIC_GLOVES.get());

        this.basicItem(UmbralSkies.prefix("trophy_bronze"));

        this.hollowLog(UmbralBlocks.HOLLOW_SKYROOT_LOG_HORIZONTAL);
        this.hollowLog(UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_HORIZONTAL);
    }

    private void hollowLog(DeferredHolder<Block, HollowLogHorizontal> hollowLog) {
        ResourceLocation id = hollowLog.getId();
        this.getBuilder(BuiltInRegistries.ITEM.getKey(hollowLog.get().asItem()).getPath()).parent(new ModelFile.ExistingModelFile(new ResourceLocation(id.getNamespace(), "block/" + id.getPath()), this.existingFileHelper));
    }

    public void glovesItem(Item item) {
        this.glovesItem(item, builder -> {});
    }

    public void glovesItem(Item item, Consumer<ItemModelBuilder> modifier) {
        ItemModelBuilder builderGlovesBase = this.withExistingParent(this.itemName(item), this.mcLoc("item/generated")).texture("layer0", this.modLoc("item/" + this.itemName(item)));
        modifier.accept(builderGlovesBase);

        double index = 0.1;
        for (ResourceKey<TrimMaterial> trimMaterial : NitrogenItemModelProvider.VANILLA_TRIM_MATERIALS) {
            String material = trimMaterial.location().getPath();
            String name = this.itemName(item) + "_" + material + "_trim";
            ItemModelBuilder builderTrimmedModel = this.withExistingParent(name, this.mcLoc("item/generated"))
                    .texture("layer0", this.modLoc("item/" + this.itemName(item)))
                    .texture("layer1", new ResourceLocation(Aether.MODID, "trims/items/gloves_trim_" + material));
            modifier.accept(builderTrimmedModel);
            builderGlovesBase.override().predicate(new ResourceLocation("trim_type"), (float) index).model(this.getExistingFile(this.modLoc("item/" + name))).end();
            index += 0.1;
        }
    }

    public void arcticGlovesItem(Item item) {
        ItemModelBuilder builderArcticGlovesBase = this.withExistingParent(this.itemName(item), this.mcLoc("item/generated"))
                .texture("layer0", this.modLoc("item/" + this.itemName(item)))
                .texture("layer1", UmbralSkies.prefix("item/" + UmbralItems.ARCTIC_GLOVES.getId().getPath() + "_overlay"));

        double index = 0.1;
        for (ResourceKey<TrimMaterial> trimMaterial : NitrogenItemModelProvider.VANILLA_TRIM_MATERIALS) {
            String material = trimMaterial.location().getPath();
            String name = this.itemName(item) + "_" + material + "_trim";
            this.withExistingParent(name, this.mcLoc("item/generated"))
                    .texture("layer0", this.modLoc("item/" + this.itemName(item)))
                    .texture("layer1", UmbralSkies.prefix("item/" + UmbralItems.ARCTIC_GLOVES.getId().getPath() + "_overlay"))
                    .texture("layer2", new ResourceLocation(Aether.MODID, "trims/items/gloves_trim_" + material));
            builderArcticGlovesBase.override().predicate(new ResourceLocation("trim_type"), (float) index).model(this.getExistingFile(this.modLoc("item/" + name))).end();
            index += 0.1;
        }
    }
}
