package us.drullk.umbralskies.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.api.distmarker.OnlyIn;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.event.DropRulesEvent;
import top.theillusivec4.curios.api.type.capability.ICurio;
import twilightforest.data.tags.CustomTagGenerator;

import java.util.List;
import java.util.function.Supplier;

public class PhantomGloves extends UmbralGloves {
    @Deprecated
    public static final String TOOLTIP_TEXT = "item.umbral_skies.phantom_gloves.desc";
    @Deprecated // FIXME switch to using TF's lang key once 1704 is released
    private static final MutableComponent TOOLTIP = Component.translatable(TOOLTIP_TEXT).setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));

    public PhantomGloves(ArmorMaterial armorMaterial, double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(armorMaterial, punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        // FIXME
        return !enchantment.builtInRegistryHolder().is(CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS) && super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        for (Enchantment enchantment : EnchantmentHelper.getEnchantments(book).keySet())
            if (enchantment.builtInRegistryHolder().is(CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS))
                return false;

        return true;
    }

    @Override
    @OnlyIn(Dist.CLIENT)
    public void appendHoverText(ItemStack stack, @Nullable Level level, List<Component> tooltips, TooltipFlag isAdvanced) {
        super.appendHoverText(stack, level, tooltips, isAdvanced);
        tooltips.add(TOOLTIP);
    }

    public static void keepPhantomGloves(DropRulesEvent event) {
        event.addOverride(stack -> stack.is(UmbralItems.PHANTOM_GLOVES.get()), ICurio.DropRule.ALWAYS_KEEP);
    }
}
