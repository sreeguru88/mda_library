package com.bofa.core;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bofa.core.driver.IMobileDriver;
import com.bofa.core.driver.MobileDriverFactory;
import com.bofa.core.objectlocator.XpathGenerator;
import com.bofa.core.objectlocator.XpathGenerator.AutomationTool;
import com.bofa.core.objectlocator.XpathGenerator.DeviceType;
import com.bofa.util.PropertyManager;
//@author-sreedhar
public class BofaLibraryBase {

	public String DeviceID = "";
	public static XpathGenerator.DeviceType devicetype;
	public IMobileDriver mobiledriverInstance;

	private Logger logger = LogManager.getLogger(BofaLibraryBase.class);

	public BofaLibraryBase(String deviceID, String deviceType, PropertyManager propmanager, int loading,
			AutomationTool tool, int timeout) {
		logger.debug(Thread.currentThread().getName() + "Start of Bofalib Constructor");
		deviceType="IPHONE";
		if (deviceType.equalsIgnoreCase("IPHONE")) {
			BofaLibraryBase.devicetype = DeviceType.IPHONE;
		}
		if (deviceType.equalsIgnoreCase("ANDROID")) {
			BofaLibraryBase.devicetype = DeviceType.ANDROID;
		} else {
			BofaLibraryBase.devicetype = DeviceType.IPAD;
		}

		MobileDriverFactory mobDriverFact = new MobileDriverFactory();
		logger.info(Thread.currentThread().getName() + "Driver Factory Object Created" + tool);
		mobiledriverInstance = mobDriverFact.createMobileDriver(tool);
	}
	
	public void InitializeMobileDriver () throws Exception
	{
		logger.debug(Thread.currentThread().getName()+"Initialize driver method");
		mobiledriverInstance.initializeMobileDriver(this.DeviceID);
	}

	public String getDeviceID()
	{
		return mobiledriverInstance.getDeviceID();
	}
}
