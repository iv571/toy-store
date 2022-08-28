package mru.tsc.model;

public class Animal extends Toy {
	private char size;
	private String material;
	
	/**
	 * 
	 * @param sn the serial number
	 * @param name the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param availableCount the amount available left
	 * @param ageAppropriate the age the toy is appropriate for
	 * @param material the material of the animal
	 * @param size the size of the animal
	 */
	public Animal(long sn, String name, String brand, double price, int availableCount, String ageAppropriate, String material, char size) {
		super(sn, name, brand, price, availableCount, ageAppropriate);
		
		this.size = size;
		this.material = material;
	
	}
	
	/**
	 * Returns the size of the animal
	 * 
	 * @return the size of the animal
	 */
	public char getSize() {
		return size;
	}

		/**
		 * 
		 * Sets the size of the animal
		 * @param size the size of the animal
		 */
	public void setSize(char size) {
		this.size = size;
	}

		/**
		 * Getter for animal material
		 * @return material of the animal
		 */
	public String getMaterial() {
		return material;
	}

	public void setMaterial(String material) {
		this.material = material;
	}

	/**
	 * Determines the type of the toy 
	 * @return Animal type
	 */
	private final String type = "ANIMAL";
	public String getType() {
		return type;
	}


	/**
	 * Converts an Animal to a string
	 * @return String format
	 */
	@Override
	public String toString() {
		String str = super.getSn() + " , " + super.getName() + " , " + super.getBrand() + " , " + super.getPrice() + " , " + super.getAvailableCount() + " , " + super.getAgeAppropriate() + " , " + material + " , " + size + " , ";
		return str;
	}
	
	
	/**
	 * Converts the animal to a format for toys.txt
	 * @return toys.txt format
	 */
	@Override
	public String toFormat() {
		// TODO Auto-generated method stub
		String str = super.getSn() + ";" + super.getName() +  ";" + super.getBrand() +  ";"+ super.getPrice() +  ";" + super.getAvailableCount() +  ";" + super.getAgeAppropriate() +  ";" + material +  ";" + size +  ";";
		return str;
	}

}
