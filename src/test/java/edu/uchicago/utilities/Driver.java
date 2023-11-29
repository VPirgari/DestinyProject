package edu.uchicago.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    private Driver(){
    }
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    public static WebDriver getDriver(){

        if(driverPool.get() == null) {
            String browserType = edu.uchicago.utilities.ConfigurationReader.getProperty("browser");

            switch (browserType) {
                case "chrome":
                    synchronized (Driver.class) {
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    }
            }

        }

        return driverPool.get();
    }

    public static void closeDriver(){
        if(driverPool != null) {
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}
