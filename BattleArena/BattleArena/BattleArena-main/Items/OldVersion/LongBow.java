package Items.OldVersion;

import java.util.Random;

public class LongBow {
    private Random randomNumberGenerator;
    static final int strength = 7;
    static final int percentageVariable = 4;

    public LongBow(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public int hit() {
        if (randomNumberGenerator.nextInt(10) < percentageVariable) {
            return strength;
        }
        return 0;
    }
}
