package BondScanner;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.LogStatus;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
 
import BondScanner.GlobalCorporateBonds;
import com.relevantcodes.extentreports.LogStatus;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.AssertJUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
 
 
public class MuniBonds extends BaseTest {
    WebDriver driver;
     
     
     @BeforeClass
        public static void setUpBeforeClass() throws Exception {
    	 System.setProperty("webdriver.chrome.driver", "C:\\Users\\daigg\\Desktop\\selenium\\chromedriver_win32_90\\chromedriver.exe");
              
        }
      
      
        @BeforeMethod
        public void setUpMehtod() throws Exception {
            System.out.println("--------Starting Test--------");
            driver = Utils.getDriver();
              
        }
      
        @AfterMethod
        public void tearDownMethod() throws Exception {
            System.out.println("--------Test Finished--------");
            driver.quit();
        }
         
        
         
         
        @Test
        public void MuniBonds_AllVsInvestmentGrade() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Muni Bonds tab
            Utils.GetMuniTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("3.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int AllTotal = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to IG
           Utils.GetResultsEditButton(driver).click();       
             
             
            Utils.GetInvestmentGradeButton(driver).click();
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for IG
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from IG Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int IGTotal = Integer.parseInt(DeleteComma2);
             
            if (IGTotal < AllTotal){
                System.out.println("Total from IG search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
                test.log(LogStatus.PASS, "Total from IG search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
                  
            }
              
            else{
                System.out.println("Total from IG search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
                test.log(LogStatus.FAIL, "Total from IG search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
            }
             
             
        }
         
        @Test
        public void MuniBonds_AllStatesVsConnecticut() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Muni Bonds tab
            Utils.GetMuniTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("3.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int AllTotal = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to CT
            Utils.GetResultsEditButton(driver).click();       
             
             
            
 
            Utils.GetStateSelect(driver).click();
             
            for (int i=0; i<7; i++){
                Utils.GetStateSelect(driver).sendKeys(Keys.ARROW_DOWN);
                if(i == 6){
                    Utils.GetStateSelect(driver).sendKeys(Keys.ENTER);}}
             
            
             
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for CT
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from CT Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int IGTotal = Integer.parseInt(DeleteComma2);
             
            if (IGTotal < AllTotal){
                System.out.println("Total from CT search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
                test.log(LogStatus.PASS, "Total from CT search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
            }
              
            else{
                System.out.println("Total from CT search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
                test.log(LogStatus.FAIL, "Total from CT search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
            }
             
             
        }
         
        @Test
        public void MuniBonds_End2021VsEnd2022() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Muni Bonds tab
            Utils.GetMuniTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
           Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2021");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
           Utils.GetYTWMax(driver).sendKeys("3.0");
             
            //Click Enter and Record the number of results
           Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int Total21 = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from 21 to 22
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetMaturityDateEnd(driver).clear();
           Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2022");
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for IG
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from IG Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int Total22 = Integer.parseInt(DeleteComma2);
             
            if (Total22 > Total21){
                System.out.println("Total from 2022 search " + Total22 + " Is correctly Larger than 2021 Total " + Total21);
                test.log(LogStatus.PASS, "Total from 2022 search " + Total22 + " Is correctly Larger than 2021 Total " + Total21);
            }
              
            else{
                System.out.println("Total from 2022 search " + Total22 + " Is incorrectly Smaller than 2021 Total " + Total21);
                test.log(LogStatus.FAIL, "Total from 2022 search " + Total22 + " Is incorrectly Smaller than 2021 Total " + Total21);
            }
             
             
        }
         
        @Test
        public void MuniBonds_YieldToWorstTest() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Muni Bonds tab
            Utils.GetMuniTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2022");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("3.0");
             
            //Click Enter and Record the number of results
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from 3% Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int Total3 = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to IG
            Utils.GetResultsEditButton(driver).click();       
             
            Utils.GetYTWMax(driver).clear();
            Utils.GetYTWMax(driver).sendKeys("4.0");
 
             
             
           Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for IG
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from 4% Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int Total4 = Integer.parseInt(DeleteComma2);
             
            if (Total4 >= Total3){
                System.out.println("Total from 4% search " + Total4 + " Is correctly Larger than 3% Total " + Total3);
                test.log(LogStatus.PASS, "Total from 4% search " + Total4 + " Is correctly Larger than 3% Total " + Total3);
            }
              
            else{
                System.out.println("Total from 4% search " + Total4 + " Is incorrectly Smaller than 3% Total " + Total3);
                test.log(LogStatus.FAIL, "Total from 4% search " + Total4 + " Is incorrectly Smaller than 3% Total " + Total3);
            }
             
             
        }
         
        @Test
        public void MuniBonds_AllStatesVsConnecticut4YTW2022() throws InterruptedException {
        	String nameofCurrMethod = new Throwable().getStackTrace()[0].getMethodName();
    		test = report.startTest(nameofCurrMethod);
          
            System.out.println("--------Opening Bond Scanner--------");
            String homePage = "https://gdcdyn.interactivebrokers.com/en/index.php?f=45559#/";
 
            //ChromeOptions options = new ChromeOptions();
            //options.addArguments("--headless", "--disable-gpu", "--window-size=1920,1200","--ignore-certificate-errors");
            //driver = new ChromeDriver(options);
            
            driver.get(homePage);
             
            //Click on  Muni Bonds tab
            Utils.GetMuniTab(driver).click();
              
            //Get current date and format it
            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");
            String formattedDate = sdf.format(date);
            
            //Enter Current date into the Maturity Date starting field
            Utils.GetMaturityDateStart(driver).sendKeys(formattedDate);
             
            //Enter end 2021 date into end date field
            Utils.GetMaturityDateEnd(driver).sendKeys("12/31/2022");
            
            //Enter the values 0.5 - 1.5 for the Yield to Worst range
            Utils.GetYTWMin(driver).sendKeys("0.0");
            Utils.GetYTWMax(driver).sendKeys("4.0");
             
            //Click Enter and Record the number of results
           Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
            String totalnum = Utils.GetTotalNum(driver).getText();
              
            String lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from All Search: " + lastFourDigits);
              
            String DeleteComma = lastFourDigits.replace(",", "");
             
            int AllTotal = Integer.parseInt(DeleteComma);
             
             
            //Click Edit and change from All to CT
            Utils.GetResultsEditButton(driver).click();       
             
             
               
 
            Utils.GetStateSelect(driver).click();
             
            for (int i=0; i<7; i++){
                Utils.GetStateSelect(driver).sendKeys(Keys.ARROW_DOWN);
                if(i == 6){
                    Utils.GetStateSelect(driver).sendKeys(Keys.ENTER);}}
             
            
             
 
             
             
            Utils.GetViewResultsButton(driver).click();
            Thread.sleep(3000);
             
         // Record the results for CT
            totalnum = Utils.GetTotalNum(driver).getText();
              
            lastFourDigits = "";     //substring containing last 4 characters
              
            if (totalnum.length() == 22)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 3);
            }
            else if (totalnum.length() == 24)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 5);
            }
            else if (totalnum.length() == 14)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 1);
            }
            else if (totalnum.length() > 2)
            {
                lastFourDigits = totalnum.substring(totalnum.length() - 2);
            }
            else
            {
                lastFourDigits = totalnum;
            }
              
            System.out.println("Total from CT Search: " + lastFourDigits);
              
            String DeleteComma2 = lastFourDigits.replace(",", "");
             
            int IGTotal = Integer.parseInt(DeleteComma2);
             
            if (IGTotal < AllTotal){
                System.out.println("Total from CT search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
                test.log(LogStatus.PASS, "Total from CT search " + IGTotal + " Is correctly Smaller than All Total " + AllTotal);
            }
              
            else{
                System.out.println("Total from CT search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
                test.log(LogStatus.FAIL, "Total from CT search " + IGTotal + " Is incorrectly Larger than All Total " + AllTotal);
            }
             
             
        }
         
}
