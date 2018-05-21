
//package test;

import com.racersystems.jracer.*;
import entities.CPU;
import instances.GPU;
import instances.RAM;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test2 {
	
	
	public static void getAllCombinations(Map<String, Integer> prices, String racer_received)
	{
		int i = 0;
		int j = 0;
 
		List<Group> groups = new ArrayList<Group>();
		
		Group group = new Group();
		
		
		String[] parts = racer_received.split("[\\(\\)]");	// parse the received text correctly
		for (String part : parts) 
		{
			
			
			if (part.length() > 1) // avoid empty spaces
			{
				String g[] = part.split(" ");	// split by whitespace
		
				// Print the values which are read from the text file 
				
				if(i%2==0)
				{
					group.setGpu(new GPU(g[1]));
					group.setGpuPrice(prices.get(g[1].toLowerCase()));
				}
				else
				{
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
		
		for(i = 0 ; i<groups.size(); i ++)
		{
		
			System.out.println("-----------");
			System.out.println("Combination " + (i+1) );
			System.out.println(groups.get(i).getGpu() +" = " + groups.get(i).getGpuPrice() + "$" );
			System.out.println(groups.get(i).getRam() +" = " + groups.get(i).getRamPrice() + "$");
			System.out.println("Total price= "+ (groups.get(i).getGpuPrice()+groups.get(i).getRamPrice()) + "$"  );
			System.out.println("-----------");
		}
		
		
		
	}
	
	// Read the prices located in the price_list.txt
	// Parse the file and put it in a HashMap with (Key = Name of the component, Value  = PriceOfTheCompoenent) 
	public static Map<String, Integer> readPricesFromFile(Map<String, Integer> prices,String filename) throws NumberFormatException, IOException
	{
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
	public static String cq2( int ramMemory, int gpuMemory) {
		return "(retrieve (?RAM ?GPU) 	( and 	(?RAM 	(and RAM(> hasMemory "+  ramMemory +".0)))(?GPU 	(and GPU(>= hasMemory "+gpuMemory+".0)))))\r\n";
	}
	
	// ram - hasMemory,ramType ; cpu - hasCores, hasFrequency 
	//  gpu - hasPCIExpress,hasPowerSource
	// storage  - hasPowerSource
	
	
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
			String racer_received = racer.sendRaw(cq2(15,7));
				
			System.out.println("Got: " + racer_received);
			
			// Prices MAP
			Map<String, Integer> prices = new HashMap<String, Integer>();
						
			// read the prices from the file
			prices = readPricesFromFile(prices, "src/price_list.txt");

			getAllCombinations(prices,racer_received);
		  

			// close connection
			racer.closeConnection();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}