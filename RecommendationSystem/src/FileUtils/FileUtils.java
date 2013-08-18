package FileUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

/**
 * Utility class that provides methods to read or write into files
 * 
 */


public class FileUtils {
	public void writetoFile(String filepath, String item) {
		try {

			BufferedWriter out = new BufferedWriter(new FileWriter(filepath,
			        true));
			
				out.write(item);

			out.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public List<String> ReadFile(String filename) {
		List<String> fileContent = new ArrayList<String>();
		try {
			BufferedReader input = new BufferedReader(new FileReader(filename));
			String oneLine = null;
			while ((oneLine = input.readLine()) != null) {
				fileContent.add(oneLine);
			}
			input.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return fileContent;
	}
}
