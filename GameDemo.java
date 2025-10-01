

// 1. Define the Playable interface with the abstract method play()
interface Playable {
    /**
     * Declares the method that all implementing classes must define.
     * This method is implicitly public and abstract.
     */
    void play();
}

// 2. Implement the Playable interface in the Cricket class
class Cricket implements Playable {
    /**
     * Implements the play() method for Cricket, displaying the game type.
     */
    @Override
    public void play() {
        System.out.println("Playing Cricket: A bat-and-ball game played between two teams of eleven players.");
    }
}

// 3. Implement the Playable interface in the Football class
class Football implements Playable {
    /**
     * Implements the play() method for Football, displaying the game type.
     */
    @Override
    public void play() {
        System.out.println("Playing Football: A team sport involving kicking a ball to score goals.");
    }
}

// 4. Main class to demonstrate the interface usage
public class GameDemo {
    public static void main(String[] args) {
        // Create objects of the classes, treating them as the interface type.
        // This demonstrates polymorphism, as both are of type Playable.
        Playable cricketGame = new Cricket();
        Playable footballGame = new Football();

        System.out.println("--- Interface Demonstration ---");
        
        // Call the play() method on the Cricket object
        System.out.print("Game 1: ");
        cricketGame.play();

        // Call the play() method on the Football object
        System.out.print("Game 2: ");
        footballGame.play();

        System.out.println("-----------------------------");
    }
}