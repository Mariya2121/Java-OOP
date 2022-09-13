package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int ATTACK = 13;
    private static final int DURABILITY = 42;
    private static final int HEALTH = 100;
    private static final int EXPERIENCE = 200;
    private Axe axe;
    private Dummy dummy;

    @Before
    public void setUp(){ // ще се изпълнява преди всеки един Тест метод
        this.axe = new Axe(ATTACK, DURABILITY);
        this.dummy = new Dummy(HEALTH, EXPERIENCE);
    }

    @Test
    public void test_AxeCreation_WillReturn_SameValues_AsCreated() {
        Assert.assertEquals(ATTACK, axe.getAttackPoints());
        Assert.assertEquals(DURABILITY, axe.getDurabilityPoints());
    }

    @Test
    public void test_AxeLossesDurability_AfterAttack() {

        axe.attack(dummy);

        Assert.assertEquals(DURABILITY - 1, axe.getDurabilityPoints());

    }

    @Test(expected = IllegalStateException.class) // грешка, която очакваме да се хвърли
    public void test_AxeAttack_WhenBroken_Fails() {
        int durability = 0;
        Axe axe = new Axe(ATTACK, durability);

        //Assert the axe is broken
        Assert.assertEquals(durability, axe.getDurabilityPoints());

        axe.attack(dummy);
    }
}
