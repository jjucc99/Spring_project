package BusPractice;

public class CityBus implements Bus{
    //   최대 승객수
    private int maxPassenger;
    //   현재 승객수
    private int currentPassenger = 0;
    //   현재 속도
    private int currentSpeed = 0;
    //   버스 요금
    private int charge;
    //  현재 연료
    private int currentFuel;
    //  버스 번호
    private String busCode;
    // 상태
    private Condition condition;
    private CityBus() {
    }

    @Override
    public void startBus(int maxPassenger, int charge ,
                         int currentFuel,  String busCode) {
        this.maxPassenger = maxPassenger;
        this.charge = charge;
        this.currentFuel = currentFuel;
        this.busCode = busCode;
        changeStatus();
    }

    @Override
    public void changeStatus() {
        if (currentFuel < 10) {
            condition = Condition.STOP;
            System.out.println("주유가 필요하다.");
        }
        condition = Condition.DRIVE;
    }
    @Override
    public void addPassenger(int passenger) {
        if ( condition == Condition.DRIVE && currentPassenger < maxPassenger) {
            currentPassenger += passenger;
        }
            System.out.println("현재 승객: " + currentPassenger);
    }

    @Override
    public void changeSpeed(int speed) {
        if (currentFuel >= 10) {
            currentSpeed += speed;
            System.out.println("현재 속도 : " + currentSpeed);
        } else {
            condition = Condition.STOP;
            currentSpeed = 0;
            System.out.println("주유량을 확인해주세요 현재 주유량: " + currentFuel);
        }
    }

    public static void main(String[] args) {
        CityBus cityBus = new CityBus();
        cityBus.startBus(50, 500, 0, "5000");
        cityBus.changeSpeed(10);
        cityBus.addPassenger(10);
    }
}
