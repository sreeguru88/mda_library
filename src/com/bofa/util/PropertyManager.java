package com.bofa.util;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.event.ConfigurationListener;
import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.compare.ObjectToStringComparator;
public class PropertyManager {
	//@author-sreedhar

	public Properties prop;
	public static propertyUtil propUtil;
	public PropertyManager()
	{
		prop= new Properties();
	}
	
	public void getPropertiesList(String loc)
	{
		try {
			//getbundle();
			prop.load(PropertyManager.class.getClassLoader().getResourceAsStream(loc));
			System.out.println(prop.getProperty("DEVICE_ID"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static propertyUtil getbundle() throws ConfigurationException, FileNotFoundException
	{
		if(null==propUtil)
		{
			propUtil= initializeConfigration();
			
		}
		return propUtil;
		
	}

	
	protected static propertyUtil initializeConfigration() throws ConfigurationException, FileNotFoundException {
		
		// TODO Auto-generated method stub
		
		propUtil= new propertyUtil(System.getProperty("applications.properties.file", "src/script.properties")) ;
		//propUtil.load((new FileInputStream("src/script.properties")));
		
		//ConfigurationListener c1 = new PropertyConfigrationListener();
		//propertyUtil p1= new propertyUtil();
		//p1.load(System.getProperty("applications.properties.file", "src/script.properties"));
		//propUtil.addConfigurationListener(p1);
		return propUtil;
	}
	
	
	private static void addBundle(String Filedir)
	{
		File resourceFile = new File(Filedir);
		if(resourceFile.exists())
		{
			if(resourceFile.isDirectory())
			{
			//	File[] propfiles= FileUtil.listFiles(".properties");
				File[] propfiles= FileUtil.listFileAsArray(resourceFile);

			}
		}
	}
	
	public  Properties FileLoad(FileInputStream F)
	{
		if(F!=null)
		{
			try {
				prop.load(F);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return prop;
		
	}

}
