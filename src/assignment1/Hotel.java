package assignment1;

public class Hotel {
    private String name;
    private Room[] rooms;

    public Hotel (String name, Room[] rooms) {
        this.name = name;
        this.rooms = new Room[rooms.length];
        for (int i = 0; i < rooms.length; i++) {
            this.rooms[i] = new Room(rooms[i]);
        }
    }
    public int reserveRoom(String type) {
        Room room = Room.findAvailableRoom(rooms, type);
        if (room == null) {
            throw new IllegalArgumentException("No available room of type " + type + " found.");
        }
        room.changeAvailability();
        return room.getPrice();
    }

    public boolean cancelRoom(String type) {
        return Room.makeRoomAvailable(this.rooms, type);
    }
}
