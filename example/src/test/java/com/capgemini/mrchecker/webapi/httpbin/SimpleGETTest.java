package com.capgemini.mrchecker.webapi.httpbin;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.jupiter.api.Test;

import com.capgemini.mrchecker.core.groupTestCases.testSuites.tags.TestsWebApi;
import com.capgemini.mrchecker.test.core.BaseTest;
import com.capgemini.mrchecker.test.core.logger.BFLogger;
import com.capgemini.mrchecker.test.core.utils.PageFactory;
import com.capgemini.mrchecker.webapi.pages.httbin.SimpleGETPage;

import io.restassured.response.Response;

@TestsWebApi
public class SimpleGETTest extends BaseTest {
	
	@Test
	public void sendSimpleGETQuery() {
		SimpleGETPage simpleGETPage = PageFactory.getPageInstance(SimpleGETPage.class);
		
		BFLogger.logInfo("Step 1 - Sending GET query to " + simpleGETPage.getEndpoint());
		Response response = simpleGETPage.sendGETQuery();
		
		BFLogger.logInfo("Step 2 - Validate response status code: ");
		assertThat(response.statusCode(), is(200));
	}
}
