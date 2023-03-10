package assignment1;

public class Basket  {
    private Reservation[] reservations;
    private int numOfReservations;
    public Basket() {
        this.reservations = new Reservation[0]; //should we just leave these array intializers here?
        this.numOfReservations = 0;
        }
    public Reservation[] getProducts() {
        Reservation[] dupe = reservations;
        return dupe;
    }

    public int add(Reservation reservation) {
        Reservation[] resArray = deepCopy(reservations, 1);
        resArray[resArray.length-1] = reservation;
        this.reservations = resArray;
        return this.reservations.length;
    }

    public boolean remove(Reservation reservation) {
       int initial = res1(this.reservations, reservation);
       if (initial != -1) {
           this.reservations[initial] = null;
           this.reservations = shorten(this.reservations);
           return true;
       }
       return false;
    }
    private Reservation[] deepCopy(Reservation[] rArray, int newStuff) {
        int len = rArray.length+newStuff;
        Reservation[] newArray = new Reservation[len];
        for (int i = 0; i < rArray.length; i++) {
            newArray[i] = rArray[i];
        }
        return newArray;
    }
    private int res1(Reservation[] resArray, Reservation reservation) {
        for (int i = 0; i < resArray.length; i ++){
            if(resArray[i].equals(reservation) & resArray[i] != null)
                return i;
        }
        return -1;
    }
    private Reservation[] shorten(Reservation[] resArray) {
        int first = 0;
        Reservation[] newResArray = new Reservation[resArray.length - 1];
        for(int x = 0; x < resArray.length - 1; x++) {
            if(resArray[x] != null) {
                if(x + first == resArray.length) break;
                newResArray[x] = resArray[x+first];
            }
            else {
                if (x + 1 == resArray.length) break;
                first = 1;
                newResArray[x] = resArray[x + 1];
            }
        }
        return newResArray;
    }
    public void clear() {
        this.reservations = new Reservation[0];
        this.numOfReservations = 0;
    }

    public int getNumOfReservations() {
        int num = 0;
        for (int i = 0; i<this.reservations.length; i++) {
            if (reservations[i] != null) num++;
        }
        return num;
    }

    public int getTotalCost() {
        int totalCost = 0;
        for (int i = 0; i < reservations.length; i++) {
            if (reservations[i] != null) totalCost += reservations[i].getCost();
        }
        return totalCost;
    }


}


