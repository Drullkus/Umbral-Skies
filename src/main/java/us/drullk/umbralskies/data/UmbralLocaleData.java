package us.drullk.umbralskies.data;

import net.minecraft.data.PackOutput;
import net.minecraftforge.common.data.LanguageProvider;
import us.drullk.umbralskies.UmbralBlocks;
import us.drullk.umbralskies.UmbralSkies;

public class UmbralLocaleData extends LanguageProvider {
    public UmbralLocaleData(PackOutput output) {
        super(output, UmbralSkies.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        addBlock(UmbralBlocks.SKYROOT_BANISTER, "Skyroot Banister");
    }
}
