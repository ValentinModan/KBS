package instances;

public class CPU {

    private String cpuName;
    private int hasMemory;
    private int hasCores;
    private float hasFrequency;
    private int hasSocket;

    public CPU(String cpuName, int hasMemory, int hasCores, float hasFrequency, int hasSocket) {
        this.cpuName = cpuName;
        this.hasMemory = hasMemory;
        this.hasCores = hasCores;
        this.hasFrequency = hasFrequency;
        this.hasSocket = hasSocket;
    }

    public String getCpuName() {
        return cpuName;
    }

    public void setCpuName(String cpuName) {
        this.cpuName = cpuName;
    }

    public int getHasMemory() {
        return hasMemory;
    }

    public void setHasMemory(int hasMemory) {
        this.hasMemory = hasMemory;
    }

    public int getHasCores() {
        return hasCores;
    }

    public void setHasCores(int hasCores) {
        this.hasCores = hasCores;
    }

    public float getHasFrequency() {
        return hasFrequency;
    }

    public void setHasFrequency(float hasFrequency) {
        this.hasFrequency = hasFrequency;
    }

    public int getHasSocket() {
        return hasSocket;
    }

    public void setHasSocket(int hasSocket) {
        this.hasSocket = hasSocket;
    }
}
