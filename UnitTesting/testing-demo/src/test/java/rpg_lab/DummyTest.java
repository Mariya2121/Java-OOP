package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DummyTest {
    private static final int aliveHealth = 100;
    private static final int deadHealth = 0;
    private static final int EXPERIENCE = 200;
    private static final int ATTACK_POINTS = 50;
    private Dummy aliveDummy;
    private Dummy deadDummy;


    @Before
    public void setUp() {
        aliveDummy = new Dummy(aliveHealth, EXPERIENCE);
        deadDummy = new Dummy(deadHealth, EXPERIENCE);

    }

    @Test
    public void test_Dummy_LossesHealth_WhenAttacked() {
        this.aliveDummy.takeAttack(ATTACK_POINTS);
        Assert.assertEquals(aliveHealth - ATTACK_POINTS, aliveDummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void test_DeadDummy_Exception_WhenAttacked() {

        //  dummy.isDead();
        Assert.assertEquals(deadHealth, deadDummy.getHealth());
        deadDummy.takeAttack(ATTACK_POINTS);
    }

    @Test(expected = IllegalStateException.class)
    public void test_Alive_Dummy_CannotGiveXP(){
        aliveDummy.giveExperience();
    }

    @Test
    public void test_Dead_Dummy_CanGiveXP(){
        int actual = deadDummy.giveExperience();
        Assert.assertEquals(EXPERIENCE, actual);
    }
    @Test
    public void testAliveDummy_IsAlive(){
        Assert.assertFalse(aliveDummy.isDead());
    }
    @Test
    public void testDeadDummy_IsDead(){
        Assert.assertTrue(deadDummy.isDead());
    }
}
