package TestDrivenDevelepment.test.java;

import TestDrivenDevelepment.main.java.Instock;
import TestDrivenDevelepment.main.java.Product;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.*;
import java.util.stream.Collectors;


public class InstockTest {

    private Instock instock;

    @Before
    public void setUp() {
        this.instock = new Instock();
    }

    @Test
    public void test_Count_Should_Be_Zero_When_Instock_Empty() {
        Assert.assertEquals(0, instock.getCount());
    }

    @Test
    public void test_Count_Should_Be_Five_When_Instock_Has_Five_Products() {
        int productsCount = 5;
        addProductsToInstock(productsCount);
        Assert.assertEquals(productsCount, instock.getCount());
    }

    //    @Test
//    public void test_Contains_Should_Be_False_When_No_Such_Product_Present() {
//        addProductsToInstock(5);
//        Assert.assertFalse(instock.contains(new Product("not present",1, 1)));
//    }
    // Един общ тест, когато е boolean
    @Test
    public void test_Contains_Should_Be_True_Or_False() {
        Product product = addProductsToInstock(5)[3];
        Assert.assertTrue(instock.contains(product));
        Assert.assertFalse(instock.contains(new Product("not present", 1, 1)));
    }

    //find works
    @Test
    public void test_findReturns_The_Correct_Product() {
        Product expected = addProductsToInstock(10)[4];
        Product actual = instock.find(4);

        Assert.assertNotNull(actual);

        Assert.assertEquals(expected.getLabel(), actual.getLabel());
    }

    // find throw exception
    @Test(expected = IndexOutOfBoundsException.class)
    public void test_find_Should_Throw_Exception_With_Negative_Index() {
        instock.find(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void test_find_Should_Throw_Exception_With_Greater_Index() {
        addProductsToInstock(2);
        instock.find(instock.getCount());
    }

    @Test
    public void test_Change_Quantity_Should_Update_TheProduct() {
        Product product = new Product("test", 1, 10);
        instock.add(product);
        int expectedQuantity = product.getQuantity() + 5;
        instock.changeQuantity(product.getLabel(), expectedQuantity);

        Assert.assertEquals(expectedQuantity, product.getQuantity());
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_Change_Quantity_Throws_Exception_When_NoProduct_WithThat_Label() {
        instock.changeQuantity("john doy", 10);
    }


    @Test
    public void test_findByLabel_Should_Return_Correct_Product() {
        Product expected = new Product("test", 1, 10);
        instock.add(expected);
        Product actual = instock.findByLabel(expected.getLabel());

        Assert.assertNotNull(actual);
        Assert.assertEquals(expected.getLabel(), actual.getLabel());

    }

    @Test(expected = IllegalArgumentException.class)
    public void test_FindByLabel_Should_Throw_Exception_When_No_Such_Label_Of_Product() {
        instock.findByLabel("test");
    }

    //@Test
    //public void test_FindFirstByAlphabeticalOrder()


    @Test
    public void test_findFirstMost_Expensive_Products_Should_Return_The_Correct_Products() {
        int productsToTake = 10;

        Product[] products = addProductsToInstock(20);

        List<Product> expected = Arrays.stream(products).sorted(Comparator.comparing(Product::getPrice).reversed())
                .limit(productsToTake)
                .collect(Collectors.toList());

//        List<Product> expected = Arrays.stream(addProductsToInstock(20))
//                .sorted(Comparator.comparing(Product::getPrice).reversed())
//                .limit(productsToTake)
//                .collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstMostExpensiveProducts(productsToTake);

        List<Product> actual = assertIterableNotNullAndConvertToList(iterable);

        Assert.assertEquals(expected, actual);
    }

    @Test(expected = IllegalArgumentException.class)
    public void test_findFirstMost_Expensive_Products_Should_Throw_Exception() {
        addProductsToInstock(10);
        instock.findFirstMostExpensiveProducts(11);
    }


    @Test
    public void test_findFirstByAlphabeticalOrder_Should_Return_Correct_Products(){
        int count = 5;
        Product[] products = addProductsToInstock(10);
        List<Product> expected = Arrays.stream(products)
                .sorted(Comparator.comparing(Product::getLabel))
                .limit(count).collect(Collectors.toList());

        Iterable<Product> iterable = instock.findFirstByAlphabeticalOrder(count);
        List<Product> actual = assertIterableNotNullAndConvertToList(iterable);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_findFirstByAlphabeticalOrder_Should_Return_Empty_Collection_When_OutOfRange(){
        addProductsToInstock(5);
        instock.findFirstByAlphabeticalOrder(6);
        Assert.assertEquals(0, instock.getCount());
    }

    @Test
    public void test_findAllInPriceRange_Should_Return_Correct_Products(){
        double lowerPrice = 10.00;
        double higherPrice = 35.00;

        Product[] products = addProductsToInstock(20);
        List<Product> expected = Arrays.stream(products)
                .filter(p -> p.getPrice() > lowerPrice && p.getPrice() <= higherPrice).collect(Collectors.toList());

        Iterable<Product> allInRange = instock.findAllInRange(lowerPrice, higherPrice);
        List<Product> actual = assertIterableNotNullAndConvertToList(allInRange);

        Assert.assertEquals(expected, actual);
    }
    @Test
    public void test_findAllInPriceRange_Should_Return_Empty_Collection_When_OutOfRange(){
        double lowerPrice = 12.00;
        double higherPrice = 35.00;

        addProductsToInstock(1);
        instock.findAllInRange(lowerPrice, higherPrice);
        Assert.assertEquals(0, instock.getCount());
    }

    private List<Product> assertIterableNotNullAndConvertToList(Iterable<Product> iterable) {
        Assert.assertNotNull(iterable);

        List<Product> products = new ArrayList<>();

        iterable.forEach(products::add);

        return products;
    }

    private Product[] addProductsToInstock(int count) {

        Product[] arr = new Product[count];

        for (int i = 1; i <= count; i++) {
            Product product = new Product("product " + i, 10.00 + i, i);
            instock.add(product); // here test add method;
            arr[i - 1] = product;
        }
        return arr;
    }
}