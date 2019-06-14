package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class NkTests {

    WebDriver driver;
    DashboardPage dashboardPage;

    @BeforeSuite
    public void setUp() {
        System.setProperty(
                "webdriver.gecko.driver",
                "C:\\Users\\joann\\Downloads\\geckodriver-v0.24.0-win32\\geckodriver.exe"
        );
        driver = new FirefoxDriver();
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://nk.pl");
    }

    @BeforeTest
    public void setUpTest() {
        logIn();
    }

    private void logIn() {
        PrivacyAgreementPage privacyAgreementPage = new PrivacyAgreementPage(driver);
        privacyAgreementPage.clickAgree();
        LoginPage loginPage = new LoginPage(driver);
        loginPage.fillLoginForm("bucccccc@gmail.com","testowanie");

        dashboardPage = loginPage.submitLoginForm();
        waitSeconds(3);
    }

    @Test
    public void changeNameTest() {
        EditProfilePage editProfilePage = dashboardPage.goToEditProfilePage();
        String randomString = "Test" + new Random().nextInt();
        editProfilePage.changeNameTo(randomString);
        editProfilePage.submitEditProfileForm();
        dashboardPage = editProfilePage.backToDashboardPage();

        Assert.assertTrue(dashboardPage.doesNameContain(randomString));
    }

    @Test
    public void searchingTest() {
        dashboardPage.search("Joanna Urbańska");
        SearchingPage searchingPage = dashboardPage.clickSearch();

        Assert.assertTrue(searchingPage.isPaginationVisible());
    }

    @Test
    public void postingTest() {
        String randomString = "Post no. " + new Random().nextInt();
        dashboardPage.sendPost(randomString);
        waitSeconds(2);
        Assert.assertTrue(dashboardPage.isPostVisible(randomString));
    }

    @Test
    public void successLoginTest() {
        Assert.assertTrue(dashboardPage.isLogoutButtonDisplayed());
    }

    @Test
    public void successLogoutTest() {
        LogoutPage logoutPage = dashboardPage.logout();

        Assert.assertTrue(logoutPage.isLoggedOut());
    }

    private void waitSeconds(Integer seconds) {
        try { Thread.sleep(seconds * 1000); } catch (Exception e) {}
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}