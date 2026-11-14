public class Parcel{
    // Instance Variables
    private String r;   // recipient name
    private int px;     // parcel x
    private int py;     // parcel y

    private double weight;      // in kg
    private boolean delivered;  // false until its delivered
    // Parcel Constructors
    public Parcel(String r, int px, int py, double weight) {
        this.r = r;
        this.px = px;
        this.py = py;
        // weight 0 or negative becomes 1.0
        if (weight > 0){
            this.weight = weight;
        } else {
            this.weight = 1.0;
        }
    }
    public Parcel(String r, int px, int py){
        this.r = r;
        this.px = px;
        this.py = py;
        // weight always 1.0
        this.weight = 1.0;
    }
    // Accessors
    // gives back the recipient name
    public String getRecipient(){
        return r;
    }
    // gives back the x coordinate
    public int getX(){
        return px;
    }
    // gives back the y coordinate
    public int getY(){
        return py;
    }
    // gives back the weight in kg
    public double getWeight(){
        return weight;
    }
    // is it delivered yet true or false
    public boolean isDelivered(){
        return delivered;
    }
    // markDelivered thingy
    public void markDelivered(){
        delivered = true;
    }
    // String toString()
    public String toString(){
        // pending unless delivered is true
        String status = "pending";
        if (delivered){
            status = "delivered";
        }
        return("Parcel for " + r + " at (" + px + ", " + py + "), " + weight + " kg, " + status);
    }
    
}