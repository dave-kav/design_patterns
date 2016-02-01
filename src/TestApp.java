import java.util.ArrayList;

public class TestApp {

	public static void main(String[] args) {

		ArrayList <Dealer> dealers = new ArrayList<Dealer>();
		IVehicleFactory cf = new CarFactory();
		IVehicleFactory vf = new VanFactory();
		IVehicle newCar;
		IVehicle newVan;
		int menuChoice;
		int nestChoice;
		int index;
		String name;
		Dealer myDealer;

		System.out.println("=========================================\n=========VEHICLE DELIVERY SYSTEM=========\n=========================================");
		newCar = cf.buildVehicle();
		newVan = (Van)vf.buildVehicle();

		do {
			menuChoice = Handy.readInt("Please choose from the following options:\n"
					+ "\t1)Register as a dealer\n"
					+ "\t2)Register interest in new models\n"
					+ "\t3)Exit\n");

			switch (menuChoice) {
			case 1:
				name = Handy.clearReadString("Enter dealership name: " );
				dealers.add(new Dealer(name));
				break;
			
			case 2:	
				name = Handy.clearReadString("Enter dealership name: " );
				index = findDealer(name, dealers);
				if (index<0) {
					System.out.println("Invalid choice"); break;
				}
					
				myDealer = dealers.get(index);
				
				do {
					nestChoice = Handy.readInt("Please choose from the following options to register your interest in our new models:\n"
							+ "\t1)Car\n"
							+ "\t2)Van\n"
							+ "\t3)Done");	

					switch (nestChoice) {

					case 1:	
						((MyObservable)newCar).addObserver( (MyObserver) myDealer);
						break;

					case 2:		
						((MyObservable)newVan).addObserver( (MyObserver) myDealer);
						break;

					case 3:		break;

					default:	System.out.println("Invalid choice, please choose from options 1 - 3.");

					}
				} while (nestChoice != 3);
				break;

			case 3: System.out.println("Program exiting, goodbye.");	break;

			case 5: ((Car)newCar).setChanged(); break;

			case 6: newVan.setStatus(); break;

			default: System.out.println("Invalid Choice"); break;
			}

		}while (menuChoice != 3);

	}

	public static int findDealer(String name, ArrayList<Dealer> dealers) {		
		for (int i = 0; i < dealers.size(); i++) {
			if (dealers.get(i).getName().equals(name))
				return i;		
		}
		return -1;
	}

}
