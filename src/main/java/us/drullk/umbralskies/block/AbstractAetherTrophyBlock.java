package us.drullk.umbralskies.block;

import com.mojang.serialization.MapCodec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.BaseEntityBlock;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.pathfinder.PathComputationType;
import org.jetbrains.annotations.Nullable;
import us.drullk.umbralskies.block.entity.AetherTrophyEntity;

import java.util.function.Supplier;

public abstract class AbstractAetherTrophyBlock extends BaseEntityBlock {
    private final MapCodec<AbstractAetherTrophyBlock> codec;

    public final Supplier<BlockEntityType<AetherTrophyEntity>> blockEntityType;

    protected AbstractAetherTrophyBlock(Properties properties, Supplier<BlockEntityType<AetherTrophyEntity>> blockEntityType) {
        super(properties);
        this.blockEntityType = blockEntityType;
		this.codec = MapCodec.unit(this);
	}

    @Override
    public boolean isPathfindable(BlockState p_60475_, BlockGetter p_60476_, BlockPos p_60477_, PathComputationType p_60478_) {
        return false;
    }

    @Nullable
    @Override
    public BlockEntity newBlockEntity(BlockPos pos, BlockState state) {
        return blockEntityType.get().create(pos, state);
    }

    @Override
    protected MapCodec<? extends BaseEntityBlock> codec() {
        return this.codec;
    }
}
