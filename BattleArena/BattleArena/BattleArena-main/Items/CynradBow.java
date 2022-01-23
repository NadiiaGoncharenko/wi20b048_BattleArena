package Items;

import Pawn.Hero;

import java.util.Random;

public class CynradBow implements IEquipment {
    private String name = "Cynrad Bow";
    private int strength = 10;
    private Random randomNumberGenerator;
    static final int percentageVariable = 2;

    public CynradBow(Random randomNumberGenerator) {
        this.randomNumberGenerator = randomNumberGenerator;
    }

    public String getName() {
        return name;
    }

    @Override
    public void use(Hero other) {
        if (randomNumberGenerator.nextInt(10) < percentageVariable) {
            other.reduceHealth(strength);
            //тут би вписати бали іншому...
        }
    }
}