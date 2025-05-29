public class CoffeeMachineFactoryMethod {
    // entry into application.
    public static void main(String[] args) {
        // Create different coffee makers using factory method pattern
        CoffeeMaker[] coffeeMakers = new CoffeeMaker[3];
        coffeeMakers[0] = new ItalianCoffeeMaker();
        coffeeMakers[1] = new AmericanCoffeeMaker();
        coffeeMakers[2] = new SpecialtyCoffeeMaker();
        
        // Create coffee using each coffee maker
        for (CoffeeMaker maker : coffeeMakers) {
            System.out.println("\n" + maker.getClass().getSimpleName() + " creates:");
            
            Coffee coffee = maker.makeCoffee();
            System.out.println(" " + coffee.getClass().getSimpleName());
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

// Abstract Creator (Factory Method pattern)
abstract class CoffeeMaker {
    // Factory method - subclasses will override this
    public abstract Coffee createCoffee();
    
    // Template method that uses the factory method
    public Coffee makeCoffee() {
        Coffee coffee = createCoffee();
        return coffee;
    }
}

// Concrete Creator 1: Italian Coffee Maker
class ItalianCoffeeMaker extends CoffeeMaker {
    @Override
    public Coffee createCoffee() {
        return new Espresso();
    }
}

// Concrete Creator 2: American Coffee Maker
class AmericanCoffeeMaker extends CoffeeMaker {
    @Override
    public Coffee createCoffee() {
        return new DripCoffee();
    }
}

// Concrete Creator 3: Specialty Coffee Maker
class SpecialtyCoffeeMaker extends CoffeeMaker {
    @Override
    public Coffee createCoffee() {
        return new ColdBrew();
    }
}

// Abstract Product
abstract class Coffee {
}

// Concrete Coffee Products
class Espresso extends Coffee {
}

class DripCoffee extends Coffee {
}

class ColdBrew extends Coffee {
}
