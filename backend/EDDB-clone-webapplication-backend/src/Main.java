import model.Settings;
import model.StarSystem;
import tools.DbConnectionManager;
import tools.XmlHandler;

/**
 * Program entry point
 * @author Gilles
 *
 */
public class Main {
	
	private final static String SETTINGS_FILENAME = "settings.xml";
	private final static Settings settings = XmlHandler.readXmlFile(SETTINGS_FILENAME, Settings.class);

	public static void main(String[] args) {
		DbConnectionManager db = new DbConnectionManager(settings);

		for (int i = 0; i < 100; i++) {
			db.insertStarSystem(new StarSystem());
		}
		
		db.deleteAllFromTable("tbl_starsystems");
		
		
	}

}
