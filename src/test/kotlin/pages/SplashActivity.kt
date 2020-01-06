package pages

import io.appium.java_client.AppiumDriver
import io.appium.java_client.MobileElement
import io.appium.java_client.pagefactory.iOSXCUITBy
import io.appium.java_client.pagefactory.AndroidFindBy


/**
 * Created by Ekaterina Kelembet on 02.01.2020.
 */

class SplashActivity(driver: AppiumDriver<MobileElement>) : BasePage(driver) {

    @AndroidFindBy(id = "com.mapswithme.maps.pro:id/tv__title")
    @iOSXCUITBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeTextField")
    private var tvTitle: MobileElement? = null

    @AndroidFindBy(id = "com.mapswithme.maps.pro:id/privacy_policy_welcome_checkbox")
    @iOSXCUITBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeSecureTextField")
    private var privacyPolicyCheckbox: MobileElement? = null

    @AndroidFindBy(id = "com.mapswithme.maps.pro:id/term_of_use_welcome_checkbox")
    @iOSXCUITBy(xpath = "//XCUIElementTypeApplication/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeStaticText")
    private var termsOfUseCheckbox: MobileElement? = null

    fun isSplashScreenOpens(): Boolean {
        return tvTitle?.text == "MAPS.ME\n" + "All-in-one travel buddy"
    }

    fun agreeToPrivacyPolicyAndTermsOfUse(): SplashActivity {
        privacyPolicyCheckbox?.click()
        termsOfUseCheckbox?.click()
        return this
    }

    fun isAccessViewOpens(): Boolean {
        return tvTitle?.text == "Allow MAPS.ME access to storage and location"
    }


}