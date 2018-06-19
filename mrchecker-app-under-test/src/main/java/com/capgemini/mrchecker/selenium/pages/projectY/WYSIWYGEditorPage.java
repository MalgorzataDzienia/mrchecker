package com.capgemini.mrchecker.selenium.pages.projectY;

import org.openqa.selenium.By;

import com.capgemini.mrchecker.selenium.core.newDrivers.elementType.Button;
import com.capgemini.mrchecker.selenium.pages.environment.GetEnvironmentParam;
import com.capgemini.mrchecker.selenium.pages.environment.PageSubURLsProjectYEnum;
import com.capgemini.mrchecker.test.core.logger.BFLogger;

public class WYSIWYGEditorPage extends TheInternetSubpage {
	
	public final By pageLinkSelector = By.cssSelector("li > a[href*='tinymce']");
	
	@Override
	public boolean isLoaded() {
		getDriver().waitForPageLoaded();
		return getDriver().getCurrentUrl()
						.contains(PageSubURLsProjectYEnum.WYSIWYGEDITOR.getValue());
	}
	
	@Override
	public void load() {
		BFLogger.logDebug("Load 'TinyMCE WYSIWYG Editor' page.");
		getDriver().get(GetEnvironmentParam.THE_INTERNET_MAIN_PAGE.getValue() + PageSubURLsProjectYEnum.WYSIWYGEDITOR.getValue());
		getDriver().waitForPageLoaded();
	}
	
	@Override
	public String pageTitle() {
		return getActualPageTitle();
	}
	
	@Override
	public void clickPageLink() {
		new Button(pageLinkSelector).click();
	}
	
}
