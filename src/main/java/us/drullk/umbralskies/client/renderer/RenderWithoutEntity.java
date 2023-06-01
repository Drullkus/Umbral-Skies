package us.drullk.umbralskies.client.renderer;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.MultiBufferSource;

public interface RenderWithoutEntity {
    void render(PoseStack poseStack, MultiBufferSource bufferSource, int packedLight, int overlay);
}
