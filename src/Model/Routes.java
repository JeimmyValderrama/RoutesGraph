package Model;

public class Routes {

    private referencePoints startPoint;
    private referencePoints endPoint;
    private double distance;

    public Routes(referencePoints startPoint, referencePoints endPoint, double distance) {
        this.startPoint = startPoint;
        this.endPoint = endPoint;
        this.distance = distance;
    }

    public referencePoints getStartPoint() {
        return startPoint;
    }

    public void setStartPoint(referencePoints startPoint) {
        this.startPoint = startPoint;
    }

    public referencePoints getEndPoint() {
        return endPoint;
    }

    public void setEndPoint(referencePoints endPoint) {
        this.endPoint = endPoint;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }
}
