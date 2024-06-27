package UI.test.productPageTest;


import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import Common.data.DataProduct;
import Common.utils.Utils;
import UI.object.loginPage.LoginPage;
import UI.object.productPage.ProductPage;
import UI.test.BaseTest;

public class ProductPageTest extends BaseTest{

	@Test(description ="verify 'Swag Labs' title text")
	public void T01_verifySwagLabsTitle()
	{
		LoginPage loginPage = new LoginPage(driver);
		loginPage.fillloginDeafult();
		Assert.assertEquals(loginPage.getTitle(), Utils.readPropStart("productTitle"));
	}
	
	@Test(description ="verify product count")
    public void T02_testProductCount() 
	{
		ProductPage product = new ProductPage(driver);
        int expectedProductCount = 6; 
        Assert.assertEquals(product.getProductCount(), expectedProductCount);
    }

    @Test(description ="verify product details")
    public void T03_testProductDetails() 
    {
    	ProductPage product = new ProductPage(driver);
        int productIndex = 0; 
        String expectedProductName = "Sauce Labs Backpack";
        String expectedProductPrice = "$29.99"; 

        Assert.assertEquals(product.getProductName(productIndex), expectedProductName);
        Assert.assertEquals(product.getProductPrice(productIndex), expectedProductPrice);
    }

    @Test(description ="verify add product to cart")
    public void T04_testAddProductToCart() 
    {
    	ProductPage product = new ProductPage(driver);
        int productIndex = 0; 
        product.addProductToCart(productIndex);

        int expectedCartItemCount = 1;
        Assert.assertEquals(product.getCartItemCount(), expectedCartItemCount);
    }
    
    @Test(description ="verify add product to cart by name")
    public void T05_testAddProductToCartByName() 
    {
    	ProductPage product = new ProductPage(driver);
        product.addProductToCartByProductName("Sauce Labs Bolt T-Shirt");

        int expectedCartItemCount = 1;
        Assert.assertEquals(product.getCartItemCount(), expectedCartItemCount);
    }
    
    @Test(description ="verify add all product to cart")
    public void T06_testAddAllProductsToCart() 
    {
    	ProductPage product = new ProductPage(driver);
        int productCount = product.getProductCount();
        for (int i = 0; i < productCount; i++) {
        	product.addProductToCart(i);
        }
        Assert.assertEquals(product.getCartItemCount(), productCount);
    }

}
