//package test;

import com.racersystems.jracer.*;

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
         
         //racer.addAttributeAssertion('DEFAULT', individual, object, attribute)
         //System.out.println(racer.sendRaw("(all-atomic-concepts)"));
         
         System.out.println(racer.allAtomicConcepts());
                  
         racer.closeConnection();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

}