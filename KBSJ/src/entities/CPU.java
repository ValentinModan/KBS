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

    public String getInstance(){
        return "(INSTANCE " + hasValue+ " " + CPU.class.getName() + ")";
    }
}


