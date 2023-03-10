package assignment1;

public class HotelReservation extends Reservation {
    private Hotel location;
    private String roomType;
    private int duration;
    private int price;

    public HotelReservation(String name, Hotel location, String roomType, int duration) {
        super(name);
        this.location = location;
        this.duration = duration;
        this.roomType = roomType;
        try {
            price = location.reserveRoom(roomType);
        }
        catch(IllegalArgumentException x){
            throw new IllegalArgumentException("This is not a possible room at" + location + "please try again!");
        }
    }
    public int getNumOfNights(){
        return this.duration;
    }
    public int getCost(){
        int totalCost = price * this.getNumOfNights();
        return totalCost;
    }
    public boolean equals(Object obj) {
        if (!(obj instanceof HotelReservation)) {
            return false;
        } else {
                HotelReservation reservation = (HotelReservation) obj;
                if (this.getCost() == reservation.getCost()
                    && this.getNumOfNights() == reservation.getNumOfNights()
                        && this.roomType.equals(reservation.roomType)
                            && this.location.equals(reservation.location)
                                && this.reservationName().equals(reservation.reservationName())) {
                    return true;
                }
                else return false;
        }

    }

}
