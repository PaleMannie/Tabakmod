package mett.palemannie.tabakmod.entity.custom;

import mett.palemannie.tabakmod.entity.ModEntities;
import mett.palemannie.tabakmod.util.ModDamageTypes;
import mett.palemannie.tabakmod.util.TabakmodConfig;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Projectile;
import net.minecraft.world.entity.projectile.ProjectileUtil;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.event.ForgeEventFactory;

public class SpuckeEntity extends Projectile {

    public SpuckeEntity(EntityType<? extends Projectile> p_37248_, Level p_37249_) {
        super(p_37248_, p_37249_);
    }

    public SpuckeEntity(Level level, Player player){
        this(ModEntities.SPUCKE.get(), level);
        this.setOwner(player);
        this.setPos(player.getX(), player.getEyeY()-0.2d, player.getZ());
    }

    @Override
    public void tick() {
        super.tick();

        HitResult hitresult = ProjectileUtil.getHitResultOnMoveVector(this, this::canHitEntity);
        if (hitresult.getType() != HitResult.Type.MISS && !ForgeEventFactory.onProjectileImpact(this, hitresult)) {
            this.hitTargetOrDeflectSelf(hitresult);
        }

        Vec3 vec3 = this.getDeltaMovement();
        double d0 = this.getX() + vec3.x;
        double d1 = this.getY() + vec3.y;
        double d2 = this.getZ() + vec3.z;
        this.updateRotation();

        if (this.isInLiquid()) {
            this.discard();
        } else if (this.level().getBlockStates(this.getBoundingBox()).noneMatch(BlockBehaviour.BlockStateBase::isAir)) {
            this.discard();
        } else {
            this.setDeltaMovement(vec3.scale(0.99f));
            this.applyGravity();
            this.setPos(d0, d1, d2);
        }

        if (this.tickCount % 9 == 0) {
            level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY() + 0.2, this.getZ(), 0d, 0d, 0d);
        }
    }

    @Override
    protected void onHitBlock(BlockHitResult pResult) {
        if (!this.level().isClientSide()) {
            this.level().broadcastEntityEvent(this, (byte)3);
            this.discard();
        }
        super.onHitBlock(pResult);
    }

    @Override
    protected void onHitEntity(EntityHitResult pResult) {
        super.onHitEntity(pResult);

        Entity entity = this.getOwner();

        if (entity instanceof Player) {

            entity = pResult.getEntity();
            Level level = this.level();

            if (level instanceof ServerLevel serverlevel) {

                float damage = TabakmodConfig.COMMON.spitDamage.get().floatValue();
                DamageSource source = level.damageSources().source(ModDamageTypes.SPUCK_SCHADEN, null, null);
                DamageSource source2 = level.damageSources().source(DamageTypes.PLAYER_ATTACK, this.getOwner(), this.getOwner());

                if(entity != this.getOwner() ){ entity.hurtServer(serverlevel, source2, 0.000000001f); }
                entity.hurtServer(serverlevel, source, damage);
            }
        }
        this.discard();
    }

    @Override
    protected void defineSynchedData(SynchedEntityData.Builder builder) {}

    @Override
    protected double getDefaultGravity() {
        return 0.05f;
    }

    @Override
    public void recreateFromPacket(ClientboundAddEntityPacket packet) {
        super.recreateFromPacket(packet);
        double d0 = packet.getMovement().x;
        double d1 = packet.getMovement().y;
        double d2 = packet.getMovement().z;

        for (int i = 0; i < 3; i++) {
            double d3 = 0.4 + 0.1 * i;
            this.level().addParticle(ParticleTypes.SPIT, this.getX(), this.getY(), this.getZ(), d0 * d3, d1, d2 * d3);
        }

        this.setDeltaMovement(d0, d1, d2);
    }
}