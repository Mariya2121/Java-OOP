package OOPExams.CounterStriker.repositories;

import CounterStriker.common.ExceptionMessages;
import CounterStriker.models.guns.Gun;

import java.util.ArrayList;
import java.util.Collection;

public class GunRepository implements Repository<Gun> {
    private Collection<Gun> models;

    public GunRepository() {
        models = new ArrayList<>();
    }

    @Override
    public Collection<Gun> getModels() {
        return this.models;
    }

    @Override
    public void add(Gun model) {
        if (model == null) {
            throw new NullPointerException(ExceptionMessages.INVALID_GUN_REPOSITORY);
        }
        models.add(model);
    }

    @Override
    public boolean remove(Gun model) {
        return models.remove(model);
    }

    @Override
    public Gun findByName(String name) {
        return models.stream().filter(m -> m.getName().equals(name)).findFirst().orElse(null);
    }
}
