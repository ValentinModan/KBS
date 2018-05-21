
//package test;

import com.racersystems.jracer.*;
import instances.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Test2 {

    private static final String RETRIEVE_ALL = "(RETRIEVE (?RAM ?GPU ?CPU ?MotherBoard ?Storage) ";
    private static final String END_OPERATION = ")";
    private static final int[] CPU_AND_MOTHERBOARD_SOCKETS = {1151, 1152};
    private static final int[] RAM_AND_MOTHERBOARD_RAMTYPE = {1, 2, 3, 4};
    private static final int[] STORAGE_AND_MOTHERBOARD_SATATYPE = {2, 3};
    private static final int[] GPU_AND_MOTHERBOARD_PCIEXPRESS = {2, 3};
    private static final int[][] GPU_SOURCEMIN_SOURCEMAX_POWER = {{700, 800, 900}, {800, 900, 1000}};


    private static String andOperation(String string) {
        if (string == null)
            return "(AND ";
        return "(AND " + string + " ";
    }

    private static String orOperation(String string) {
        if (string == null)
            return "(OR ";
        return "(OR " + string + " ";
    }

    public static String stringChecker(CommonParameters commonParameter, String parameterName, int value, boolean canBeGreater) {
        StringBuilder stringBuilder = new StringBuilder();


        if (commonParameter != null && value != 0) {
                stringBuilder.append("(?" + commonParameter.getName() + " ");
                {
                    stringBuilder.append(andOperation(null));

                    stringBuilder.append(commonParameter.getName() + " ");
                    if (canBeGreater)
                        stringBuilder.append("(>= " + parameterName + " " + value + ".0)");
                    else
                        stringBuilder.append("(= " + parameterName + " " + value + ".0)");

                    stringBuilder.append(END_OPERATION);
                }
                stringBuilder.append(END_OPERATION);
            } else {
                stringBuilder.append("(?" + commonParameter.getName() + " ");

                stringBuilder.append(commonParameter.getName() + " ");

                stringBuilder.append(END_OPERATION);
            }

        return stringBuilder.toString();
    }

    private static String generate_same_value_rule(String firstName,String secondName, String parameter, int value){
        return "(and (?"+firstName+"  (and "+firstName+" (= "+parameter+" " + value + ".0) ))(?"+secondName+" (and "+secondName+" (= "+parameter+" " + value + ".0))))";
    }

    private static String generate_interval_value_rule(String firstName,String secondName, String parameter, int value,int minim, int maxim) {
        return "(and (?"+firstName+"  (and "+firstName+" (<= "+parameter+" "+value+".0)))(?"+secondName+" (and "+secondName+"(>= "+parameter+" "+minim+".0)(<= "+parameter+" "+maxim+".0))))";}

    public static String generate_dependencies() {
        StringBuilder stringBuilder = new StringBuilder();


        //1151.0, 1152.0 versions
        stringBuilder.append(orOperation(null));
        for (int socketVersion : CPU_AND_MOTHERBOARD_SOCKETS) {
            stringBuilder.append(generate_same_value_rule("CPU","MotherBoard","hasSocket",socketVersion));
        }
        stringBuilder.append(END_OPERATION);


        //RAMTYPE 1, 2, 3 ,4
        stringBuilder.append(orOperation(null));
        for (int ramType : RAM_AND_MOTHERBOARD_RAMTYPE) {
            stringBuilder.append(generate_same_value_rule("RAM","MotherBoard","hasRamType",ramType));
        }
        stringBuilder.append(END_OPERATION);

        //SATAType 2 3
        stringBuilder.append(orOperation(null));
        for (int sataType : STORAGE_AND_MOTHERBOARD_SATATYPE) {
            stringBuilder.append(generate_same_value_rule("Storage","MotherBoard","hasSATAType",sataType));
        }
        stringBuilder.append(END_OPERATION);

        //pciExpress 2 3
        stringBuilder.append(orOperation(null));
        for (int pciVersion : GPU_AND_MOTHERBOARD_PCIEXPRESS) {
            stringBuilder.append(generate_same_value_rule("GPU","MotherBoard","hasPCIExpress",pciVersion));

        }
        stringBuilder.append(END_OPERATION);

        stringBuilder.append(orOperation(null));
        for (int[] powerArray : GPU_SOURCEMIN_SOURCEMAX_POWER) {
            stringBuilder.append(generate_interval_value_rule("GPU","MotherBoard","hasPowerSource",powerArray[0],powerArray[1],powerArray[2]));

        }
        stringBuilder.append(END_OPERATION);

        return stringBuilder.toString();
    }


    public static String generate_retrieve(CPU cpu, GPU gpu, Storage storage, MotherBoard motherBoard, RAM ram) {
        //for NPE
        cpu = cpu != null ? cpu : new CPU("");
        gpu = gpu != null ? gpu : new GPU("");
        storage = storage != null ? storage : new Storage("");
        ram = ram != null ? ram : new RAM("");
        motherBoard = motherBoard != null ? motherBoard : new MotherBoard("");

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append(RETRIEVE_ALL);

        stringBuilder.append(andOperation(null));


        //ram
        stringBuilder.append(stringChecker(ram, "HASMEMORY", ram.getHasMemory(), true));
        stringBuilder.append(stringChecker(ram, "HASRAMTYPE", ram.getHasRamType(), false));

        //gpu
        stringBuilder.append(stringChecker(gpu, "hasMemory", gpu.getHasMemory(), true));
        stringBuilder.append(stringChecker(gpu, "hasPCIExpress", gpu.getHasPCIExpress(), false));
        stringBuilder.append(stringChecker(gpu, "hasPowerSource", gpu.getHasPowerSource(), true));

        //cpu
        stringBuilder.append(stringChecker(cpu, "hasCores", cpu.getHasCores(), true));
        stringBuilder.append(stringChecker(cpu, "hasSocket", cpu.getHasSocket(), false));
        stringBuilder.append(stringChecker(cpu, "HasFrequency", cpu.getHasFrequency(), true));

        //storage
        stringBuilder.append(stringChecker(storage, "hasSATAType", storage.getHasSATAType(), false));

        //motherboard
        stringBuilder.append(stringChecker(motherBoard, "HasPCIExpress", motherBoard.getHasPCIExpress(), false));
        stringBuilder.append(stringChecker(motherBoard, "HasPowerSource", motherBoard.getHasPowerSource(), true));
        stringBuilder.append(stringChecker(motherBoard, "HasRamType", motherBoard.getHasRamType(), false));
        stringBuilder.append(stringChecker(motherBoard, "HasSATAType", motherBoard.getHasSATAType(), false));
        stringBuilder.append(stringChecker(motherBoard, "HasSocket", motherBoard.getHasSocket(), false));

        //dependencies
        stringBuilder.append(generate_dependencies());

        stringBuilder.append(END_OPERATION);

        //retrieve all
        stringBuilder.append(END_OPERATION);

        return stringBuilder.toString();
    }


    public static void getAllCombinations(Map<String, Integer> prices, String racer_received) {
        int i = 0;
        int j = 0;

        List<Group> groups = new ArrayList<Group>();

        Group group = new Group();


        String[] parts = racer_received.split("[\\(\\)]");    // parse the received text correctly
        for (String part : parts) {


            if (part.length() > 1) // avoid empty spaces
            {
                String g[] = part.split(" ");    // split by whitespace

                // Print the values which are read from the text file

                if (i % 2 == 0) {
                    group.setGpu(new GPU(g[1]));
                    group.setGpuPrice(prices.get(g[1].toLowerCase()));
                } else {
                    group.setRam(new RAM(g[1]));
                    group.setRamPrice(prices.get(g[1].toLowerCase()));

                    groups.add(group);
                    group = new Group();
                }

                //System.out.println(g[1] + " with value: "+ prices.get(g[1].toLowerCase()));
                i = i + 1;
            }
        }

        // Prices for all combinations

        for (i = 0; i < groups.size(); i++) {

            System.out.println("-----------");
            System.out.println("Combination " + (i + 1));
            System.out.println(groups.get(i).getGpu() + " = " + groups.get(i).getGpuPrice() + "$");
            System.out.println(groups.get(i).getRam() + " = " + groups.get(i).getRamPrice() + "$");
            System.out.println("Total price= " + (groups.get(i).getGpuPrice() + groups.get(i).getRamPrice()) + "$");
            System.out.println("-----------");
        }


    }

    // Read the prices located in the price_list.txt
    // Parse the file and put it in a HashMap with (Key = Name of the component, Value  = PriceOfTheCompoenent)
    public static Map<String, Integer> readPricesFromFile(Map<String, Integer> prices, String filename) throws NumberFormatException, IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = br.readLine()) != null) {

                String[] ss = line.split(" ");

                String key = ss[0];
                String value = ss[1];

                System.out.println("Read: " + key + " " + value);

                prices.put(key, Integer.valueOf(value));
            }
        }
        return prices;
    }

    // CQ2 - Recommend desktop configurations based on minimum requirements
    public static String cq2(int ramMemory, int gpuMemory) {
        return "(retrieve (?RAM ?GPU) 	( and 	(?RAM 	(and RAM(> hasMemory " + ramMemory + ".0)))(?GPU 	(and GPU(>= hasMemory " + gpuMemory + ".0)))))\r\n";
    }

    // ram - hasMemory,ramType ; cpu - hasCores, hasFrequency
    //  gpu - hasPCIExpress,hasPowerSource
    // storage  - hasPowerSource


    public static void printresult(RacerClient racer, String s) throws RacerClientException {
        System.out.println(s);
        System.out.println(racer.sendRaw(s));
    }

    public static void test(RacerClient racer) throws RacerClientException {

        //random test
        RAM ram = new RAM("rami");
        GPU gpu = new GPU("gpui");
        CPU cpu = new CPU("test");
        Storage storage = new Storage("test");
        MotherBoard motherBoard = new MotherBoard("test1");

        printresult(racer, generate_retrieve(cpu, gpu, storage, motherBoard, null));

        System.out.println();

        ram.setHasMemory(15);

        printresult(racer, generate_retrieve(cpu, gpu, storage, motherBoard, ram));

        ram.setHasRamType(3);

        printresult(racer, generate_retrieve(cpu, gpu, storage, motherBoard, ram));


    }


    public static void main(String[] argv) {
        String ip = "127.0.0.1";
        int port = 8088;
        String filename = "\"test.racer\"";

        RacerClient racer = new RacerClient(ip, port);
        try {
            racer.openConnection();

            System.out.println(racer.sendRaw("(racer-read-file " + filename + ")"));
            System.out.println("-------------");

            // CQ2 - Recommend desktop configurations based on minimum requirements
            // (e.g. price, benchmark score)

            System.out.println("Get all configurations with ram/gpu...");
            String racer_received = racer.sendRaw(cq2(15, 7));

            System.out.println("Got: " + racer_received);

            // Prices MAP
            Map<String, Integer> prices = new HashMap<String, Integer>();

            // read the prices from the file
            prices = readPricesFromFile(prices, "src/price_list.txt");

            getAllCombinations(prices, racer_received);


            test(racer);


            CPU cpu = new CPU("Te");
            System.out.println(cpu.getName());

            // close connection
            racer.closeConnection();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}