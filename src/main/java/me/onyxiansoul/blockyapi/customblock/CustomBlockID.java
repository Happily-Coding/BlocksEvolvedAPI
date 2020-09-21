package me.onyxiansoul.blockyapi.customblock;

import me.onyxiansoul.blockyapi.customblock.BlockKind;
import org.bukkit.Material;

public interface CustomBlockID {
    
    //Todo sacar los gets de la API?
    
    public BlockKind getBlockKind();

    public Material getMaterial();

    public String getBlockData();

    public Short getSubtype();
    


    

    
    
    
}