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

    @Test(enabled = true)
    public  void testCase01(){
        System.out.println("Start Test case: testCase01");
        //Navigate to Flipkart Website
        driver.get("https://www.flipkart.com/");
        // verifying the Current URL using Assert Statements
        Assert.assertTrue(driver.getCurrentUrl().equals("https://www.flipkart.com/"), "Unverified URL");
        System.out.println("end Test case: testCase01");
    }

    @Test(enabled = true)
    public void testCase02(){

        System.out.println("Start Test case: testCase02");
        try {
            // Locate SearchBox
            WebElement searchBox = driver.findElement(By.xpath("//input[@class='Pke_EE']"));

            //Click on SearchBox
        SeleniumWrapper.clickAction(searchBox, driver);

        //Enter Text in SearchBox
        SeleniumWrapper.enterText(searchBox, "Washing machine");

        //Locate Search button
        WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

        //Click Search Button
        SeleniumWrapper.clickAction(searchbtn, driver);

        //Get Washing Machine WebElement
        WebElement washingmachinetext = driver.findElement(By.xpath("//span[text()='Washing machine']"));

        //Convert Get Washing Machine WebElement into String
        String getWashingMachineText = washingmachinetext.getText();

        //Verify Washing Machine Text using Assert Statements
        Assert.assertEquals(getWashingMachineText, "Washing machine");

        //Locate 'Popularity Category'
        WebElement popularity_category = driver.findElement(By.xpath("//div[@class='_5THWM1']//div[text()='Popularity']"));

        //Click on Popularity Category
        popularity_category.click();

        Thread.sleep(3000);

        //Creating a list of WebElements for Ratings
List<WebElement> ratingsList = driver.findElements(By.xpath("//div[@class='_2kHMtA']//div[@class='_3LWZlK']"));

int countOfLowRatings = 0;

for (int i = 0; i < ratingsList.size(); i++) {
    try {
        WebElement ratingElement = ratingsList.get(i);
        // Assuming the text of rating WebElement can be extracted as follows
        float rating = Float.parseFloat(ratingElement.getText());
        
        //Checking if rating is <= 4.0
        if (rating <= 4.0) {
            // if true, increment countOfLowRatings
            countOfLowRatings++;
        }
    } catch (NumberFormatException e) {
        // Handle if the rating cannot be parsed to float
        e.printStackTrace();
    }
}

// Print total count of Ratings <= 4
System.out.println("Count of ratings less than or equal to 4: " + countOfLowRatings);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("End Test case: testCase02");
    }

    @Test(enabled = true)
    public void testCase03(){
        System.out.println("Start Test case: testCase03");
        try {
            // Locate SearchBox
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

            //Click on SearchBox
        SeleniumWrapper.clickAction(searchBox, driver);

        //Enter Text in SearchBox
        SeleniumWrapper.enterText(searchBox, "Iphone");

        //Locate Search button
        WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

        //Click Search Button
        SeleniumWrapper.clickAction(searchbtn, driver);

        // Get Iphone from WebElement
        WebElement Iphonetext = driver.findElement(By.xpath("//span[text()='Iphone']"));

        //Convert iphone as String from WebElement
        String getIphoneText = Iphonetext.getText();

        //verifying Iphone Text using Assert Statements
        Assert.assertEquals(getIphoneText, "Iphone");


        Thread.sleep(3000);

        //Creating a list of Elements for Discount
        List<WebElement> discountList = driver.findElements(By.xpath("//div[@class='_3pLy-c row']//div[@class='_3Ay6Sb']"));
        int countOfDiscount = 0;
        WebElement productTitle;
        String getProductTitle = " ";

for (WebElement ratingElement : discountList) {
    try {
        //Get Discount % from the WebElement as Text
        String discountRate = ratingElement.getText();
        // Assuming the text of the discount WebElement represents the discount rate

        // Extracting the numeric part of the discount rate
        String numericDiscount = discountRate.replaceAll("[^0-9]", "");
        int discountValue = Integer.parseInt(numericDiscount);

        //Checking if discountValue > 17
        if (discountValue >= 17) {
            productTitle = driver.findElement(By.xpath("//div[@class='_3pLy-c row']//div[@class='_4rR01T']"));
            getProductTitle = productTitle.getText();
            System.out.println("Product titles above 17% Discount: " + getProductTitle);
            countOfDiscount++;
        }
    } catch (Exception e) {
        e.printStackTrace();
    }
}
//Print Product Titles and Total count above 17% Discount
 System.out.println("Product titles above 17% Discount: " + getProductTitle);
 System.out.println("Total Count above 17% Discount: " + countOfDiscount);

    }
         catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }

        System.out.println("End Test case: testCase03");
    }

    @Test(enabled = true)
    public void testCase04(){

        System.out.println("Start Test case: testCase04");
        try {
            // Locate SearchBox
            WebElement searchBox = driver.findElement(By.xpath("//input[@type='text']"));

            //Click on SearchBox
        SeleniumWrapper.clickAction(searchBox, driver);

        //Enter Text in SearchBox
        SeleniumWrapper.enterText(searchBox, "Coffee Mug");

        //Locate Search button
        WebElement searchbtn = driver.findElement(By.xpath("//button[@type='submit']"));

        //Click Search Button
        SeleniumWrapper.clickAction(searchbtn, driver);

                // Get Iphone from WebElement
                WebElement Iphonetext = driver.findElement(By.xpath("//span[text()='Coffee Mug']"));

                //Convert iphone as String from WebElement
                String getIphoneText = Iphonetext.getText();
        
                //verifying Iphone Text using Assert Statements
                Assert.assertEquals(getIphoneText, "Coffee Mug");

                //Creating a list of for clicking on 4 stars and above
       List <WebElement> stars = driver.findElements(By.xpath("//div[@class='_2d0we9']//div"));

        for(int i = 0; i< stars.size(); i++){
         String getStars = stars.get(i).getText();
         
         //Checking if the list contains 4 
         if(getStars.contains("4")){
            stars.get(i).click();
            break;
         }
    }

    // Creating a list of WebElements for Reviews
    List<WebElement> reviews = driver.findElements(By.xpath("//span[@class='_2_R_DZ']"));
    int count = 1;
    
    for (WebElement reviewElement : reviews) {
        try {

            // get the text from the Discount List of WebElements
            String discountRate = reviewElement.getText();
            // Assuming the text of the discount WebElement represents the discount rate
        
            // Extracting the numeric part of the discount rate
            String numericReview = discountRate.replaceAll("[^0-9]", "");
            int numericReviewValue = Integer.parseInt(numericReview);
    
            //verify if Ratings is > 1000 and count to print is < 5
            if (numericReviewValue > 1000 && count < 5) {
                WebElement productTitle = driver.findElement(By.xpath("(//a[@class='s1Q9rs'])[" + (count + 1) + "]"));
                String productTitleText = productTitle.getText();
                WebElement imgURLElement = driver.findElement(By.xpath("//img[@loading='eager']"));
                String url = imgURLElement.getAttribute("src");
                System.out.println("URL: " + url);
                System.out.println("Product Title: " + productTitleText);
                count++;
            }

            //if count >=5 
            if(count >= 5){
                //End Test
                endTest();
            }
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

        Thread.sleep(2000);
       
    } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        System.out.println("End Test case: testCase04");
    }
}