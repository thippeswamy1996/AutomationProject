package com.testCases;

import org.testng.annotations.Test;
import com.pageObjects.HomePage;
import com.testBase.BaseClass;
  


public class TC001_Verify_Registration_Page extends BaseClass {
	
    @Test(priority=1)
    public void verifyRegistration() {
    	logger.info("Test case is starting");
        System.out.println("Executing Registration Test Case...");
        
        HomePage hp = new HomePage(driver);
        hp.clickHome();
        logger.info("Clicked on home link");
    }
}
