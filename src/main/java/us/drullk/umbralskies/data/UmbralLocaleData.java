package us.drullk.umbralskies.data;

import net.minecraft.data.PackOutput;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.common.data.LanguageProvider;
import us.drullk.umbralskies.UmbralTab;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.PhantomGloves;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.UmbralSkies;

import java.util.function.Supplier;

public class UmbralLocaleData extends LanguageProvider {
    public UmbralLocaleData(PackOutput output) {
        super(output, UmbralSkies.MODID, "en_us");
    }

    @Override
    protected void addTranslations() {
        this.addBlock(UmbralBlocks.SKYROOT_BANISTER, "Skyroot Banister");

        this.addItem(UmbralItems.NAGA_GLOVES, "Naga Scale Gloves");
        this.addItem(UmbralItems.IRONWOOD_GLOVES, "Ironwood Gloves");
        this.addItem(UmbralItems.FIERY_GLOVES, "Fiery Gloves");
        this.addItem(UmbralItems.STEELEAF_GLOVES, "Steeleaf Gloves");
        this.addItem(UmbralItems.KNIGHTMETAL_GLOVES, "Knightmetal Gauntlets");
        this.addItem(UmbralItems.PHANTOM_GLOVES, "Phantom Gauntlets");
        this.addItem(UmbralItems.ARCTIC_GLOVES, "Arctic Mittens");
        this.addItem(UmbralItems.YETI_GLOVES, "Yeti Gloves");

        // FIXME switch to using TF's lang key once 1704 is released
        this.add(PhantomGloves.TOOLTIP_TEXT, "Never drops on death");

        this.addItem(UmbralItems.SLIDER_TROPHY, "Slider Trophy");
        this.addItem(UmbralItems.VALKYRIE_QUEEN_TROPHY, "Valkyrie Queen Trophy");
        this.addItem(UmbralItems.SUN_SPIRIT_TROPHY, "Sun Spirit Trophy");

        this.makeAetherLore(UmbralBlocks.SKYROOT_BANISTER, "A banister like those found within the Twilight Forest, made of Skyroot wood.");

        this.add(UmbralTab.TAB_LOCALE, "Umbral Skies");

        // Severely underestimated how much writing these require plus the rest of TF content - Would've just generated the rest if GPT 3.5 were more competent
        //makeAetherLore(TFBlocks.NAGA_TROPHY, "The trophy of the Naga's head, marking the adventurer's victory over the fearsome serpentine adversary that guarded the Naga Courtyard, serves as a powerful symbol of their strength and dexterity.");
        //makeAetherLore(TFBlocks.LICH_TROPHY, "The trophy of the Lich's head, obtained by defeating the powerful undead sorcerer and his unliving minions from the Lich Tower, serves as a testament to the adventurer's fearlessness and perseverance.");
        //makeAetherLore(TFBlocks.MINOSHROOM_TROPHY, "The trophy of the Minoshroom's head, gained by defeating the fungal abomination within the Labyrinth's depths below the Swamps, is a symbol of skill about maneuvering and resolve.");
        //makeAetherLore(TFBlocks.HYDRA_TROPHY, "The trophy from one of the Hydra's heads, reaped by conquering the multi-headed scourge of resource-rich Lairs among the Fiery Swamps, only those with fast reflexes and tenacity will be able to earn it.");
    }

    private void makeAetherLore(Supplier<? extends ItemLike> item, String text) {
        this.add("lore." + item.get().asItem().getDescriptionId(), text);
    }
}
