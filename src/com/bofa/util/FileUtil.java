package com.bofa.util;

import java.io.File;
import java.io.FilenameFilter;
import java.nio.file.Files;
import java.util.Collection;
import java.util.Vector;

import org.apache.commons.io.FileUtils;
//@author-sreedhar

public class FileUtil extends FileUtils {
	
	public static File[] listFileAsArray(File dir,FilenameFilter filter,boolean recurse)
	{
		Collection<File> files =listFiles(dir,filter,recurse);
		File[] arr = new File[files.size()];
 		return files.toArray(arr);
		
	}

	public static File[] listFileAsArray(File dir)
	{
		Collection<File> files =listFiles(dir);
		File[] arr = new File[files.size()];
 		return files.toArray(arr);
		
	}
	static Collection<File> listFiles(File dir) {
		// TODO Auto-generated method stub
		
		Vector<File> files = new Vector<File>();
		File[] entries = dir.listFiles();
		for(File entry:entries)
		{
			
				files.add(entry);
		}
		return files;
	}

	private static Collection<File> listFiles(File dir, FilenameFilter filter, boolean recurse) {
		// TODO Auto-generated method stub
		
		Vector<File> files = new Vector<File>();
		File[] entries = dir.listFiles();
		for(File entry:entries)
		{
			if((filter==null)|| filter.accept(dir, entry.getName()))
			{
				files.add(entry);
			}
			
			if(recurse&& entry.isDirectory()&& !entry.isHidden())
			{
				files.addAll(listFiles(entry,filter,recurse));
			}
		}
		return files;
	}

}
