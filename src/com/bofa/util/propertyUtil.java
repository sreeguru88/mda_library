package com.bofa.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import org.apache.commons.configuration.ConfigurationException;
import org.apache.commons.configuration.PropertiesConfiguration;
import org.apache.commons.configuration.XMLConfiguration;
//@author-sreedhar

public class propertyUtil extends XMLConfiguration {
	//Properties prop;
	public propertyUtil() {
		super();
		// prop= new Properties();

		setDelimiterParsingDisabled(true);
	}
	public propertyUtil(propertyUtil prop) {
		this();
		append(prop);
	}
	public propertyUtil(String... file) {
		this();
		load(file);
		System.out.println(file.length);
	}

	public boolean load(String... file) {
		boolean r = true;
		for (String filep : file) {
			filep=getSubstitutor().replace(filep);
		}
		return r;

	}
	
	public boolean load(File... files) {
		boolean r = true;
		for (File file : files) {
			loadFile(file);
		}
		return false;

	}
	

	
	
	private boolean loadFile(File file) {
		try {
			if (file.getName().endsWith("xml") || file.getName().contains(".xml.")) {
				load(new FileInputStream(file));
			} else {

				PropertiesConfiguration propconfig = new PropertiesConfiguration();
				propconfig.setEncoding("UFT-8");
				propconfig.setDelimiterParsingDisabled(true);
				propconfig.load(new FileInputStream(file));
				copy(propconfig);
				propconfig.clear();

			}
		} catch (ConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return false;

	}
    
//    public propertyUtil(){
//         
//        InputStream is;
//        try {
//            this.prop = new Properties();
//            is = propertyUtil.class.getResourceAsStream("/scripts.properties");
//            prop.load(is);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
     
//    public String getPropertyValue(String key){
//    	System.out.println(key);
//    	//return (String) PropertyManager.getbundle().getProperty(key);
//        return this.prop.getProperty(key);
//    }

}
