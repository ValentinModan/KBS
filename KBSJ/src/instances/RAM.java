package instances;

import java.util.ArrayList;
import java.util.List;

public class RAM extends CommonParameters {

	private String ramName;

	private int hasRamType;

	private int hasMemory;

	public String createInstance() {
		return "(instance " + this.ramName + " RAM)";
	}

	public List<String> createAttributes() {
		List<String> instance = new ArrayList<String>();

		instance.add("(attribute-filler " + this.ramName + " " + this.hasRamType + ".0 hasRamType)");
		instance.add("(attribute-filler " + this.ramName + " " + this.hasMemory + ".0 hasMemory)");
		instance.add("(attribute-filler " + this.ramName + " " + this.brandName.hashCode() + ".0 HASBRAND)");


		return instance;
	}

	public String isRam() {
		return "RAM ";
	}

	public String minimumMemory() {
		return "(>= HASMEMORY " + hasMemory + ".0)";
	}

	public String hasType() {
		return "(= HASRAMTYPE " + hasRamType + ".0)";
	}

    public RAM(String brandName, String ramName, int hasRamType, int hasMemory) {
        super(brandName);
        this.ramName = ramName;
        this.hasRamType = hasRamType;
        this.hasMemory = hasMemory;
    }

    public RAM(String ramName) {
		super();
		this.ramName = ramName;
		this.hasMemory = 0;
		this.hasRamType = 0;
	}



	public RAM(String ramName, int hasRamType, int hasMemory) {
		this.ramName = ramName;
		this.hasRamType = hasRamType;
		this.hasMemory = hasMemory;
	}

	public int getHasRamType() {
		return hasRamType;
	}

	public void setHasRamType(int hasRamType) {
		this.hasRamType = hasRamType;
	}

	public int getHasMemory() {
		return hasMemory;
	}

	public void setHasMemory(int hasMemory) {
		this.hasMemory = hasMemory;
	}

	@Override
	public String toString() {
		return "RAM [ramName=" + ramName + "]";
	}

	public String getRamName() {
		return ramName;
	}

	public void setRamName(String ramName) {
		this.ramName = ramName;
	}

}
