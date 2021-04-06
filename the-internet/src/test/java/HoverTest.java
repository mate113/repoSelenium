import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class HoverTest extends TestBase{

    @Test
    public void hoverOverTheAvatarTest(){
        WebElement addRemoveElement = driver.findElement(By.cssSelector("a[href*='hovers']"));
        addRemoveElement.click();

        List<WebElement> userAvatars = driver.findElements(By.cssSelector(".figure"));
        List<WebElement> userNames = driver.findElements(By.cssSelector(".figcaption"));
        Actions actions = new Actions(driver);

        userNames.forEach(name -> assertFalse(name.isDisplayed()));

        for (int i = 0; i < userAvatars.size(); i++) {
            actions.moveToElement(userAvatars.get(i)).perform();
            for (int j = 0; j < userNames.size(); j++) {
                if (j==i) assertTrue(userNames.get(j).isDisplayed());
                else assertFalse(userNames.get(j).isDisplayed());
            }
        }
    }
}
