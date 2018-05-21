package instances;

public class RAM {

	private String ramName;
	
	
 
	@Override
	public String toString() {
		return "RAM [ramName=" + ramName + "]";
	}

	public RAM(String ramName) {
		super();
		this.ramName = ramName;
	}

	public String getRamName() {
		return ramName;
	}

	public void setRamName(String ramName) {
		this.ramName = ramName;
	}

	
}
