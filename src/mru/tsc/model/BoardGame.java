package mru.tsc.model;

public class BoardGame extends Toy{
	private String numPlayers;
	private String designer;
	
	/**
	 * 
	 * @param sn the serial number
	 * @param name the name of the toy
	 * @param brand the brand of the toy
	 * @param price the price of the toy
	 * @param availableCount the amount available left
	 * @param ageAppropriate the age the toy is appropriate for
	 * @param numPlayers the number of players for the puzzle
	 * @param designer the designer of the puzzle
	 */



	public BoardGame(long sn, String name, String brand, double price, int availableCount, String ageAppropriate, String numPlayers, String designer) {
		super(sn, name, brand, price, availableCount, ageAppropriate);
		
		this.numPlayers = numPlayers;
		this.designer = designer;
	
	}
	

	/**
	 * Converts a Board Game to a string
	 * @return String format
	 */
	@Override
	public String toString() {
		String str = super.getSn() + " , " + super.getName() + " , " + super.getBrand() + " , " + super.getPrice() + " , " + super.getAvailableCount() + " , " + super.getAgeAppropriate() + " , " + numPlayers + " , " + designer + " , ";
		return str;
	}
	
	

	@Override
	/**
	 * Converts the Board Game to a format for toys.txt
	 * @return toys.txt format
	 */
	public String toFormat() {
		String str = super.getSn() + ";" + super.getName() + ";" + super.getBrand() + ";" + super.getPrice() + ";" + super.getAvailableCount() + ";" + super.getAgeAppropriate() + ";" + numPlayers + ";" + designer + ";";
		return str;
	}
	
	
	
	 
	private final String type = "BOARD_GAME";

	@Override
	/**
	 * Determines the type of the toy 
	 * @return Board Game type
	 */
	public String getType() {
		// TODO Auto-generated method stub
		return type;
	}
}
