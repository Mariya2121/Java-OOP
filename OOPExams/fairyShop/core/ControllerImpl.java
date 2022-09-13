package OOPExams.fairyShop.core;

import fairyShop.common.ConstantMessages;
import fairyShop.common.ExceptionMessages;
import fairyShop.models.*;
import fairyShop.repositories.HelperRepository;
import fairyShop.repositories.PresentRepository;

import java.util.Collection;
import java.util.stream.Collectors;

public class ControllerImpl implements Controller {
    private HelperRepository helperRepository;
    private PresentRepository presentRepository;

    public ControllerImpl() {
        this.presentRepository = new PresentRepository();
        this.helperRepository = new HelperRepository();
    }

    @Override
    public String addHelper(String type, String helperName) {
        BaseHelper helper = null;
        switch (type) {
            case "Sleepy":
                helper = new Sleepy(helperName);
                break;
            case "Happy":
                helper = new Happy(helperName);
                break;
            default:
                throw new IllegalArgumentException(ExceptionMessages.HELPER_TYPE_DOESNT_EXIST);
        }
        helperRepository.add(helper);
        return String.format(ConstantMessages.ADDED_HELPER, type, helperName);
    }

    @Override
    public String addInstrumentToHelper(String helperName, int power) {

        Helper helper = helperRepository.findByName(helperName);
        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.HELPER_DOESNT_EXIST);
        }

        InstrumentImpl instrument = new InstrumentImpl(power);
        helper.addInstrument(instrument);

        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_INSTRUMENT_TO_HELPER, power, helperName);

    }

    @Override
    public String addPresent(String presentName, int energyRequired) {
        Present present = new PresentImpl(presentName, energyRequired);
        presentRepository.add(present);
        return String.format(ConstantMessages.SUCCESSFULLY_ADDED_PRESENT, presentName);
    }

    @Override
    public String craftPresent(String presentName) {
        Collection<BaseHelper> helpers = helperRepository.getModels();

        BaseHelper helper = helpers.stream().filter(h -> h.getEnergy() > 50).findFirst().orElse(null);

        if (helper == null) {
            throw new IllegalArgumentException(ExceptionMessages.NO_HELPER_READY);
        }

        Present presentToBeCrafted = presentRepository.findByName(presentName);

        ShopImpl shop = new ShopImpl();
        shop.craft(presentToBeCrafted, helper);

        String doneOrNot = String.format(presentToBeCrafted.isDone() ? "done" : "not done");

        return String.format(ConstantMessages.PRESENT_DONE, presentName, doneOrNot)
                + String.format(ConstantMessages.COUNT_BROKEN_INSTRUMENTS, helper.getBrokenInstrument());
    }

    @Override
    public String report() {
        return presentRepository.getModels().stream().filter(Present::isDone).count() + " presents are done!" + System.lineSeparator() +
                "Helpers info:" + System.lineSeparator() +
                helperRepository.toString();
    }
}
