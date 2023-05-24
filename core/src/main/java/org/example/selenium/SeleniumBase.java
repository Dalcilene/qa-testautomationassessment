package org.example.selenium;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

public class SeleniumBase {
    private static SeleniumBase instance;
    private WebDriver driver;

    private SeleniumBase(){}

    public static SeleniumBase getInstance(){
        if(instance == null)
            instance = new SeleniumBase();
        return instance;
    }

    public void startBrowser(){
        startBrowser(false);
    }

    public void startBrowser(boolean isHeadless){
        try{
            ChromeOptions chromeOptions = new ChromeOptions();
            chromeOptions.addArguments("--remote-allow-origins=*");
            chromeOptions.setHeadless(isHeadless);
            if(driver == null){
                WebDriverManager.chromedriver().setup();
                driver = new ChromeDriver(chromeOptions);
            }
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

        }catch (Exception ex){
            quitDriver();
            throw new RuntimeException("Could not start browser (driverException): "+ ex.getMessage());
        }
    }

    public void startBrowser(String url, boolean isHeadless){
        startBrowser(isHeadless);
        driver.navigate().to(url);
    }

    public void startBrowser(String url){
        startBrowser(false);
        driver.navigate().to(url);
    }

    public Set<String> getTabs(){
        return driver.getWindowHandles();
    }

    public void changeToNextTab(){
        for (String tab: driver.getWindowHandles()) {
            if(!tab.equals(driver.getWindowHandle())){
                driver.switchTo().window(tab);
            }
        }
    }

    public void takeScreenShot(String filename){
        String screenShotPath = "c:\\tmp\\";

        File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File(screenShotPath+filename+".png"));
        } catch (IOException e) {
            throw new RuntimeException("Unable to copy screenShot to file");
        }
    }

    public WebDriver getDriver(){
        if(driver == null)
            startBrowser();
        return this.driver;
    }
    public void quitDriver() {
        WebDriver driver = this.getDriver();
        if (driver != null) {
            driver.quit();
        }
    }
}
