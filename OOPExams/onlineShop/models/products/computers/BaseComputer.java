package OOPExams.onlineShop.models.products.computers;

import onlineShop.common.constants.ExceptionMessages;
import onlineShop.models.products.BaseProduct;
import onlineShop.models.products.components.CentralProcessingUnit;
import onlineShop.models.products.components.Component;
import onlineShop.models.products.peripherals.Peripheral;

import java.util.ArrayList;
import java.util.List;

public class BaseComputer extends BaseProduct implements Computer {
    private List<Component> components;
    private List<Peripheral> peripherals;

    protected BaseComputer(int id, String manufacturer, String model, double price, double overallPerformance) {
        super(id, manufacturer, model, price, overallPerformance);
        components = new ArrayList<>();
        peripherals = new ArrayList<>();
    }

    @Override
    public List<Component> getComponents() {
        return null;
    }

    @Override
    public List<Peripheral> getPeripherals() {
        return null;
    }

    @Override
    public void addComponent(Component component) {

        if (components.contains(component)) {
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT,
                    component.getClass().getSimpleName(), getClass().getSimpleName(), component.getId()));
        }
        components.add(component);
    }

    @Override
    public Component removeComponent(String componentType) {

        if (componentType.equals("CentralProcessingUnit") || componentType.equals("Motherboard") || componentType.equals("PowerSupply")
                || componentType.equals("RandomAccessMemory") || componentType.equals("SolidStateDrive") || componentType.equals("VideoCard")){

            components.remove(componentType);
        }

        return null;
    }

    @Override
    public void addPeripheral(Peripheral peripheral) {

        if (peripherals.contains(peripheral)){
            throw new IllegalArgumentException(String.format(ExceptionMessages.EXISTING_COMPONENT, peripheral.getClass().getSimpleName(),
                    peripheral.getModel(), peripheral.getId()));
        }
        peripherals.add(peripheral);
    }

    @Override
    public Peripheral removePeripheral(String peripheralType) {
        return null;
    }

}
