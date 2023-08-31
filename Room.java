import java.util.HashMap;
/**
 * Class Room - a room in an adventure game.
 *
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 *
 * A "Room" represents one location in the scenery of the game.  It is 
 * connected to other rooms via exits.  The exits are labelled north, 
 * east, south, west.  For each direction, the room stores a reference
 * to the neighboring room, or null if there is no exit in that direction.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */
public class Room 
{
    private String description;
    private HashMap exits;
    /**
     * Create a room described "description". Initially, it has
     * no exits. "description" is something like "a kitchen" or
     * "an open court yard".
     * @param description The room's description.
     */
    public Room(String description) 
    {
        this.description = description;
        exits = new HashMap();
    }
    
/**
 * Define an exit from this room.
 */
public void setExit(String direction, Room neighbor)
{
 exits.put(direction, neighbor);
}
 /**
 * Return the room that is reached if we go from this room in
 * direction "direction". If there is no room in that
 * direction, return null.
 */
 public Room getExit(String direction)
 {
 return (Room)exits.get(direction);
 }
     /**
 * Return the description of the room (the one that was defined
 * in the constructor).
 */
 public String getDescription()
 {
 return description;
 }
}
    
    /**
     * Define the exits of this room.  Every direction either leads
     * to another room or is null (no exit there).
     * @param north The north exit.
     * @param east The east east.
     * @param south The south exit.
     * @param west The west exit.
     */
    public void setExits(Room north, Room east, Room south, Room west) 
    {
        if(north != null) {
            northExit = north;
        }
        if(east != null) {
            eastExit = east;
        }
        if(south != null) {
            southExit = south;
        }
        if(west != null) {
            westExit = west;
        }
    }

    /**
     * @return The description of the room.
     */
    public String getDescription()
    {
        return description;
    }
   
/**
 * Return a string describing the room's exits, for example
 * "Exits: north west".
 */
public String getExitString()
{
 String returnString = "Exits:";
 Set keys = exits.keySet();
 for(Iterator iter = keys.iterator(); iter.hasNext(); )
 returnString += " " + iter.next();
 return returnString;
}
/**
 * Return a long description of this room, on the form:
 * You are in the kitchen.
 * Exits: north west
 */
public String getLongDescription()
{
 return "You are " + description + ".\n" + getExitString();
}
}
