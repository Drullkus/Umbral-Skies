package us.drullk.umbralskies.client;

import com.aetherteam.aether.client.renderer.accessory.GlovesRenderer;
import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.RenderLayerParent;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

public class EmissiveGlovesRenderer extends GlovesRenderer {
    @Override
    public <T extends LivingEntity, M extends EntityModel<T>> void render(ItemStack stack, SlotContext slotContext, PoseStack poseStack, RenderLayerParent<T, M> renderLayerParent, MultiBufferSource buffer, int light, float limbSwing, float limbSwingAmount, float partialTicks, float ageInTicks, float netHeadYaw, float headPitch) {
        super.render(stack, slotContext, poseStack, renderLayerParent, buffer, 0xF000F0, limbSwing, limbSwingAmount, partialTicks, ageInTicks, netHeadYaw, headPitch);
    }

    @Override
    public void renderFirstPerson(ItemStack stack, PoseStack poseStack, MultiBufferSource buffer, int combinedLight, AbstractClientPlayer player, HumanoidArm arm) {
        super.renderFirstPerson(stack, poseStack, buffer, 0xF000F0, player, arm);
    }
}
