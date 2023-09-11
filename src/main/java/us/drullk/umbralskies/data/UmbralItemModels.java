package us.drullk.umbralskies.data;

import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.ModelFile;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.TwilightForestMod;
import twilightforest.block.HollowLogHorizontal;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.UmbralKeys;
import us.drullk.umbralskies.UmbralSkies;

public class UmbralItemModels extends ItemModelProvider {
    public UmbralItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UmbralSkies.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        this.withExistingParent(UmbralBlocks.SKYROOT_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item")).texture("texture", UmbralKeys.SKYROOT_BANISTER_TEX);

        this.basicItem(UmbralItems.NAGA_GLOVES.get());
        this.basicItem(UmbralItems.IRONWOOD_GLOVES.get());
        this.basicItem(UmbralItems.FIERY_GLOVES.get()).customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).end();
        this.basicItem(UmbralItems.STEELEAF_GLOVES.get());
        this.basicItem(UmbralItems.KNIGHTMETAL_GLOVES.get());
        this.basicItem(UmbralItems.PHANTOM_GLOVES.get());
        this.basicItem(UmbralItems.ARCTIC_GLOVES.get()).texture("layer1", UmbralSkies.prefix("item/" + UmbralItems.ARCTIC_GLOVES.getId().getPath() + "_overlay"));
        this.basicItem(UmbralItems.YETI_GLOVES.get());

        this.basicItem(UmbralSkies.prefix("trophy_bronze"));

        this.hollowLog(UmbralBlocks.HOLLOW_SKYROOT_LOG_HORIZONTAL);
        this.hollowLog(UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_HORIZONTAL);
    }

    private void hollowLog(RegistryObject<HollowLogHorizontal> hollowLog) {
        ResourceLocation id = hollowLog.getId();
        this.getBuilder(ForgeRegistries.ITEMS.getKey(hollowLog.get().asItem()).getPath()).parent(new ModelFile.ExistingModelFile(new ResourceLocation(id.getNamespace(), "block/" + id.getPath()), this.existingFileHelper));
    }
}
