package model;

import java.util.Random;

/**
 * StarSystem bean class.
 * We assume that one starsystem has only 1 star and 0 or more objects around it.
 * 
 * The star is going to have the name of the system.
 * Its children will use the same name followed by a letter/number
 *  
 * @author Gilles
 *
 */
public class StarSystem {
	//TODO: list of children aka planets
	//TODO: star object(s)
	private Integer idStarSystem;
	private String nameStarSystem;
	private int amountOfStellarObjects;
	
	public StarSystem() {
		this.idStarSystem = generateRandomId();
		this.nameStarSystem = generateRandomSystemName();
		this.amountOfStellarObjects = generateRandomAmountOfStellarObjects();
	}
	
	/**
	 * Generates a random star-id.
	 * NOTE: It's not completely random: duplicates may be possible but are not frequent,
	 * this also isn't the unique identifier for this object.
	 * 
	 * @return Integer
	 * 			The new value for idStarSystem
	 */
	public Integer generateRandomId() {
		Integer number = 0;
		
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		int rand1 = r1.nextInt(100000);
		int rand2 = r2.nextInt(450000);
		int rand3 = r3.nextInt(650000);
		
		number = rand1 - rand2 + rand3;
		
		if (number <= 0) {
			number += r1.nextInt(200000) - r2.nextInt(25000);
		}
		
		return number;
	}
	
	/**
	 * Generates a Random System name.
	 * 
	 * @return String
	 * 			the System name
	 */
	public String generateRandomSystemName() {
		StringBuilder sb = new StringBuilder();
		Random rand = new Random();
		
		//TODO: either get this list from an external file or from DB.
		String[] sectorNames = {
				"america", "europa", "asia", "northern",
				"horse", "southern", "flya", "stroifa",
				"dark", "blie", "plua", "loihoa", "liu",
				"dryoi", "phoo crae", "vegeau", "gatchue",
				"bleae bo", "exap ho", "eodgork", "ongair"
		};
		
		String sector = "-sector-";
		String randomSector = sectorNames[rand.nextInt(sectorNames.length)];
		//append random sector
		sb.append(randomSector);
		//append "-sector-"
		sb.append(sector);
		
		//append random 6 length number
		for (int i = 0; i < 6; i++) {
			String s = "";
			s += rand.nextInt(10);
			sb.append(s);
		}
		
		sb.append("-");
		
		//append letter + 2 length number
		char letter = (char) (rand.nextInt(26) + 'a');
		int randBetweenTenAndHundred = rand.nextInt(100 - 10) + 10;
		String lastPart = "" + letter + randBetweenTenAndHundred;
		sb.append(lastPart);
		
		
		
		return sb.toString();
	}
	
	/**
	 * Method to return a random amount according to a percentage chance.
	 * 
	 * @return
	 */
	public int generateRandomAmountOfStellarObjects() {
		int numberToReturn = 0;
		
		double d = Math.random();
		double d2 = Math.random();
		if (d <= 0.001)
			numberToReturn = 14;
		else if (d <= 0.005)
			numberToReturn = 13;
		else if (d <= 0.01)
			numberToReturn = 12;
		else if (d <= 0.02)
			numberToReturn = 11;
		else if (d <= 0.05)
			numberToReturn = 10;
		else if (d <= 0.10)
			numberToReturn = 9;
		else if (d <= 0.20)
			numberToReturn = 8;
		else if (d <= 0.25)
			numberToReturn = 7;
		else if (d <= 0.30)
			numberToReturn = 6;
		else if (d <= 0.35)
			numberToReturn = 5;
		else if (d <= 0.40)
			numberToReturn = 4;
		else if (d <= 0.45)
			numberToReturn = 3;
		else if (d <= 0.50)
			numberToReturn = 2;
		else if (d <= 1) {
			if (d2 <= 0.7) {
				numberToReturn = 1;
			} else {
				numberToReturn = 0;
			}
		}
		else
			numberToReturn = 0;
		
		return numberToReturn;
	}
	
	@Override
	public String toString() {
		return String.format("Starsystem (ID: %s): %s, %d stellar objects.", this.idStarSystem, this.nameStarSystem, this.amountOfStellarObjects);
	}

	public Integer getIdStarSystem() {
		return idStarSystem;
	}

	public void setIdStarSystem(Integer idStarSystem) {
		this.idStarSystem = idStarSystem;
	}

	public String getNameStarSystem() {
		return nameStarSystem;
	}

	public void setNameStarSystem(String nameStarSystem) {
		this.nameStarSystem = nameStarSystem;
	}

	public int getAmountOfStellarObjects() {
		return amountOfStellarObjects;
	}

	public void setAmountOfStellarObjects(int amountOfStellarObjects) {
		this.amountOfStellarObjects = amountOfStellarObjects;
	}
}
