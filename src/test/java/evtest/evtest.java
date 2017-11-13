package evtest;

import evgames_pages.*;
import models.ProductDetail;
import org.testng.Assert;
import org.testng.annotations.Test;
import utility.ListComparator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakumar on 11/11/17.
 */
public class evtest extends evBaseTest {





    /**
     * <pre>
     * Open the browser and maximize it.
     * Open  ss.com
     * switch to Russian language.
     * Go to the section “Электротехника”
     * open search ('Поиск')
     * In Search enter the search phrase (eg. 'Computer') and select a different search parameters.
     * Click Search
     * Sort the results by price
     * select option 'Продажа' in "Тип сделки" dropdown
     * Open “Расширенный поиск”. (advanced search)
     * Enter search option price between 160 and 300.
     * Click Search
     * Choose at least 3 random ads
     * Press “Добавить выбранные в закладки” ( = add to memo)
     * Open “Закладки”
     * Verify that the ads on the page match the previously selected
     * Close browser
     *</pre>
     */
    @Test
    public void testcase_1() throws  Exception
    {
        List<ProductDetail> expectedList= new ArrayList<>();
        HomePage homePage = new HomePage(driver);
        homePage.loadHomePage();
        /* changing language to russian */
        homePage.changeLanguage();
        /* selecting “Электротехника” section */
        SectionPage sectionPage = homePage.goToSectionPage();
        sectionPage.loadSectionPage();
        /* going to search page */
        SearchPage searchPage = sectionPage.goToSearchPage();
        searchPage.loadSearchPage();
        /* entering search for computer  and other search params */
        searchPage.enterSearchString("Computer");
        searchPage.enterSearchPeriod("Среди всех объявлений");
        searchPage.enterTown_district("Все объявления");
        searchPage.enterSortby("Цена");
        /* clicking search button and navigating to search results */
        SearchResultPage searchResultPage = searchPage.goToSearchResult();
        searchResultPage.loadSearchResultPage();
        /* sorting search results by price */
        searchResultPage.sortPrice();
        /* selecting Продажа option */
        searchResultPage.optionSelect();
        /* navigating to advance search */
        searchPage=searchResultPage.goToSearchPage();
        searchPage.loadSearchPage();
        /* entering max and min price */
        searchPage.enterMinprice("160");
        searchPage.enterMaxPrice("300");
        searchResultPage=searchPage.goToSearchResult();
        /* navigating to search result page */
        searchResultPage.loadSearchResultPage();
        /* selecting 3 ads from search result */
        if(searchResultPage.CountSearchResult() >= 3) {
            expectedList = searchResultPage.selectProduct(3);
        }
        else
        {
            expectedList=searchResultPage.selectProduct(searchResultPage.CountSearchResult());
        }
        /* adding selected ads to memo */
        searchResultPage.addToMemo();
        /* navigating to memo page */
        MemoPage memoPage=searchResultPage.goToMemoPage();
        memoPage.loadMemoPage();
        /* get all ads present in memo */
        List<ProductDetail> actualList=memoPage.getProductDetailInFav();
        /* verifying selected ads are only present in memom */
        Assert.assertTrue(ListComparator.compareObject(actualList,expectedList)==true,"All selected add are which are added are not showing in memo page");




    }




}
