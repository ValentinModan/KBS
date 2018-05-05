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



         String abox =  racer.getAboxGraph();
         String cpu = "cpu";
         
         

         racer.addRoleAssertion( "DEFAULT", "CPU", "hasSocket",  "pizza");
         racer.addRoleAxiom("PIZZA","BERE");
         racer.sendRaw("(DEFINE-PRIMITIVE-ROLE |hasSocketVersion| :RANGE |CPUSocket|) ");

         Object a = null, b = null, c = null;
        String s = racer.allRoles();


        System.out.println("EMPTY SPACE");
        System.out.println(s);
        System.out.println("EMPTY SPACE");

        //racer.addAttributeAssertion('DEFAULT', individual, object, attribute)

         System.out.println(racer.allAtomicConcepts());

        System.out.println("EMPTY_SPACE");
        System.out.println(racer.allAtomicConcepts());


         racer.closeConnection();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

}