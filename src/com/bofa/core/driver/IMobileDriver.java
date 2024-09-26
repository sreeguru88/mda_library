package com.bofa.core.driver;

public interface IMobileDriver {
	//@author-sreedhar

	public void initializeMobileDriver(String deviceID) throws Exception;

	public String getDeviceID();
}
