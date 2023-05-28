package us.drullk.umbralskies.item;

import net.minecraft.world.item.Item;
import us.drullk.umbralskies.block.FloorAetherTrophyBlock;
import us.drullk.umbralskies.block.WallAetherTrophyBlock;

import java.util.function.Supplier;

public class AetherTrophyItem extends Item {
    private final Supplier<FloorAetherTrophyBlock> floorTrophyBlock;
    private final Supplier<WallAetherTrophyBlock> wallTrophyBlock;

    public AetherTrophyItem(Properties properties, Supplier<FloorAetherTrophyBlock> floorTrophyBlock, Supplier<WallAetherTrophyBlock> wallTrophyBlock) {
        super(properties);
        this.floorTrophyBlock = floorTrophyBlock;
        this.wallTrophyBlock = wallTrophyBlock;
    }

    /*@Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(new AetherTrophyItemRenderer(this.block.get().blockEntityType.get()));
    }

    private static final class AetherTrophyItemRenderer implements IClientItemExtensions {
        private final BlockEntityWithoutLevelRenderer withoutLevelRenderer;

        public AetherTrophyItemRenderer(BlockEntityType<AetherTrophyEntity> aetherTrophyBlock) {
            if (aetherTrophyBlock == UmbralBlocks.SLIDER_TROPHY_ENTITY.get()) {
                this.withoutLevelRenderer = new AetherTrophyRenderer.SliderWithoutLevel();
            } else if (aetherTrophyBlock == UmbralBlocks.VALKYRIE_TROPHY_ENTITY.get()) {
                this.withoutLevelRenderer = new AetherTrophyRenderer.SliderWithoutLevel();
            } else if (aetherTrophyBlock == UmbralBlocks.SUN_SPIRIT_TROPHY_ENTITY.get()) {
                this.withoutLevelRenderer = new AetherTrophyRenderer.SliderWithoutLevel();
            } else {
                this.withoutLevelRenderer = Minecraft.getInstance().getItemRenderer().getBlockEntityRenderer();
            }
        }

        @Override
        public BlockEntityWithoutLevelRenderer getCustomRenderer() {
            return this.withoutLevelRenderer;
        }
    }*/
}
