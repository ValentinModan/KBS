package instances;

import java.util.ArrayList;
import java.util.List;

public class GPU extends CommonParameters {
	private String gpuName;

	private int hasMemory;
	private int hasPCIExpress;
	private int hasPowerSource;

	public String createInstance() {

		return "(instance " + this.gpuName + " GPU)";
	}

	public List<String> createAttributes() {
		List<String> instance = new ArrayList<String>();

		instance.add("(attribute-filler " + this.gpuName + " " + this.hasMemory + ".0 hasMemory)");
		instance.add("(attribute-filler " + this.gpuName + " " + this.hasPCIExpress + ".0 hasPCIExpress)");
		instance.add("(attribute-filler " + this.gpuName + " " + this.hasPowerSource + ".0 hasPowerSource)");
		instance.add("(attribute-filler " + this.gpuName + " " + this.brandName.hashCode() + ".0 HASBRAND)");

		return instance;
	}

	public GPU(String gpuName, int hasMemory, int hasPCIExpress, int hasPowerSource) {
		this.gpuName = gpuName;
		this.hasMemory = hasMemory;
		this.hasPCIExpress = hasPCIExpress;
		this.hasPowerSource = hasPowerSource;
	}

	public String isGPU() {
		return "GPU ";
	}

	public String hasPowerSource() {
		return "(= hasPowerSource " + hasPowerSource + ".0)";
	}

	public String minimumMemory() {
		return "(>= HASMEMORY " + hasMemory + ".0)";
	}

	public GPU(String gpuName) {
		super();
		this.gpuName = gpuName;
	}

	public int getHasMemory() {
		return hasMemory;
	}

	public void setHasMemory(int hasMemory) {
		this.hasMemory = hasMemory;
	}

	public int getHasPCIExpress() {
		return hasPCIExpress;
	}

	public void setHasPCIExpress(int hasPCIExpress) {
		this.hasPCIExpress = hasPCIExpress;
	}

	public int getHasPowerSource() {
		return hasPowerSource;
	}

	public void setHasPowerSource(int hasPowerSource) {
		this.hasPowerSource = hasPowerSource;
	}

	public String getGpuName() {
		return gpuName;
	}

	public void setGpuName(String gpuName) {
		this.gpuName = gpuName;
	}

	@Override
	public String toString() {
		return "GPU [gpuName=" + gpuName + "]";
	}

}
