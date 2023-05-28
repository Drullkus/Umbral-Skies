package us.drullk.umbralskies.client;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.renderer.AetherModelLayers;
import com.aetherteam.aether.client.renderer.entity.model.SunSpiritModel;
import com.aetherteam.aether.client.renderer.entity.model.ValkyrieModel;
import com.aetherteam.aether.entity.monster.dungeon.boss.SunSpirit;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import us.drullk.umbralskies.block.entity.AetherTrophyEntity;

public class SunSpiritTrophyRenderer implements BlockEntityRenderer<AetherTrophyEntity> {
    private final SunSpiritModel<SunSpirit> sunSpiritModel;
    private final RenderType sunSpiritRendertype;

    public SunSpiritTrophyRenderer(BlockEntityRendererProvider.Context context) {
        this.sunSpiritModel = new SunSpiritModel<>(context.bakeLayer(AetherModelLayers.SUN_SPIRIT));
        this.sunSpiritModel.torso.skipDraw = true;
        this.sunSpiritModel.leftArm.visible = false;
        this.sunSpiritModel.rightArm.visible = false;
        this.sunSpiritRendertype = this.sunSpiritModel.renderType(new ResourceLocation(Aether.MODID, "textures/entity/mobs/sun_spirit/sun_spirit.png"));
    }

    @Override
    public void render(AetherTrophyEntity trophy, float partial, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5f, -0.36f, 0.5f - 1/32f);
        poseStack.mulPose(Axis.XP.rotation(Mth.PI));
        this.sunSpiritModel.renderToBuffer(poseStack, bufferSource.getBuffer(this.sunSpiritRendertype), packedLight, overlay, 1f, 1f, 1f, 1f);
        poseStack.popPose();
    }
}
