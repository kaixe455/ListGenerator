package utils;

import java.io.FileWriter;
import java.util.List;

import com.opencsv.CSVWriter;

public class CsvUtils {
	
	public static void listToCsv (List<String> files) {
		try (CSVWriter writer = new CSVWriter(new FileWriter("outputfiles/list.csv"))) {
			for (String file : files) {
					String[] data = { file };
			        writer.writeNext(data);
			        System.out.println("Escribiendo" + file);			
			}
	        System.out.println("Finalizado");
	    } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
