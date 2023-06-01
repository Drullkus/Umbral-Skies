package us.drullk.umbralskies.client.renderer;

import com.aetherteam.aether.Aether;
import com.aetherteam.aether.client.renderer.AetherModelLayers;
import com.aetherteam.aether.client.renderer.entity.model.SliderModel;
import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import net.minecraft.client.model.geom.EntityModelSet;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.blockentity.BlockEntityRenderer;
import net.minecraft.client.renderer.blockentity.BlockEntityRendererProvider;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.Mth;
import us.drullk.umbralskies.block.entity.AetherTrophyEntity;

public class SliderTrophyRenderer implements BlockEntityRenderer<AetherTrophyEntity>, RenderWithoutEntity {
    private final SliderModel sliderModel;
    private final RenderType sliderRendertype;
    private final RenderType emissiveRendertype;

    public SliderTrophyRenderer(BlockEntityRendererProvider.Context context) {
        this(new SliderModel(context.bakeLayer(AetherModelLayers.SLIDER)));
    }

    public SliderTrophyRenderer(EntityModelSet modelSet) {
        this(new SliderModel(modelSet.bakeLayer(AetherModelLayers.SLIDER)));
    }

    public SliderTrophyRenderer(SliderModel sliderModel) {
        this.sliderModel = sliderModel;
        this.sliderRendertype = this.sliderModel.renderType(new ResourceLocation(Aether.MODID, "textures/entity/mobs/slider/slider_awake.png"));
        this.emissiveRendertype = RenderType.eyes(new ResourceLocation(Aether.MODID, "textures/entity/mobs/slider/slider_awake_glow.png"));
    }

    @Override
    public void render(AetherTrophyEntity trophy, float partial, PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int overlay) {
        this.render(trophy, poseStack, bufferSource, packedLight, overlay);
    }

    @Override
    public void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int overlay) {
        poseStack.pushPose();
        poseStack.translate(0.5f, 0.375f, 0.5f);
        poseStack.scale(0.25f, 0.25f, 0.25f);
        poseStack.mulPose(Axis.XP.rotation(Mth.PI));
        this.sliderModel.renderToBuffer(poseStack, bufferSource.getBuffer(this.sliderRendertype), packedLight, overlay, 1f, 1f, 1f, 1f);
        poseStack.pushPose();
        poseStack.scale(1.01f, 1.01f, 1.01f);
        this.sliderModel.renderToBuffer(poseStack, bufferSource.getBuffer(this.emissiveRendertype), packedLight, 0xF000F0, 1f, 1f, 1f, 1f);
        poseStack.popPose();
        poseStack.popPose();
    }
}
