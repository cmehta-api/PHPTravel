/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phptravels;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import static java.nio.file.Files.list;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.swing.Action;
import static javax.swing.text.Position.Bias.Backward;
import junit.framework.Assert;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/**
 *
 * @author cmehta
 */
public class TheInternet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, InterruptedException {
        // TODO code application logic here
        TheInternet phpObj = new TheInternet();
        
        //phpObj.phpBrowserLaunch();
        //phpObj.phpABTesting();
        //phpObj.phpBasicAuth();
        //phpObj.brokenImages();
        phpObj.iFrame();
        //phpObj.nestedIFrame();
        //phpObj.canvasDOM();
        //phpObj.checkbox();
        phpObj.checkBoxToolsQA();
        
        
    }
    
    
    
    public void phpBrowserLaunch(){
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        Assert.assertEquals(phpTitle, phpExpected, phpTitle);
        
        //verify URL
        String phpURL = driver.getCurrentUrl();
        String phpExpectedURL = " ";
        System.out.println(phpURL);
        
        Assert.assertEquals(phpExpectedURL, phpURL); 
        
        //verify headers
        
        String phpHearders = driver.findElement(By.xpath("//h1[@class='heading']")).getText();
        System.out.println(phpHearders);
        
        String phpContentHeaders = driver.findElement(By.xpath("//h2[contains(text(),'Available Examples')]")).getText();
        System.out.println(phpContentHeaders);
        
        //verify "Fork me on GitHub" image
       boolean phpGITHUB =  driver.findElement(By.xpath("//img[@src='/img/forkme_right_green_007200.png']")).isDisplayed();
       boolean phpExpectedGITHUB = true;
       Assert.assertEquals(phpExpectedGITHUB, phpGITHUB);
        
        driver.close();
    }
    
    
    
    public void phpABTesting(){
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        Assert.assertEquals(phpTitle, phpExpected, phpTitle);
        
        //verify URL
        String phpURL = driver.getCurrentUrl();
        String phpExpectedURL = "http://the-internet.herokuapp.com/";
        System.out.println(phpURL);
        
        String phpABTesting = driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).getText();
        String phpExpectedABTesting = "A/B Testing";
        Assert.assertEquals(phpExpectedABTesting, phpABTesting);
        driver.findElement(By.xpath("//a[contains(text(),'A/B Testing')]")).click();
        String getHearder= driver.findElement(By.xpath("//h3[contains(text(),'A/B Test Variation 1')]")).getText();
        System.out.println(getHearder);
        String getExpectedHeader = "A/B Test Variation 1";
        
        Assert.assertEquals(getExpectedHeader, getHearder);
        driver.navigate().refresh();
        driver.navigate().back();
        
       
        driver.close();
    }
    
    
    
    public void phpBasicAuth() throws FileNotFoundException, IOException{
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        //verify login credentials
        /*
        File src = new File("D:\\Users\\cmehta\\Downloads\\testData.xlsx");
        FileInputStream fis = new FileInputStream(src);
        XSSFWorkbook wb = new XSSFWorkbook(fis);
        XSSFSheet sheet1 = wb.getSheetAt(0);
        String cellValue = sheet1.getRow(0).getCell(0).getStringCellValue();
        System.out.println(cellValue);
        
        int totalRowNumber = sheet1.getLastRowNum();
        System.out.println(totalRowNumber);
        
        //driver.findElement(By.xpath("//a[contains(text(),'Basic Auth')]")).click();
        //driver.switchTo().alert().sendKeys("admin");
        
                */
        driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
        String basicAuthMessage = driver.findElement(By.xpath("//p[contains(text(),'Congratulations! You must have the proper credenti')]")).getText();
        String basicAuthMessageExpected = "Congratulations! You must have the proper credentials.";
        
        Assert.assertEquals(basicAuthMessageExpected, basicAuthMessage);
       
        driver.close();
    }
    
    
    public void brokenImages(){
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        driver.findElement(By.xpath("//a[contains(text(),'Broken Images')]")).click();
        String brokenImagesTitle = driver.findElement(By.xpath("//h3[contains(text(),'Broken Images')]")).getText();
        System.out.println(brokenImagesTitle);
        String expectedBrokenImage = "Broken Images";
        
        Assert.assertEquals(expectedBrokenImage, brokenImagesTitle);
        
        
        //List<WebElement> imageLink = (List<WebElement>) driver.findElement(By.tagName("img"));
        //System.out.println(imageLink.size());
        
        WebElement linklist = driver.findElement(By.tagName("img"));
        System.out.println("Total number of images on page: " +linklist.getSize());
        ArrayList<String> activeImage = new ArrayList<String>();
        
        driver.close();
        
    }
    
    
    public void iFrame(){
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        driver.findElement(By.xpath("//a[@href='/frames']")).click();
        String frameHeader = driver.findElement(By.xpath("//h3[contains(text(),'Frames')]")).getText();
        String frameHeaderExpected = "Frames";
        Assert.assertEquals(frameHeaderExpected, frameHeader);
        driver.findElement(By.xpath("//a[contains(text(),'iFrame')]")).click();
        
        String headerText = driver.findElement(By.xpath("//h3[contains(text(),'An iFrame containing the TinyMCE WYSIWYG Editor')]")).getText();
        String expectedHeaderText = "An iFrame containing the TinyMCE WYSIWYG Editor";
        
        Assert.assertEquals(expectedHeaderText, headerText);
        
        String poweredBy = driver.findElement(By.xpath("//a[@target='_blank']")).getText();
        System.out.println(poweredBy);
        
        //driver.switchTo().frame("mce_0_ifr");  //locate the frame by ID
        //driver.switchTo().frame(0);    //locate by index
        
        WebElement myFrame = driver.findElement(By.xpath("//iframe[@id='mce_0_ifr']")); // locate by webelement
        driver.switchTo().frame(myFrame);
        
 
        String iFrameText = driver.findElement(By.xpath("//p[contains(text(),'Your content goes here.')]")).getText();
        String expectediFrameText = "Your content goes here.";
        Assert.assertEquals(expectediFrameText, iFrameText); 
        System.out.println("iFrame text is: " +iFrameText);
        
        
        
        driver.close();
        
    }
    
    
    
    public void nestedIFrame(){
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        driver.findElement(By.xpath("//a[@href='/frames']")).click();
        String frameHeader = driver.findElement(By.xpath("//h3[contains(text(),'Frames')]")).getText();
        String frameHeaderExpected = "Frames";
        Assert.assertEquals(frameHeaderExpected, frameHeader);
        
        driver.findElement(By.xpath("//a[contains(text(),'Nested Frames')]")).click();
        String currentURL = driver.getCurrentUrl();
        System.out.println(currentURL);
        String expectedCurrentURL = "http://the-internet.herokuapp.com/nested_frames";
        
        Assert.assertEquals(expectedCurrentURL, currentURL);
        
        List<WebElement> iFrames = driver.findElements(By.tagName("frame"));
        int frameSize= iFrames.size();
        System.out.println("Total frames : "+frameSize);
        
        
        //WebElement leftFrame = driver.findElement(By.xpath("//Frame[@name = 'frame-left']"));
        //driver.switchTo().frame(leftFrame);
        
        driver.switchTo().defaultContent();
        String leftFrameText = driver.findElement(By.xpath("//body[contains(text(),'LEFT')]")).getText();
        
        System.out.println(leftFrameText);
        
        driver.close();
        
        
    }
    
    
    
    public void canvasDOM(){
        
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        driver.findElement(By.xpath("//a[contains(text(),'Challenging DOM')]")).click();
        
        String t = driver.findElement(By.xpath("//a[@class='button']")).getText();
        System.out.println(t);
        
        WebElement element = driver.findElement(By.xpath("//canvas[@id='canvas']"));
        
        Actions canvas  = new Actions(driver);
        
        Actions drawAction = canvas.moveToElement(element, 599, 200);
        
        drawAction.doubleClick();
        
        
        String can = driver.findElement(By.xpath("//canvas[@id='canvas']")).getText();
        
        System.out.println(can);
        
        driver.close();

    }
    
    
    
    public void checkbox() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("http://the-internet.herokuapp.com/");
        String phpTitle = driver.getTitle();
        String phpExpected = "The Internet";
        System.out.println(phpTitle);
        
        
        driver.findElement(By.linkText("Checkboxes")).click();
        //boolean checkbox = driver.findElement(By.xpath("//form[@id='checkboxes']")).isSelected();
        //System.out.println(checkbox);
        
        List<WebElement> chkBox = driver.findElements(By.xpath("//input[@type = 'checkbox']"));
        
         boolean isSelectdChkBox = chkBox.get(0).isSelected();
         
         int sizeOfChkBox = chkBox.size();
         System.out.println(sizeOfChkBox);
        
        
           
            if(isSelectdChkBox ==true){
                
                chkBox.get(1).click();
                Thread.sleep(4000);
            }else{
                chkBox.get(0).click();
                
                Thread.sleep(4000);
            }       
        
        
        driver.close();
        

        
    }
    
    
    
    public void checkBoxToolsQA() throws InterruptedException{
        
        System.setProperty("webdriver.chrome.driver", "D:\\Users\\cmehta\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        
        //Verify title
        driver.get("https://www.toolsqa.com/automation-practice-form/");
        String phpTitle = driver.getTitle();
        String phpExpected = "Demo Form for practicing Selenium Automation";
        System.out.println(phpTitle);
        Assert.assertEquals(phpExpected, phpTitle);
        
        
        String textSex = driver.findElement(By.xpath("//label[contains(text(),'Sex')]")).getText(); 
        String expectedTextSex = "Sex";
        Assert.assertEquals(expectedTextSex, textSex);
        
        List<WebElement> sexOptions = driver.findElements(By.name("sex"));
        
        sexOptions.get(0);
        
        System.out.println(sexOptions.size());
        
       // ArrayList<Object> sexArray = new ArrayList<Object>(sexOptions);
        
            
            if (sexOptions.get(0).isSelected() !=true){
                
                sexOptions.get(1).click();
                
                Thread.sleep(4000);
            }else{
                sexOptions.get(0).click();
                
            }
            
        
        
        driver.close();
        
    }
    
    
}
