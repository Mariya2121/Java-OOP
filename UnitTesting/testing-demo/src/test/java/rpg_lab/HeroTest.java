package rpg_lab;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

public class HeroTest {

    //example of stubbed implementation of Weapon
    private static class FakeWeapon implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    @Test
    public void test_HeroGainsXP_WhenKillingTarget() {
        Hero hero = new Hero("Joro", new FakeWeapon());
        Assert.assertEquals(0, hero.getExperience());

        // Example of anonymous class instance of Target just to fake giveExperience() and isDead()
        Target target = new Target() { // анонима инстанция от интерфейс
            @Override
            public int getHealth() {
                return 0;
            }

            @Override
            public void takeAttack(int attackPoints) {

            }

            @Override
            public int giveExperience() {
                return 200;
            }

            @Override
            public boolean isDead() {
                return true;
            }
        };

        hero.attack(target);
        Assert.assertEquals(200, hero.getExperience());
    }


    // Mockito option for testing
    @Test
    public void test_HeroGainsXP_WhenKillingTarget_MockingExample() {

        Weapon weapon = Mockito.mock(Weapon.class);

        Hero hero = new Hero("Joro", weapon);
        Assert.assertEquals(0, hero.getExperience());

        Target target = Mockito.mock(Target.class);

        Mockito.when(target.isDead()).thenReturn(true);

        Mockito.when(target.giveExperience()).thenReturn(200);

        hero.attack(target);
        Assert.assertEquals(200, hero.getExperience());
    }
}
