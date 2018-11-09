package de.oio.maven.uebung.test;


import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Locale;

import org.apache.commons.io.FileUtils;

public class App{
    public static void main( String[] args ){
    	System.out.println("bla");
        File localizedFile = getLocalizedFile();
   
		try {
			String localizedText = FileUtils.readFileToString(localizedFile,Charset.defaultCharset());
			System.out.println(localizedText);
		} catch (IOException e) {}
    }

	private static File getLocalizedFile() {
		HashMap<Locale, File> fileMap = doAsIfRetrievingFiles();
//		File localizedFile = fileMap.get(Locale.getDefault());
		File localizedFile = fileMap.get(Locale.ENGLISH);
		if(localizedFile != null) {
			return localizedFile;
		}else {
			return fileMap.get(Locale.ENGLISH);
		}
	}
// hello bla
	private static HashMap<Locale, File> doAsIfRetrievingFiles(){
		File engFile = new File("HelloWorld.txt");
    	File gerFile = new File("HalloWelt.txt");
		HashMap<Locale, File> fileMap = new HashMap<Locale, File>();
    	fileMap.put(Locale.ENGLISH, engFile);
    	fileMap.put(Locale.GERMANY, gerFile);
		try {
	    	FileUtils.writeStringToFile(engFile, "Hello World!",Charset.defaultCharset());
	    	FileUtils.writeStringToFile(gerFile, "Hallo Welt!",Charset.defaultCharset());
		} catch (IOException e) {}
    	return fileMap;
	}
}
