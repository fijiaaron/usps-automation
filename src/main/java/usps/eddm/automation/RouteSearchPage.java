package usps.eddm.automation;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import usps.eddm.api.RouteSearchOrderSummary;

import static org.openqa.selenium.support.ui.ExpectedConditions.*;

public class RouteSearchPage extends PageObject
{
	public static String url = "https://eddm.usps.com/eddm/customer/routeSearch.action";
	public RouteSearchPage(WebDriver driver)
	{
		super(driver, RouteSearchPage.url);
	}
	
	@FindBy(id="address")
	WebElement addressSearchField;
	
	@FindBy(css="#formSearch button[type=submit]")
	WebElement searchButton;

	// zip code select modal
	@FindBy(css="#modal-box #zipCodesList > li")
	List<WebElement> zipCodeSelectList;
	
	@FindBy(css="#zipcodeSelectBtn")
	WebElement zipCodeSelectButton;
	
	@FindBy(css="#eddm_overlay-progress")
	WebElement progressOverlay;
	
	
	// select routes table
	@FindBy(css=".route-table-toggle")
	WebElement showTableLink;
	
	@FindBy(css=".totalsArea")
	WebElement selectAllRoutes;
	
	
	//  order summary
	@FindBy(css="#info-panel .order-summary .routes")
	WebElement OrderSummary_Routes;
	
	@FindBy(css="#info-panel .order-summary .dropoffs")
	WebElement OrderSummary_Dropoffs;
	
	@FindBy(css="#info-panel .order-summary .delivery-addresses")
	WebElement OrderSummary_DeliveryAddresses;
	
	@FindBy(css="#info-panel .order-summary .approx-cost")
	WebElement OrderSummary_ApproximateCost;
	
	@FindBy(css="#info-panel .order-summary .clear-sel")
	WebElement OrderSummary_Clear;
	
	
	@FindBy(css="#info-panel .order-summary .continue-btn")
	WebElement OrderSummary_ContinueButton;

	public void selectZipCodeFromList(int index)
	{
		zipCodeSelectList.get(index).click();	
	}
	
	public void waitForMap()
	{
		wait.until(visibilityOf(progressOverlay));
		wait.until(invisibilityOf(progressOverlay));
	}
	
	public void selectAllRoutes()
	{
		wait.until(elementToBeClickable(showTableLink)).click();
		wait.until(elementToBeClickable(selectAllRoutes)).click();
		
		wait.until(visibilityOf(OrderSummary_Clear));
	}
	
	public RouteSearchOrderSummary getOrderSummary()
	{
		int routes = Integer.parseInt(OrderSummary_Routes.getText());
		int dropoffs = Integer.parseInt(OrderSummary_Dropoffs.getText());
		int deliveryAddresses = Integer.parseInt(OrderSummary_DeliveryAddresses.getText());
		String approximateCost = OrderSummary_ApproximateCost.getText();
	
		return new RouteSearchOrderSummary(routes, dropoffs, deliveryAddresses, approximateCost);
	}
	
	public void submitOrder()
	{
		wait.until(elementToBeClickable(OrderSummary_ContinueButton)).click();
	}
}
