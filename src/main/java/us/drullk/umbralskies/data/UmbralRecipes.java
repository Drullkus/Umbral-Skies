package us.drullk.umbralskies.data;

import com.aetherteam.aether.block.AetherBlocks;
import com.aetherteam.aether.item.AetherItems;
import net.minecraft.data.PackOutput;
import net.minecraft.data.recipes.*;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import twilightforest.data.tags.ItemTagGenerator;
import twilightforest.init.TFItems;
import us.drullk.umbralskies.block.UmbralBlocks;
import us.drullk.umbralskies.item.UmbralItems;
import us.drullk.umbralskies.UmbralSkies;

import java.util.function.Consumer;

public class UmbralRecipes extends RecipeProvider {

    public UmbralRecipes(PackOutput output) {
        super(output);
    }

    @Override
    protected void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder
                .shaped(RecipeCategory.DECORATIONS, UmbralBlocks.SKYROOT_BANISTER.get())
                .pattern("___")
                .pattern("| |")
                .define('_', AetherBlocks.SKYROOT_SLAB.get())
                .define('|', Tags.Items.RODS_WOODEN)
                .unlockedBy("has_item", has(AetherBlocks.SKYROOT_SLAB.get()))
                .save(consumer);

        recipeGloves(consumer, UmbralItems.NAGA_GLOVES.get(), TFItems.NAGA_SCALE.get());
        recipeGloves(consumer, UmbralItems.IRONWOOD_GLOVES.get(), TFItems.IRONWOOD_INGOT.get());
        recipeGloves(consumer, UmbralItems.FIERY_GLOVES.get(), TFItems.FIERY_INGOT.get());
        recipeGloves(consumer, UmbralItems.STEELEAF_GLOVES.get(), TFItems.STEELEAF_INGOT.get());
        recipeGloves(consumer, UmbralItems.KNIGHTMETAL_GLOVES.get(), TFItems.KNIGHTMETAL_INGOT.get());
        recipeGloves(consumer, UmbralItems.ARCTIC_GLOVES.get(), TFItems.ARCTIC_FUR.get());
        recipeGloves(consumer, UmbralItems.YETI_GLOVES.get(), TFItems.ALPHA_YETI_FUR.get());

        ShapelessRecipeBuilder
                .shapeless(RecipeCategory.COMBAT, UmbralItems.FIERY_GLOVES.get())
                .requires(AetherItems.IRON_GLOVES.get())
                .requires(Ingredient.of(ItemTagGenerator.FIERY_VIAL), 2)
                .unlockedBy("has_item", has(ItemTagGenerator.FIERY_VIAL))
                .save(consumer, UmbralSkies.prefix("fiery_iron_gloves"));

        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, UmbralBlocks.HOLLOW_SKYROOT_LOG_HORIZONTAL.get(), AetherBlocks.SKYROOT_LOG.get());
        stonecutterResultFromBase(consumer, RecipeCategory.BUILDING_BLOCKS, UmbralBlocks.HOLLOW_GOLDEN_OAK_LOG_HORIZONTAL.get(), AetherBlocks.GOLDEN_OAK_LOG.get());
    }

    private static void recipeGloves(Consumer<FinishedRecipe> consumer, Item gloves, Item material) {
        ShapedRecipeBuilder
                .shaped(RecipeCategory.COMBAT, gloves)
                .pattern("# #")
                .define('#', material)
                .unlockedBy("has_item", has(material))
                .save(consumer);
    }
}
