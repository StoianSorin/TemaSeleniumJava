package com.endava;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.InterfaceImplementation;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created by sstoian on 8/3/2016.
 */
public class IngrijireCorpListPage {
    private WebDriver webDriver;

    public IngrijireCorpListPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }

    @FindBy(xpath = "//div[@class='filter-count']/span[@class='total-count']")
    private WebElement totalResults;

    @FindBy(xpath = "//a[@class='button k-button load-more']")
    private WebElement moreButton;

    @FindBy(xpath = "//div[@class='ui-cookie-tooltip']/button[@class='k-button']")
    private WebElement inchideButton;

    @FindBy(xpath = "//span[@class='k-icon k-i-arrow-s']")
    private WebElement celeMaiRecente;

    @FindBy(xpath = "//li[@class='k-item'][2]")
    private WebElement criteria;

    @FindBy(xpath = "//div[@id='grid']/div/div[@class='w-content g15 g-last']/section/section/a[@class='ui-product-box g5 isotope-item']/div[@class='w-info']/div[@class='offer']/span")
    private List<WebElement> productPriceList;

    @FindBy(xpath = "//div[@id='grid']/div/div[@class='w-content g15 g-last']/section/section/a[@class='ui-product-box g5 isotope-item']/div[@class='w-info']/span[@class='name']")
    private  List<WebElement> productList;

    @FindBy(xpath = "//div[@id='pdp-content']/form/h1[@class='name']")
    private  WebElement getProductName;

    @FindBy(xpath = "//div[@class='w-grid pdp']/div[@class='ui-breadcrumb-back g-all']/p/a/span")
    private WebElement backIngrijireCorpButton;

    @FindBy(xpath = "//nav[@id='facet-menu']/div/ul[@class='links-list']/li/a[@href='/bath-body/new']")
    private  WebElement noutatiButton;

    @FindBy(xpath = "//div[@class='w-grid']/div/section/div/div/div[@class='filter-count']/span")
    private  WebElement newProducts;

    @FindBy(xpath = "//div[@class='w-grid']/div/section/section/a[@class='ui-product-box g5 isotope-item']/div[@class='w-info']/span[@class='name']")
    private  List<WebElement> listOfNewProd;

    @FindBy(xpath = "//button[@id='addToBasketButton']")
    private WebElement adaugaInCosButton;

    @FindBy(xpath = "//div[@class='ui-sticky-bar']/ul/li[@class='basket right']/a/span[@class='basket-items']")
    private WebElement nrProdInCos;

    @FindBy(xpath = "//span[@class='v-icon-mini-bag']")
    private WebElement cosButton;

    @FindBy(xpath = "//div[@class='w-grid']/div/div[@class='ui-basket-products']/div[@class='basket-products-table']/ul[@class='row-data row-1']/li[@class='quantity mobile-on']/span/span/span/span/span[@class='k-link']/span[@class='k-icon k-i-arrow-n']")
    private WebElement upButton;

    @FindBy(xpath = "//div[@class='totals']/span/span")
    private WebElement totalPrice;

    @FindBy(xpath = "//div[@class='bp']/span[@class='value']/span[@class='total-bp']")
    private WebElement totalPoints;

    public Integer getTotalProducts() {
        String totResults = totalResults.getText();
        return Integer.parseInt(totResults);
    }

    public void inchidePopup() {
        inchideButton.click();
    }

    public void clickCeleMaiRecente() {
        celeMaiRecente.click();
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(criteria));
        criteria.click();

    }

    public String returneazaProdusulDePretMaxim()
    {
        return productList.get(0).getText().toString();
    }
    public String returneazaCelMaiMarePret()
    {
        return productPriceList.get(0).getText().toString();
    }

    public void clickOnTheProduct()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(productList));
        productList.get(0).click();
    }

    public String getProductNameF()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(getProductName));
        return getProductName.getText().toString();
    }

    public void clickBackIngrCorpButton()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(backIngrijireCorpButton));
        backIngrijireCorpButton.click();
    }

    public void clickNoutatiButton()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(noutatiButton));
        noutatiButton.click();
    }

    public String returneazaNrProduseNoi()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(newProducts));
        return newProducts.getText().toString();
    }

    public void clickOnSecondNewProd()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOfAllElements(listOfNewProd));
        listOfNewProd.get(1).click();
    }

    public void clickAdaugaInCosButton()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(adaugaInCosButton));
        adaugaInCosButton.click();
    }

    public int returneazaNrProduseDinCos()
    {
        String numar=nrProdInCos.getText().toString();
        return Integer.parseInt(numar);
    }

    public void clickCosCumparaturi()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(cosButton));
        cosButton.click();
    }

    public void clickUpButton()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(upButton));
        upButton.click();

        wait.until(ExpectedConditions.visibilityOf(upButton));
        upButton.click();
    }

    public String returneazaTotalPlata()
    {
        String numar2 = totalPrice.getText().toString();
        return numar2;
    }

    public String returneazaPuncteTotale()
    {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(totalPoints));
        String numar=totalPoints.getText().toString();
        return numar;
    }

    public void waitForPage() {
        WebDriverWait wait = new WebDriverWait(webDriver, 10);
        wait.until(ExpectedConditions.visibilityOf(totalResults));
        wait.until(ExpectedConditions.textToBePresentInElement(totalResults, ""));
    }
}
