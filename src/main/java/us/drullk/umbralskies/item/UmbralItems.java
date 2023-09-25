package us.drullk.umbralskies.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Rarity;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import twilightforest.enums.TwilightArmorMaterial;
import twilightforest.init.TFSounds;
import us.drullk.umbralskies.UmbralSkies;
import us.drullk.umbralskies.block.UmbralBlocks;

import java.util.function.Supplier;

public class UmbralItems {
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, UmbralSkies.MODID);

    private static final Supplier<SoundEvent> GENERIC_EQUIP_SOUND = () -> SoundEvents.ARMOR_EQUIP_GENERIC;
    public static final RegistryObject<GlovesItem> NAGA_GLOVES = ITEMS.register("naga_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_NAGA, 0.25, "naga", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_NAGA.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> IRONWOOD_GLOVES = ITEMS.register("ironwood_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_IRONWOOD, 0.5, "ironwood", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_IRONWOOD.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> FIERY_GLOVES = ITEMS.register("fiery_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_FIERY, 1, "fiery", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_FIERY.getDurabilityForType(ArmorItem.Type.BOOTS)).fireResistant().rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> STEELEAF_GLOVES = ITEMS.register("steeleaf_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_STEELEAF, 0.75, "steeleaf", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_STEELEAF.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> KNIGHTMETAL_GLOVES = ITEMS.register("knightmetal_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_KNIGHTLY, 1, "knightmetal", TFSounds.KNIGHTMETAL_EQUIP, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_KNIGHTLY.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> PHANTOM_GLOVES = ITEMS.register("phantom_gloves", () -> new PhantomGloves(TwilightArmorMaterial.ARMOR_PHANTOM, 1, "phantom", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_PHANTOM.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));
    public static final RegistryObject<GlovesItem> ARCTIC_GLOVES = ITEMS.register("arctic_gloves", () -> new DyeableGloves(TwilightArmorMaterial.ARMOR_ARCTIC, 0.25, "arctic", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_ARCTIC.getDurabilityForType(ArmorItem.Type.BOOTS))));
    public static final RegistryObject<GlovesItem> YETI_GLOVES = ITEMS.register("yeti_gloves", () -> new UmbralGloves(TwilightArmorMaterial.ARMOR_YETI, 0.75, "yeti", GENERIC_EQUIP_SOUND, new Item.Properties().stacksTo(1).durability(TwilightArmorMaterial.ARMOR_YETI.getDurabilityForType(ArmorItem.Type.BOOTS)).rarity(Rarity.UNCOMMON)));

    public static final RegistryObject<AetherTrophyItem> SLIDER_TROPHY = ITEMS.register("slider_trophy", () -> new AetherTrophyItem(UmbralBlocks.SLIDER_TROPHY_BLOCK.get(), UmbralBlocks.SLIDER_WALL_TROPHY_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<AetherTrophyItem> VALKYRIE_QUEEN_TROPHY = ITEMS.register("valkyrie_queen_trophy", () -> new AetherTrophyItem(UmbralBlocks.VALKYRIE_QUEEN_TROPHY_BLOCK.get(), UmbralBlocks.VALKYRIE_WALL_QUEEN_TROPHY_BLOCK.get(), new Item.Properties()));
    public static final RegistryObject<AetherTrophyItem> SUN_SPIRIT_TROPHY = ITEMS.register("sun_spirit_trophy", () -> new AetherTrophyItem(UmbralBlocks.SUN_SPIRIT_TROPHY_BLOCK.get(), UmbralBlocks.SUN_SPIRIT_WALL_TROPHY_BLOCK.get(), new Item.Properties()));
    }
