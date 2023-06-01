package us.drullk.umbralskies.loottables;

import com.mojang.serialization.Codec;
import net.minecraftforge.common.loot.IGlobalLootModifier;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import us.drullk.umbralskies.UmbralSkies;

public class UmbralLootModifiers {
    public static final DeferredRegister<Codec<? extends IGlobalLootModifier>> LOOT_MODIFIERS = DeferredRegister.create(ForgeRegistries.Keys.GLOBAL_LOOT_MODIFIER_SERIALIZERS, UmbralSkies.MODID);

    public static final RegistryObject<Codec<ItemAdditionModifier>> LOOT_ADDITION = LOOT_MODIFIERS.register("item_addition", () -> ItemAdditionModifier.CODEC);
}
