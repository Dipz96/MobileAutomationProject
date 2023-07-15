package MobileTestAutomation.MobileApp;



import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

/**
 * Hello world!
 *
 */
public class App 
{
	static AppiumDriver driver;
    static WebDriverWait wait;
    public static void main( String[] args )
    {
        try {
        	loginToApplication();
        }
        catch(Exception e)
        {
        	if(driver!=null)
        		driver.quit();
        	System.out.println("Failed with exception: "+e.getMessage());
        }
    }

    
    static void loginToApplication() throws Exception {
    	if(launchApplication()) {
    		System.out.println("Login Action Started");
    		WebElement engE1=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath( "//*[(@text='Eng')]")));
    		engE1.click();
    		WebElement proceedBtn=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.widget.ScrollView/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[4]"));
    		proceedBtn.click();
    		
    		WebElement weekSelect=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(@text='Week 4')]")));
    		weekSelect.click();
    		
    		WebElement weekSubmitBtn=driver.findElement(By.xpath("//*[(@text='Submit')]"));
    		weekSubmitBtn.click();
    		
    		WebElement unselectNumber=driver.findElement(By.id("com.google.android.gms:id/cancel"));
    		unselectNumber.click();
    		
    		WebElement signInBtn=driver.findElement(By.xpath("//*[(@text='Sign in with Google')]"));
    		signInBtn.click();
    		
    		WebElement addgmailAccount=driver.findElement(By.xpath("//*[(@text='Add another account')]"));
    		addgmailAccount.click();
    		
    		WebElement usePin=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(@text='Use PIN')]")));
    		usePin.click();
    		
    		WebElement pinTxtBox=driver.findElement(By.id("com.samsung.android.biometrics.app.setting:id/lockPassword"));
    		pinTxtBox.sendKeys("1018");
    		
    		WebElement emailTxtBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @resource-id='identifierId']")));
    		emailTxtBox.sendKeys("usert2559@gmail.com");
    		
    		WebElement nextBtn=driver.findElement(By.xpath("//*[(@text='Next')]"));
    		nextBtn.click();
    		    	
    		Thread.sleep(5000);
    		
    		WebElement pwdTxtBox=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@class='android.widget.EditText' and @displayed='true']")));
    		pwdTxtBox.sendKeys("Test@123");
    		
    		WebElement nextBtn1=driver.findElement(By.xpath("//*[(@text='Next')]"));
    		nextBtn1.click();
    		
    		Thread.sleep(3000);
    		
    		scrollAndClick("Skip");
    		
    		
    		WebElement acceptTOS=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[(@text='I agree')]")));
    		acceptTOS.click();
	
    		//Login Action Completed
    		
    		Thread.sleep(10000);
    		//Logout Action Started
    		System.out.println("Logout Action Started");
    		
    		WebElement locAccessPopup=wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.widget.HorizontalScrollView/android.view.ViewGroup/android.view.ViewGroup[1]")));
    		locAccessPopup.click();
    		
    		WebElement menuBtn=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup[1]/android.view.ViewGroup/android.widget.TextView"));
    		menuBtn.click();
    		
    		WebElement logoutBtn=driver.findElement(By.xpath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[2]/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup/android.view.ViewGroup[1]/android.view.ViewGroup[2]/android.widget.ImageView"));
    		logoutBtn.click();
    		
    		WebElement logoutPopup=driver.findElement(By.id("android:id/button1"));
    		logoutPopup.click();
    		
    		driver.quit();
    		System.out.println("Test execution Completed");
    	}
    	    	
    }
    
    static boolean launchApplication() {
    	DesiredCapabilities cap=new DesiredCapabilities();
    	try {
    	cap.setCapability("deviceName", "GalaxyM51");
    	cap.setCapability("udid", "RZ8NA0T713R");
    	cap.setCapability("platformName", "Android");
    	cap.setCapability("appPackage", "com.avegen.together");
    	cap.setCapability("appActivity", "com.avegen.together.MainActivity");
    	cap.setCapability("appium:noReset", true);
    	System.out.println("Started execution");
    	URL url=new URL("http://127.0.0.1:4723/wd/hub");
    	driver=new AppiumDriver(url,cap);
    	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10)) ;
    	wait=new WebDriverWait(driver, Duration.ofSeconds(20));
    	System.out.println("Application Started");
    	}
    	catch(Exception e)
    	{
    		System.out.println("Application not started due to "+e.getMessage());
    		return false;
    	}
    	return true;
    }
    
    public static void scrollAndClick(String visibleText) {
    	driver.findElement(new AppiumBy.ByAndroidUIAutomator("new UiScrollable(new UiSelector().scrollable(true).instance(0)).scrollIntoView(new UiSelector().textContains(\""+visibleText+"\").instance(0))")).click();
   }
       
    
   
}
