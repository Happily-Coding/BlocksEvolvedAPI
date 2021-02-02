
package me.onyxiansoul.blockyapi;

import java.util.List;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.bukkit.block.Block;
import org.bukkit.event.Event;
import me.onyxiansoul.onyxiancoreapi.event.EventDataObtainer;

/**The base Block Event Data Obtainer you need to implement in order to allow Blocky to obtain parameters from an event*/ 
public interface BlockEventDataObtainer extends EventDataObtainer {
       
    /** Get the blocks affected by this event.
     * @param e = an event of this type
     * @return  The blocks affected by this event.Should always have a block. Can't be null or empty*/
    @NotNull @NotEmpty @Override
    public abstract List<Block> getAffectedBlocks(Event e) throws ClassCastException; 
    
    
    
    

}
