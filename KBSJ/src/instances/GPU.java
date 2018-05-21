package instances;

public class GPU extends CommonParameters{
	private String gpuName;

	private int hasMemory;
	private int hasPCIExpress;
	private int hasPowerSource;

	public GPU(String gpuName, int hasMemory, int hasPCIExpress, int hasPowerSource) {
		this.gpuName = gpuName;
		this.hasMemory = hasMemory;
		this.hasPCIExpress = hasPCIExpress;
		this.hasPowerSource = hasPowerSource;
	}

    public String isGPU(){
        return  "GPU ";
    }

    public String hasPowerSource() {
        return "(= hasPowerSource "+ hasPowerSource + ".0)";
    }

    public String minimumMemory() {
        return "(>= HASMEMORY "+ hasMemory +".0)";
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
