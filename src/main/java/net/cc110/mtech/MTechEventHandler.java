package net.cc110.mtech;

import net.minecraft.item.*;
import net.minecraft.entity.*;
import net.minecraft.util.math.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.passive.*;
import net.minecraftforge.event.entity.living.*;
import net.minecraftforge.fml.common.eventhandler.*;

public class MTechEventHandler
{
	@SubscribeEvent
	public void onDrop(LivingDropsEvent event)
	{
		Entity entity = event.getEntity();
		
		if(entity instanceof EntityBat && MTech.MTECH_RANDOM.nextInt(MathHelper.clamp_int(ConfigHolder.batWingDropChance - (event.getLootingLevel() * 2), 1, ConfigHolder.batWingDropChance)) == 0)
		{
			event.getDrops().add(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, new ItemStack(MTech.resource, 1, 0)));
		}
		else if(entity instanceof EntityWolf && !((EntityWolf)entity).isTamed() && MTech.MTECH_RANDOM.nextInt(MathHelper.clamp_int(ConfigHolder.wolfTailboneDropChance - (event.getLootingLevel() * 2), 2, ConfigHolder.wolfTailboneDropChance)) == 0)
		{
			event.getDrops().add(new EntityItem(entity.worldObj, entity.posX, entity.posY, entity.posZ, new ItemStack(MTech.resource, 1, 6)));
		}
	}
}
