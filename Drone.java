public class Drone {
    // Static Variables
    private static int droneCount;
    private static int totalDeliveries;
    // Instance Variables
    private int id;
    private String name;
    private int x;
    private int y;
    private int battery;
    private int deliveries;
    // Extra Instance Variables

    private int startBattery;
    // Drone(String n)
    public Drone(String n){
        droneCount++;
        this.id = droneCount;
        this.name = n;
        this.x = 0;
        this.y = 0;
        this.battery = 100;
        this.deliveries = 0;
    }
    // Drone(paramters and more parameters)
    public Drone(String n, int startX, int startY, int startBattery){
        // declaring x & y
        this.x = startX;
        this.y = startY;
        // declaring the battery constraints
        if (startBattery > 100){
            this.battery = 100;
        } else if (startBattery < 0){
            this.battery = 0;
        } else {
            this.battery = startBattery;
        }
        this.id = droneCount;
    }
    // Accessors
    public int getId(){
        return id;
    }
    public String getName(){
        return name;
    }
    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getBattery(){
        return battery;
    }
    public int getDeliveries(){
        return deliveries;
    }
    // recharger
    public void recharge(int amount){
        if (amount > 0 && amount < 100){
            battery += amount;
        } else if (amount == 0 || amount < 0){
            battery = battery;
        }
    }
    // straight line distance weird thing
    static double distance(int x1, int y1, int x2, int y2){
        double FirstPartofEquation = x2-x1;
        double FirstPartofEquationSquared = FirstPartofEquation * FirstPartofEquation;
        double SecondPartofEquation = y2-y1;
        double SecondPartofEquationSquared = SecondPartofEquation * SecondPartofEquation;
        double FirstPartofEquationAddedtoSecondPartofEquation = FirstPartofEquationSquared + SecondPartofEquationSquared;
        double FirstPartofEquationAddedtoSecondPartofEquationSquareRooted = Math.sqrt(FirstPartofEquationAddedtoSecondPartofEquation);
        return FirstPartofEquationAddedtoSecondPartofEquationSquareRooted;
    }
}