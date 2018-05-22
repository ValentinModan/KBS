package instances;

import java.util.ArrayList;
import java.util.List;

public  class CommonParameters {

    protected String name = this.getClass().getSimpleName();

    protected String brandName = "f5a5a608";

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public CommonParameters(String brandName) {
        this.brandName = brandName;
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
