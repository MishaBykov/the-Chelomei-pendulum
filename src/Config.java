import java.awt.geom.Point2D;
import java.util.HashMap;

public class Config {
    private static double widthWasher = 0.1;
    private static double heightWasher = 0.1;
    private static double scale = 100;
    private static int speedDown = 25;
    private static double step = 1.0 / (speedDown * 10);

    private Config(){}

    public static double getStep() {
        return step;
    }

    public static double getScale() {
        return scale;
    }

    public static int getSpeedDown() {
        return speedDown;
    }

    public static double getHeightWasher() {
        return heightWasher;
    }

    public static double getWidthWasher() {
        return widthWasher;
    }

    public static Point2D.Double findTwoPoint(Point2D.Double onePoint, double length, double angle) {
        return new Point2D.Double(-Math.sin(angle) * length + onePoint.getX(),
                Math.cos(angle) * length + onePoint.getY());
    }
    
    public static HashMap<String, Double> getScaleSlider(){
        HashMap<String, Double> result = new HashMap<String, Double>();
        result.put("x", 1.0);
        result.put("phi", 1.0);
        result.put("dotX", 1.0);
        result.put("dotPhi", 1.0);
        result.put("I0", 1.0);
        result.put("I1", 1.0);
        result.put("m", 1.0);
        result.put("l", 1.0);
        result.put("k1", 1.0);
        result.put("k2", 1.0);
        result.put("M", 1.0);
        result.put("g", 1.0);
        result.put("alpha", 1.0);
        result.put("nu", 1.0);
        result.put("theta", 1.0);
        return result;
    }
}