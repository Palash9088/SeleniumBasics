package Assignment;//import java.util.*;

import Base.PredefinedActions;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class Assignment5MultiDropDown extends PredefinedActions {
    WebDriver driver;
    void startBrowser(String url)
    {
        driver = start(url);
    }
    void scrollDownToMulti()
    {
        System.out.println("Step -> Opening Basic Element");
        driver.findElement(By.linkText("Basic Elements")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println("Step -> Scroll to Dropdown");
        // Made JavaScript Executor
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView();",driver.findElement(By.xpath("//select[2]")));

        System.out.println("Print all available options in the DropDown");
        WebElement element = driver.findElement(By.xpath("//select[2]"));
        Select elementSelect = new Select(element); //Object of Select for dropdown
        List <WebElement> optionsList = elementSelect.getOptions();

        System.out.println("Total number of options are : " +  optionsList.size());
        System.out.print("Options available are : ");
        for(WebElement options : optionsList )
        {
            System.out.print(options.getText() + " ");
        }

        System.out.println("Step -> Select all Even Options : ");
        for(WebElement options : optionsList)
        {
            int num  = Integer.parseInt(options.getText()); //to get text into integer
            if(num%2 == 0)
            {
                String evenNum = options.getText(); // to convert integer text into string
                elementSelect.selectByVisibleText(String.valueOf(evenNum));
                System.out.print(options.getText() + " ");
            }
        }

        System.out.println("Step -> Print all Selected options");
        List <WebElement> selectedOptionsList = elementSelect.getAllSelectedOptions();
        for(WebElement SelectedOptions : selectedOptionsList)
        {
            System.out.println("Selected Options are :" + SelectedOptions.getText());
        }

        System.out.println("Step -> Print all Deselect options");
        for(WebElement deselectedOptions : optionsList )
        {
            if(!deselectedOptions.isSelected())
            {
                System.out.println("Options which are not selected :" + deselectedOptions.getText());
            }
        }

        System.out.println("Step -> Deselect all the options");
        elementSelect.deselectAll();

        System.out.println("Verify options are deselected");
        if(elementSelect.getAllSelectedOptions().size() == 0)
        {
            System.out.println("Test Passed all options are deselected");
        }
        else
        {
            System.out.println("Test Failed options are not deselected");
        }

    }
    void printAllOptions()
    {
        System.out.println("Print all available options in the DropDown");
        WebElement element = driver.findElement(By.xpath("//select[2]"));
        Select elementSelect = new Select(element); //Object of Select for dropdown
        List <WebElement> optionsList = elementSelect.getOptions();

        System.out.println("Total number of options are :" +  optionsList.size());
        for(WebElement options : optionsList )
        {
            System.out.println(" Options are :" +  options.getText());
        }
    }

    public static void main(String[] args) {
        Assignment5MultiDropDown multiDropDownAssignment5 = new Assignment5MultiDropDown();
        multiDropDownAssignment5.startBrowser("http://automationbykrishna.com/");
        multiDropDownAssignment5.scrollDownToMulti();
        multiDropDownAssignment5.printAllOptions();
    }
}
