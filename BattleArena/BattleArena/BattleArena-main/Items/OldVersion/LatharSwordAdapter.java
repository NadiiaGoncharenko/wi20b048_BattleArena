package Items.OldVersion;

import Items.IEquipment;
import Pawn.Hero;

import java.util.Random;

public class LatharSwordAdapter implements IEquipment{

    private LatharSword latharSword;

 /*     public LatharSwordAdapter(LatharSword latharSword) {
        this.latharSword = latharSword;
    }
  */

    public LatharSwordAdapter () {

        Random randomNumberGenerator = new Random();

        latharSword = new LatharSword(randomNumberGenerator);
        this.latharSword = latharSword;
    }


    @Override
    public void use(Hero other) {
        int strengt = latharSword.hit();

        other.reduceHealth(strengt);
    }

    /* description of the difference between class and object adapter:
    *
    * An adapter is a structural design pattern that allows objects with non-adjacent interfaces to work together.
    *
    * The object adapter uses composition and can be used in all popular languages,
    *  while the class adapter is only possible in languages that allow multiple inheritance
    * (in Java one of the interfaces must be of  Java Interface type).
    *  A class adapter inherits interfaces from both classes, an object adapter wraps
    * (i.e. contains a reference to a service object) one object and implements the interface of the other object.
    *
    * These two adapters use different techniques: Inheritance (white-box reuse) and composition (black-box reuse).
    *
    * Composition has the advantage that well-defined interfaces support class separation and implementations can
    * be easily replaced if necessary (or new adapter types can be added to the software, regardless of the client code.)
    * "Inheritance breaks encapsulation because a subclass gets the details of the parent class implementation
    * and makes the subclass dependent. It also complicates code and testing, functionality also suffers.
    * Which adapter to use also depends on specific requirements (and programming language).
    * */
}
