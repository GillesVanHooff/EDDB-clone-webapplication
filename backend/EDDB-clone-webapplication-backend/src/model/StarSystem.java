package model;

import java.util.Random;

public class StarSystem {
	private Integer idStarSystem;
	private String nameStarSystem;
	private int amountOfStellarObjects;
	
	public StarSystem() {
		this.idStarSystem = generateRandomId();
		this.nameStarSystem = generateRandomSystemName();
		this.amountOfStellarObjects = generateRandomAmountOfStars();
	}
	
	public Integer generateRandomId() {
		Integer number = 0;
		
		Random r1 = new Random();
		Random r2 = new Random();
		Random r3 = new Random();
		int rand1 = r1.nextInt(15000);
		int rand2 = r2.nextInt(12090);
		int rand3 = r3.nextInt(30000);
		
		number = rand1 - rand2 + rand3;
		
		if (number <= 0) {
			number += r1.nextInt(50000) - r2.nextInt(2500);
		}
		
		return number;
	}
	
	public String generateRandomSystemName() {
		return "test star";
	}
	
	public int generateRandomAmountOfStars() {
		return 1;
	}
	
	@Override
	public String toString() {
		return String.format("Starsystem (ID: %s): %s, %d stars.", this.idStarSystem, this.nameStarSystem, this.amountOfStellarObjects);
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
