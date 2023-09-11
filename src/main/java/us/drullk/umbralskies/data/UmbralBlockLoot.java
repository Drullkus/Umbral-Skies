package us.drullk.umbralskies.data;

import net.minecraft.advancements.critereon.StatePropertiesPredicate;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.loot.BlockLootSubProvider;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.storage.loot.LootPool;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.entries.LootItem;
import net.minecraft.world.level.storage.loot.functions.ApplyBonusCount;
import net.minecraft.world.level.storage.loot.functions.SetItemCountFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemBlockStatePropertyCondition;
import net.minecraft.world.level.storage.loot.providers.number.ConstantValue;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.block.HollowLogClimbable;
import twilightforest.block.HollowLogHorizontal;
import twilightforest.block.HollowLogVertical;
import twilightforest.enums.HollowLogVariants;
import twilightforest.init.TFBlocks;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.block.FloorAetherTrophyBlock;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.block.WallAetherTrophyBlock;
import us.drullk.umbralskies.item.AetherTrophyItem;
import us.drullk.umbralskies.item.UmbralItems;

import java.util.Map;
import java.util.Set;

public class UmbralBlockLoot extends BlockLootSubProvider {
    protected UmbralBlockLoot() {
        super(Set.of(), FeatureFlags.REGISTRY.allFlags());
    }

    @Override
    protected void generate() {
        this.dropSelf(UmbralBlocks.SKYROOT_BANISTER.get());

        this.hollowLogs(UmbralBlocks.HOLLOW_SKYROOT_LOG_HORIZONTAL, UmbralBlocks.HOLLOW_SKYROOT_LOG_VERTICAL, UmbralBlocks.HOLLOW_SKYROOT_LOG_CLIMBABLE);
        this.hollowLogs(UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_HORIZONTAL, UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_VERTICAL, UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_CLIMBABLE);

        this.trophy(UmbralItems.SLIDER_TROPHY, UmbralBlocks.SLIDER_TROPHY_BLOCK, UmbralBlocks.SLIDER_WALL_TROPHY_BLOCK);
        this.trophy(UmbralItems.VALKYRIE_QUEEN_TROPHY, UmbralBlocks.VALKYRIE_QUEEN_TROPHY_BLOCK, UmbralBlocks.VALKYRIE_WALL_QUEEN_TROPHY_BLOCK);
        this.trophy(UmbralItems.SUN_SPIRIT_TROPHY, UmbralBlocks.SUN_SPIRIT_TROPHY_BLOCK, UmbralBlocks.SUN_SPIRIT_WALL_TROPHY_BLOCK);
    }

    private void trophy(RegistryObject<AetherTrophyItem> itemTrophy, RegistryObject<FloorAetherTrophyBlock> floorTrophy, RegistryObject<WallAetherTrophyBlock> wallTrophy) {
        var table = this.createSingleItemTable(itemTrophy.get());
        this.add(floorTrophy.get(), table);
        this.add(wallTrophy.get(), table);
    }

    private void hollowLogs(RegistryObject<HollowLogHorizontal> horizontalLog, RegistryObject<HollowLogVertical> verticalLog, RegistryObject<HollowLogClimbable> climbable) {
        this.add(horizontalLog.get(), this.horizontalHollowLog(horizontalLog.get()));
        this.add(verticalLog.get(), this.verticalHollowLog(verticalLog.get()));
        this.add(climbable.get(), this.climbableHollowLog(climbable.get()));
    }

    private LootTable.Builder horizontalHollowLog(HollowLogHorizontal log) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(log.asItem()).when(HAS_SILK_TOUCH).otherwise(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.GRASS).when(HAS_SILK_TOUCH).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogHorizontal.VARIANT, HollowLogVariants.Horizontal.MOSS_AND_GRASS)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(TFBlocks.MOSS_PATCH.get()).when(HAS_SILK_TOUCH).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogHorizontal.VARIANT, HollowLogVariants.Horizontal.MOSS_AND_GRASS)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(TFBlocks.MOSS_PATCH.get()).when(HAS_SILK_TOUCH).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogHorizontal.VARIANT, HollowLogVariants.Horizontal.MOSS)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Items.SNOWBALL).when(HAS_SILK_TOUCH).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogHorizontal.VARIANT, HollowLogVariants.Horizontal.SNOW)))));
    }

    private LootTable.Builder verticalHollowLog(HollowLogVertical log) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(log.asItem()).when(HAS_SILK_TOUCH).otherwise(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))));
    }

    private LootTable.Builder climbableHollowLog(HollowLogClimbable log) {
        return LootTable.lootTable()
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(log.asItem()).when(HAS_SILK_TOUCH).otherwise(LootItem.lootTableItem(Items.STICK).apply(SetItemCountFunction.setCount(UniformGenerator.between(2.0F, 4.0F))).apply(ApplyBonusCount.addUniformBonusCount(Enchantments.BLOCK_FORTUNE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.VINE).when(HAS_SILK_TOUCH).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogClimbable.VARIANT, HollowLogVariants.Climbable.VINE)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.LADDER).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogClimbable.VARIANT, HollowLogVariants.Climbable.LADDER)))))
                .withPool(LootPool.lootPool().setRolls(ConstantValue.exactly(1.0F))
                        .add(LootItem.lootTableItem(Blocks.LADDER).when(LootItemBlockStatePropertyCondition.hasBlockStateProperties(log).setProperties(StatePropertiesPredicate.Builder.properties().hasProperty(HollowLogClimbable.VARIANT, HollowLogVariants.Climbable.LADDER_WATERLOGGED)))));
    }

    @Override
    protected Iterable<Block> getKnownBlocks() {
        return ForgeRegistries.BLOCKS.getEntries().stream().filter(entry -> UmbralSkies.MODID.equals(entry.getKey().location().getNamespace())).map(Map.Entry::getValue).toList();
    }
}
