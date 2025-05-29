
public class AbstractFactoryMethod {
    // entry into application
    public static void main(String[] args) {
        // Create and run the African animal world
        ContinentFactory africa = new AfricaFactory();
        AnimalWorld world = new AnimalWorld(africa);
        world.runFoodChain();
        
        // Create and run the American animal world
        ContinentFactory america = new AmericaFactory();
        world = new AnimalWorld(america);
        world.runFoodChain();
    }
}


// The 'AbstractFactory' abstract class
abstract class ContinentFactory {
    public abstract Herbivore createHerbivore();
    public abstract Carnivore createCarnivore();
}


// The 'ConcreteFactory1' class
class AfricaFactory extends ContinentFactory {
    @Override
    public Herbivore createHerbivore() {
        return new Wildebeest();
    }
    
    @Override
    public Carnivore createCarnivore() {
        return new Lion();
    }
}


// The 'ConcreteFactory2' class
class AmericaFactory extends ContinentFactory {
    @Override
    public Herbivore createHerbivore() {
        return new Bison();
    }
    
    @Override
    public Carnivore createCarnivore() {
        return new Wolf();
    }
}


// The 'AbstractProductA' abstract class
abstract class Herbivore {
}


// The 'AbstractProductB' abstract class
abstract class Carnivore {
    public abstract void eat(Herbivore h);
}


// The 'ProductA1' class
class Wildebeest extends Herbivore {
}


// The 'ProductB1' class
class Lion extends Carnivore {
    @Override
    public void eat(Herbivore h) {
        // Eat Wildebeest
        System.out.println(this.getClass().getSimpleName() + 
            " eats " + h.getClass().getSimpleName());
    }
}


// The 'ProductA2' class
class Bison extends Herbivore {
}


// The 'ProductB2' class
class Wolf extends Carnivore {
    @Override
    public void eat(Herbivore h) {
        // Eat Bison
        System.out.println(this.getClass().getSimpleName() + 
            " eats " + h.getClass().getSimpleName());
    }
}


// The 'Client' class
class AnimalWorld {
    private Herbivore herbivore;
    private Carnivore carnivore;
    
    // Constructor
    public AnimalWorld(ContinentFactory factory) {
        carnivore = factory.createCarnivore();
        herbivore = factory.createHerbivore();
    }
    
    public void runFoodChain() {
        carnivore.eat(herbivore);
    }
}