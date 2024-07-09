import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class PlayerTest {
    
    @Test
    void testPlayerInitialization() {
        Player player = new Player("Test Player", 100, 10, 20);
        assertEquals("Test Player", player.getName());
        assertEquals(100, player.getHealth());
        assertEquals(10, player.getStrength());
        assertEquals(20, player.getAttack());
    }

    @Test
    void testIsAlive() {
        Player player = new Player("Test Player", 100, 10, 20);
        assertTrue(player.isAlive());
        player.setHealth(0);
        assertFalse(player.isAlive());
    }

    @Test
    void testAttackOpponent() {
        Player attacker = new Player("Attacker", 100, 10, 20);
        Player defender = new Player("Defender", 100, 10, 20);
        
        // Mocking the dice rolls
        int attackRoll = 5;
        int defendRoll = 3;
        int expectedDamage = (20 * attackRoll) - (10 * defendRoll);
        
        attacker.attackOpponent(defender, attackRoll, defendRoll);
        
        assertEquals(100 - expectedDamage, defender.getHealth());
    }
}

class MagicalArenaTest {
    
    @Test
    void testMatch() {
        Player playerA = new Player("Player A", 50, 5, 10);
        Player playerB = new Player("Player B", 100, 10, 5);
        
        MagicalArena.match(playerA, playerB);
        
        assertTrue(playerA.getHealth() <= 0 || playerB.getHealth() <= 0);
    }
}
