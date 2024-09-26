package com.bofa.core.driver;

import java.net.URL;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.bofa.util.PropertyManager;
import com.bofa.util.propertyUtil;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
//@author-sreedhar

public class MobileDriver_BAFExtended implements IMobileDriver {

	String deviceTypeString;
	public AppiumDriver<MobileElement> mobiledriver;
	Logger logger = LogManager.getLogger(MobileDriver_BAFExtended.class);

	@Override
	public void initializeMobileDriver(String deviceID) throws Exception {
		// TODO Auto-generated method stub
		logger.debug(Thread.currentThread().getName() + "start of Initialize Mobile Driver method");
		//propertyUtil prop = new propertyUtil();
		DesiredCapabilities capabilities = new DesiredCapabilities();
		URL gridURL = new URL(PropertyManager.getbundle().getString("APPIUM_HOST_URL"));
		String cloud = PropertyManager.getbundle().getString("CLOUD");

		logger.debug(Thread.currentThread().getName() + "Appium host url" + gridURL);
		logger.debug(Thread.currentThread().getName() + "Deviceid" + deviceID);
		logger.debug(Thread.currentThread().getName() + "cloud" + cloud);

		logger.debug(Thread.currentThread().getName() + "platform" + PropertyManager.getbundle().getString("PLATFORM"));

		logger.debug(Thread.currentThread().getName() + "automationname"
				+ PropertyManager.getbundle().getString("AUTOMATION"));
		logger.debug(Thread.currentThread().getName() + "driverclass"
				+ PropertyManager.getbundle().getString("DRIVER_CLASS"));

		logger.debug(
				Thread.currentThread().getName() + "bundleid" + PropertyManager.getbundle().getString("BUNDLE_ID"));

		logger.debug(Thread.currentThread().getName() + "bundleidsim"
				+ PropertyManager.getbundle().getString("BUNDLE_ID_SIM"));

		capabilities.setCapability("platformname", PropertyManager.getbundle().getString("PLATFORM"));
		capabilities.setCapability("driverclass", PropertyManager.getbundle().getString("DRIVER_CLASS"));
		capabilities.setCapability("automationName",
				deviceTypeString.equalsIgnoreCase("android") ? "uiAutomator2" : "XCUITest");

		capabilities.setCapability("noReset", "true");
		capabilities.setCapability("fullReset", "false");

		if (deviceTypeString.equalsIgnoreCase("Android")) {
			capabilities.setCapability("appPackage", PropertyManager.getbundle().getString("APP_PACKAGE"));
			capabilities.setCapability("appActivity", PropertyManager.getbundle().getString("APP_ACTIVITY"));
//			capabilities.setCapability("gigafox:username",System.getenv("cloudUser"));
//			capabilities.setCapability("gigafox:apiKey",System.getenv("securityToken")); --> fetching from secuirity from ecliple

			capabilities.setCapability("waitForQuiescence", false);
			mobiledriver = new AndroidDriver<MobileElement>(new URL(gridURL.toString()), capabilities);

		} else {
			capabilities.setCapability("bundleId", PropertyManager.getbundle().getString("BUNDLE_ID"));
			capabilities.setCapability("appActivity", PropertyManager.getbundle().getString("BUNDLE_ID_SIM"));
			mobiledriver = new AppiumDriver<MobileElement>(new URL(gridURL.toString()), capabilities);

		}
		mobiledriver= getnativeDriver();
	}

	private AppiumDriver<MobileElement> getnativeDriver() {
		// TODO Auto-generated method stub
		//mobiledriver=(AppiumDriver<MobileElement>) mobiledriver.context("NATIVE_APP");
		return mobiledriver;
	}
	private AppiumDriver<MobileElement> getvisualDriver() {
		// TODO Auto-generated method stub
		//mobiledriver=(AppiumDriver<MobileElement>) mobiledriver.context("VISUAL");
		return mobiledriver;
	}
	private AppiumDriver<MobileElement> getwebviewDriver() {
		// TODO Auto-generated method stub
		//mobiledriver=(AppiumDriver<MobileElement>) mobiledriver.context("WEBVIEW");
		return mobiledriver;
	}

	@Override
	public String getDeviceID() {
		// TODO Auto-generated method stub
		return null;
	}

}
