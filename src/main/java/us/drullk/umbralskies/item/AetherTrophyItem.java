package us.drullk.umbralskies.item;

import net.minecraft.core.Direction;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.StandingAndWallBlockItem;
import net.minecraftforge.client.extensions.common.IClientItemExtensions;
import org.jetbrains.annotations.Nullable;
import us.drullk.umbralskies.block.FloorAetherTrophyBlock;
import us.drullk.umbralskies.block.WallAetherTrophyBlock;
import us.drullk.umbralskies.client.renderer.UmbralWithoutLevelRenderer;

import java.util.function.Consumer;

public class AetherTrophyItem extends StandingAndWallBlockItem {
    public AetherTrophyItem(FloorAetherTrophyBlock floorTrophyBlock, WallAetherTrophyBlock wallTrophyBlock, Properties properties) {
        super(floorTrophyBlock, wallTrophyBlock, properties, Direction.DOWN);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, Entity entity) {
        return armorType == EquipmentSlot.HEAD;
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.HEAD;
    }

    @Override
    public void initializeClient(Consumer<IClientItemExtensions> consumer) {
        consumer.accept(UmbralWithoutLevelRenderer.ITEM_EXTENSION);
    }
}
