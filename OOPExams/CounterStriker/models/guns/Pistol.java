package OOPExams.CounterStriker.models.guns;

public class Pistol extends GunImpl{
    public Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
        setBulletsPerShoot(1);
    }
}
