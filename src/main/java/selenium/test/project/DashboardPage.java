package selenium.test.project;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class DashboardPage {

    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    public boolean isLogoutButtonDisplayed() {
        System.out.println(driver.getCurrentUrl());
        return driver.findElement(By.xpath("//html/body/div/div[1]/div[2]/div[2]/div[1]/div/div/ul/li[3]")).isDisplayed();
    }

    public DashboardPage search(String name){
        driver.findElement(By.id("id-q")).sendKeys(name);
        return this;
    }

    public SearchingPage clickSearch(){
        driver.findElement(By.xpath("/html/body/div/div[1]/div[2]/div[2]/div[2]/form/div/button/span[1]")).click();
        return new SearchingPage(driver);
    }

    public EditProfilePage goToEditProfilePage() {
        driver.findElement(By.cssSelector("button.details-actions__button")).click();
        driver.findElement(By.linkText("Edycja profilu")).click();
        return new EditProfilePage(driver);
    }

    public LogoutPage logout() {
        driver.findElement(By.xpath("//html/body/div/div[1]/div[2]/div[2]/div[1]/div/div/ul/li[3]")).click();
        return new LogoutPage(driver);
    }

    public DashboardPage sendPost(String content) {
        WebElement postField = driver.findElement(By.xpath("//*[@id=\"form1_content\"]"));
        postField.sendKeys(content);
        postField.submit();
        return this;
    }

    public boolean isPostVisible(String content) {
        WebElement postList = driver.findElement(By.xpath("//*[@id=\"shout_collection\"]"));
        List<WebElement> posts = postList.findElements(By.className("parser"));
        for(WebElement post : posts) {
            String postText = post.getText();
            if (postText.equals(content)) {
                return true;
            }
        }
        return false;
    }

    public boolean doesNameContain(String string) {
        String currentName = driver.findElement(By.xpath("/html/body/div/div[1]/div[4]/div[1]/div/div/div[2]/h1/a")).getText();
        return currentName.contains(string);
    }
}
