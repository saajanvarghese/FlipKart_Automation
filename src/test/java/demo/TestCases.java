package demo;


import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;


public class TestCases {
    ChromeDriver driver;
    public TestCases()
    {
        System.out.println("Constructor: TestCases");
        WebDriverManager.chromedriver().timeout(30).setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    public void endTest()
    {
        System.out.println("End Test: TestCases");
        driver.close();
        driver.quit();

    }

    @Test
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.flipkart.com/");
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.flipkart.com/"), "Unverified URL");
        System.out.println("end Test case: testCase01");
    }

    @Test
    public void testCase02(){

        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));

        SeleniumWrapper.clickAction(searchBox, driver);

        SeleniumWrapper.enterText(searchBox, "Washing machine");

        WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

        SeleniumWrapper.clickAction(searchbtn, driver);

        WebElement washingmachinetext = driver.findElement(By.xpath("//span[text()='Washing machine']"));

        String getWashingMachineText = washingmachinetext.getText();

        Assert.assertEquals(getWashingMachineText, "Washing machine");


        WebElement popularity_category = driver.findElement(By.xpath("//div[@class='_5THWM1']//div[text()='Popularity']"));
        // SeleniumWrapper.clickAction(popularity_category, driver);
        popularity_category.click();

        Thread.sleep(3000);

        List<WebElement> ratingsList = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']"));
         int countOfLowRatings = 0;

for (WebElement ratingElement : ratingsList) {
    // Assuming the text of rating WebElement can be extracted as follows
    float rating = Float.parseFloat(ratingElement.findElement(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']")).getText());
    
    if (rating <= 4.0) {
        countOfLowRatings++;
    }
}
        
        System.out.println("Count of ratings less than 4: " + countOfLowRatings);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }

    @Test
    public void testCase03(){
        try {
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

        SeleniumWrapper.clickAction(searchBox, driver);

        SeleniumWrapper.enterText(searchBox, "Iphone");

        WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

        SeleniumWrapper.clickAction(searchbtn, driver);

        WebElement Iphonetext = driver.findElement(By.xpath("//span[text()='Iphone']"));

        String getIphoneText = Iphonetext.getText();

        Assert.assertEquals(getIphoneText, "Iphone");


        Thread.sleep(3000);

        List<WebElement> discountList = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[@class='_3Ay6Sb']"));
        int countOfDiscount = 0;
        WebElement productTitle;
        String getProductTitle = " ";

for (WebElement ratingElement : discountList) {
    try {
        String discountRate = ratingElement.getText();
        // Assuming the text of the discount WebElement represents the discount rate

        // Extracting the numeric part of the discount rate
        String numericDiscount = discountRate.replaceAll("[^0-9]", "");
        int discountValue = Integer.parseInt(numericDiscount);

        if (discountValue > 17) {
            productTitle = driver.findElement(By.xpath("//div[@class='_3pLy-c row']//div[@class='_4rR01T']"));
            getProductTitle = productTitle.getText();
            System.out.println("Product titles above 17% Discount: " + getProductTitle);
            countOfDiscount++;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}

 System.out.println("Product titles above 17% Discount: " + getProductTitle);
 System.out.println("Total Count above 17% Discount: " + countOfDiscount);

    }
         catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
    }
}
