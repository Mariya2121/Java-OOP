package InterfacesAndAbstraction.BorderControl;

public class Robot extends  IdentifiableImpl{
    private String model;

    protected Robot(String model, String id) {
        super(id);
        this.model = model;
    }

    public String getModel() {
        return model;
    }
}
