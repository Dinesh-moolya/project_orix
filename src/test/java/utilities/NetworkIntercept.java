package utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v111.network.model.RequestId;
import org.openqa.selenium.devtools.v111.network.Network;
import org.openqa.selenium.interactions.Actions;

import java.util.Optional;

public class NetworkIntercept {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver;
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(chromeOptions);

        DevTools devTools = ((ChromeDriver) driver).getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));

        devTools.addListener(Network.requestWillBeSent(), request -> {
            if (request.getRequest().getUrl().contains("/geo/address/")) {
                System.out.println(request.getRequest().getUrl());
            }
        });

        final RequestId[] requestIds = new RequestId[1];
        devTools.addListener(Network.responseReceived(), response -> {
            requestIds[0] = response.getRequestId();
            String responseBody = devTools.send(Network.getResponseBody(requestIds[0])).getBody();
            if (responseBody.contains("formattedAddress")) {
                System.out.println(responseBody);
            }
        });

        driver.get("https://inroute.intangles.com/#/");

        driver.findElement(By.id("userName")).sendKeys("test_user@intangles.com");
        driver.findElement(By.xpath("//*[@placeholder='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        Thread.sleep(5000);
        WebElement webElement = driver.findElement(By.xpath("//*[local-name()='svg']/*[local-name()='path']"));
        Actions act = new Actions(driver);
        act.moveToElement(webElement).click().build().perform();
        Thread.sleep(5000);

        driver.findElement(By.cssSelector("input[placeholder='Search Vehicle...']")).clear();
        driver.findElement(By.cssSelector("input[placeholder='Search Vehicle...']")).sendKeys("TUSHAR _ IMAX 3");
        Thread.sleep(5000);
        driver.findElement(By.cssSelector("input[placeholder='Search Vehicle...']")).sendKeys(Keys.ENTER);
        Thread.sleep(5000);

        driver.quit();
        devTools.close();

    }
}