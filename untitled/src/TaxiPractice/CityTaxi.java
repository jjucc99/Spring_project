package TaxiPractice;

public class CityTaxi implements Taxi{

    //택시 번호
    private String taxiCode;

    //주유량
    private int currentFuel = 0;

    //현재속도
    private int currentSpeed = 0;

    //목적지
    private String destination;

    //기본거리
    private int baseDistance = 2000;

    //목적지까지의 거리
    private int destinationDistance;

    //기본 요금
    private int baseCharge = 2000;

    //거리당 요금
    private int mPerCharge = 500;
    
    
    //상태
    private Condition condition;

    private CityTaxi() {
    }

    @Override
    public void startTaxi(String taxiCode, int currentFuel) {
        this.taxiCode = taxiCode;
        this.currentFuel = currentFuel;

        System.out.println("현재 연료" + this.currentFuel);
        if (this.currentFuel < 10) {
            condition = Condition.STOP;
        } else {
            condition = Condition.BASE;
        }
    }

    @Override
    public void changeSpeed(int speed) {
        if (currentFuel > 10) {
            System.out.println("연료를 채워주세요");
            condition = Condition.STOP;
        }
        currentSpeed += speed;
        System.out.println("현재 속도는 " + currentSpeed);

    }
    @Override
    public int addPassenger(Passenger passenger) {
        if (condition == Condition.BASE) {
            condition = Condition.DRIVE;
            destination = passenger.getDestination();
            int charge = payCharge(
                    chargeAdditional(
                            passenger.getDistance()));
            return charge;
        } else {
            System.out.println("현재 택시를 이용하실 수 없습니다.");
            return 0;
        }
    }
    @Override
    public int chargeAdditional(int distance) {
        destinationDistance = distance - baseDistance;
        if (destinationDistance > 0) {
            return  this.destinationDistance * mPerCharge;
        } else {
            return baseCharge;
        }
    }

    @Override
    public int payCharge(int charge) {
        System.out.println("최종 요금은 " + charge + " 입니다.");
        condition = Condition.BASE;
        return charge;
    }

    public static void main(String[] args) {
        CityTaxi cityTaxi = new CityTaxi();
        Passenger wonju = new Gangwondo(3000, "원주");

        cityTaxi.startTaxi("5050", 50);
        int charge = cityTaxi.addPassenger(wonju);
    }
}
