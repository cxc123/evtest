package evgames_pages;

import models.ProductDetail;
import org.omg.PortableServer.THREAD_POLICY_ID;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by aakumar on 08/11/17.
 */
public class MemoPage
{
    private WebDriver webDriver;
    @FindBy(css = "tr[id^='tr_']")
    private List<WebElement> productElements;
    public MemoPage(WebDriver webDriver) {
        this.webDriver = webDriver;
    }
    public void loadMemoPage()
    {


        PageFactory.initElements(webDriver,this);

    }

    public List<ProductDetail> getProductDetailInFav() throws Exception
    {
        List<ProductDetail> productDetailList = new ArrayList<>();
        for(WebElement webElement:productElements)
        {
            WebElement w = webElement.findElement(By.cssSelector("a[id^='dm_']"));
            ProductDetail productDetail = new ProductDetail();
            productDetail.setHref(w.getAttribute("href"));
            productDetail.setId(w.getAttribute("id"));
            productDetailList.add(productDetail);
        }

        return  productDetailList;

    }

}
