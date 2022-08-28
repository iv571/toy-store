package mru.tsc.controller;

import java.io.Console;
import java.io.File;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;

import mru.tsc.exceptions.BoardGameException;
import mru.tsc.exceptions.NegativePriceException;
import mru.tsc.model.Animal;
import mru.tsc.model.BoardGame;
import mru.tsc.model.Figure;
import mru.tsc.model.Puzzle;
import mru.tsc.model.Toy;
import mru.tsc.view.AppMenu;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public  class StoreManager {
	AppMenu appMen;
	 ArrayList<Toy> toys;
	
	 
	 

	private final String FILE_PATH = "res/toys.txt";
	
	/**
	 * Manages the inputs 
	 */
	public StoreManager() {
		toys = new ArrayList<>();
		appMen = new AppMenu();
		checkToyInfo();
		
	}
	/**
		 * 
		 */
		private int choiceInt;
		
	
	

	    @FXML
	    private Button sNum;
	    
	    @FXML
	    private TextField sNumInp;
	    
	    @FXML
	    private Button buyBtn;
	    
	    @FXML
	    private Button saveBtn;
	    

	    @FXML
	    private TextArea console;
	    
	    @FXML
	    private TextArea console2;
	    
	    @FXML
	    private TextField name;

	    @FXML
	    private Button nameBtn;

	    @FXML
	    private TextField type;

	    @FXML
	    private Button typeBtn;
	    
	    @FXML
	    private TextField toyCount;

	    @FXML
	    private TextField toyPrice;

	    @FXML
	    private TextField toyBrand;

	    @FXML
	    private TextField toyName;

	    @FXML
	    private TextField toySn;

	    @FXML
	    private TextField toyAgeAppropriate;
	    
	    @FXML
	    private TextField toyClassfication;

	    @FXML
	    private TextField toyMaterial;

	    @FXML
	    private TextField toySize;

	    @FXML
	    private TextField toyType;

	    @FXML
	    private TextField toyMin;

	    @FXML
	    private TextField toyMax;
	    
	    @FXML
	    private ChoiceBox choices;
	    
	    ObservableList<String> toyChoices//
        = FXCollections.observableArrayList("Figure", "Animal", "Puzzle", "Board Game");

	    @FXML
	    private TextField toyDesigners;
	    
	    /**
	     * Initializes dropdown menu
	     */
	    @FXML
	    private void initialize () {
	    	choices.setItems(toyChoices);
	    }

	    
	    /**
	     * Adds a Toy object to the toys array
	     * @param event 
	     */
	    @FXML
	    void saveBtnPressed(ActionEvent event) {
	    	Thread t = new Thread (new Runnable() {
	    		@Override
	    		public void run () {
	    			Scanner sc = new Scanner(System.in);
		    		appMen.addToyMenu();
		    		String sN = toySn.getText();
		    		
		    		if (sN.length() != 10) {
		    			console.setText("Serial numbers must be 10 digits");
		    			return;
		    		}
		    		
		    		try {
		    			Long snl = Long.parseLong(sN);
		    			
		    			for (Toy t : toys) {
		    				if (snl.equals(t.getSn()) ) {
		    					console.setText("This Serial Number already exists");
		    					return;
		    				} 
		    			}
		    			
		    			
		    			Long snl1 = snl/100000000;
		    			snl1 = snl1 / 10;
		    			char snlChar = snl1.toString().charAt(0);
		    			
		    			if (snlChar == '0' || snlChar == '1') {
		    				
		    				
		    				String name = toyName.getText();
		    				
		    				
		    				appMen.addBrand();
		    				String brand = toyBrand.getText();
		    				
		    				appMen.addPrice();
		    				double price = Double.parseDouble(toyPrice.getText());;
		    				int y = 0;
		    				
		    				
		    					try {
		    						if (price < 0) {
		    							throw new NegativePriceException();
		    						}
		    						
		    					} catch (NegativePriceException e){
		    						console.setText("Price must be positive");
		    					}
		    				
		    				
		    				
		    				
		    				appMen.addAC();
		    				
		    				int AC;
		    				
		    				try {
		    					AC = Integer.parseInt(sc.nextLine());
		    				} catch (NumberFormatException e) {
		    					console.setText("Must be an integer");
		    					return;
		    				}
		    				
		    				
		    				appMen.addAge();
		    				String age = toyAgeAppropriate.getText();
		    				
		    				appMen.addClassification();
		    				char classification = toyClassfication.getText().charAt(0);
		    				
		    				Figure a = new Figure(snl, name, brand, price, AC, age, classification);
		    				toys.add(a);
		    				console.setText("Toy Saved");
		    				
		    			} else if (snlChar == '2' || snlChar == '3') {
		    				appMen.addName();
		    				String name = toyName.getText();
		    				
		    				
		    				appMen.addBrand();
		    				String brand = toyBrand.getText();
		    				
		    				appMen.addPrice();
		    				Double price = Double.parseDouble(toyPrice.getText());
		    				
		    	appMen.addAC();
		    				
		    				int AC;
		    				
		    				try {
		    					AC = Integer.parseInt(sc.nextLine());
		    				} catch (NumberFormatException e) {
		    					console.setText("Must be an integer");
		    					return;
		    				}
		    				
		    				appMen.addAge();
		    				String age = toyAgeAppropriate.getText();
		    				
		    				appMen.addMaterial();
		    				String material = toyMaterial.getText();
		    				
		    				
		    				appMen.addSize();
		    				char size = toySize.getText().charAt(0);
		    				
		    				Animal a = new Animal(snl, name, brand, price, AC, age, material, size);
		    				toys.add(a);
		    				console.setText("Toy Saved");
		    			} else if (snlChar == '4' || snlChar == '5' || snlChar == '6') {

		    				appMen.addName();
		    				String name = toyName.getText();
		    				
		    				
		    				appMen.addBrand();
		    				String brand = toyBrand.getText();
		    				
		    				appMen.addPrice();
		    				Double price = Double.parseDouble(toyPrice.getText());
		    				
		    	appMen.addAC();
		    				
		    				int AC;
		    				
		    				try {
		    					AC = Integer.parseInt(sc.nextLine());
		    				} catch (NumberFormatException e) {
		    					console.setText("Must be an integer");
		    					return;
		    				}
		    				
		    				appMen.addAge();
		    				String age = toyAgeAppropriate.getText();
		    				
		    				appMen.addPT();
		    				String puzzleType = toyType.getText();
		    				
		    				Puzzle a = new Puzzle(snl, name, brand, price, AC, age, puzzleType);
		    				console.setText("Toy Saved");
		    				toys.add(a);
		    			} else if (snlChar == '7' || snlChar == '8' || snlChar == '9') {
		    				appMen.addName();
		    				String name = toyName.getText();
		    				
		    				
		    				appMen.addBrand();
		    				String brand = toyBrand.getText();
		    				
		    				appMen.addPrice();
		    				Double price = Double.parseDouble(toyPrice.getText());
		    				
		    				appMen.addAC();
		    				int AC = Integer.parseInt(toyCount.getText());
		    				
		    				appMen.addAge();
		    				String age = toyAgeAppropriate.getText();
		    				
		    				appMen.addDesigner();
		    				String designer = toyDesigners.getText();
		    				
		    				
		    				appMen.addNumPlayers();
		    				String numP = toyMin.getText() + "-" +  toyMax.getText();
		    				
		    				try {
		    					if (numP.charAt(0) > numP.charAt(3)){
		    						throw new BoardGameException();
		    					} 
		    					}
		    					catch (BoardGameException e) {
		    						console.setText("Minimum Players greater than Maximum Players");
		    					}
		    					
		    				
		    				
		    				BoardGame a = new BoardGame(snl, name, brand, price, AC, age, designer, numP);
		    				console.setText("Toy Saved");
		    				toys.add(a);
		    			} 

		    			
		    		} catch (NumberFormatException e) {
		    			console.setText("There are no letters in a serial number");
		    			
		    		}
		    		
		    		
		    		if (sN.length() != 10) {
		    			console.setText("Serial numbers must be 10 digits");
		    		}
		    		
		    		
		    		
		    		
		    		appMen.addToyMenu();
		    		
		    		
	    			save();
	    		}
	    	});
	    	
	    	t.start();
	    		
	    		
	    		
	    	}
	    	

	    
	    
	    /**
	     * Buys the toy
	     * @param event
	     */
	    @FXML
	    void buyBtnPressed(ActionEvent event) {
	    	console.setText("Toy Purchased");
	    	choiceInt = 0;

	    }
	    
	    /**
	     * Searches toy by type
	     * @param event
	     */
	    @FXML
	    void typeBtnPressed(ActionEvent event) {
	    	System.out.println("x1");
	    	Thread t = new Thread(new Runnable() {
	    		
	    		
	    		@Override
				public void run() {
	    			
	    			System.out.println("x2");
	    			Scanner sc = new Scanner(System.in);
	    			
	    			String sName = type.getText();
	    			
	    			String s = " ";
	    			
	    			
	    			
	    			
	    			int amountLeft = 0;

	    			Toy match =null;

	    			ArrayList<Integer> i = new ArrayList<>();
	    			ArrayList<Toy> tos = new ArrayList<>();
	    			int ind = 1;
	    			
	    			
	    			
	    			for (Toy t : toys) {
	    				
	    				Long snF = t.getSn()/100000000;
	    				snF = snF / 10;
	    				char snFChar = snF.toString().charAt(0);

	    					if (sName.equals("1") && (snFChar == '0' || snFChar == '1')) {
	    						match = t;
	    						Toy matchToy1 = match;
	    						amountLeft = matchToy1.getAvailableCount();
	    						
	    						System.out.println("(" + ind + ")" + " ");
	    						i.add(ind);
	    						ind++;
	    						
	    						tos.add(match);
	    						
	    						s = matchToy1.toString();

	    						

	    						

	    						
	    						}else if (sName.equals("2") && (snFChar == '2' || snFChar == '3')) {
	    							match = t;
	    							

	    							Animal matchToy1 = (Animal) match;
	    							amountLeft = matchToy1.getAvailableCount();
	    							
	    							
	    							System.out.println("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;
	    							
	    							tos.add(match);

	    							s = matchToy1.toString();


	    						} else if (sName.equals("3") && (snFChar == '4' || snFChar == '5' || snFChar == '6')) {
	    							match = t;
	    							Puzzle matchToy1 = (Puzzle) match;
	    							amountLeft = matchToy1.getAvailableCount();
	    							
	    							
	    							System.out.println("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;
	    							tos.add(match);
	    							
	    							s = matchToy1.toString();
	    							
	    						} else if (sName.equals("4")  && (snFChar == '7' || snFChar == '8' || snFChar == '9')) {
	    							match = t;
	    							BoardGame matchToy1 = (BoardGame) match;
	    							
	    							
	    							
	    							System.out.println("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;
	    							tos.add(match);
	    							
	    							s = matchToy1.toString();
	    							

	    					
	    						} else {
	    							
	    							Toy matchToy1 = null;
	    							
	    							}  
	    					 
	    					}
	    			
	    			
	    			
	    			console.setText(s);;
	    			appMen.purchaseMenu();
	    			String choice = sc.nextLine().toLowerCase();
	    			
	    			try {
	    				
	    			
//	    			int choiceInt = Integer.parseInt(choice);
	    			
	    			
	    			
	    			for (int x = 0; x < i.size(); x++) {
	    				if (choiceInt == 1) {

	    					if (amountLeft > 0) {
	    						System.out.println("Toy purchased");
	    						
	    						
	    						//subtract 1 from amount left of toy
	    						tos.get(x).setAvailableCount(tos.get(x).getAvailableCount() - 1);
	    					}
	    				} else {
	    					System.out.println("Toy out of stock");
	    					return;
	    				}
	    			}
	    			} catch (NumberFormatException e) {
	    				return;
	    			}
	    			

	    					
	    				}

			
	    	});
	    	
	    	t.start();
	    	
	    	

	    }
	    
	    /**
	     * Searches Toy by name
	     * @param event
	     */
	    @FXML
	    void nameBtnPressed(ActionEvent event) {
	    	Thread t = new Thread() {
	    		
	    		@Override
	    		public void run() {
	    			Scanner sc = new Scanner(System.in);
	    		
	    			String sName = name.getText().toLowerCase();
	    			
	    			String s = " ";
	    			
	    			int amountLeft = 0;

	    			Toy match =null;

	    			ArrayList<Integer> i = new ArrayList<>();
	    			ArrayList<Toy> tos = new ArrayList<>();
	    			int ind = 1;
	    			
	    			
	    			
	    			for (Toy t : toys) {
	    				
	    				Long snF = t.getSn()/100000000;
	    				snF = snF / 10;
	    				
	    				char snFChar = snF.toString().charAt(0);

	    		

	    				if (t.getName().toLowerCase().contains(sName)) {
	    					

	    					
	    					

	    					if (snFChar == '0' || snFChar == '1') {
	    						match = t;
	    						Figure matchToy1 = (Figure) match;
	    						amountLeft = matchToy1.getAvailableCount();
	    						
	    						System.out.print("(" + ind + ")" + " ");
	    						i.add(ind);
	    						ind++;
	    						
	    						tos.add(match);

	    						console.setText(matchToy1.toString());

	    						

	    						
	    						}else if (snFChar == '2' || snFChar == '3') {
	    							match = t;
	    							System.out.println("x");

	    							Animal matchToy1 = (Animal) match;
	    							amountLeft = matchToy1.getAvailableCount();
	    							
	    							
	    							System.out.print("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;
	    							
	    							tos.add(match);

	    							console.setText(matchToy1.toString());


	    						} else if (snFChar == '4' || snFChar == '5' || snFChar == '6') {
	    							match = t;
	    							Puzzle matchToy1 = (Puzzle) match;
	    							amountLeft = matchToy1.getAvailableCount();
	    							
	    							
	    							System.out.print("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;
	    							console.setText(matchToy1.toString());

	    							tos.add(match);
	    						} else if (snFChar == '7' || snFChar == '8' || snFChar == '9') {
	    							match = t;
	    							BoardGame matchToy1 = (BoardGame) match;
	    							
	    							
	    							
	    							System.out.print("(" + ind + ")" + " ");
	    							i.add(ind);
	    							ind++;

	    							console.setText(matchToy1.toString());

	    							tos.add(match);

	    					
	    						} else {
	    							Toy matchToy1 = null;
	    							
	    							}  
	    					} 
	    					}
	    			
	    			System.out.println(s);
	    			
	    			int purchToy = 0;
	    			appMen.purchaseMenu();
	    			String choice = sc.nextLine().toLowerCase();
	    			
	    			try {
	    				
	    			
	    			int choiceInt = Integer.parseInt(choice);
	    			
	    			for (int x = 0; x < i.size(); x++) {
	    				if (choiceInt == i.get(x)) {

	    					if (amountLeft > 0) {
	    						System.out.println("Toy purchased");
	    						
	    						purchToy = 1;
	    						
	    						//subtract 1 from amount left of toy
	    						match.setAvailableCount(match.getAvailableCount() - 1);
	    					} else {
	    						System.out.println("Toy out of stock");
	    					}
	    				} else {
	    					return;
	    				}
	    			}
	    			} catch (NumberFormatException e) {
	    				return;
	    			}
	    			

	    					
	    				}
	    		
	    	};
	    	
	    	t.start();

	    }

	    
	    /**
	     * Searches toy by Serial Number
	     * @param event
	     */
	    @FXML
	    void sNumPressed(ActionEvent event) {
	    	Thread t = new Thread() { 
	    		
	    		@Override
	    		public  void run() {
	    			Scanner sc = new Scanner (System.in);
	    			String sNum = sNumInp.getText();
	    			String s = " ";
	    			
	    			
	    			try {
	    				Long sLong = Long.parseLong(sNum);
	    			} catch (NumberFormatException e){
	    				console.setText("Serial number must be in numbers");
	    				return;
	    			}
	    			Long sLong = Long.parseLong(sNum);
	    			int amountLeft = 0;

	    			Toy match = null;

	    			int i = 1;

	    			
	    			if(sNum.length() == 10 ) {
	    				for (Toy t : toys) {

	    					Long tSn = t.getSn();

	    					if ((long) tSn == (long) sLong) {

	    						match = t;

	    						if (sNum.charAt(0) == '0' || sNum.charAt(0) == '1') {

	    							Figure matchToy1 = (Figure) match;
	    							amountLeft = matchToy1.getAvailableCount();

	    							console.setText(matchToy1.toString());

	    							appMen.purchaseMenu();
	    							String choice = sc.nextLine().toLowerCase();

	    							if (choice.equals("1")) {

	    								if (amountLeft > 0) {
	    									System.out.println("Toy purchased");
	    									matchToy1.setAvailableCount(matchToy1.getAvailableCount() - 1);
	    								}
	    							} else {
	    								run();
	    							}
	    						} else if (sNum.charAt(0) == '2' || sNum.charAt(0) == '3') {
	    							System.out.println("x");

	    							Animal matchToy1 = (Animal) match;
	    							amountLeft = matchToy1.getAvailableCount();

	    							console.setText(matchToy1.toString());


	    							appMen.purchaseMenu();
	    							String choice = sc.nextLine().toLowerCase();

	    							if (choice.equals("1")) {

	    								if (amountLeft > 0) {
	    									System.out.println("Toy purchased");
	    									matchToy1.setAvailableCount(matchToy1.getAvailableCount() - 1);
	    								}
	    							} else {
	    								run();
	    							}
	    						} else if (sNum.charAt(0) == '4' || sNum.charAt(0) == '5' || sNum.charAt(0) == '6') {
	    							Puzzle matchToy1 = (Puzzle) match;
	    							amountLeft = matchToy1.getAvailableCount();

	    							console.setText(matchToy1.toString());

	    							appMen.purchaseMenu();
	    							String choice = sc.nextLine().toLowerCase();

	    							if (choice.equals("1")) {

	    								if (amountLeft > 0) {
	    									System.out.println("Toy purchased");
	    									matchToy1.setAvailableCount(matchToy1.getAvailableCount() - 1);
	    								}
	    							} else {
	    								run();
	    							}
	    						} else if (sNum.charAt(0) == '7' || sNum.charAt(0) == '8' || sNum.charAt(0) == '9') {
	    							BoardGame matchToy1 = (BoardGame) match;
	    							amountLeft = matchToy1.getAvailableCount();

	    							console.setText(matchToy1.toString());


	    							appMen.purchaseMenu();
	    							String choice = sc.nextLine().toLowerCase();

	    							if (choice.equals("1")) {

	    								if (amountLeft > 0) {
	    									System.out.println("Toy purchased");
	    									matchToy1.setAvailableCount(matchToy1.getAvailableCount() - 1);
	    								}
	    							} else {
	    								run();
	    							}
	    						} else {
	    							Toy matchToy1 = null;
	    							amountLeft = matchToy1.getAvailableCount();
	    						

	    							appMen.purchaseMenu();
	    							String choice = sc.nextLine().toLowerCase();

	    							if (choice.equals("1")) {

	    								if (amountLeft > 0) {
	    									System.out.println("Toy purchased");
	    									matchToy1.setAvailableCount(matchToy1.getAvailableCount() - 1);
	    								} else {
	    									System.out.println("Out of stock");
	    								}
	    							} else {
	    								run();
	    							}
	    						}
	    						
	    						

	    						break;
	    					}

	    				}
	    				
	    				
	    			} else {
	    				s = "That is not a valid number";
	    			}
	    			
	    			System.out.println("good");
	    			


	    		}
	    		
	    		
	    	
	    	};
	    	
	    	t.start();
	    	
	    
	      

	    }
	    
	    @FXML
	    private TextField sNum2;

	    @FXML
	    private Button remove;
	    
	    /**
	     * Removes a toy
	     * @param event
	     */
	    @FXML
	    void removePress(ActionEvent event) {
	    	removeToy(sNum2.getText());

	    }
	    
	    
	    
	   


	
	
	
	/**
	 * Runs the store manager class
	 */
	public  void run1() {
		Scanner scan = new Scanner(System.in);
		boolean flag = true;

		
		
		while (flag == true) {
			
			appMen.startupMenu();
			String startupChoice = scan.next().toLowerCase();
			
			if (startupChoice.equals("1")) {
				appMen.searchMenu();
				String searchChoice = scan.next().toLowerCase();

				if (searchChoice.equals("1")) {
//					searchSerial();

				} else if (searchChoice.equals("2")) {
//					searchName();

				} else if (searchChoice.equals("3")) {
//					searchCat();

				} else if (searchChoice.equals("4")) {
					//

				} else {
					System.out.println("Invalid Choice");
				}

			} else if (startupChoice.equals("2")) {
//				addToy();

				
			} else if (startupChoice.equals("3")) {
//				removeToy();
			} else if (startupChoice.equals("4")) {
				giftSuggestion();
			}
			else if (startupChoice.equals("5")) {
				flag = false;
				save();

			} else {
				System.out.println("Invalid Choice");
			}
		}

		

	}

	
	/**
	 * Removes a toy from the database
	 * @param input 
	 */
	public void removeToy(String input) {
		Scanner sc = new Scanner(System.in);
		
		String sN = input;
		
		try {
			Long snl = Long.parseLong(sN);
			System.out.println(snl);
			
			
			for (Toy t : toys) {
				if (snl.equals(t.getSn()) ) {
					toys.remove(t);
					console2.setText("This toy has been removed");
					
				}  else {
					console2.setText("This toy doesn't exist");
					
				}
			}
		} catch (NumberFormatException e) {
			console2.setText("There are no letters in a serial number");
		}
		
		save();
	
	}
	
	
	/**
	 * Saves the added and removed toys into the toys.txt file
	 */
	
	public void save() {
		File toysInfo = new File(FILE_PATH);
		PrintWriter ti;
		try {
			ti = new PrintWriter(toysInfo);
			for (Toy t: toys) {
				ti.println(t.toFormat());
				
			}
			ti.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Saving");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		System.out.print(".");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print(".");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(".");
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.print("Done!");
		
		
	}
	
	
		
		
	

		

	

	/**
	 * Checks toy info
	 * @return
	 */
	public ArrayList<Toy> checkToyInfo() {

		File toyPath = new File(FILE_PATH);
		
		final int LDIV = 1000000000;
//		ArrayList<Player> casinoInfoArray = new ArrayList<Player>();
		String[] splittedLine;

		if (toyPath.exists()) {
			Scanner scan;

			try {
				scan = new Scanner(toyPath);
				while (scan.hasNextLine()) {

					String currentLine = scan.nextLine();

					splittedLine = currentLine.split(";");

					long l = Long.parseLong(splittedLine[0]) / LDIV;

					if (l == 0 || l == 1) {
						Toy f = new Figure(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), splittedLine[5],
								splittedLine[6].charAt(0));
						
						toys.add(f);

					} else if (l == 2 || l == 3) {
						Toy a = new Animal(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), splittedLine[5],
								splittedLine[6], splittedLine[7].charAt(0));
						
						toys.add(a);

					} else if (l == 4 || l == 5 || l == 6) {
						Toy p = new Puzzle(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), splittedLine[5],
								splittedLine[6]);
						
						toys.add(p);

					} else if (l == 7 || l == 8 || l == 9) {
						Toy b = new BoardGame(Long.parseLong(splittedLine[0]), splittedLine[1], splittedLine[2],
								Double.parseDouble(splittedLine[3]), Integer.parseInt(splittedLine[4]), splittedLine[5],
								splittedLine[6], splittedLine[7]);
						
						toys.add(b);

					} else {

						Toy t = new Figure(0, "0", "0", 0, 0, "0", '0');
						toys.add(t);

					}

				}

				scan.close();

			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		} else {
			try {
				toyPath.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

		return toys;

	}
	
	/**
	 * Makes a gift suggestion
	 */
	public  void giftSuggestion () {
		Scanner sc = new Scanner(System.in);
		appMen.giftMenu();
		String sAge = sc.nextLine().toLowerCase();
		appMen.priceMenu();
		String sPrice = sc.nextLine().toLowerCase();
		appMen.typeMenu();
		String sType = sc.nextLine().toUpperCase();
		
		int amountLeft = 0;

		Toy match =null;

		ArrayList<Integer> i = new ArrayList<>();
		ArrayList<Toy> tos = new ArrayList<>();
		int ind = 1;
		
		try {
			int age = Integer.parseInt(sAge);
			double price = Double.parseDouble(sPrice);
			
			if (age == -1) {
				age = 0;
			}
			if (price == 0) {
				price = 100000;
			}
			
			
				for (Toy t: toys) {
					if (t.getAgeAppropriate().contains(sAge) && t.getPrice() <= price && t.getType().equals(sType)) {
						match = t;
						Toy matchToy1 = match;
						amountLeft = matchToy1.getAvailableCount();
						
						System.out.print("(" + ind + ")" + " ");
						i.add(ind);
						ind++;
						
						tos.add(match);

						System.out.println(matchToy1.toString());
					} 
		}
		}
					 
						
							
						
			catch (NumberFormatException e) {
			System.out.print("not a number");
		}


		int purchToy = 0;
		appMen.purchaseMenu();
		String choice = sc.nextLine().toLowerCase();
		
		
		try {
			int choiceInt = Integer.parseInt(choice);
			for (int x = 0; x < i.size(); x++) {
				if (choiceInt == i.get(x)) {

					if (amountLeft > 0) {
						System.out.println("Toy purchased");
						
						purchToy = 1;
						
						//subtract 1 from amount left of toy
						match.setAvailableCount(match.getAvailableCount() - 1);
					} else {
						System.out.println("Toy out of stock");
					}
				} else {
					return;
				}
			}
		} catch (NumberFormatException e) {
			
			return;
		}

		

		
	}
	
	
	

}
