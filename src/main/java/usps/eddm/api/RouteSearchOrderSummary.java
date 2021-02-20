package usps.eddm.api;

import java.lang.reflect.Type;

import com.google.common.reflect.TypeToken;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class RouteSearchOrderSummary
{
	public int routes;
	public int dropoffs;
	public int deliveryAddresses;
	public String approximateCost;
	
	public RouteSearchOrderSummary(int routes, int dropoffs, int deliveryAddresses, String approximateCost)
	{
		this.routes = routes;
		this.dropoffs = dropoffs;
		this.deliveryAddresses = deliveryAddresses;
		this.approximateCost = approximateCost;
	}
	
	@SuppressWarnings("serial")
	public String toJson()
	{		
		Type type = new TypeToken<RouteSearchOrderSummary>() {}.getType();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		return gson.toJson(this, type);
	}
}
