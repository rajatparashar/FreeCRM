package com.qa.freecrm.base;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageBase {
	private static final int TIMEOUT = 50;
	private static final int POLLING = 100;

	protected WebDriver driver;
	private WebDriverWait wait;

	public PageBase(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, TIMEOUT, POLLING);
		PageFactory.initElements(new AjaxElementLocatorFactory(driver, TIMEOUT), this);
	}

//	public WebElement findElement(WebElement parentElem, String sLocatorType, String sValue) {
//		WebElement retElem = null;
//		try {
//			retElem = pingDOMToFindElement( parentElem, sLocatorType, sValue);
//			if(retElem.isDisplayed() == false) {
//				System.out.println("Element is not visible");
//			}
//			
//		} catch (Exception e) {
//			retElem = null;
//		}
//		return retElem; 
//	}
//	
//	public WebElement pingDOMToFindElement(final WebElement parentElem, final String sLocatorType, final String sValue) {
//		WebElement retElem = (new WebDriverWait(driver, 10)).until(new ExpectedCondition<WebElement>() {
//			public WebElement apply(WebDriver driver) {
//				WebElement elem = null;
//				if(parentElem == null) {
//					if(sLocatorType.equals("name")) {
//						elem = driver.findElement(By.name(sValue));
//					}
//					else if(sLocatorType.equals("id")) {
//						elem = driver.findElement(By.id(sValue));
//					}
//				}
//				else {
//					if(sLocatorType.equals("name")) {
//						elem = parentElem.findElement(By.name(sValue));
//					}
//					else if(sLocatorType.equals("id")) {
//						elem = parentElem.findElement(By.id(sValue));
//					}
//				}
//				return elem;
//			}});
//		return retElem;		
//	}

}