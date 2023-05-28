package us.drullk.umbralskies.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.client.model.generators.ItemModelProvider;
import net.minecraftforge.client.model.generators.loaders.ItemLayerModelBuilder;
import net.minecraftforge.common.data.ExistingFileHelper;
import twilightforest.TwilightForestMod;
import us.drullk.umbralskies.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.UmbralKeys;
import us.drullk.umbralskies.UmbralSkies;

public class ItemModels extends ItemModelProvider {
    public ItemModels(PackOutput output, ExistingFileHelper existingFileHelper) {
        super(output, UmbralSkies.MODID, existingFileHelper);
    }

    @Override
    protected void registerModels() {
        withExistingParent(UmbralBlocks.SKYROOT_BANISTER.getId().toString(), TwilightForestMod.prefix("item/banister_item")).texture("texture", UmbralKeys.SKYROOT_BANISTER_TEX);

        basicItem(UmbralItems.NAGA_GLOVES.get());
        basicItem(UmbralItems.IRONWOOD_GLOVES.get());
        basicItem(UmbralItems.FIERY_GLOVES.get()).customLoader(ItemLayerModelBuilder::begin).emissive(15, 15, 0).end();
        basicItem(UmbralItems.STEELEAF_GLOVES.get());
        basicItem(UmbralItems.KNIGHTMETAL_GLOVES.get());
        basicItem(UmbralItems.PHANTOM_GLOVES.get());
        basicItem(UmbralItems.ARCTIC_GLOVES.get()).texture("layer1", UmbralSkies.prefix("item/" + UmbralItems.ARCTIC_GLOVES.getId().getPath() + "_overlay"));
        basicItem(UmbralItems.YETI_GLOVES.get());
    }
}
