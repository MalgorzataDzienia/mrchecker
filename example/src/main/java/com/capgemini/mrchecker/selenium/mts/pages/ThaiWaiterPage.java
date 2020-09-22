package com.capgemini.mrchecker.selenium.mts.pages;

import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.BasePage;
import com.capgemini.mrchecker.test.core.logger.BFLogger;
import com.capgemini.mrchecker.test.core.utils.PageFactory;

public class ThaiWaiterPage extends BasePage {
	
	private static final By	ordersTabSearch			= By.xpath("//a[@routerlink='/orders']");
	private static final By	reservationsTabSearch	= By.xpath("//a[@routerlink='/reservations']");
	
	@Override
	public boolean isLoaded() {
		getDriver().waitForPageLoaded();
		
		return getDriver().getCurrentUrl()
				.contains("orders");
	}
	
	@Override
	public void load() {
		BFLogger.logError("MyThaiStar waiter page was not loaded.");
	}
	
	@Override
	public String pageTitle() {
		return "";
	}
	
	public ThaiOrdersPage switchToOrders() {
		getDriver().findElementDynamic(ordersTabSearch)
				.click();
		
		return PageFactory.getPageInstance(ThaiOrdersPage.class);
	}
	
	/**
	 * Seek for the reservations tab and click on it
	 *
	 * @return ThaiReservationsPage an object representing the reservations page
	 */
	public ThaiReservationsPage switchToReservations() {
		
		getDriver().findElementDynamic(reservationsTabSearch)
				.click();
		
		return PageFactory.getPageInstance(ThaiReservationsPage.class);
	}
	
}
