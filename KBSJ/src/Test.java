//package test;

import com.racersystems.jracer.*;
import entities.CPU;
import entities.GPU;

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


        message = CPU.hasBrand("Intel","Intel_Core_i7");
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));
        System.out.println(racer.sendRaw("(related-individuals hasBrand)"));
        System.out.println("EMPTY_SPACE");


        ArrayList<String> message1  = CPU.hasSocket("Intel_Core_i7","s6501");
        System.out.println("Sending message: " + message1.get(0));
        racer.sendRaw(message1.get(0));
        System.out.println("Sending message: " + message1.get(1));
        racer.sendRaw(message1.get(1));
        System.out.println(racer.sendRaw("(related-individuals hasSocket)"));
        System.out.println("EMPTY_SPACE");


        message1  = CPU.hasCore("Intel_Core_i7","c4.0");
        System.out.println("Sending message: " + message1.get(0));
        racer.sendRaw(message1.get(0));
        System.out.println("Sending message: " + message1.get(1));
        racer.sendRaw(message1.get(1));
        System.out.println(racer.sendRaw("(related-individuals hasCore)"));
        System.out.println("EMPTY_SPACE");


        message1  = CPU.hasPower("Intel_Core_i7","w65");
        System.out.println("Sending message: " + message1.get(0));
        racer.sendRaw(message1.get(0));
        System.out.println("Sending message: " + message1.get(1));
        racer.sendRaw(message1.get(1));
        System.out.println(racer.sendRaw("(related-individuals hasPower)"));
        System.out.println("EMPTY_SPACE");
     
        
        
        System.out.println("xxx");
        
        message =GPU.hasPCIType("GTX_1080ti", "PCI_Express") ;
        System.out.println("M1: "+message.get(0));
        System.out.println("M2: "+message.get(1));
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

        System.out.println(racer.sendRaw("(related-individuals hasPCIType)"));
        
        message =GPU.hasPower("GTX_1080ti", "W330");
    	System.out.println("M1: "+message.get(0));
        System.out.println("M2: "+message.get(1));
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

        System.out.println(racer.sendRaw("(related-individuals hasPower)"));
        
        
        message =GPU.hasBrand("nVidia", "GTX_1080ti");
    	System.out.println("M1: "+message.get(0));
        System.out.println("M2: "+message.get(1));
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

        System.out.println(racer.sendRaw("(related-individuals hasBrand)"));
        
         
        message =GPU.hasBandwidth("GTX_1080ti", "484GB/s");
    	System.out.println("M1: "+message.get(0));
        System.out.println("M2: "+message.get(1));
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

        System.out.println(racer.sendRaw("(related-individuals hasBandwidth)"));
        
        
        message =GPU.hasClockFrequency( "GTX_1080ti", "11010MHz");
    	System.out.println("M1: "+message.get(0));
        System.out.println("M2: "+message.get(1));
        racer.sendRaw(message.get(0));
        racer.sendRaw(message.get(1));

        System.out.println(racer.sendRaw("(related-individuals hasClockFrequency)"));
        
        
        
        // close connection
        racer.closeConnection();
    }
    catch (Exception e) {
        e.printStackTrace();
    }
}

}