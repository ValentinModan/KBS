package instances;

import java.util.ArrayList;
import java.util.List;

public class CPU extends CommonParameters {

	private String cpuName;
	private int hasCores;
	private int hasFrequency;
	private int hasSocket;

	public CPU(String cpuName) {
		this.cpuName = cpuName;

	}

	public String createInstance() {
		return "(instance " + this.cpuName + " CPU)";
	}

	public List<String> createAttributes() {
		List<String> instance = new ArrayList<String>();

		instance.add("(attribute-filler " + this.cpuName + " " + this.hasCores + ".0 hasCores)");
		instance.add("(attribute-filler " + this.cpuName + " " + this.hasFrequency + ".0 hasFrequency)");
		instance.add("(attribute-filler " + this.cpuName + " " + this.hasSocket + ".0 hasSocket)");

		return instance;
	}

	public CPU(String cpuName, int hasCores, int hasFrequency, int hasSocket) {
		this.cpuName = cpuName;
		this.hasCores = hasCores;
		this.hasFrequency = hasFrequency;
		this.hasSocket = hasSocket;
	}

	public String getCpuName() {
		return cpuName;
	}

	public void setCpuName(String cpuName) {
		this.cpuName = cpuName;
	}

	public int getHasCores() {
		return hasCores;
	}

	public void setHasCores(int hasCores) {
		this.hasCores = hasCores;
	}

	public int getHasFrequency() {
		return hasFrequency;
	}

	public void setHasFrequency(int hasFrequency) {
		this.hasFrequency = hasFrequency;
	}

	public int getHasSocket() {
		return hasSocket;
	}

	public void setHasSocket(int hasSocket) {
		this.hasSocket = hasSocket;
	}

	@Override
	public String toString() {
		return "CPU [cpuName=" + cpuName + "]";
	}
}
