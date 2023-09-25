package us.drullk.umbralskies.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.world.item.ArmorMaterial;
import us.drullk.umbralskies.UmbralSkies;

import java.util.function.Supplier;

public class UmbralGloves extends GlovesItem {
    public UmbralGloves(ArmorMaterial armorMaterial, double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(armorMaterial, punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public void setRenderTexture(String modId, String registryName) {
        this.GLOVES_TEXTURE = UmbralSkies.prefix("textures/models/gloves/" + registryName + ".png");
    }
}
