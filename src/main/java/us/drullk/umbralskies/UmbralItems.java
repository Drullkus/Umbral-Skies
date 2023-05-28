package us.drullk.umbralskies;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.enums.TwilightArmorMaterial;
import twilightforest.init.TFSounds;

public class UmbralItems {
    static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UmbralSkies.MODID);

    public static final RegistryObject<GlovesItem> NAGA_GLOVES = ITEMS.register("naga_gloves", () -> new GlovesItem(0.25, "naga_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_NAGA.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> IRONWOOD_GLOVES = ITEMS.register("ironwood_gloves", () -> new GlovesItem(0.5, "ironwood_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_IRONWOOD.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> FIERY_GLOVES = ITEMS.register("fiery_gloves", () -> new GlovesItem(1, "fiery_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_FIERY.getDurabilityForType(ArmorItem.Type.BOOTS)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> STEELEAF_GLOVES = ITEMS.register("steeleaf_gloves", () -> new GlovesItem(1, "steeleaf_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_STEELEAF.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> KNIGHTMETAL_GLOVES = ITEMS.register("knightmetal_gloves", () -> new GlovesItem(1, "knightmetal_gloves", TFSounds.KNIGHTMETAL_EQUIP, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_KNIGHTLY.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> PHANTOM_GLOVES = ITEMS.register("phantom_gloves", () -> new GlovesItem(1, "phantom_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_PHANTOM.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> ARCTIC_GLOVES = ITEMS.register("arctic_gloves", () -> new DyeableGloves(0.25, "arctic_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_ARCTIC.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> YETI_GLOVES = ITEMS.register("yeti_gloves", () -> new GlovesItem(0.75, "yeti_gloves", () -> SoundEvents.ARMOR_EQUIP_GENERIC, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_YETI.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));
}
