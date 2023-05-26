package us.drullk.umbralskies.data;

import net.minecraft.core.Direction;
import net.minecraft.data.PackOutput;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.client.model.generators.ConfiguredModel;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.ForgeRegistries;
import twilightforest.TwilightForestMod;
import twilightforest.block.BanisterBlock;
import us.drullk.umbralskies.UmbralBlocks;
import us.drullk.umbralskies.UmbralKeys;
import us.drullk.umbralskies.UmbralSkies;

public class BlockStateModels extends BlockStateProvider {
    public BlockStateModels(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, UmbralSkies.MODID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
        banister(UmbralBlocks.SKYROOT_BANISTER.get(), UmbralKeys.SKYROOT_BANISTER_TEX, "skyroot");
    }

    private void banister(BanisterBlock banister, ResourceLocation tex0, String woodName) {
        String banisterDir = "block/wood/banister/" + woodName + "/";

        getVariantBuilder(banister).forAllStatesExcept(state -> {
            Direction facing = state.getValue(BanisterBlock.FACING);
            int yRot = (int) facing.toYRot();
            String extended = state.getValue(BanisterBlock.EXTENDED) ? "_extended" : "";
            String variant = state.getValue(BanisterBlock.SHAPE).getSerializedName() + extended;

            return ConfiguredModel.builder()
                    .modelFile(models().withExistingParent(banisterDir + getBlockName(banister) + "_" + variant, TwilightForestMod.prefix("banister_" + variant)).texture("texture", tex0)).rotationY(yRot).build();
            //String modelName = banisterDir + getBlockName(banister) + "_" + variant;
            //ResourceLocation parentName = TwilightForestMod.prefix("banister_" + variant);
            //return ConfiguredModel.builder()
            //        .modelFile(models().getBuilder(modelName).parent(new ModelFile.UncheckedModelFile(parentName)).texture("texture", tex0)).rotationY(yRot).build();
        }, BanisterBlock.WATERLOGGED);
    }

    private String getBlockName(Block block) {
        return ForgeRegistries.BLOCKS.getKey(block).getPath();
    }
}
