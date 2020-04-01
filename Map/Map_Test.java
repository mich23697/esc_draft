package selenium_testing;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserTest {
		
	public static void main(String[] args) throws InterruptedException {		
		//System.setProperty("webdriver.gecko.driver","C:\\Users\\simon\\Desktop\\ZZM\\selenium_testing\\drivers\\geckdriver\\geckodriver.exe");
		//WebDriver driver = new FirefoxDriver();

		System.setProperty("webdriver.chrome.driver","C:\\Users\\simon\\Desktop\\ZZM\\selenium_testing\\drivers\\chromeDriver\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		driver.get("file:///C:/Users/simon/Desktop/JavaScript/map.html");
		//driver.get("https://istd.sutd.edu.sg/");
		//driver.get("https://www.google.com.sg");
		
		// get all the links
		java.util.List<WebElement> buttons = driver.findElements(By.tagName("button"));
		System.out.println(buttons.size());
				
		// print all the links
		for (int i = 0; i < buttons.size(); i=i+1) {
			System.out.println(i + " " + buttons.get(i).getText());
			System.out.println(i + " " + buttons.get(i).getAttribute("href"));
		}
		
		// maximize the browser windows
		driver.manage().window().maximize();
		
		// click all links in a web page
		for(int i = 0; i < buttons.size(); i++)
		{
			System.out.println("*** Navigating to" + " " + buttons.get(i).getAttribute("href"));
			//if (links.get(i).getAttribute("href") == null || 
			//		links.get(i).getAttribute("href").equals("https://sudiptac.bitbucket.io"))
			if (buttons.get(i).getAttribute("href") == null)
				continue;
			boolean staleElementLoaded = true;
			//the loop checks whether the elements is properly loaded
			while(staleElementLoaded) {
				try {
					//navigate to this link
					driver.navigate().to(buttons.get(i).getAttribute("href"));
					Thread.sleep(3000);
					//click the back button in the browser
					driver.navigate().back();
					buttons = driver.findElements(By.tagName("button"));
					System.out.println("*** Navigated to" + " " + buttons.get(i).getAttribute("href"));
					staleElementLoaded = false;
				} catch (StaleElementReferenceException e) {
					staleElementLoaded = true;
				}
			}
		}
	}
}

