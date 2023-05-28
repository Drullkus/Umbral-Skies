package us.drullk.umbralskies.item;

import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;
import org.apache.commons.lang3.tuple.ImmutableTriple;

import java.util.function.Supplier;

public class DyeableGloves extends UmbralGloves implements DyeableLeatherItem {
    public DyeableGloves(double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundtag = stack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0xBDCFD9;
    }

    @Override
    public ImmutableTriple<Float, Float, Float> getColors(ItemStack stack) {
        int packedColor = this.getColor(stack);
        return new ImmutableTriple<>((packedColor >> 16 & 255) / 255f, (packedColor >> 8 & 255) / 255f, (packedColor & 255) / 255f);
    }
}
