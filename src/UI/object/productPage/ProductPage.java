package UI.object.productPage;
import java.util.List;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import UI.object.BasePage;

public class ProductPage extends BasePage {

	  @FindBy(css = ".inventory_item")
	    private List<WebElement> productList;

	    @FindBy(css = ".inventory_item_name")
	    private List<WebElement> productNames;

	    @FindBy(css = ".inventory_item_price")
	    private List<WebElement> productPrices;

	    @FindBy(css = ".btn_primary.btn_inventory")
	    private List<WebElement> addToCartButtons;

	    @FindBy(css = ".shopping_cart_badge")
	    private WebElement cartBadge;

	    public ProductPage(WebDriver driver) {
	        super(driver);
	    }

	    public int getProductCount() 
	    {
	        return productList.size();
	    }

	    public String getProductName(int index) 
	    {
	        return productNames.get(index).getText();
	    }

	    public String getProductPrice(int index) 
	    {
	        return productPrices.get(index).getText();
	    }

	    public void addProductToCart(int index) 
	    {
	        addToCartButtons.get(index).click();
	    }
	    
	    public void addProductToCartByProductName(String productName) 
	    {
	        for(int i=0;i<productNames.size();i++)
	        {
	        	if(productNames.get(i).equals(productName))
	        		addToCartButtons.get(i).click();
	        }
	    }

	    public int getCartItemCount() 
	    {
	        return Integer.parseInt(cartBadge.getText());
	    }
	    
}
