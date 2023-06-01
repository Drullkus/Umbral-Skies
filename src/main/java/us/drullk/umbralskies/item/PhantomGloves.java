package us.drullk.umbralskies.item;

import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.registries.ForgeRegistries;
import org.jetbrains.annotations.Nullable;
import top.theillusivec4.curios.api.event.DropRulesEvent;
import top.theillusivec4.curios.api.type.capability.ICurio;
import twilightforest.data.tags.CustomTagGenerator;

import java.util.List;
import java.util.function.Supplier;

public class PhantomGloves extends UmbralGloves {
    private static final MutableComponent TOOLTIP = Component.translatable("item.twilightforest.phantom_armor.tooltip").setStyle(Style.EMPTY.withColor(ChatFormatting.GRAY));

    public PhantomGloves(double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public boolean canApplyAtEnchantingTable(ItemStack stack, Enchantment enchantment) {
        return !ForgeRegistries.ENCHANTMENTS.tags().getTag(CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS).contains(enchantment) && super.canApplyAtEnchantingTable(stack, enchantment);
    }

    @Override
    public boolean isBookEnchantable(ItemStack stack, ItemStack book) {
        for (Enchantment enchantment : EnchantmentHelper.getEnchantments(book).keySet())
            if (ForgeRegistries.ENCHANTMENTS.tags().getTag(CustomTagGenerator.EnchantmentTagGenerator.PHANTOM_ARMOR_BANNED_ENCHANTS).contains(enchantment))
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
