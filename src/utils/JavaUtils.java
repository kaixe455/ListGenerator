package utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class JavaUtils {
	
	public static List<String> getFilesFromFolder(File folder) {
		List<String> filesPath = new ArrayList<String>();
		File[] listOfFiles = folder.listFiles();

		for (int i = 0; i < listOfFiles.length; i++) {
		  if (listOfFiles[i].isFile()) {
			  filesPath.add(folder.getName() + "/" + listOfFiles[i].getName());
		  }
		}
		
		return filesPath;
	}

}
