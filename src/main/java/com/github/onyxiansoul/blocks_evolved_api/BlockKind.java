package com.github.onyxiansoul.blocks_evolved_api;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public enum BlockKind {
    
    ALL_BLOCKS, //Every block will be considered a block of this type, and will be affected by its settings
    BLOCKS_OF_MATERIAL{ 
        @Override
        public boolean requiresMaterial(){
            return true;
        }
    }, //Every block of this material will be considered this customBlock (REGARDLESS OF THE STATE) ie: All RED_MUSHROOM_BLOCKS
    BLOCKS_OF_BLOCKSTATE{
        @Override
        public boolean requiresBlockState(){
            return true;
        }
    }, //Every block of this blockstate will be considered this customBlock (REGARDLESS OF THE MATERIAL) ie: All DIRECTIONAL BLOCKS FACING EAST
    BLOCKS_OF_CUSTOMBLOCK_ID_NUMBER, //Every block for which the additional saved information equals this info. ie any bllock, which on file has info CustomBlockIdentifier = 20;
    BLOCK_OF_GROUP, //A blockstate + material is chosen from this group.
    BLOCKS_OF_MATERIAL_AND_BLOCKSTATE{
        @Override
        public boolean requiresMaterial(){
            return true;
        }
        @Override
        public boolean requiresBlockState(){
            return true;
        }
    }, //Every block of this material and BlockState will be considered this custom block ie: All OAK_LOG Facing EAST    
    BLOCKS_OF_MATERIAL_AND_CUSTOMBLOCK_ID_NUMBER{
        @Override
        public boolean requiresMaterial(){
            return true;
        }
    }, //Every block of this material and saved info. ie: All OAK_PLANK which on file has info CustomBlockIdentifier = 20;
    BLOCKS_OF_BLOCKSTATE_AND_CUSTOMBLOCK_ID_NUMBER{
        @Override
        public boolean requiresBlockState(){
            return true;
        }
    }, //Every block of this blockstate and saved info. ie: All DIRECTIONAL BLOCKS facing east, which on file has info CustomBlockIdentifier =20;
    BLOCKS_OF_MATERIAL_AND_BLOCKSTATE_AND_CUSTOMBLOCK_ID_NUMBER{
        @Override
        public boolean requiresMaterial(){
            return true;
        }
        @Override
        public boolean requiresBlockState(){
            return true;
        }
    }, //Every block of a material, with a certain blockstate, and a certain saved. IE: All OAK_LOGS Facing EAST with data saved on file CustomBlockIdentifier = 20;
    SPAWNER_BLOCK_WITH_LAYERS, //Every spawner block
    ARMORSTAND, //Buena idea para pilar box La ID tendria que ser vanilla, con el agregado de armorstand
    SKULL_BLOCK_OF_SKIN; //Buena idea para small cube box
    
    public boolean requiresMaterial(){
        return false;
    }
    public boolean requiresBlockState(){
        return false;
    }
    public boolean requiresIDNumber(){
        return false;
    }
    
    public static final HashMap<String,BlockKind> onlyConfigKinds;
    static{
        onlyConfigKinds= new HashMap<>();
        //onlyConfigKinds.put("REAL_BLOCK_OF_GROUP",BLOCKS_OF_MATERIAL_AND_BLOCKSTATE);
    }
    
}

    








    //LECTERN_OF_BOOK, no parece funcionar. ya que no renderiza el book parece. habria que ver si modificando el resourscpeakc se puede pero se ve improbable
    //ITEM_FRAME_WITH_ITEM, //Buena idea para cube  --> pointless mejor armorstand marker
    //Tal vez otros mobs sin AI son una buena idea para otras boxes?
    //Tal vez block normal para una box, hit detection etc y item frame invisible / armorstand invisible con item displaceado para el modelo? Suena promising!!
    //You could make a resource pack that makes objects that will not make it turn dark (like glass, stained glass, etc) to look like quarts or whatever you need it to be  para evitar darkening
    //por estar dentro del block
    //The issue is when the client renders that entity, it finds that the light level is 0, You will need to change the light level of the block(s) the entity is in, This has worked for me in the past.
    //That being said, it is prone to having issues when a block update is sent or a lighting update, may be best to do it with packets. 
    //As it turns out if you give the armor stand the fire tag {Fire:100s} it will be lit up. To get rid of the flame, you just have to make the armor stand a marker {Marker:1}.
    //armorStand.setFireTicks(2147483647) (~3 años)
    //armorstand no parece tener bounding box regardless of anything. Frame no muestra bien los items regardless del fuego.
    
    //Item frame necesita facing, y fixed(si se rompe o no cuadno le sacan el soporte) //Item rotation tambien
    //Glow rodea el item perfectamente nomas. Se va si esta invisible
    //No es rodeado por la cosa negra al apuntarle
    //NO evita que le pongas bloques ensima
    //pitch y yaw no le hacen nada
    //Se le puede poner passengers, ej shulker y tiene la bounding box de un bloque normal, y no permite ponerle bloques pero sigue sin tener coso negro. (ademas de que estarias spawneando una enttity)
