package com.github.onyxiansoul.blocks_evolved_api;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**The class which gives your plugin access to the BlocksEvolvedApi*/
public interface BlocksEvolvedApiAccess {
  
  /**Get the API to get information about or extend the functionality of Blocky.*/
  public BlocksEvolvedApi getBlocksEvolvedAPI(@NotNull Plugin plugin);

}