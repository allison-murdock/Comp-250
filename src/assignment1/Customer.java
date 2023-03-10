package assignment1;

public class Customer {
    private String name;
    private int balance;
    private Basket basket;

    public Customer(String name, int balance) {
        this.name = name;
        this.balance = balance;
        this.basket = new Basket();
    }

    public String getName() {
        return this.name;
    }

    public int getBalance() {
        return this.balance;
    }
    private void saveBalanceAs(int newBalance){ //a helper method to set the balance after it changes (helpful for last method)
        this.balance = newBalance;
    }
    public Basket getBasket() {
        return basket;
    }

    public int addFunds(int addition) {
        if (addition < 0) {
            throw new IllegalArgumentException("Input cannot be negative or zero. Please try again");
        } else saveBalanceAs (this.getBalance() + addition); {
            return this.getBalance();
        }
    }

    public int addToBasket(Reservation reservation) {
        if (reservation.reservationName().equals(this.name)) {
            this.basket.add(reservation);
            return this.basket.getNumOfReservations();
        }
        else throw new IllegalArgumentException("This is not the correct reservation");
    }
    public int addToBasket(Hotel location, String type, int duration, boolean addBreakfast){
        if (addBreakfast) {
            this.basket.add(new BnBReservation(this.name, location, type, duration));
        }
        else{
            this.basket.add(new HotelReservation(this.name, location, type, duration));
            }
        return this.basket.getNumOfReservations();
    }
    public int addToBasket(Airport airport1, Airport airport2) {
        this.basket.add(new FlightReservation(this.name, airport1, airport2));
        return this.basket.getNumOfReservations();
    }
    public boolean removeFromBasket(Reservation reservation){
        return this.basket.remove(reservation);
    }
    public int checkOut(){
        int basketCost = basket.getTotalCost();
        if(this.balance < basketCost){
            throw new IllegalArgumentException("balance too low!");
        }
        else {
                this.basket.clear();
                saveBalanceAs(this.balance-basketCost);
                return this.getBalance();
        }
    }
}
