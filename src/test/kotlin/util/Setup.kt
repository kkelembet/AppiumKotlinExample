package util

import org.openqa.selenium.remote.DesiredCapabilities
import io.appium.java_client.android.AndroidDriver
import java.net.URL
import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.testng.annotations.AfterTest
import org.testng.annotations.BeforeTest
import java.util.concurrent.TimeUnit


/**
 * Created by Ekaterina Kelembet on 03.01.2020.
 */
open class Setup {

    var os: OS = OS.ANDROID
    var driver: AppiumDriver<MobileElement>? = null

    @BeforeTest
    fun setup() {
        os = OS.valueOf(System.getProperty("platform", OS.ANDROID.name))
        val capabilities = DesiredCapabilities()
        val serverAddress = URL("http://127.0.0.1:4723")

        if (os == OS.ANDROID) {
            capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0")
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2")
            capabilities.setCapability("appPackage", "com.mapswithme.maps.pro")
            capabilities.setCapability("appActivity", "com.mapswithme.maps.SplashActivity")

            driver = AndroidDriver(serverAddress, capabilities)
        } else {
            capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1")
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
            capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone SE")
            capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")

            driver = IOSDriver(serverAddress, capabilities)
        }
        driver?.let {
            it.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        }
    }

    @AfterTest
    fun tearDown() {
        driver?.quit()
    }
}
