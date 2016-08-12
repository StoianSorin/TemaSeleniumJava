package com.endava.PageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import com.endava.HomePage;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sstoian on 8/3/2016.
 */
public class BaseClass {
    private static WebDriver webDriver;

    protected  HomePage hPage;

    @BeforeClass
    public static void setUp()
    {
        webDriver = new FirefoxDriver();
        webDriver.manage().window().maximize();
        webDriver.get("http://oriflame.ro");
    }

    @Before
    public void initPageObjects(){
        hPage = PageFactory.initElements(webDriver, HomePage.class);
    }
/*
    @AfterClass
    public static void tDown(){
        webDriver.close();
    }*/
}
