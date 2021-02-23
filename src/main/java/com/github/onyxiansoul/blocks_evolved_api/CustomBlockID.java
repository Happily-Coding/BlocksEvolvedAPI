package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.Material;

public interface CustomBlockID {
    
    //Todo sacar los gets de la API?
    
    public BlockKind getBlockKind();

    public Material getMaterial();

    public String getBlockData();

    public Short getSubtype();
    


    

    
    
    
}