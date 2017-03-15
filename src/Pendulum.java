import java.awt.*;
import java.awt.geom.*;

public class Pendulum {
    private Color color;

    private double length;
    private double angle;
    private Point2D.Double onePoint;
    private Point2D.Double twoPoint;
    private Functions functions;
    private Parameters parameters;
    private Rku rku;

    public Pendulum(Functions functions, Parameters parameters, Rku rku, Color color) {
        this.functions = functions;
        this.parameters = parameters;
        this.rku = rku;
        onePoint = new Point2D.Double();

        this.color = color;

        update();
    }

    public Color getColor() {
        return color;
    }

    public Point2D.Double getOnePoint() {
        return onePoint;
    }

    public Point2D.Double getTwoPoint() {
        return twoPoint;
    }

    public double getAngle() {
        return angle;
    }

    public double getLength() {
        return length;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void setOnePoint(double x, double y) {
        onePoint.setLocation(x ,y);
    }

    public void setTwoPoint(double x, double y) {
        twoPoint.setLocation(x, y);
    }

    public void setAngle(double angle) {
        this.angle = angle;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public void update() {
        setAngle(parameters.get("phi"));
        setLength(parameters.get("l"));
        setOnePoint(functions.suspensionX(rku.getT()), functions.suspensionY(rku.getT()));
        twoPoint = Setting.findTwoPoint(onePoint, getLength(), getAngle());
    }
}