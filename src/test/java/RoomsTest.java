import Rooms.*;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RoomsTest {

    Rooms rooms;
    Room room1;
    Room room2;
    Room room3;


    @Before
    public void before(){
        rooms = new Rooms();
        room1 = new Room();
        room2 = new Room();
        room3 = new Room();

        rooms.addRoom(room1);
        rooms.addRoom(room2);
        rooms.addRoom(room3);
    }


    @Test
    public void canAddRooms(){
        assertEquals(3, rooms.getNumberofRooms());
    }


}
