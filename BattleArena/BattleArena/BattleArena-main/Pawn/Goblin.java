package Pawn;

import java.util.Random;

public class Goblin {
    private int strength;
    private Random randomNumberGenerator;
    static final int percentageVariable = 3;

    public Goblin(int strength, Random randomNumberGenerator) {
        this.strength = strength;
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public void action(Hero other) {
        if (randomNumberGenerator.nextInt(10) < percentageVariable) {
            other.reduceHealth(strength);
        }
    }
}
