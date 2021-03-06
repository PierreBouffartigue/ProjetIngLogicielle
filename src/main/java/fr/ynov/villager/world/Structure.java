package fr.ynov.villager.world;

import fr.ynov.villager.entity.EntityCweep;
import fr.ynov.villager.entity.EntityFarmer;
import net.minecraft.block.Block;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.EntityCreature;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.util.ArrayList;

public class Structure {

    public static void HouseStructure(EntityCreature creature, World world) {
        JSONObject jo;
        ArrayList<String> listdata = new ArrayList<String>();
        if (!world.isRemote) {
            try {
                Object obj = new JSONParser().parse(new FileReader("../src/main/resources/assets/villager/json/house.json"));
                jo = (JSONObject) obj;
                JSONArray ja = (JSONArray) jo.get("house");


                for (Object o : ja) {
                    listdata.add(o.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            int x = (int) creature.posX;
            int y = (int) creature.posY;
            int z = (int) creature.posZ - 10;
            BlockPos initialPos = new BlockPos(x, y, z);

            for (String listdatum : listdata) {
                String[] parts = listdatum.split(",");

                Block blk = Block.getBlockById(Integer.parseInt(parts[3]));
                IBlockState blkState = blk.getDefaultState();

                initialPos = new BlockPos(x + Integer.parseInt(parts[0]) - 1, y + Integer.parseInt(parts[1]), z + Integer.parseInt(parts[2]) + 1);
                world.setBlockState(initialPos, blkState);
            }
            EntityCweep cweep = new EntityCweep(world);
            cweep.setLocationAndAngles(creature.posX, creature.posY + cweep.getYOffset(), creature.posZ + 20, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
            world.spawnEntity(cweep);
        }
    }

    public static void FarmStructure(EntityCreature creature, World world) {
        JSONObject jo;
        ArrayList<String> listdata = new ArrayList<String>();
        if (!world.isRemote) {
            try {
                Object obj = new JSONParser().parse(new FileReader("../src/main/resources/assets/villager/json/farm.json"));
                jo = (JSONObject) obj;
                JSONArray ja = (JSONArray) jo.get("farm");


                for (Object o : ja) {
                    listdata.add(o.toString());
                }

            } catch (Exception e) {
                e.printStackTrace();
            }

            int x = (int) creature.posX - 5;
            int y = (int) creature.posY;
            int z = (int) creature.posZ - 6;
            BlockPos initialPos = new BlockPos(x, y, z);

            for (String listdatum : listdata) {
                String[] parts = listdatum.split(",");

                Block blk = Block.getBlockById(Integer.parseInt(parts[3]));
                IBlockState blkState = blk.getDefaultState();

                initialPos = new BlockPos(x + Integer.parseInt(parts[0]) - 1, y + Integer.parseInt(parts[1]), z + Integer.parseInt(parts[2]) + 1);
                world.setBlockState(initialPos, blkState);
            }
            EntityFarmer farmer = new EntityFarmer(world);
            farmer.setLocationAndAngles(creature.posX - 4, creature.posY + farmer.getYOffset(), creature.posZ - 3, MathHelper.wrapDegrees(world.rand.nextFloat() * 360.0F), 0.0F);
            world.spawnEntity(farmer);
        }
    }
}
