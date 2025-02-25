package com.testBase;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;


public class BaseClass {
    public WebDriver driver;
    public Logger logger;
    public Properties p;

    @BeforeClass
    @Parameters({"os" ,"browser"})
    public void setUp(String os ,String br) throws IOException {
    	//LOading Config.properties file;
    	
    	try {
			FileReader file = new FileReader("./src/test/resources/config.properties");
			p=new Properties();
			p.load(file);
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	logger =LogManager.getLogger(this.getClass());
        switch(br.toLowerCase()) {
        case"chrome": driver=new ChromeDriver();break;
        case"edge": driver=new EdgeDriver();break;
        case"FireFox": driver=new FirefoxDriver();break;
        default : System.out.println("Invalid broser "); 
        return;
        }
        
        // Delete all cookies
        driver.manage().deleteAllCookies();
        
        // Implicit wait
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        
        // Launch URL
        driver.get(p.getProperty("appURL")); //reading url prom properties file
        
        // Maximize window
        driver.manage().window().maximize();
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            driver.quit(); // Close the browser after test execution
        }
    }
}
