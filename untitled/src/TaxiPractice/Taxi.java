package TaxiPractice;

public  interface Taxi {
    public void startTaxi(String taxiCode, int currentFuel);
    public int addPassenger(Passenger passenger);
    public void changeSpeed(int speed);
    public int chargeAdditional(int destination);
    public int payCharge(int charge);



}
