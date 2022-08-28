package mru.tsc.model;

public class Puzzle extends Toy {
	private String puzzleType;
	
	/**
	 * 
	 * @param sn the serial number
	 * @param name the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param availableCount the amount available left
	 * @param ageAppropriate the age the toy is appropriate for
	 * @param puzzleType the Type of puzzle
	 */
	public Puzzle(long sn, String name, String brand, double price, int availableCount, String ageAppropriate, String puzzleType) {
		super(sn, name, brand, price, availableCount, ageAppropriate);
		
		this.puzzleType = puzzleType;
	
	}
	
	
	/**
	 * Converts a Puzzle to a string
	 * @return String format
	 */
	public String toString() {
		String str = super.getSn() + " , " + super.getName() + " , " + super.getBrand() + " , " + super.getPrice() + " , " + super.getAvailableCount() + " , " + super.getAgeAppropriate() + " , " + puzzleType;
		return str;
	}
	
	/**
	 * Converts the Puzzle to a format for toys.txt
	 * @return toys.txt format
	 */
	@Override
	public String toFormat() {
		String str = super.getSn() + ";" + super.getName() + ";" + super.getBrand() + ";" + super.getPrice() + ";" + super.getAvailableCount() + ";" + super.getAgeAppropriate() + ";" + puzzleType;
		return str;
	}
	
	
	/**
	 * Determines the type of the toy 
	 * @return Puzzle type
	 */
    private final String type = "PUZZLE"; 
	@Override
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}

}
