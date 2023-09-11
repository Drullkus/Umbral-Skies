package us.drullk.umbralskies.data;

import com.aetherteam.aether.loot.AetherLoot;
import net.minecraft.data.PackOutput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.data.GlobalLootModifierProvider;
import net.minecraftforge.common.loot.LootTableIdCondition;
import twilightforest.loot.TFLootTables;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.loottables.ItemAdditionModifier;

public class UmbralLootModifiers extends GlobalLootModifierProvider {
    public UmbralLootModifiers(PackOutput output) {
        super(output, UmbralSkies.MODID);
    }

    @Override
    protected void start() {
        // /give @p chest{"BlockEntityTag":{"LootTable":"twilightforest:chests/stronghold_boss"}}
        // /give @p chest{"BlockEntityTag":{"LootTable":"aether:chests/dungeon/bronze/bronze_dungeon_reward"}}
        // /give @p chest{"BlockEntityTag":{"LootTable":"aether:chests/dungeon/silver/silver_dungeon_reward"}}
        // /give @p chest{"BlockEntityTag":{"LootTable":"aether:chests/dungeon/gold/gold_dungeon_reward"}}

        this.add("add_phantom_gloves", new ItemAdditionModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(TFLootTables.STRONGHOLD_BOSS.lootTable).build() }, new ItemStack(UmbralItems.PHANTOM_GLOVES.get())));
        this.add("add_slider_trophy", new ItemAdditionModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(AetherLoot.BRONZE_DUNGEON_REWARD).build() }, new ItemStack(UmbralItems.SLIDER_TROPHY.get())));
        this.add("add_valkyrie_queen_trophy", new ItemAdditionModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(AetherLoot.SILVER_DUNGEON_REWARD).build() }, new ItemStack(UmbralItems.VALKYRIE_QUEEN_TROPHY.get())));
        this.add("add_sun_spirit_trophy", new ItemAdditionModifier(new LootItemCondition[]{ new LootTableIdCondition.Builder(AetherLoot.GOLD_DUNGEON_REWARD).build() }, new ItemStack(UmbralItems.SUN_SPIRIT_TROPHY.get())));
    }
}
