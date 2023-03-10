package assignment1;

public class BnBReservation extends HotelReservation {
    public BnBReservation(String name, Hotel hotel, String roomType, int duration) {
        super(name, hotel, roomType, duration);
    }
    public int getCost(){
        return super.getCost() + 1000 * this.getNumOfNights();
    }
}
