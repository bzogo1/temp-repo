public class DispatchCenter {

    // tries a delivery, prints it, and if it fails recharges and tries again
    public static void attemptDelivery(Drone d, Parcel p){
        boolean success = d.deliver(p);
        System.out.println(d.getName() + " delivered to " + p.getRecipient() + ": " + success);
        // failed so recharge and retry once
        if (!success){
            System.out.println("Recharging " + d.getName() + " and retrying...");
            d.recharge(100);
            success = d.deliver(p);
            System.out.println(d.getName() + " delivered to " + p.getRecipient() + ": " + success);
        }
    }

    // main runs the whole time
    public static void main(String[] args){
        // two drones, one for each constructor
        Drone hawk = new Drone("Hawk");
        Drone owl = new Drone("Owl", 0, 0, 30);   // low battery so one fails

        int samX = (int) (Math.random() * 21) - 10;
        int samY = (int) (Math.random() * 21) - 10;
        int zoeX = (int) (Math.random() * 21) - 10;
        int zoeY = (int) (Math.random() * 21) - 10;

        // four parcels, both constructors
        Parcel ana = new Parcel("Ana", 3, 4, 2.5);
        Parcel leo = new Parcel("Leo", -6, 8);
        Parcel sam = new Parcel("Sam", samX, samY, 1.5);
        Parcel zoe = new Parcel("Zoe", zoeX, zoeY);

        // try all the deliveries
        attemptDelivery(hawk, ana);
        attemptDelivery(owl, leo);   // needs 32 but owl has 30 so fails first
        attemptDelivery(hawk, sam);
        attemptDelivery(owl, zoe);

        // print every drone and parcel (calls toString)
        System.out.println(hawk);
        System.out.println(owl);
        System.out.println(ana);
        System.out.println(leo);
        System.out.println(sam);
        System.out.println(zoe);

        // fleet stats through the class name
        System.out.println("Fleet: " + Drone.getDroneCount() + " drones, "
            + Drone.getTotalDeliveries() + " deliveries");

        // hawk.battery = 500;
        // wont compile because battery is private in Drone, DispatchCenter is a
        // different class so it cant touch it directly, has to use recharge()
    }
}