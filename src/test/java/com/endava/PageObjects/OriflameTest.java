package com.endava.PageObjects;

import com.endava.HomePage;
import com.endava.IngrijireCorpListPage;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by sstoian on 8/3/2016.
 */
public class OriflameTest extends BaseClass {

    @Test
    public void metodaTest()
    {
        IngrijireCorpListPage ingrijireCorpListPage = hPage.goToIngrijireCorpTab();
        Integer totalProductsNumber = ingrijireCorpListPage.getTotalProducts();
        System.out.println("Total products: "+ingrijireCorpListPage.getTotalProducts());
        assertTrue(totalProductsNumber>0);
        ingrijireCorpListPage.inchidePopup();

        ingrijireCorpListPage.clickCeleMaiRecente();
        System.out.println("Produsul cu cel mai mare pret este '"+ingrijireCorpListPage.returneazaProdusulDePretMaxim()+"' si are pretul "+ ingrijireCorpListPage.returneazaCelMaiMarePret());
        ingrijireCorpListPage.clickOnTheProduct();
        String productName=ingrijireCorpListPage.getProductNameF();
        assertEquals("Tratament anticelulitic Bioclinic",productName);

        ingrijireCorpListPage.clickBackIngrCorpButton();

        ingrijireCorpListPage.clickNoutatiButton();
        String nrOfNewProd=ingrijireCorpListPage.returneazaNrProduseNoi();
        System.out.println("S-au gasit "+ingrijireCorpListPage.returneazaNrProduseNoi()+" produse noi");
        assertTrue(Integer.parseInt(nrOfNewProd)>0);

        ingrijireCorpListPage.clickOnSecondNewProd();

        ingrijireCorpListPage.clickAdaugaInCosButton();

        int num=ingrijireCorpListPage.returneazaNrProduseDinCos();
        assertTrue(num==1);

        ingrijireCorpListPage.clickCosCumparaturi();

        ingrijireCorpListPage.clickUpButton();


        System.out.println("Puncte acumulate "+ingrijireCorpListPage.returneazaPuncteTotale());

        String sumaPlata=ingrijireCorpListPage.returneazaTotalPlata();
        assertEquals("38,97 LEI",sumaPlata);
    }
}
