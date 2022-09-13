package InterfacesAndAbstraction.BorderControl;

public abstract class IdentifiableImpl implements Identifiable{ // Базов клас, който пази общото състояние и методи и никой не може да го
    //създава, зашото е абстрактен

    private String id;

    protected IdentifiableImpl(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }
}
