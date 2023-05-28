package us.drullk.umbralskies;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.DyeableLeatherItem;
import net.minecraft.world.item.ItemStack;

import java.util.function.Supplier;

public class DyeableGloves extends GlovesItem implements DyeableLeatherItem {
    public DyeableGloves(double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public int getColor(ItemStack stack) {
        CompoundTag compoundtag = stack.getTagElement("display");
        return compoundtag != null && compoundtag.contains("color", 99) ? compoundtag.getInt("color") : 0xBDCFD9;
    }
}
