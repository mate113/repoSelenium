package driver;

public enum BrowserType {
    CHROME("chrome"),
    FIREFOX("firefox"),
    IE("internetExplorer");

    private final String browser;

    BrowserType(String browser) {
        this.browser = browser;
    }
}
