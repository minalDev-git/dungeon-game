import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class DungeonGame {
    public static void main(String[] args) {

        System.out.println("Welcome to Dungeon Game");
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the player name: ");
        String playerName = scan.next();

        Player player = new Player(playerName);

        ArrayList<Creature> creatures = new ArrayList<>();

        Random random = new Random();
        //initializing the creatures array
        for (int i = 0; i < 10; i++) {
            if (i % 2 == 0) {
                creatures.add(new Dragon());
            } else {
                creatures.add(new Goblin());
            }
        }

        while (player.isAlive() && !creatures.isEmpty()) {
            Creature creature = creatures.get(random.nextInt(creatures.size()));
            startGame(creature, player, scan);
            if (!creature.isAlive()) {
                creatures.remove(creatures.indexOf(creature));
            }
            if (!player.isAlive()) {
                System.out.println("Game Over!, you have been defeated");
                break;
            }
        }
        if (player.isAlive()) {
            System.out.println(player.name + "Wins!");
        }
    }

    public static void startGame(Creature creature, Player player, Scanner scan) {
        if (creature.isAlive() && player.isAlive()) {
            System.out.println("You encounter a " + creature.name + " Do you want to fight(1)? or flee(2)");
            try {
                int ans = Integer.parseInt(scan.next());
                if (ans == 1) {
                    creature.takeDamage(15);
                    if (!creature.isAlive()) {
                        Player.increaseScore(30);
                        System.out.println("You defeated the " + creature.name);
                        if (Player.getScore() % 100 == 0) {
                            player.health += 10;
                        }
                    }
                } else if (ans == 2) {
                    System.out.println("You choose to flee");
                    System.out.println("You have been attacked by the " + creature.name);
                    creature.attack(player);
                } else {
                    throw new IllegalArgumentException("Invalid Input, Choose 1 or 2");
                }
            } catch (Exception e) {
                System.out.println("Exception occured " + e.getMessage());
            }
        }
    }
}
