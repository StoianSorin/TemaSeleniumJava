package com.endava;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by sstoian on 8/3/2016.
 */
public class HomePage {
    private WebDriver webDriver;

    @FindBy(xpath = "//div[@id='primary-navigation']/ul/li/a[@data-category='bath-body']")
    private WebElement tab;

    public HomePage(WebDriver webDriver){
        this.webDriver=webDriver;
    }

    public IngrijireCorpListPage goToIngrijireCorpTab ()
    {
        tab.click();

        IngrijireCorpListPage ingrijireCorpListPage = PageFactory.initElements(webDriver, IngrijireCorpListPage.class);

        ingrijireCorpListPage.waitForPage();

        return  ingrijireCorpListPage;
    }
}
