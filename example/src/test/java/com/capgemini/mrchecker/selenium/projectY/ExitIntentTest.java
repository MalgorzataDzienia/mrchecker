package com.capgemini.mrchecker.selenium.projectY;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.capgemini.mrchecker.core.groupTestCases.testSuites.tags.TestsLocal;
import com.capgemini.mrchecker.core.groupTestCases.testSuites.tags.TestsNONParallel;
import com.capgemini.mrchecker.selenium.pages.projectY.ExitIntentPage;

@TestsLocal
@TestsNONParallel
public class ExitIntentTest extends TheInternetBaseTest {
	
	private static final String MODAL_WINDOW_TITLE = "This is a modal window";
	
	private static ExitIntentPage exitIntentPage;
	
	@BeforeAll
	public static void setUpBeforeClass() {
		exitIntentPage = shouldTheInternetPageBeOpened().clickExitIntentLink();
		
		logStep("Verify if Exit Intent page is opened");
		assertTrue("Unable to open Exit Intent page", exitIntentPage.isLoaded());
		
		logStep("Verify if exit intent message is visible");
		assertTrue("Exit intent message is not visible", exitIntentPage.isIntentMessageVisible());
	}
	
	@Test
	public void shouldModalWindowAppearWhenMouseMovedOutOfViewportTest() {
		
		logStep("Verify if modal window is hidden");
		assertTrue("Fail to hide modal window", !exitIntentPage.isModalWindowVisible());
		
		logStep("Move mouse pointer out of viewport");
		exitIntentPage.moveMouseOutOfViewport();
		
		logStep("Verify if modal window showed up");
		assertTrue("Fail to show up modal window", exitIntentPage.isModalWindowVisible());
		
		logStep("Verify if modal window title displays properly");
		assertTrue("Fail to display modal window's title", exitIntentPage.verifyModalWindowTitle(MODAL_WINDOW_TITLE.toUpperCase()));
		
		logStep("Close modal window");
		exitIntentPage.closeModalWindow();
		
		logStep("Verify if modal window is hidden again");
		assertTrue("Fail to hide modal window", !exitIntentPage.isModalWindowVisible());
	}
	
}
