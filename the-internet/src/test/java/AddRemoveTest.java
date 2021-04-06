import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertTrue;


public class AddRemoveTest extends TestBase{

    @Test
    public void addRemoveTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='add_remove']"));
        addRemoveElement.click();

        WebElement addButton = driver.findElement(By.cssSelector("button"));
        addButton.click();

        List<WebElement> elements = driver.findElements(By.className("added-manually"));
        int elementsCount = elements.size();
        assertTrue(elementsCount == 1);

        elements.get(0).click();

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 0);

        for (int i = 0; i < 5; i++) {
            addButton.click();
        }

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 5);

        elements.forEach(WebElement::click);

        elements = driver.findElements(By.className("added-manually"));
        elementsCount = elements.size();

        assertTrue(elementsCount == 0);
    }
}
