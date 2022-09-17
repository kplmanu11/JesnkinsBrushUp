package utility;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class base {

	public static WebDriver driver;
	public Properties prop;
	
	public WebDriver initializeDriver() throws IOException {
		prop = new Properties();
		FileInputStream fis = new FileInputStream("D:\\Test\\Demo\\src\\main\\java\\utility\\data.properties");
		prop.load(fis);
		String browserName = prop.getProperty("browser");
				
		if(browserName.equals("edge")) {
			System.setProperty("webdriver.edge.driver","D:\\Test\\edgedriver_win64\\msedgedriver.exe");
			driver = new EdgeDriver();
		}
		else if(browserName.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver","D:\\Test\\chromedriver_win32\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.manage().window().maximize();
		
		return driver;
		
	}


	
}
