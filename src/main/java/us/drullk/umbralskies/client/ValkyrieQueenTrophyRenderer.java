package us.drullk.umbralskies.client;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.renderer.AetherModelLayers;
import com.aetherteam.aether.client.renderer.entity.model.ValkyrieModel;
import com.aetherteam.aether.entity.monster.dungeon.boss.ValkyrieQueen;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import us.drullk.umbralskies.block.entity.AetherTrophyEntity;

public class ValkyrieQueenTrophyRenderer implements BlockEntityRenderer<AetherTrophyEntity> {
    private final ValkyrieModel<ValkyrieQueen> valkyrieQueenModel;
    private final RenderType queenRendertype;

    private static final float SCALE = 21.25f/16f;

    public ValkyrieQueenTrophyRenderer(BlockEntityRendererProvider.Context context) {
        this.valkyrieQueenModel = new ValkyrieModel<>(context.bakeLayer(AetherModelLayers.VALKYRIE_QUEEN));
        this.valkyrieQueenModel.body.visible = false;
        this.valkyrieQueenModel.leftArm.visible = false;
        this.valkyrieQueenModel.rightArm.visible = false;
        this.valkyrieQueenModel.leftLeg.visible = false;
        this.valkyrieQueenModel.rightLeg.visible = false;
        this.valkyrieQueenModel.leftFrontSkirt.visible = false;
        this.valkyrieQueenModel.rightFrontSkirt.visible = false;
        this.valkyrieQueenModel.leftBackSkirt.visible = false;
        this.valkyrieQueenModel.rightBackSkirt.visible = false;
        this.valkyrieQueenModel.leftSideSkirt.visible = false;
        this.valkyrieQueenModel.rightSideSkirt.visible = false;
        this.queenRendertype = this.valkyrieQueenModel.renderType(new ResourceLocation(Aether.MODID, "textures/entity/mobs/valkyrie_queen/valkyrie_queen.png"));
    }

    @Override
    public void render(AetherTrophyEntity trophy, float partial, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5f, 1, 0.5f);
        poseStack.scale(SCALE, SCALE, SCALE);
        poseStack.mulPose(Axis.XP.rotation(Mth.PI));
        this.valkyrieQueenModel.renderToBuffer(poseStack, bufferSource.getBuffer(this.queenRendertype), packedLight, overlay, 1f, 1f, 1f, 1f);
        poseStack.popPose();
    }
}
