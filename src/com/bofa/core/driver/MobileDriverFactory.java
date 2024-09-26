package com.bofa.core.driver;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.bofa.core.objectlocator.XpathGenerator.AutomationTool;
//@author-sreedhar

public class MobileDriverFactory {

	private Logger logger = LogManager.getLogger(MobileDriverFactory.class);

	public IMobileDriver createMobileDriver(AutomationTool tool) {
		logger.debug(Thread.currentThread().getName() + "Start : CreateMobileDriver Method");
		IMobileDriver mobiledriver = null;
		if (AutomationTool.SEETEST == tool) {
			mobiledriver = new MobileDriver_SeeTest();
			
		} else if (AutomationTool.BAF_EXTENDED == tool) {
			mobiledriver = new MobileDriver_BAFExtended();
		}
		return mobiledriver;
	}

}
