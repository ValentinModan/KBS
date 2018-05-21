import instances.RAM;
import instances.GPU;

public class Group {
	
	private GPU gpu;
	private int gpuPrice;
	private RAM ram;
	private int ramPrice;
	
	public Group()
	{
		
	}

	public GPU getGpu() {
		return gpu;
	}

	public void setGpu(GPU gpu) {
		this.gpu = gpu;
	}

	public int getGpuPrice() {
		return gpuPrice;
	}

	public void setGpuPrice(int gpuPrice) {
		this.gpuPrice = gpuPrice;
	}

	public RAM getRam() {
		return ram;
	}

	public void setRam(RAM ram) {
		this.ram = ram;
	}

	public int getRamPrice() {
		return ramPrice;
	}

	public void setRamPrice(int ramPrice) {
		this.ramPrice = ramPrice;
	}

	@Override
	public String toString() {
		return "Group [gpu=" + gpu + ", gpuPrice=" + gpuPrice + ", ram=" + ram + ", ramPrice=" + ramPrice + "]";
	}

	public Group(GPU gpu, int gpuPrice, RAM ram, int ramPrice) {
		super();
		this.gpu = gpu;
		this.gpuPrice = gpuPrice;
		this.ram = ram;
		this.ramPrice = ramPrice;
	}
	
 
	
	 
	
	
	

}
