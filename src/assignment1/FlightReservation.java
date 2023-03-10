package assignment1;

public class FlightReservation extends Reservation {
    private Airport arrival;
    private Airport departure;

    public FlightReservation(String name, Airport arrival, Airport departure) {
        super(name);
        if (departure.equals(arrival)) {
            throw new IllegalArgumentException("This is the same airport, departure and arrival cannot be the same");
        }
        this.arrival = arrival;
        this.departure = departure;
    }

    public int getCost() {
        double fuelCost = (Airport.getDistance(departure, arrival)/167.52)*(1.24 * 100);
        double cost = fuelCost + arrival.getFees() + departure.getFees() + (53.75 * 100);
        return (int) Math.ceil(cost);
    }

    public boolean equals(Object obj) {
        if (obj instanceof FlightReservation) {
            FlightReservation other = (FlightReservation) obj;
            return other.reservationName().equals(this.reservationName()) &&
                    other.departure.equals(this.departure) &&
                    other.arrival.equals(this.arrival);
        }
        return false;
    }
}
