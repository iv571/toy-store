package mru.tsc.model;

public class Figure extends Toy {
	
	private char classification;
	
	
	
	/**
	 * 
	 * @param sn the serial number
	 * @param name the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param availableCount the amount available left
	 * @param ageAppropriate the age the toy is appropriate for
	 * @param classification the classification of the figure
	 */
	public Figure(long sn, String name, String brand, double price, int availableCount, String ageAppropriate, char classification) {
		super(sn, name, brand, price, availableCount, ageAppropriate);
		
		
		this.classification = classification;
	
	}

	/**
	 * Converts a Figure to a string
	 * @return String format
	 */
	public String toString() {
		String str = super.getSn() + " , "  + super.getName() + " , " + super.getBrand() + " , " + super.getPrice( ) + " , " + super.getAvailableCount() + " , " + super.getAgeAppropriate() + " , " + classification ;
		return str;
	}


	@Override
	/**
	 * Converts the Figure to a format for toys.txt
	 * @return toys.txt format
	 */
	public String toFormat() {
		// TODO Auto-generated method stub
		
		String str = super.getSn() + ";"  + super.getName() + ";" + super.getBrand() + ";" + super.getPrice( ) + ";" + super.getAvailableCount() + ";" + super.getAgeAppropriate() + ";" + classification ;
		return str;
	 
	}
	
	
	private final String type = "FIGURE";

	/**
	 * Determines the type of the toy 
	 * @return Figure type
	 */
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
