package instances;

import java.util.ArrayList;
import java.util.List;

public class Storage extends CommonParameters {
	private String hddName;
	private int hasSATAType;
	private int hasMemory;

	public String createInstance() {
		return "(instance " + this.hddName + " Storage)";
	}

	public List<String> createAttributes() {
		List<String> instance = new ArrayList<String>();

		instance.add("(attribute-filler " + this.hddName + " " + this.hasSATAType + ".0 hasSATAType)");
		instance.add("(attribute-filler " + this.hddName + " " + this.hasMemory + ".0 hasMemory)");

		return instance;
	}

	public Storage(String hddName) {
		this.hddName = hddName;
	}

	public Storage(String hddName, int hasSATAType, int hasMemory) {
		this.hddName = hddName;
		this.hasSATAType = hasSATAType;
		this.hasMemory = hasMemory;
	}

	public String getHddName() {
		return hddName;
	}

	public void setHddName(String hddName) {
		this.hddName = hddName;
	}

	public int getHasSATAType() {
		return hasSATAType;
	}

	public void setHasSATAType(int hasSATAType) {
		this.hasSATAType = hasSATAType;
	}

	public int getHasMemory() {
		return hasMemory;
	}

	public void setHasMemory(int hasMemory) {
		this.hasMemory = hasMemory;
	}

	@Override
	public String toString() {
		return "Storage [hddName=" + hddName + "]";
	}
}
