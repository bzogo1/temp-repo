public class Parcel{
    // Instance Variables
    private String r;
    private int px;
    private int py;

    private double weight;
    private boolean delivered;
    // Parcel Constructors
    public Parcel(String r, int px, int py, double weight) {
        this.r = r;
        this.px = px;
        this.py = py;
        this.weight = weight;
    }
    public Parcel(String r, int px, int py){
        this.r = r;
        this.px = px;
        this.py = py;
    }
    // Accessors
    public String getRecipient(){
        return r;
    }
    public int getX(){
        return px;
    }
    public int getY(){
        return py;
    }
    public double getWeight(){
        return weight;
    }
    public boolean delivered(){
        return delivered;
    }
    // markDelivered thingy
    public void markDelivered(){
        delivered = true;
    }
    // String toString()
    public String toString(){
        String status = "pending";
        if (delivered){
            status = "delivered";
        }
        return("Parcel for " + r + " at (" + px + ", " + py + "), " + weight + "kg, " + status);
    }
    
}