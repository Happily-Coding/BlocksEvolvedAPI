package com.github.onyxiansoul.blockyApiV2;

import me.onyxiansoul.blockyapi.BlockyAPI;
import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

/**The class which gives your plugin access to the BlockyAPI*/
public interface BlockyApiAccess {
  
  /**Get the API to get information about or extend the functionality of Blocky.*/
  public BlockyAPI getBlockyAPI(@NotNull Plugin plugin);

}
  

