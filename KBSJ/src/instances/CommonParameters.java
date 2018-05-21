package instances;

public  class CommonParameters {

    protected String name = this.getClass().getSimpleName();

    public CommonParameters(String name) {
        this.name = name;
}

    public CommonParameters() {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
