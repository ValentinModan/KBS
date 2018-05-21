package instances;

public class CPU extends CommonParameters{

    private String cpuName;
    private int hasCores;
    private int hasFrequency;
    private int hasSocket;

    public CPU(String cpuName) {
        this.cpuName = cpuName;

    }

    public CPU(String cpuName, int hasCores, int hasFrequency, int hasSocket) {
        this.cpuName = cpuName;
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


    public int getHasCores() {
        return hasCores;
    }

    public void setHasCores(int hasCores) {
        this.hasCores = hasCores;
    }

    public int getHasFrequency() {
        return hasFrequency;
    }

    public void setHasFrequency(int hasFrequency) {
        this.hasFrequency = hasFrequency;
    }

    public int getHasSocket() {
        return hasSocket;
    }

    public void setHasSocket(int hasSocket) {
        this.hasSocket = hasSocket;
    }
}
