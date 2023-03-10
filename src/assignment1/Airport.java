package assignment1;

public class Airport {
    private int boundX;
    private int boundY;
    private int fees;

    public Airport ( int boundX, int boundY, int fees) {
       this.boundX = boundX;
       this.boundY = boundY;
       this.fees = fees;
    }
    public int getFees() {
        return this.fees;
    }
    public static int getDistance(Airport airport1, Airport airport2) {
        int Xdist = (airport1.boundX - airport2.boundX);
        int Ydist = (airport1.boundY - airport2.boundY);
        double distance = Math.sqrt(Xdist * Xdist + Ydist * Ydist);
        return (int) Math.ceil(distance);
    }


}
