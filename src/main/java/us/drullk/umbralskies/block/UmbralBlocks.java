package us.drullk.umbralskies.block;

import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegisterEvent;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.block.BanisterBlock;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.block.entity.AetherTrophyEntity;

public class UmbralBlocks {
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, UmbralSkies.MODID);
    public static final DeferredRegister<BlockEntityType<?>> BLOCK_ENTITIES = DeferredRegister.create(ForgeRegistries.BLOCK_ENTITY_TYPES, UmbralSkies.MODID);

    public static final RegistryObject<BanisterBlock> SKYROOT_BANISTER = BLOCKS.register("skyroot_banister", () -> new BanisterBlock(BlockBehaviour.Properties.copy(Blocks.OAK_PLANKS)));

    public static final RegistryObject<FloorAetherTrophyBlock> SLIDER_TROPHY_BLOCK = BLOCKS.register("slider_trophy", () -> new FloorAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.SLIDER_TROPHY_ENTITY));
    public static final RegistryObject<FloorAetherTrophyBlock> VALKYRIE_QUEEN_TROPHY_BLOCK = BLOCKS.register("valkyrie_queen_trophy", () -> new FloorAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.VALKYRIE_TROPHY_ENTITY));
    public static final RegistryObject<FloorAetherTrophyBlock> SUN_SPIRIT_TROPHY_BLOCK = BLOCKS.register("sun_spirit_trophy", () -> new FloorAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.SUN_SPIRIT_TROPHY_ENTITY));
    public static final RegistryObject<WallAetherTrophyBlock> SLIDER_WALL_TROPHY_BLOCK = BLOCKS.register("slider_wall_trophy", () -> new WallAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.SLIDER_TROPHY_ENTITY));
    public static final RegistryObject<WallAetherTrophyBlock> VALKYRIE_WALL_QUEEN_TROPHY_BLOCK = BLOCKS.register("valkyrie_queen_wall_trophy", () -> new WallAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.VALKYRIE_TROPHY_ENTITY));
    public static final RegistryObject<WallAetherTrophyBlock> SUN_SPIRIT_WALL_TROPHY_BLOCK = BLOCKS.register("sun_spirit_wall_trophy", () -> new WallAetherTrophyBlock(BlockBehaviour.Properties.of(Material.DECORATION).instabreak(), UmbralBlocks.SUN_SPIRIT_TROPHY_ENTITY));

    public static final RegistryObject<BlockEntityType<AetherTrophyEntity>> SLIDER_TROPHY_ENTITY = BLOCK_ENTITIES.register("slider_trophy", () -> BlockEntityType.Builder.of(AetherTrophyEntity::slider, UmbralBlocks.SLIDER_TROPHY_BLOCK.get(), UmbralBlocks.SLIDER_WALL_TROPHY_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<AetherTrophyEntity>> VALKYRIE_TROPHY_ENTITY = BLOCK_ENTITIES.register("valkyrie_queen_trophy", () -> BlockEntityType.Builder.of(AetherTrophyEntity::valkyrie, UmbralBlocks.VALKYRIE_QUEEN_TROPHY_BLOCK.get(), UmbralBlocks.VALKYRIE_WALL_QUEEN_TROPHY_BLOCK.get()).build(null));
    public static final RegistryObject<BlockEntityType<AetherTrophyEntity>> SUN_SPIRIT_TROPHY_ENTITY = BLOCK_ENTITIES.register("sun_spirit_trophy", () -> BlockEntityType.Builder.of(AetherTrophyEntity::sunSpirit, UmbralBlocks.SUN_SPIRIT_TROPHY_BLOCK.get(), UmbralBlocks.SUN_SPIRIT_WALL_TROPHY_BLOCK.get()).build(null));

    public static void registerItemsForBlocks(RegisterEvent event) {
        if (!ForgeRegistries.ITEMS.equals(event.getForgeRegistry())) return;

        registerItemFromBlock(event, SKYROOT_BANISTER);
    }

    private static void registerItemFromBlock(RegisterEvent event, RegistryObject<? extends Block> block) {
        event.register(ForgeRegistries.Keys.ITEMS, helper -> helper.register(block.getId(), new BlockItem(block.get(), new Item.Properties())));
    }
}
