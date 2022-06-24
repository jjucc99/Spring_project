package TaxiPractice;

public class Gangwondo implements Passenger {
    int distance;
    String destination;

    public Gangwondo(int distance, String destination) {
        this.distance = distance;
        this.destination = destination;
    }

    public int getDistance() {
        return distance;
    }

    public String getDestination() {
        return destination;
    }
}
