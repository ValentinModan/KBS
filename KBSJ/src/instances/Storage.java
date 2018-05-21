package instances;

public class Storage extends CommonParameters{
    private String hddName;
    private int hasSATAType;
    private int hasMemory;

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
}
