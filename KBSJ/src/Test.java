//package test;

import com.racersystems.jracer.*;
import entities.CPU;

import java.util.ArrayList;

public class Test {

public static void main(String[] argv) {
    String ip = "127.0.0.1";
    int port = 8088;
    String filename="\"desktop.racer\"";

    RacerClient racer = new RacerClient(ip,port);
    try {
         racer.openConnection();


         System.out.println(racer.sendRaw("(racer-read-file " + filename + ")"));
         System.out.println("-------------");

         racer.sendRaw("(DEFINE-PRIMITIVE-ROLE |hasSocketVersion| :RANGE |CPUSocket|) ");

        String s = racer.allRoles();


        System.out.println("EMPTY SPACE");
        System.out.println(s);
        System.out.println("EMPTY SPACE");

        //racer.addAttributeAssertion('DEFAULT', individual, object, attribute)

         System.out.println(racer.allAtomicConcepts());

        System.out.println("EMPTY_SPACE");
        System.out.println(racer.allAtomicConcepts());
        System.out.println("EMPTY_SPACE");
        ArrayList<String> message =CPU.hasCPUVersion("Intel_Core_i7","6900HK");


        System.out.println("Message to be send: " + message);
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

       // System.out.println(racer.allAtomicConcepts());
        System.out.println(racer.sendRaw("(related-individuals hasCPUVersion)"));
        System.out.println("EMPTY_SPACE");

         racer.closeConnection();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

}