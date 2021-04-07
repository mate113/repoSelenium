package driver.manager;

public class DriverUtils {

    public static void setInitialConfiguration(){
        DriverManager.getDriver().manage().window().maximize();
    }

    public static void navigateTo(String url){
        DriverManager.getDriver().navigate().to(url);
    }
}
