package entities;

import java.util.ArrayList;

public class CPU {
    String name;
    String hasValue;
    String role;
    String hasRole;

    public CPU(String name, String hasValue, String role) {
        this.name = name;
        this.hasValue = hasValue;
        this.hasRole = "has" + role;
        this.role = role;
    }


    public static ArrayList<String> hasCPUVersion(String cpuName, String version){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + version + " CPUVersion)";
        String related = "(RELATED "+ cpuName + " " + version + " hasCPUVersion)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }

    public static ArrayList<String> hasBrand(String brand, String cpuName){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + cpuName + " Brand)";
        String related = "(RELATED "+ brand + " " + cpuName+ " hasBrand)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }

    public static ArrayList<String> hasSocket(String cpuName, String socket){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + socket + " Socket)";
        String related = "(RELATED "+ cpuName + " " + socket+ " hasSocket)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }

    public static ArrayList<String> hasCore(String cpuName, String core){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + core + " Core)";
        String related = "(RELATED "+ cpuName + " " + core+ " hasCore)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }

    public static ArrayList<String> hasPower(String cpuName, String power){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + power + " Power)";
        String related = "(RELATED "+ cpuName + " " + power+ " hasPower)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }

    public String getInstance(){
        return "(INSTANCE " + hasValue+ " " + CPU.class.getName() + ")";
    }
}


