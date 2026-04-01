package lesson3.labs.prob4;

import java.util.List;

public class Driver {
	public static void main(String[] args) {
		Address addressHouse = new Address("1000N 4th ST", "Fairfield", "Iowa", 52566);
		Address addressCondo = new Address("1000N 4th ST", "Chicago", "Iowa", 52566);
		Address addressTrailer = new Address("1000N 4th ST", "New York", "Iowa", 52566);
		Address parkAddress = new Address("PARK ADDRESS", "Fairfield", "Iowa", 52566);

		Property[] properties = {
				new House(addressHouse,9000), // 0.1 * 9000 = 900
				new Condo(addressCondo, 2), // 400 * 2 = 800
				new Trailer(addressTrailer, parkAddress) // 500Ï
		};

		double totalRent = Admin.computeTotalRent(properties);
		System.out.println(totalRent);


		List<Property> list = Admin.listAllProperties(properties, "Fairfield");
		for (Property p : list) {
			System.out.println(p.getClass().getSimpleName() + " - " + p.getAddress() + " - " + p.computeRent());
		}
	}
}
