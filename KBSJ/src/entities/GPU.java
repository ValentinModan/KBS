package entities;

import java.util.ArrayList;

public class GPU {
	
	public static ArrayList<String> hasPCIType(String gpuName, String PCIType){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + PCIType + " PCIType)";
        String related = "(RELATED "+ gpuName + " " + PCIType + " hasPCIType)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }
	
	public static ArrayList<String> hasSize(String gpuName, String size){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + size + " Size)";
        String related = "(RELATED "+ gpuName + " " + size + " hasSize)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }
	
	public static ArrayList<String> hasPower(String gpuName, String power){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + power + " Power)";
        String related = "(RELATED "+ gpuName + " " + power+ " hasPower)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }
	
	public static ArrayList<String> hasBrand(String brand, String gpuName){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + gpuName + " Brand)";
        String related = "(RELATED "+ brand + " " + gpuName+ " hasBrand)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }
	
	
	public static ArrayList<String> hasBandwidth(String gpuName,String bandwidth ){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + bandwidth + " Bandwidth)";
        String related = "(RELATED "+ gpuName + " " + bandwidth+ " hasBandwidth)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }
	
	
	public static ArrayList<String> hasClockFrequency(String gpuName,String frequency ){
        ArrayList<String> mesaj = new ArrayList<>();
        String instance = "(INSTANCE " + frequency + " ClockFrequency)";
        String related = "(RELATED "+ gpuName + " " + frequency+ " hasClockFrequency)";

        mesaj.add(instance);
        mesaj.add(related);
        return mesaj;
    }




}
