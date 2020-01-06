package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory

/**
 * Created by Ekaterina Kelembet on 02.01.2020.
 */
abstract class BasePage (private val driver: AppiumDriver<*>) {
    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this)
    }
}