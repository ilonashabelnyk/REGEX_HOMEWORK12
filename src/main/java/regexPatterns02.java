import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class regexPatterns02 {
    public static String getValueByRegEx(String text, String pattern, int group) {
        Pattern replacementPattern = Pattern.compile(pattern);
        Matcher matcher = replacementPattern.matcher(text);
        matcher.find();
        return matcher.group(group);
    }

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.epam.com/about/who-we-are/contact");
        WebElement centralTextWebelement = driver.findElement(By.cssSelector("p:nth-child(1) b span span"));
        String centralText = centralTextWebelement.getText();
        System.out.println("The text from the webpage is got by Driver: " + centralText);
        driver.quit();

        //"41 University Drive • Suite 202,\n Newtown, PA 18940 • USA";

        List<String> centralTextFirstSplit = Arrays.asList(centralText.split("•"));
        String streetNameAndNumber = centralTextFirstSplit.get(0);
        String streetName = getValueByRegEx(streetNameAndNumber, "([A-Za-z])(.+)(\\s?)", 0).trim();
        String streetNumber = getValueByRegEx(streetNameAndNumber, "(\\d+)", 0);

        List<String> centralTextSecondSplit = Arrays.asList(centralTextFirstSplit.get(1).split(","));

        String officeNameAndNumber = centralTextSecondSplit.get(0);
        String officeNumber = getValueByRegEx(officeNameAndNumber, "\\d.+", 0);

        String cityNameSplit = centralTextSecondSplit.get(1).trim();
        String cityName = getValueByRegEx(cityNameSplit, "([A-Za-z])(.+)(\\s?)", 0);


        String stateAndPostalCode  = centralTextSecondSplit.get(2).trim();
        String stateName = getValueByRegEx(stateAndPostalCode, "([A-Z]{2})", 0);
        String postalCode = getValueByRegEx(stateAndPostalCode, "(\\d{5})", 0);


        String countryNameSplit = centralTextFirstSplit.get(2).trim();
        String countryName = getValueByRegEx(countryNameSplit, "([A-Za-z])(.+)(\\s?)", 0);

        System.out.println("Street name is: " + streetName);
        System.out.println("Street number is: " + streetNumber);
        System.out.println("Office number is: " + officeNumber);
        System.out.println("City name is: " + cityName);
        System.out.println("State is: " + stateName);
        System.out.println("Postal code is: " + postalCode);
        System.out.println("Country name is: " + countryName);
    }
}