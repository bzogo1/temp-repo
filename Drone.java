public class Drone {
    // Static Variables
    private static int droneCount;       // how many drones made total
    private static int totalDeliveries;  // deliveries by every drone together
    // Instance Variables
    private int id;
    private String name;
    private int x;
    private int y;
    private int battery;
    private int deliveries;
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
        // count goes up first then id uses it
        droneCount++;
        this.name = n;
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
        this.deliveries = 0;
    }
    // Accessors
    // gives back the id
    public int getId(){
        return id;
    }
    // gives back the name
    public String getName(){
        return name;
    }
    // gives back x
    public int getX(){
        return x;
    }
    // gives back y
    public int getY(){
        return y;
    }
    // gives back the battery percent
    public int getBattery(){
        return battery;
    }
    // gives back how many deliveries this drone did
    public int getDeliveries(){
        return deliveries;
    }
    // recharger
    public void recharge(int amount){
        if (amount > 0){
            battery += amount;
            // cant go over 100
            if (battery > 100){
                battery = 100;
            }
        }
        // zero or negative does nothing
    }
    // straight line distance weird thing
    public static double distance(int x1, int y1, int x2, int y2){
        double FirstPartofEquation = x2-x1;
        double FirstPartofEquationSquared = Math.pow(FirstPartofEquation, 2);
        double SecondPartofEquation = y2-y1;
        double SecondPartofEquationSquared = Math.pow(SecondPartofEquation, 2);
        double FirstPartofEquationAddedtoSecondPartofEquation = FirstPartofEquationSquared + SecondPartofEquationSquared;
        double FirstPartofEquationAddedtoSecondPartofEquationSquareRooted = Math.sqrt(FirstPartofEquationAddedtoSecondPartofEquation);
        return FirstPartofEquationAddedtoSecondPartofEquationSquareRooted;
    }
    // battery needed to fly to a spot, distance times 3
    public int flightCost(int toX, int toY){
        return (int) (distance(x, y, toX, toY) * 3);
    }
    // flight cost plus the weight cost of the parcel
    public int deliveryCost(Parcel p){
        int flight = flightCost(p.getX(), p.getY());
        int weightCost = (int) (p.getWeight() * 2);
        return flight + weightCost;
    }
    // flyTo thingy, false if not enough battery
    public boolean flyTo(int toX, int toY){
        // cost first while x and y are still the old spot
        int cost = flightCost(toX, toY);
        if (cost > battery){
            return false;
        }
        battery -= cost;
        x = toX;
        y = toY;
        return true;
    }
    // deliver the parcel, true if it worked
    public boolean deliver(Parcel p){
        // cost before moving or it would be wrong
        int cost = deliveryCost(p);
        // already delivered or not enough battery
        if (p.isDelivered() || cost > battery){
            return false;
        }
        battery -= cost;
        x = p.getX();
        y = p.getY();
        deliveries++;
        totalDeliveries++;
        p.markDelivered();
        return true;
    }
    // String toString()
    public String toString(){
        return "Drone #" + id + " " + name + " at (" + x + ", " + y + "), battery " + battery + "%, deliveries: " + deliveries;
    }
    // static getter for droneCount
    public static int getDroneCount(){
        return droneCount;
    }
    // static getter for totalDeliveries
    public static int getTotalDeliveries(){
        return totalDeliveries;
    }
}