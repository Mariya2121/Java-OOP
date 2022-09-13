package ReflectionAndAnnotation.barracksWars.models.units;

public class Gunner extends AbstractUnit{
    private static final int SWORDSMAN_HEALTH = 20;
    private static final int SWORDSMAN_DAMAGE = 20;

    protected Gunner() {
        super(SWORDSMAN_HEALTH, SWORDSMAN_DAMAGE);
    }
}
