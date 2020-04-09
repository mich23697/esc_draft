package SeleniumJava.SeleniumJava;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Browser_test {
	static String myPassword = "SUTD@Singapore";

	public static void main(String[] args) throws InterruptedException {
		

		System.setProperty("webdriver.gecko.driver","C:\\JAVA\\SeleniumJava\\drivers\\geckodriver\\geckodriver.exe");
         WebDriver driver = new FirefoxDriver();

		driver.get("file:///C:/Users/simon/Documents/GitHub/esc_draft/Map/Button_css.html");
		String GroupId = "1234";
		List<WebElement> Button = driver.findElements(By.className("button"));	
		List<WebElement> textbox = driver.findElements(By.className("textbox"));	
		List<WebElement> changebutton = driver.findElements(By.className("changebutton"));	
		WebElement press = driver.findElement(By.id("Algo"));
		WebElement reset = driver.findElement(By.id("Reset"));
		System.out.println(Button);
		//click the location button and input random 4 digit integer and click change button to update the data
		for(int i=0;i<30;i++)
		{
			Button.get(i).click();
			Thread.sleep(500);
			textbox.get(i).sendKeys(randomString(4));
			Thread.sleep(500);
			changebutton.get(i).click();
			Thread.sleep(500);
		}
		for(int i=0;i<30;i++)
		{
			Button.get(i).click();
			Thread.sleep(100);

		}
		for(int i=0;i<5;i++)
		{
			press.click();
			Thread.sleep(1000);
			reset.click();
			Thread.sleep(1000);
		}
	}
	static String randomString(int len){
	    StringBuilder s = new StringBuilder(len);
	    final String strings = "0123456789";
	    Random r = new Random();
	    for( int i = 0; i < len; i++ ) 
	       s.append( strings.charAt( r.nextInt(strings.length()) ) );
	    return s.toString();
	 }
	
}