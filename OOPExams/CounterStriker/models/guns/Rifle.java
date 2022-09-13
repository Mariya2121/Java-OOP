package OOPExams.CounterStriker.models.guns;

public class Rifle extends GunImpl{
    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(10);
    }
}
