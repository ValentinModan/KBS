import instances.RAM;
import instances.Storage;
import instances.CPU;
import instances.GPU;
import instances.MotherBoard;

public class Group implements Comparable{
	
	private GPU gpu;
	private int gpuPrice;
	private RAM ram;
	private int ramPrice;
	private CPU cpu;
	private int cpuPrice;
	private MotherBoard motherBoard;
	private int motherBoardPrice;
	private Storage storage;
	private int storagePrice;
	
	
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

	public int getStoragePrice() {
		return storagePrice;
	}

	public void setStoragePrice(int storagePrice) {
		this.storagePrice = storagePrice;
	}

	public Storage getStorage() {
		return storage;
	}

	public void setStorage(Storage storage) {
		this.storage = storage;
	}

	public int getMotherBoardPrice() {
		return motherBoardPrice;
	}

	public void setMotherBoardPrice(int motherBoardPrice) {
		this.motherBoardPrice = motherBoardPrice;
	}

	public MotherBoard getMotherBoard() {
		return motherBoard;
	}

	public void setMotherBoard(MotherBoard motherBoard) {
		this.motherBoard = motherBoard;
	}

	public int getCpuPrice() {
		return cpuPrice;
	}

	public void setCpuPrice(int cpuPrice) {
		this.cpuPrice = cpuPrice;
	}

	public CPU getCpu() {
		return cpu;
	}

	public void setCpu(CPU cpu) {
		this.cpu = cpu;
	}

	@Override
	public int compareTo(Object o) {
		Group group = (Group) o;
		
		int sum = group.getCpuPrice()+group.getGpuPrice()+group.getMotherBoardPrice()+group.getRamPrice()+group.getStoragePrice();
		
		int this_sum = this.cpuPrice+this.gpuPrice+this.motherBoardPrice+this.ramPrice+this.storagePrice;
		
		
		return this_sum-sum;
	}
	
 
	
	 
	
	
	

}
