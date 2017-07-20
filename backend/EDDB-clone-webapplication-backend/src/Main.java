import model.Settings;
import tools.XmlHandler;

public class Main {
	
	private final static String SETTINGS_FILENAME = "settings.xml";

	public static void main(String[] args) {
		Settings s = XmlHandler.readXmlFile(SETTINGS_FILENAME, Settings.class);
		
		System.out.println(s.getVersion());
	}

}
