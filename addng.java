package qa;

import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class addng {
	static WebDriver wb = new FirefoxDriver();
	JavascriptExecutor js=(JavascriptExecutor) wb;
	public static void main(String args[])
	{	addng obj=new addng();
		
		wb.get("http://10.0.1.86/tatoc/basic/grid/gate");
		String s, s1;
		JavascriptExecutor js=(JavascriptExecutor) wb;
//		wb.findElement(By.cssSelector("div.greenbox")).click();
		
		List<WebElement> web=obj.element("div.greenbox");
		web.get(0).click();
		wb.switchTo().frame(0);
//		s = wb.findElement(By.cssSelector("div#answer")).getAttribute("class");
		List<WebElement> web1=obj.element("div#answer");
		s=web1.get(0).getAttribute("class");
		wb.switchTo().frame("child");
//		s1 = wb.findElement(By.cssSelector("div#answer")).getAttribute("class");
		List<WebElement> web2=obj.element("div#answer");
		s1=web2.get(0).getAttribute("class");
		while (true) 
		{
			wb.switchTo().defaultContent();
			wb.switchTo().frame(0); 
			List<WebElement> web6=obj.element("a");
			if (!(s.equals(s1))) 
			{
				System.out.println(s + " and " + s1 + "\n");
//				wb.findElement(By.linkText("Repaint Box 2")).click();
//				List<WebElement> web6=obj.element("a");
				web6.get(0).click();
				
				wb.switchTo().frame("child");
				web1 = obj.element("div#answer");
				s1=web1.get(0).getAttribute("class");
				System.out.println("not equals\n");
			} 
			else 
			{
				web6.get(1).click();
				break;
			}
		}
			web2=obj.element("#dragbox");
			web1=obj.element("#dropbox");
		    
		  Actions builder = new Actions(wb);  // Configure the Action
		  Action dragAndDrop = builder.clickAndHold(web2.get(0))
		    .moveToElement(web1.get(0))
		    .release(web1.get(0))
		    .build();  // Get the action
		    dragAndDrop.perform();
		    web=obj.element("a");
		    web.get(0).click();

//		    wb.findElement(By.linkText("Launch Popup Window")).click();
		    web1=obj.element("a");
		    web1.get(0).click();
		    String winHandleBefore = wb.getWindowHandle();

		    
		    for(String winHandle : wb.getWindowHandles()){
		        wb.switchTo().window(winHandle);
		    }
		    //wb.findElement(By.cssSelector("input#name")).sendKeys("heyaa");
		    web2=obj.element("#name");
		    web2.get(0).sendKeys("heyaa");
//		    wb.findElement(By.cssSelector("input#submit")).click();
		    web2=obj.element("input#submit");
		    web2.get(0).click();
		    wb.switchTo().window(winHandleBefore);
		    web1=obj.element("a");
		    		web1.get(1).click();
		   
		    		web1=obj.element("a");
		    		web1.get(0).click();
		   web2=obj.element("#token");
		   String s2=web2.get(0).getText();
		   String s3=s2.substring(7);
		   System.out.println(s3);
		   Cookie name = new Cookie("Token", s3);
			wb.manage().addCookie(name);
			web1=obj.element("a");
    		web1.get(1).click();
		    
	}
	public List element(String id)
	{List<WebElement> script=(List<WebElement>) js.executeScript("return document.querySelectorAll('"+id+"')");
		return script;
		
	}
	
}