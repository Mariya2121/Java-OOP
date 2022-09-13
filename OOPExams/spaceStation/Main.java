package OOPExams.spaceStation;

import spaceStation.core.Controller;
import spaceStation.core.ControllerImpl;
import spaceStation.core.Engine;
import spaceStation.core.EngineImpl;
import spaceStation.repositories.AstronautRepository;
import spaceStation.repositories.PlanetRepository;

public class Main {
    public static void main(String[] args) {

        PlanetRepository planetRepository = new PlanetRepository();
        AstronautRepository astronautRepository = new AstronautRepository();

        Controller controller = new ControllerImpl();
        Engine engine = new EngineImpl(controller);
        engine.run();

    }
}
