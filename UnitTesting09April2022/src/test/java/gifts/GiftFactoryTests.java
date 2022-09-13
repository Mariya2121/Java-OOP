package UnitTesting09April2022.src.test.java.gifts;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class GiftFactoryTests {
    private static final String GIFT1_TYPE = "Barbie";
    private static final Double GIFT1_MAGIC = 20.5;
    private static final String GIFT2_TYPE = "Princess";
    private static final Double GIFT2_MAGIC = 15.9;
    private static final String GIFT3_TYPE = "Princess-2";
    private static final Double GIFT3_MAGIC = 11.9;


    private Gift gift1;
    private Gift gift2;
    private Gift gift3;
    private GiftFactory giftFactory;

    @Before
    public void setUp() {
        gift1 = new Gift(GIFT1_TYPE, GIFT1_MAGIC);
        gift2 = new Gift(GIFT2_TYPE, GIFT2_MAGIC);
        gift3 = new Gift(GIFT3_TYPE, GIFT3_MAGIC);

        giftFactory = new GiftFactory();

        giftFactory.createGift(gift1);
        giftFactory.createGift(gift2);
    }

    @Test
    public void test_Data_Count() {
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Add_ExistingGift_toGiftFactory() {
        giftFactory.createGift(gift1);
    }

    @Test
    public void test_CreateGift() {
        giftFactory.createGift(gift3);
        Assert.assertEquals(GIFT3_TYPE, gift3.getType());
    }

    @Test(expected = NullPointerException.class)
    public void test_RemoveGift_With_NullName() {
        giftFactory.removeGift(null);
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test
    public void test_Can_Remove_Gift() {
        giftFactory.removeGift(GIFT2_TYPE);
        Assert.assertEquals(1, giftFactory.getCount());
    }

    @Test
    public void test_Cannot_Remove_Gift_WithIncorrectName() {
        giftFactory.removeGift("Doll");
        Assert.assertEquals(2, giftFactory.getCount());
    }

    @Test
    public void test_Present_With_LeastMagic() {
        Assert.assertEquals(gift2, giftFactory.getPresentWithLeastMagic());
    }

    @Test
    public void test_Get_Present() {
        Assert.assertEquals(gift1, giftFactory.getPresent(GIFT1_TYPE));
    }

}

