import java.util.Random;

class Player {
    private String name;
    private int health;
    private int strength;
    private int attack;

    public Player(String name, int health, int strength, int attack) {
        this.name = name;
        this.health = health;
        this.strength = strength;
        this.attack = attack;
    }

    public boolean isAlive() {
        return this.health > 0;
    }

    public String getName() {
        return this.name;
    }

    public int getHealth() {
        return this.health;
    }

    public void attackOpponent(Player opponent) {
        Random rand = new Random();
        int attackRoll = rand.nextInt(6) + 1;
        int defendRoll = rand.nextInt(6) + 1;

        int attackDamage = this.attack * attackRoll;
        int defendValue = opponent.strength * defendRoll;

        int damage = Math.max(0, attackDamage - defendValue);
        opponent.health -= damage;

        System.out.println(this.name + " attacks " + opponent.name + " and rolls a " + attackRoll + ".");
        System.out.println(opponent.name + " defends and rolls a " + defendRoll + ".");
        System.out.println("Attack damage is " + this.attack + " * " + attackRoll + " = " + attackDamage);
        System.out.println("Defend value is " + opponent.strength + " * " + defendRoll + " = " + defendValue);
        System.out.println(opponent.name + " takes " + damage + " damage and now has " + opponent.health + " health.\n");
    }
}

public class MagicalArena {
    public static void match(Player player1, Player player2) {
        Player[] players = {player1, player2};
        if (player1.getHealth() > player2.getHealth()) {
            players[0] = player2;
            players[1] = player1;
        }

        while (player1.isAlive() && player2.isAlive()) {
            Player attacker = players[0];
            Player defender = players[1];
            attacker.attackOpponent(defender);

            if (!defender.isAlive()) {
                System.out.println(defender.getName() + " has died. " + attacker.getName() + " wins!");
                break;
            }

            Player temp = players[0];
            players[0] = players[1];
            players[1] = temp;
        }
    }

    public static void main(String[] args) {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);

        match(playerA, playerB);
    }
}
