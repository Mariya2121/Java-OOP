package UnitTesting11December2021.src.test.java.cats;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HouseTests {
    private static final String HOUSE_NAME = "Star";
    private final static int HOUSE_CAPACITY = 3;
    private final static int HOUSE_CAT_COUNT = 2;


    private Cat cat1;
    private Cat cat2;
    private Cat cat3;
    private Cat cat4;

    private House house;

    @Before
    public void setUp() {
        cat1 = new Cat("mike");
        cat2 = new Cat("mimi");
        cat3 = new Cat("sharo");
        cat4 = new Cat("pinki");

        house = new House(HOUSE_NAME, HOUSE_CAPACITY);
        house.addCat(cat1);
        house.addCat(cat2);
    }

    @Test(expected = NullPointerException.class)
    public void test_create_house_with_null_name() {
        House house2 = new House(null, 10);
    }

    @Test
    public void test_getHouseName() {
        Assert.assertEquals(HOUSE_NAME, house.getName());
    }

    @Test
    public void test_capacity() {
        Assert.assertEquals(HOUSE_CAPACITY, house.getCapacity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_negative_capacity() {
        House house2 = new House("hello", -1);
    }

    @Test
    public void test_getCount() {
        Assert.assertEquals(HOUSE_CAT_COUNT, house.getCount());
    }

    @Test
    public void test_addCat() {
        house.addCat(cat3);
        Assert.assertEquals(HOUSE_CAT_COUNT + 1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_add_Cat_When_HouseIsFull() {
        house.addCat(cat3);
        house.addCat(cat4);

        Assert.assertEquals(HOUSE_CAT_COUNT, house.getCount());
    }

    @Test
    public void test_removeCat() {
        house.removeCat("mike");
        Assert.assertEquals(HOUSE_CAT_COUNT - 1, house.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_removeNullCat() {
        house.removeCat("cat");
    }

    @Test
    public void test_caTForSale() {
        Assert.assertEquals(cat2, house.catForSale("mimi"));
        Assert.assertFalse(cat2.isHungry());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_CatForSale_When_Doesnt_Exist() {
        Assert.assertEquals(cat2, house.catForSale("cat"));
    }

}
