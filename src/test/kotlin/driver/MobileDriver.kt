package driver

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.android.AndroidDriver
import io.appium.java_client.ios.IOSDriver
import io.appium.java_client.remote.MobileCapabilityType
import org.openqa.selenium.remote.DesiredCapabilities
import org.testng.Assert
import java.net.URL
import java.util.concurrent.TimeUnit

/**
 * Created by Ekaterina Kelembet on 03.01.2020.
 */

class MobileDriver {
    companion object {
        private val os: OS
        val driver: AppiumDriver<MobileElement>

        init {
            val platformProperty = System.getProperty("platform")
            println("Driver platform: $platformProperty")

            os = when (platformProperty) {
                "iOS" -> OS.IOS
                "Android" -> OS.ANDROID
                else -> {
                    Assert.assertTrue(false, "Please set platform in build.gradle")
                    OS.UNDEFINED
                }
            }

            val capabilities = DesiredCapabilities()
            val serverAddress = URL("http://localhost:4723/wd/hub")


            if (os == OS.ANDROID) {
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "7.0")
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "Pixel 2")
                capabilities.setCapability("appPackage", "com.mapswithme.maps.pro")
                capabilities.setCapability("appActivity", "com.mapswithme.maps.SplashActivity")
                capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, "60");

                driver = AndroidDriver(serverAddress, capabilities)
            } else {
                capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.15.1")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "iOS")
                capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "iPhone Xr")
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "12.4")
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "XCUITest")
                capabilities.setCapability("app", "Users/ekaterinak/Downloads/Creator Connect.app")

                driver = IOSDriver(serverAddress, capabilities)
            }
            driver.manage()?.timeouts()?.implicitlyWait(30, TimeUnit.SECONDS)
        }

    }
}