package com.qualitystream.tutorial;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class GoogleSearchTest {
	
	private WebDriver driver;
	
	@Before
	public void setUp() 
	{
		System.setProperty("webdriver.chrome.driver", "./src/test/resource/chromedriver/chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize(); // Maximiza la ventana
		driver.get("https://www.google.com/"); // Abre el link deseado
	}
	
	@Test
	public void testGooglePage() 
	{
		WebElement searchbox = driver.findElement(By.name("q"));
		searchbox.clear(); // Limpia la caja
		searchbox.sendKeys("quality-stream Introducción a la Automatización de Pruebas de Software"); // envía el mensaje
		searchbox.submit(); // es como dar enter
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);// Tiempo de espera, evita falsos positivos
		
		assertEquals("quality-stream Introducción a la Automatización de Pruebas de Software - Google Search", driver.getTitle());
	}
	

	@After
	public void tearDown()
	{
		driver.quit();
	}

}
