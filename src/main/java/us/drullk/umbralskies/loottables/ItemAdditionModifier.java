package us.drullk.umbralskies.loottables;

import com.mojang.serialization.Codec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.common.loot.LootModifier;
import org.jetbrains.annotations.NotNull;

import java.util.List;

public class ItemAdditionModifier extends LootModifier {
    public static final Codec<ItemAdditionModifier> CODEC = RecordCodecBuilder.create(instance -> LootModifier.codecStart(instance)
            .and(ItemStack.CODEC.listOf().fieldOf("stacks").forGetter(o -> o.additionalStacks))
            .apply(instance, ItemAdditionModifier::new)
    );

    private final List<ItemStack> additionalStacks;

    public ItemAdditionModifier(LootItemCondition[] conditions, ItemStack... additionalStacks) {
        this(conditions, List.of(additionalStacks));
    }

    public ItemAdditionModifier(LootItemCondition[] conditions, List<ItemStack> additionalStacks) {
        super(conditions);
        this.additionalStacks = additionalStacks;
    }

    @Override
    protected @NotNull ObjectArrayList<ItemStack> doApply(ObjectArrayList<ItemStack> generatedLoot, LootContext context) {
        int overflow = (generatedLoot.size() - 27);
        if (overflow > 0) generatedLoot.removeElements(26, 26 + overflow);

        for (ItemStack stack : this.additionalStacks) {
            generatedLoot.add(stack.copy());
        }

        return generatedLoot;
    }

    @Override
    public Codec<? extends IGlobalLootModifier> codec() {
        return UmbralLootModifiers.LOOT_ADDITION.get();
    }
}
