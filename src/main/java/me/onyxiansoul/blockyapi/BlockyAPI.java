package me.onyxiansoul.blockyapi;

import com.sun.istack.internal.NotNull;
import com.sun.istack.internal.Nullable;
import me.onyxiansoul.blockyapi.customblock.CustomBlockID;
import me.onyxiansoul.onyxiancoreapi.OnyxianCoreAPI;
import org.bukkit.Location;
import org.bukkit.configuration.ConfigurationSection;
import org.bukkit.inventory.ItemStack;


public interface BlockyAPI {
    

    
    @Nullable public String getTestString();
    
    //REAL API:
    public OnyxianCoreAPI getOnyxianCoreAPI();
    
    /**Process a configurationSection and register the customBlockType.
     * @param configSection = the section that defines the blockType. The name of the section will become the name of the Custom_block_Type.
     * The contents of the section will define all block settings.
     * Uses the exact syntax required for any custom block defined within 'CustomBlocks' on the plugin config.
     */
    public void registerCustomBlockType(@NotNull ConfigurationSection configSection);
    
    /** Get the custom block ID of a custom block type. Must have been previously registered.
     * @param customBlockName = the name of the section from which the block was registered.
     */
    @Nullable public CustomBlockID getCustomBlockID(@NotNull String customBlockName);
    
    /** Set the block of a location to a certain customBlock
     * @param customBlockID: A valid id for a custom block. get it with 'getCustomBlockID'. Use{@link #getCustomBlockID} to get the ID for the block you want.
     * @param location: The bukkit location where you'd like to change the block to the custom block.
    */
    public void setCustomBlock(@NotNull CustomBlockID customBlockID, @NotNull Location location);
    
    /**Gets the default item to place a block of some ID.
     * @param customBlockID: The id of the custom block you'd like to get the default item. Use{@link #getCustomBlockID} to get the ID for the block you want.
     * @param size: The size of the item stack.
     */
    @Nullable public ItemStack getDefaultCustomBlockItem(@NotNull CustomBlockID customBlockID, @Nullable int size);
    
    
    /** Checks if an item has the ability to place a customBlock. If it does, returns the CustomBlockID of the block that it places, otherwise returns null.
     * @param itemStack: The item stack to analyze.
     */
    @Nullable public CustomBlockID getItemStackCustomBlockID(@NotNull ItemStack itemStack);
    
    /** Adds metadata to an itemStack to turn it into an ItemStack that places a certain customBlock on right click
     * @param itemStack: The itemStack to add the metadata to
     * @param customBlockID: The CustomBlockID of the custom block that should be placed on right click. Use{@link #getCustomBlockID} to get the ID for the block you want.
     */
    @Nullable public ItemStack turnIntoCustomBlockStack(@NotNull ItemStack itemStack, @NotNull CustomBlockID customBlockID);
    
    
    
    
}
