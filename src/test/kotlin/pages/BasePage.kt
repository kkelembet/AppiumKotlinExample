package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.pagefactory.AppiumFieldDecorator
import org.openqa.selenium.support.PageFactory
import util.OS

/**
 * Created by Ekaterina Kelembet on 02.01.2020.
 */
abstract class BasePage (val driver: AppiumDriver<*>) {

    private val os = if (driver is AndroidDriver) OS.ANDROID else OS.IOS

    init {
        PageFactory.initElements(AppiumFieldDecorator(driver), this.os)
    }
}