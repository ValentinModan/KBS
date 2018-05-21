package instances;

public class GPU {
	
	private String gpuName;

	
	
	public GPU(String gpuName) {
		super();
		this.gpuName = gpuName;

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
