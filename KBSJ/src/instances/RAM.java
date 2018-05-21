package instances;

public class RAM {

	private String ramName;

	private int hasRamType;

	private int hasMemory;

	public String isRam(){
	    return  "RAM ";
    }

    public String minimumMemory() {
        return "(>= HASMEMORY "+ hasMemory +".0)";
}

    public String hasType() {
	   return "(= HASRAMTYPE "+ hasRamType + ".0)";
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
