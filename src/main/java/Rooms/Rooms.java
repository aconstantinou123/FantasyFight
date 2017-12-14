package Rooms;

import Players.Player;

import java.util.ArrayList;

public class Rooms {

    private ArrayList<Room> rooms;


    public Rooms() {
        this.rooms = new ArrayList<>();
    }

    public ArrayList<Room> getRooms() {
        return rooms;
    }

    public int getNumberofRooms(){
        return rooms.size();
    }

    public void addRoom(Room room) {
        this.rooms.add(room);
    }

    public boolean lastRoom(int roomIndex) {
        boolean result = false;
        roomIndex += 1;
        if (roomIndex  > rooms.size()){
            result = true;
        }
        return result;
    }


}
