package usps.eddm.automation;

import org.testng.annotations.Test;

import usps.eddm.api.RouteSearchOrderSummary;

public class RouteSearchTest extends WebDriverTest
{
	@Test
	public void search_for_route()
	{
		RouteSearchPage routeSearch = new RouteSearchPage(driver);
		routeSearch.open();	
		
		String title = driver.getTitle();
		System.out.println(title);
		pause(1);
		
		routeSearch.addressSearchField.sendKeys("Orange, CA");
		routeSearch.searchButton.click();
		pause(1);
		
		routeSearch.selectZipCodeFromList(0);
		pause(1);
		
		routeSearch.zipCodeSelectButton.click();
		routeSearch.waitForMap();
		pause(1);
		
		routeSearch.selectAllRoutes();
		pause(1);
		
		RouteSearchOrderSummary orderSummary = routeSearch.getOrderSummary();
		System.out.println(orderSummary.toJson());
		
		routeSearch.OrderSummary_ContinueButton.click();
		pause(3);
	}
}