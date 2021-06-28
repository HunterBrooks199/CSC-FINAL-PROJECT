@@ -0,0 +1,98 @@
import java.util.ArrayList;
import java.util.Scanner;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {
	static ArrayList<String> carList = new ArrayList<>();
	
	public static void main (String [] args) throws IOException {
		Car carOne = new Car("Honda", "Civic", "Blue" , 1993, 20000);
		Car carTwo = new Car("Dodge", "Ram", "Silver", 2003, 350000);
		
		addCarToList(carOne);
		
		for (int i = 0; i < carList.size(); i++) {
			System.out.println(carList.get(i) + " ");
		}
		
		
		try {
			removeCarFromList(carOne);
			System.out.println("Car has been removed.");
			System.out.println("Inventory: " + carList);
		}
		catch(Exception e) {
			System.out.println("Not in list.");
		}
		
		addCarToList(carTwo);
		listInfo(carTwo);
		
		updateCar(carOne);
		System.out.println("Car has been updated: Here is the updated car.");
		listInfo(carOne);
		
		printInfo();
		System.out.println(carList);
			
	}
			
		

	public static void addCarToList(Car x) {
		carList.add(x.getMake());
		carList.add(x.getModel());
		carList.add(x.getColor());
		carList.add("" + x.getYear());
		carList.add("" + x.getMileage());
	}
	
	public static void removeCarFromList(Car x) {
		carList.remove(x.getMake());
		carList.remove(x.getModel());
		carList.remove(x.getColor());
		carList.remove("" + x.getYear());
		carList.remove("" + x.getMileage());
	}
	
	public static void updateCar(Car x) {
		x.setColor("Red");
		x.setMake("Chevy");
		x.setModel("Camaro");
		x.setYear(2004);
		x.setMileage(3000);
	}
	
	public static void listInfo(Car x) {
		System.out.println(x.getMake());
		System.out.println(x.getModel());
		System.out.println(x.getColor());
		System.out.println(x.getYear());
		System.out.println(x.getMileage());


	}
	
	public static void printInfo() throws IOException {
		Scanner in = new Scanner(System.in);
		String choice;
		
		System.out.println("Would you like to print the inventory list to a txt file? Y/N: ");
		choice = in.nextLine();
		
		if(choice.equals("Y")) {
			Path out = Paths.get("Inventory.txt");
			Files.write(out, carList , Charset.defaultCharset());
			System.out.println("Inventory list has been printed.");
		}
		else {
			System.out.println("Nothing will be printed.");
		}
		in.close();
	}
	
}
