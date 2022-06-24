package BusPractice;

public interface Bus {

    public void startBus(int maxPassenger, int charge ,
                         int currentFuel,  String busCode);
    public void changeStatus();
    public void addPassenger(int passenger);
    public void changeSpeed(int speed);
}
