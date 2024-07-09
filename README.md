Player Class:

    Attributes: name, health, strength, attack.
    Methods:
        isAlive: Checks if the player is still alive.
        getName and getHealth: Getters for name and health.
        attackOpponent: Executes an attack on the opponent, calculates damage, and reduces the opponent's health.

MagicalArena Class:

    match Method:
        Takes two players as input and sorts them based on their health (player with lower health attacks first).
        Players attack each other in turns until one player's health reaches 0.
        The loop continues until one of the players dies, printing the status after each attack.
    main Method:
        Creates two example players and starts the match.


 For Unit Test Cases

    PlayerTest:
        testPlayerInitialization:Verifies that a player is initialized correctly.
        testIsAlive: Verifies the behavior of the isAlive method.
        testAttackOpponent: Tests the attackOpponent method by providing mock dice rolls.

    MagicalArenaTest:
        testMatch:Simulates a match between two players and asserts that one player's health reaches 0 by the end.
