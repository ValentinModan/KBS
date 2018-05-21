package instances;

public class MotherBoard extends CommonParameters{
    private String motherBoardName;

    //GPU
    private int hasPCIExpress;
    private int hasPowerSource;

    //CPU
    private int hasSocket;

    //RAM
    private int hasRamType;

    //Storage
    private int hasSATAType;

    public MotherBoard(String motherBoardName) {
        this.motherBoardName = motherBoardName;
    }

    public MotherBoard(String motherBoardName, int hasPCIExpress, int hasPowerSource, int hasSocket, int hasRamType, int hasSATAType) {
        this.motherBoardName = motherBoardName;
        this.hasPCIExpress = hasPCIExpress;
        this.hasPowerSource = hasPowerSource;
        this.hasSocket = hasSocket;
        this.hasRamType = hasRamType;
        this.hasSATAType = hasSATAType;
    }

    public String getMotherBoardName() {
        return motherBoardName;
    }

    public void setMotherBoardName(String motherBoardName) {
        this.motherBoardName = motherBoardName;
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

    public int getHasSocket() {
        return hasSocket;
    }

    public void setHasSocket(int hasSocket) {
        this.hasSocket = hasSocket;
    }

    public int getHasRamType() {
        return hasRamType;
    }

    public void setHasRamType(int hasRamType) {
        this.hasRamType = hasRamType;
    }

    public int getHasSATAType() {
        return hasSATAType;
    }

    public void setHasSATAType(int hasSATAType) {
        this.hasSATAType = hasSATAType;
    }
}
