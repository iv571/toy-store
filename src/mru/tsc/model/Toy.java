package mru.tsc.model;

public abstract class Toy {
	
	private String name;
	private long sn;
	private double price;
	private String brand;
	private int availableCount;
	private String ageAppropriate;
	
	
	/**
	 * 
	 * @param sn the serial number
	 * @param name the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param availableCount the amount available left
	 * @param ageAppropriate the age the toy is appropriate for
	 */
	public Toy(long sn, String name, String brand, double price, int availableCount, String ageAppropriate) {
		this.sn = sn;
		this.name = name;
		this.brand = brand;
		this.availableCount = availableCount;
		this.ageAppropriate = ageAppropriate;
	
	}

	/**
	 * Gets the name of the toy
	 * @return the name of the toy
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the toy
	 * @param name the name of the toy
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the serial number of the toy
	 * @return the serial number of the toy
	 */
	public long getSn() {
		return sn;
	}


	/**
	 * Sets the serial number of the toy
	 * @param name the serial number of the toy
	 */
	public void setSn(int sn) {
		this.sn = sn;
	}

	/**
	 * Gets the brand of the toy
	 * @return the brand of the toy
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand of the toy
	 * @param name the brand of the toy
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the available count of the toy
	 * @return the available count of the toy
	 */
	public int getAvailableCount() {
		return availableCount;
	}

	/**
	 * Sets the available count of the toy
	 * @param name the available count of the toy
	 */
	public void setAvailableCount(int availableCount) {
		this.availableCount = availableCount;
	}

	/**
	 * Gets the age appropriate rating of the toy
	 * @return the age appropriate rating of the toy
	 */
	public String getAgeAppropriate() {
		return ageAppropriate;
	}

	/**
	 * Sets the age appropriate rating of the toy
	 * @param name the age appropriate rating of the toy
	 */
	public void setAgeAppropriate(String ageAppropriate) {
		this.ageAppropriate = ageAppropriate;
	}
	
	
	/**
	 * Gets the price of the toy
	 * @return the price of the toy
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price of the toy
	 * @param name the price of the toy
	 */
	public void setPrice(Double price) {
		this.price = price;
	}
	
	/**
	 * Gets the type of the toy. Made to be overwritten.
	 * 
	 * @return the type
	 */
	public abstract String getType();
	
	
	/**
	 * Converts the toy to a string. Made to be overwritten.
	 * 
	 * @return the toy object as a string
	 */
	public abstract String toString();
	
	
	/**
	 * Converts the toy to a toys.txt format. Made to be overwritten.
	 * 
	 * @return the toy object in the format of toys.txt
	 */
	public abstract String toFormat();

	


	

}
