package us.drullk.umbralskies.item;

import com.aetherteam.aether.item.accessories.gloves.GlovesItem;
import net.minecraft.sounds.SoundEvent;
import us.drullk.umbralskies.UmbralSkies;

import java.util.function.Supplier;

public class UmbralGloves extends GlovesItem {
    public UmbralGloves(double punchDamage, String glovesName, Supplier<? extends SoundEvent> glovesSound, Properties properties) {
        super(punchDamage, glovesName, glovesSound, properties);
    }

    @Override
    public void setRenderTexture(String modId, String registryName) {
        this.GLOVES_TEXTURE = UmbralSkies.prefix("textures/models/gloves/" + registryName + ".png");
        this.GLOVES_SLIM_TEXTURE = UmbralSkies.prefix("textures/models/gloves/" + registryName + "_slim.png");
    }
}
