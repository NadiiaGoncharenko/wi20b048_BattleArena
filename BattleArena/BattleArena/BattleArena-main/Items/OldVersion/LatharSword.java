package Items.OldVersion;
// this file is in use by an older version of the game, don't change it!

import java.util.Random;

public class LatharSword {
    private Random randomNumberGenerator;
    static final int strength = 5;
    static final int percentageVariable = 4;

    LatharSword(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int hit() {
        if (randomNumberGenerator.nextInt(10) < percentageVariable) {
            return strength;
        }
        return 0;
    }
}