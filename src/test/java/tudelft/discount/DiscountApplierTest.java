package tudelft.discount;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.List;

public class DiscountApplierTest {

    /*
    The DiscountApplier class is responsible for applying the new discounts on the prices of the product. If the
    category of the product is HOME, the new price should now be 90% of the old price.
    If the category of the product is BUSINESS, the new price should be 110% of the old price.
     */

     /*
You will have to use mocks to simulate the ProductDao class, the one responsible for getting
all the products from the database.
      */
/*
There's a bug in our implementation. Use everything you learned so far to test this class and fix the bug.
Write your tests inside the DiscountApplierTest class. At the end, push your solution to your GitHub repository.
 */

    @Test
    public void emptyProductsTest() {
        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(new ArrayList<>());

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();
    }

    @Test
    public void singleHOMEProduct() {
        Product homeProduct = new Product("TV", 100.0, "HOME");
        List<Product> productList = new ArrayList<>();
        productList.add(homeProduct);

        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(productList);

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(110.0, homeProduct.getPrice(), 0.0001);
    }

    @Test
    public void singleBUSINESSProduct()
    {
        Product businessProduct = new Product("Printer", 100.0, "BUSINESS");
        List<Product> productList = new ArrayList<>();
        productList.add(businessProduct);

        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(productList);

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(90.0, businessProduct.getPrice());
    }

    @Test
    public void singleBUSINESSProductWithNaNPrice()
    {
        Product businessProduct = new Product("Printer", Double.NaN, "BUSINESS");
        List<Product> productList = new ArrayList<>();
        productList.add(businessProduct);

        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(productList);

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(Double.NaN, businessProduct.getPrice());
    }

    @Test
    public void twoProducts()
    {
        Product businessProduct = new Product("Printer", 100.0, "BUSINESS");
        Product homeProduct = new Product("TV", 100.0, "HOME");
        List<Product> productList = new ArrayList<>();
        productList.add(businessProduct);
        productList.add(homeProduct);

        ProductDao productDao = Mockito.mock(ProductDao.class);
        Mockito.when(productDao.all()).thenReturn(productList);

        DiscountApplier discountApplier = new DiscountApplier(productDao);
        discountApplier.setNewPrices();

        Assertions.assertEquals(90.0, businessProduct.getPrice());
        Assertions.assertEquals(110.0, homeProduct.getPrice(), 0.01);
    }

}
