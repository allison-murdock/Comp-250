package assignment1;

public class Room {
    private String roomType;
    private int roomPrice;
    private boolean avaliable;

    public Room(String roomType) {
        if (roomType.equals("double")) {
            this.roomType = roomType;
            this.roomPrice = 90 * 100;
        } else if (roomType.equals("queen")) {
            this.roomType = roomType;
            this.roomPrice = 110 * 100;
        } else if (roomType.equals("king")) {
            this.roomType = roomType;
            this.roomPrice = 150 * 100;
        } else {
            throw new IllegalArgumentException(roomType + "is not a possible room, please try again");
        }
        this.avaliable = true;
    }

    public Room(Room room) { //copy of constructor
        this.roomType = room.roomType;
        this.roomPrice = room.roomPrice;
        this.avaliable = room.avaliable;

    }
    public String getType() {
        return this.roomType;
    }

    public int getPrice() {
        return this.roomPrice;
    }

    public void changeAvailability() {

        this.avaliable = !this.avaliable;
    }
    public static Room findAvailableRoom(Room[] rooms, String type) {
        for (Room room : rooms) {
            if (room.roomType.equals(type) && room.avaliable) {
                return room;
            }
        }
        return null;
    }
    public static boolean makeRoomAvailable(Room[] rooms, String roomType) {
        for (Room room : rooms) {
            if (room.roomType.equals(roomType) && !room.avaliable) {
                room.avaliable = true;
                return true;
            }
        }
        return false;
    }

}
