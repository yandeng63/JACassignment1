import java.util.Scanner;
public class main {

	private static final String password = "password";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
       Scanner input = new Scanner(System.in);
       Computer c = new Computer();
       int maxComputers = 0;
       String pass;
       boolean check = true;
       
       System.out.println("Welcome to the computer store. ");
       
       //use loop to check if input is less or equals to 0, ask until input is more than 0;
	   do {
			try {
				System.out.println("How many computers do you want?");
				maxComputers = input.nextInt();
				if (maxComputers <= 0) {
					System.out.println("Please enter positive integer");
				}
			}
			catch (Exception e) {
				System.out.println("Exception " + e + " Occured. Enter a positive integer");
				input.nextLine();
			}

		} while (maxComputers <= 0);
      
      Computer[] inventory = new Computer[maxComputers]; //initialize the array
      
      
      int choice = 0;
      
    		do {
    			try{
    				System.out.print("\nWhat do you want to do?\n" + "1.Enter new computers (password required)\n"
    						+ "2.Change information of a computer (password required)\n"
    						+ "3.Display all computers by a specific brand\n"
    						+ "4.Display all computers under a certain a price.\n" + "5.Quit\n" + "Please enter your choice ");
    				choice = input.nextInt();
    				
    				//createdComputers is used to store the count of computers inserted in inventory array
    				int createdComputers = Computer.findNumberOfCreatedComputer();

    				switch (choice) {
    				case 1:
    					System.out.println("Please enter your password ");
    					pass = input.next();
    					
    					//password check
    					if (!pass.equals(password))
    						break;

    					int addComputersize = 0;
    					int temp = 1;
    					
    					do {//loop runs until the user inputs a value which is less than or equal to createdComputer
    							
    							do {// loop runs until user inputs a positive integer
    							System.out.println("Enter the number of computers you want to add ");
    							try{
    								addComputersize = input.nextInt();
    								if(addComputersize <= 0) {
    									System.out.println("Enter a positive integer ");
    								}
    							}
    							catch (Exception e) {
    								System.out.println("Exception " + e + " Occured. Enter a positive integer");
    								input.nextLine();
    							}
    							}while(addComputersize <= 0);
    							
    							if ((maxComputers - createdComputers) >= addComputersize) { //run if there is enough space in the inventory array 
    							
    								for (int i = createdComputers; i < (createdComputers + addComputersize); i++) {

    								double price = 0;
    								System.out.print("Enter the brand name of the computer " + temp + ": ");
    								String brand = input.next();
    								System.out.print("Enter the model of the computer " + temp + ": ");
    								String model = input.next();
    								
    								do {//runs until a positive integer is entered
    									try{
    										System.out.print("Enter the price of the computer " + temp + ": ");
    										price = input.nextDouble();
    										if (price <= 0) {
    											System.out.println("Please enter positive number");
    										}
    									}
    									catch (Exception e) {
    										System.out.println("Exception " + e + " Occured. Enter a positive integer");
    										input.nextLine();
    									}
    								} while (price <= 0);
    								
    								inventory[i] = new Computer(brand, model, price);
    								temp++;
    								System.out.println();

    							}
    								
    							System.out.println("Computer details you entered = ");
    							for (int i = createdComputers; i < (createdComputers + addComputersize); i++) {
    								System.out.println(inventory[i].toString());
    								
    								System.out.println();
    							}
    						} 
    							else {
    							
    							if(maxComputers - createdComputers == 0) { //inventory array is full
    								System.out.println("Your inventory is full. You cannot add new computers!");
    								break;
    							}
    							
    							else { //inventory array is full
    							System.out.println(" Sorry, you can only add up to "
    									+ (maxComputers - createdComputers) + " computers.");
    							}
    						}

    					} while ((maxComputers - createdComputers) < addComputersize);
    					System.out.println();
    					break;

    				case 2:
    					System.out.println("Please enter your password");
    					pass = input.next();
    					int index = 0;
    					
    					//passwordChecker function is used to verify the password
    					if (!pass.equals(password))
    						break;
    					char check2 = 'Y';
    					char check4 = 'Y';
    					
    					
    					do { //loop until a valid computer index is entered
    						
    						do { //loop until a positive integer >=0 is entered
    							try{
    								System.out.print("Please enter the number of computer you want to modify: ");
    								index = input.nextInt();
    								
    								if(index <= 0) {
    									System.out.println("Sorry, please enter a positive number");
    								}
    							}
    							catch (Exception e) {
    							
    								System.out.println("Exception " + e + "Please reenter a positive integer");
    							
    								input.nextLine();
    						
    							}
    						
    						}while(index <= 0);
    						
    						//if index > createdComputers, user is asked to choose one of 2 options i.e, either enter another computer number or quit from option 2
    						if (index - 1 >= createdComputers) {
    							System.out.println(
    									"There is no computer at this location. \n1. Enter Y if you wish to enter another computer number\n2. Enter Q to quit.");
    							check4 = input.next().charAt(0);
    							if(check4 == 'Y') {
    								check2 = 'Y';
    							}
    							else {
    								check2 = 'N';
    							}
    							
    						} else {
    							check2 = 'N';
    						}
    					} while (check2 == 'Y');
    					
    					if (check4 != 'Y' ) {
    						System.out.println("You have exited from option 2\n");
    						break;
    					}
    					
    					//if index is correct > display computer details
    					
    					System.out.println("\nThe details of the computer with the specified index are:\n");
    					
    					System.out.println(inventory[index - 1].toString());
    					
    					System.out.println();

    					boolean check3 = true;
    					
    					int choice2;
    					
    					do {//Then ask the user which attribute they wish to change by displaying the following menu.
    						
    						try{
    							System.out.print("What information would you like to change?\n" + "1.brand\n" + "2.model\n"
    									+ "3.SN\n" + "4.price\n" + "5.Quit\n" + "Enter your choice:" + "");
    							choice2 = input.nextInt();

    							switch (choice2) {
    							
    							
    							case 1: //case 1 update brand
    								System.out.print("Enter the brand name you want to update: ");
    								inventory[index - 1].setBrand(input.next());
    								System.out.println("Updated details of the computer are:");
    								System.out.println(inventory[index - 1].toString());
    								break;
    							
    							case 2: //case 2 update model
    								System.out.print("Enter the model name you want to update: ");
    								inventory[index - 1].setModel(input.next());
    								System.out.println("Updated details of the computer are:");
    								System.out.println(inventory[index - 1].toString());
    								break;
    							
    							case 3: //case 3 update serial Number
    								long l = 0;
    								
    								do { //loop until input is valid
    									try{
    										System.out.print("Enter the serial number you want to update: ");
    										l = input.nextLong();
    										if(l <= 0) {
    											System.out.println("Please enter postive number");
    										}
    									}
    									catch (Exception e) {
    										System.out.println("Exception " + e + "Please reenter a positive integer");
    										input.nextLine();
    									}
    								} while (l <= 0);
    								
    								inventory[index - 1].setSerialNumber(l);
    								System.out.println("Updated details of the computer are:");
    								System.out.println(inventory[index - 1].toString());
    								break;
    							
    							case 4: //case 4 update price
    								
    								double d = 0;
    								
    								do {
    									try{
    										System.out.print("Enter the price you would like to update: ");
    										d = input.nextDouble();
    										if (d <= 0) {
    											System.out.println("Please enter a positive number");
    										}
    									}
    									catch (Exception e) {
    										System.out.println("Exception " + e + " Please reenter a positive integer");
    										input.nextLine();
    									}
    								} while (d <= 0);
    								inventory[index - 1].setPrice(d);
    								System.out.println("\nUpdated details of the computer are:");
    								System.out.println(inventory[index - 1].toString());
    								break;
    							
    							case 5: //quit
    								check3 = false;
    								break;
    							//if any number other than 1 to 5 is entered default is executed
    							default:
    								System.out.println("Please enter a number between 1 and 5");
    								break;
    							}
    						}
    						catch (Exception e) {
    							System.out.println("Exception " + e + "Please reenter a positive integer");
    							input.nextLine();
    						}
    						System.out.println();
    					} while (check3);

    					System.out.println();
    					break;

    				case 3:
    					System.out.println("Please enter a brand name to find the computers with the brand name");
    					String brandName = input.next();
    					findComputersByBrand(inventory, brandName);
    					break;

    				case 4:
    					double value = 0;
    					
    					do { //loop until a positive integer is entered
    						try{
    							System.out.println("Enter the price, to find the computers less than the given price");
    							value = input.nextDouble();
    							if (value <= 0) {
    								System.out.println("Please enter a positive value:");
    							}
    						}
    						catch (Exception e) {
    							System.out.println("Exception " + e + "Please reenter a positive integer");
    							input.nextLine();
    						}
    					} while (value <= 0);
    				
    					findCheaperThanPrice(inventory, value);
    					break;
    				
    				case 5:
    					check = false;
    					System.out.println("Thank you for visiting the computer store.");
    					break;
    				//if any number other than 1 to 5 is entered below default statement is printed
    				default:
    					System.out.println("Please enter a number between 1 and 5");
    					break;
    				}
    			}
    		
    			catch (Exception e) {
    				System.out.println("Exception " + e + "Please reenter a positive integer");
    				input.nextLine();
    			}

    		} while (check);

    		input.close();

    	}

    	public static void findComputersByBrand(Computer[] inventory, String brandName) {
    		int createdComputers = Computer.findNumberOfCreatedComputer();
    		int count = 0;
    		int temp = 1;
    		for (int i = 0; i < createdComputers; i++) {
    			if (inventory[i].getBrand().equalsIgnoreCase(brandName)) {
    				System.out.println("Computer: " + (temp++));
    				System.out.println(inventory[i].toString());
    				count++;
    				System.out.println();
    			}
    		}
    		if (count == 0) { //not found
    			System.out.println("There are no computers with specified brand name");
    		}

    	}

 
    	public static void findCheaperThanPrice(Computer[] inventory, double price) {
    		int createdComputers = Computer.findNumberOfCreatedComputer();
    		int count = 0;
    		int temp =1;
    		for (int i = 0; i < createdComputers; i++) {
    			if (inventory[i].getPrice() <= price) {
    				System.out.println("Computer: " + (temp++));
    				System.out.println(inventory[i].toString());
    				count++;
    				System.out.println();
    			}
    		}
    		
    		if (count == 0) { //not found
    			System.out.println("There are no computers under the specified price");
    		}
    	}
}
