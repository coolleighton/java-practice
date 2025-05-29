

public class CoffeeMachineAbstractFactory {
    // entry into application.
    public static void main(String[] args) {
        // Create different coffee style factories using abstract factory
        CoffeeStyleFactory[] factories = new CoffeeStyleFactory[3];
        factories[0] = new ItalianStyleFactory();
        factories[1] = new AmericanStyleFactory();
        factories[2] = new SpecialtyStyleFactory();
        
        // Create coffee families using each factory
        for (CoffeeStyleFactory factory : factories) {
            System.out.println("\n" + factory.getClass().getSimpleName() + " creates:");
            
            Coffee coffee = factory.createCoffee();
            MilkComponent milk = factory.createMilkComponent();
            SugarComponent sugar = factory.createSugarComponent();
            
            System.out.println(" " + coffee.getClass().getSimpleName());
            System.out.println(" " + milk.getClass().getSimpleName());
            System.out.println(" " + sugar.getClass().getSimpleName());
        }
        
        // wait for input
        System.out.println("\nPress Enter to exit...");
        try {
            System.in.read();
        } catch (Exception e) {
            // dont do anything for exception
        }
    }
}

// Abstract Factory Interface
abstract class CoffeeStyleFactory {
    public abstract Coffee createCoffee();
    public abstract MilkComponent createMilkComponent();
    public abstract SugarComponent createSugarComponent();
}

// Concrete Factory 1: Italian Style
class ItalianStyleFactory extends CoffeeStyleFactory {
    @Override
    public Coffee createCoffee() {
        return new Espresso();
    }
    
    @Override
    public MilkComponent createMilkComponent() {
        return new SteamedMilk();
    }
    
    @Override
    public SugarComponent createSugarComponent() {
        return new RawSugar();
    }
}

// Concrete Factory 2: American Style
class AmericanStyleFactory extends CoffeeStyleFactory {
    @Override
    public Coffee createCoffee() {
        return new DripCoffee();
    }
    
    @Override
    public MilkComponent createMilkComponent() {
        return new WholeMilk();
    }
    
    @Override
    public SugarComponent createSugarComponent() {
        return new WhiteSugar();
    }
}

// Concrete Factory 3: Specialty Style
class SpecialtyStyleFactory extends CoffeeStyleFactory {
    @Override
    public Coffee createCoffee() {
        return new ColdBrew();
    }
    
    @Override
    public MilkComponent createMilkComponent() {
        return new OatMilk();
    }
    
    @Override
    public SugarComponent createSugarComponent() {
        return new CoconutSugar();
    }
}

// Abstract Product Classes
abstract class Coffee {
}

abstract class MilkComponent {
}

abstract class SugarComponent {
}

// Concrete Coffee Products
class Espresso extends Coffee {
}

class DripCoffee extends Coffee {
}

class ColdBrew extends Coffee {
}

// Concrete Milk Products
class SteamedMilk extends MilkComponent {
}

class WholeMilk extends MilkComponent {
}

class OatMilk extends MilkComponent {
}

// Concrete Sugar Products
class RawSugar extends SugarComponent {
}

class WhiteSugar extends SugarComponent {
}

class CoconutSugar extends SugarComponent {
}