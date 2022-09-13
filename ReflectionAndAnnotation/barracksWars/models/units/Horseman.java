package ReflectionAndAnnotation.barracksWars.models.units;

public class Horseman extends AbstractUnit{
    private static final int SWORDSMAN_HEALTH = 50;
    private static final int SWORDSMAN_DAMAGE = 10;

    protected Horseman() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
