package tools;

import java.io.File;

import javax.xml.bind.*;


/**
 * Helper class to read and write from and to XML files.
 * 
 * @author Gilles
 *
 */
public class XmlHandler {
	
	@SuppressWarnings("unchecked")
	public static <T> T readXmlFile(String filename, Class<T> clasz) {
		try {
			File xml = new File(filename);	
			JAXBContext jc = JAXBContext.newInstance(clasz);
			Unmarshaller unmarshaller = jc.createUnmarshaller();
			
			T type = (T) unmarshaller.unmarshal(xml);
			
			return type;
		} catch (Exception e) {
			System.err.println("Error unmarshalling xml file: " + e.getMessage());
			e.printStackTrace();
		}
		return null;
		
	}
}
