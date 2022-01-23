package Pawn;

import Items.IEquipment;
import Observer.LepreconSubscriber;
import Observer.Publisher;
import Singleton.Singleton;

import java.time.LocalDateTime;
import java.util.Random;
import java.util.Vector;

public class Hero extends Publisher{

    private String name;
    private int health;
    private int coins;
    private int leprechaun;
    private int lastKeyInput;
    private IEquipment weapon;
    private Vector<Goblin> goblins = new Vector<Goblin>();
    private Publisher publisher = new Publisher();



    public Hero(String name, IEquipment equipment) {
        this.name = name;
        this.health = 100;
        this.coins = 1;
        this.leprechaun = 0;
        lastKeyInput = -1;
        weapon = equipment;
        publisher.subscribe(new LepreconSubscriber());
    }

    public boolean action(Hero other) {
        weapon.use(other);
        return true;
    }

    public void updateCoins() {
        coins += leprechaun + 1;
        if(leprechaun % 5 == 0 && leprechaun != 0) {
            this.publisher.send("%s got 5th leprecon", this.name);

        }
    }

    public void useGoblins(Hero other) {
        for (Goblin tmpGoblin : goblins) {
            tmpGoblin.action(other);
        }
    }

    public int getHealth() {
        return health;
    }

    public void reduceHealth(int hitpoints) {
        this.health -= hitpoints;
    }

    public int getCoins() {
        return coins;
    }

    public boolean addLeprechaun() {
        if (coins > 1) {
            coins -= 2;
            leprechaun++;
            if(leprechaun % 5 == 0 && leprechaun != 0){
                this.publisher.send("%s got 5th leprecon", this.name);
            }

            Singleton.getInstance().setLog("Leprecon bought by " + name + "at " + LocalDateTime.now() + "\n");
                //für static singleton
             // StaticSingleton.getInstance().setLog("Leprecon bought by " + name + "at " + LocalDateTime.now() + "\n");



            return true;
        }
        return false;
    }

    public int getLeprechaun() {
        return leprechaun;
    }

    public int getNumberofGoblins() {
        return goblins.size();
    }

    public boolean addTinyGoblin(Random randomNumberGenerator) {
        if (coins > 0) {
            coins -= 1;
            goblins.add(new Goblin(1, randomNumberGenerator));
            return true;
        }
        return false;

    }

    public boolean addMediumGoblin(Random randomNumberGenerator) {
        if (coins > 2) {
            coins -= 3;
            goblins.add(new Goblin(2, randomNumberGenerator));
            return true;
        }
        return false;
    }

    public boolean addBigGoblin(Random randomNumberGenerator) {
        if (coins > 5) {
            coins -= 6;
            goblins.add(new Goblin(3, randomNumberGenerator));
            return true;
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getLastKeyInput() {
        return lastKeyInput;
    }

    public void setLastKeyInput(int key) {
        lastKeyInput = key;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nCoins: " + coins + "\nLeprechaun: " + leprechaun + "\nLastKeyInput: " + lastKeyInput
                + "\n\n";
    }

}
