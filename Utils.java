package BondScanner;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Utils {

   public static WebDriver getDriver () {
	   System.setProperty("webdriver.gecko.driver", "C:/Users/daigg/Desktop/selenium/geckodriver-v0.29.0-win32/geckodriver.exe");
       WebDriver driver = new FirefoxDriver();
       return driver;
   }
    
   public static boolean killDriver () {
       System.out.println("Not yet implemeted...");
       return true;
   }
    
   public static WebElement GetMaturityDateStart(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f20\"]"));
   }
    
   public static WebElement GetMaturityDateEnd(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f21\"]"));
   }
    
   public static WebElement GetYTWMin(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f23\"]"));
   }
    
   public static WebElement GetYTWMax(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f24\"]"));
   }
    
   public static WebElement GetCouponMax(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f28\"]"));
   }
    
   public static WebElement GetCouponMin(WebDriver driver) {
       return driver.findElement(By.xpath("//*[@id=\"_f27\"]"));
   }
    
   public static WebElement GetViewResultsButton(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[3]/div/button"));
   }
    
   public static WebElement GetTotalNum(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div[1]/div/div[3]/div/div[2]/div[2]/div[1]/div/div/span"));
   }
    
   public static WebElement GetResultsEditButton(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div[1]/div/div[1]/div/span/button[3]"));
   }
    
   public static WebElement GetHighYieldButton(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[1]/div[5]/div/div/button[2]"));
   }
    
   public static WebElement GetInvestmentGradeButton(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[1]/div[5]/div/div/button[3]"));
   }
    
   public static WebElement GetCountryIssuer(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[1]/div[6]/div[2]/div/span/span/span"));
   }
    
   public static WebElement GetCurrency(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[1]/div[7]/span/span/span"));
   }
    
   public static WebElement GetNoneInd(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[2]/div/button"));
   }
    
   public static WebElement GetEnergyCheck(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[2]/div/ul/li[1]/label/span[1]"));
   }
    
   public static WebElement GetBasicCheck(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[2]/div/ul/li[2]/label/span[1]"));
   }
    
   public static WebElement GetIndustrialCheck(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[2]/div/ul/li[3]/label/span[1]"));
   }
    
   public static WebElement GetMuniTab(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[2]/div/div[2]/ul/li[4]/a"));
   }
    
   public static WebElement GetSovereignTab(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[2]/div/div[2]/ul/li[5]/a"));
   }
    
   public static WebElement GetCDTab(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[2]/div/div[2]/ul/li[2]/a"));
   }
    
   public static WebElement GetTreasuryTab(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[2]/div/div[2]/ul/li[3]"));
   }
    
   public static WebElement GetStateSelect(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[3]/section[2]/div/div/div/div/div/div/div[3]/div/form/div[2]/div[2]/span/span/span"));
   }
    
   public static WebElement GetCpEdit(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[1]/div[1]/div[1]/div/div[2]/div/div/div/span/span/button[3]"));
   }
   
   public static WebElement GetNoResultClose(WebDriver driver) {
       return driver.findElement(By.xpath("/html/body/div[8]/div/div[2]/div/button"));
   }
    
    
}
