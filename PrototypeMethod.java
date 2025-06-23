import java.util.HashMap;
import java.util.Map;

/**
 * Prototype Design Pattern
 */
public class PrototypeMethod {
    public static void main(String[] args) {
        ColorManager colorManager = new ColorManager();
        
        // Initialize with standard colors
        colorManager.setColor("red", new Color(255, 0, 0));
        colorManager.setColor("green", new Color(0, 255, 0));
        colorManager.setColor("blue", new Color(0, 0, 255));
        
        // User adds personalized colors
        colorManager.setColor("angry", new Color(255, 54, 0));
        colorManager.setColor("peace", new Color(128, 211, 128));
        colorManager.setColor("flame", new Color(211, 34, 20));
        
    
        // User clones selected colors
        Color color1 = (Color) colorManager.getColor("red").clone();
        Color color2 = (Color) colorManager.getColor("peace").clone();
        Color color3 = (Color) colorManager.getColor("flame").clone();
        
        // Wait for user
        try {
            System.in.read();
        } catch (Exception e) {
        }
    }
}

/**
 * The 'Prototype' abstract class
 */
abstract class ColorPrototype implements Cloneable {
    public ColorPrototype clone() {
        try {
            return (ColorPrototype) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Clone not supported", e);
        }
    }
}

/**
 * The 'ConcretePrototype' class
 */
class Color extends ColorPrototype {
    private int red;
    private int green;
    private int blue;
    
    // Constructor
    public Color(int red, int green, int blue) {
        this.red = red;
        this.green = green;
        this.blue = blue;
    }
    
    // Create a shallow copy
    @Override
    public ColorPrototype clone() {
        System.out.printf("Cloning color RGB: %3d,%3d,%3d%n", red, green, blue);
        
        return super.clone();
    }
}

/**
 * Prototype manager
 */
class ColorManager {
    private Map<String, ColorPrototype> colors = new HashMap<>();
    
    // Getter method (equivalent to C# indexer get)
    public ColorPrototype getColor(String key) {
        return colors.get(key);
    }
    
    // Setter method (equivalent to C# indexer set)
    public void setColor(String key, ColorPrototype value) {
        colors.put(key, value);
    }
}