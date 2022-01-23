package Singleton;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class Singleton {

    private static Singleton instance;

    private List<String> log = new LinkedList();

    private Singleton() {
    }

    public static Singleton getInstance() {
        if (null == instance) {
            instance = new Singleton();
        }
        return instance;
    }

    public void  setLog(String newLeprecon){
        log.add(newLeprecon);
    }


    public void exportSingleton() {

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("C:\\Users\\LENOVO\\Downloads\\log.txt"))) {

            for (String leprecon : log){
                bw.write(leprecon);
                bw.newLine();
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}

    /*
    * description of the pattern / anti-pattern:
    *
    * Pattern is  typical way, the structure/ generic principe to solve some problem. It is not copy-paste method,
    * developer should adapt pattern to the code/situation/goal, so realisation will be
    * different for each case (problem, program). So it is not some static code or
    * structured line of steps, but it is a description "how could you do this", sometimes highleveled explained.
    * Usually description is presented in formal, standardised way, which allows to find that pattern, which
    * id needed for solving this problem (which is often same problem , but with some variations).
    *
    ** Pattern is architectural element which is used over and over again. It helps to communicate with other
    * developers (also from different countries/ companies/ languages), standardise and shorten cycle time
    * of developing (it saves not only time, but money and also helps to include new team members in work)
    * There are few categories of patterns.
    *
    *
    ** Anti-pattern: it is way how not to write code. It is inefficient, ineffective,
    * bad design of software, way to complex code which breaks often. Often this part of code need to be
    * reviewed and fixed sooner or later. Anti-pattern can arise from copying patterns from old Systems or
    * choosing a poor algorithm.
    * Anti-pattern is also described as 20% of code(for example) which causes 80% of all problems
    * (caused more problems that should be expected) and they can be find in different parts of
    * the project (requirements, design, and code).
    *
                 *** Singleton is a popular pattern, a creational design pattern.

    * * Its implementation requires almost no adaptation to the situation. So its simple and often used (and overused too).
    * It ensures that there is only one instance of the class, and provides a global access point.
    * Regardless of where you call it from, it will always give you the same object.
    * This class has no public constructor and has several types of implementation.
    *
                            *** Singleton as anti-pattern:***

    * - violates the SOLID pattern (SRP (Single Responsibility Principle) in addition to fulfilling its
    * immediate duties, it also controls the number of its instances.
    * - the complexity of refactoring when subsequently replacing a singleton with an object containing multiple instances.
    * - the singleton instance is not passed in the method parameters but is obtained directly through getInstance()
    * and it is necessary to get into the body of each method to reveal the class dependency on the singleton
    * - the correctness of work with a singleton depends on the order of calls to it, which causes implicit dependence
    *  of subsystems from each other and as a consequence, complicates development seriously.
    * -the presence of a singleton lowers the testability of an application in general and classes that use
    * a singleton in particular (on the other hand, singleton makes programming auto-tests much easier).
    *
    * **Implementation:

        lazy - The class object is not created at the beginning, but only when the first reference to it is received.
            * This is in use, if we are not sure, that we will need it/it will be in use. So we will initialise it only,
            * if we come to the use direct.
            * This creates a threading problem, which can be solved by synchronisation (also has its drawbacks),
            * or you can use the "Lazy Initialization Holder" pattern
            *
        * * I chose lazy one, as I know, that I will use it anyway. Also I understand it better and had more praxis with it

        static - a class object is created at the beginning. Use this one, if you are sure, that you will need this
    *
    * */


    /*@Override
    public String toString() {
        return "Singleton{" +
                "name='" + name + '\'' +
                '}';
    }*/


