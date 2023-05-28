package us.drullk.umbralskies;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.block.BanisterBlock;

public class UmbralBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UmbralSkies.MODID);

    public static final RegistryObject<BanisterBlock> SKYROOT_BANISTER = BLOCKS.register("skyroot_banister", () -> new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    static void registerItemsForBlocks(RegisterEvent event) {
        if (!ForgeRegistries.ITEMS.equals(event.getForgeRegistry())) return;

        registerItemFromBlock(event, SKYROOT_BANISTER);
    }

    private static void registerItemFromBlock(RegisterEvent event, RegistryObject<? extends Block> block) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> helper.register(block.getId(), new BlockItem(block.get(), new Item.Properties())));
    }
}
