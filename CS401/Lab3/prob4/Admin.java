package lesson3.labs.prob4;

import java.util.ArrayList;
import java.util.List;

public class Admin {
//	public static double computeTotalRent(Object[] properties) {
//		double totalRent = 0;
//		for (Object o : properties) {
//			if (o instanceof House) {
//				House h = (House) o;
//				totalRent += h.computeRent();
//			}
//			else if (o instanceof Condo) {
//				Condo h = (Condo) o;
//				totalRent += h.computeRent();
//			}
//			else if (o instanceof Trailer) {
//				Trailer h = (Trailer) o;
//				totalRent += h.computeRent();
//			}
//		}
//		return totalRent;
//	}

	public static double computeTotalRent(Property[] properties) {
		double total = 0;
		for (Property p : properties) {
			total += p.computeRent();
		}
		return total;
	}

	public static List<Property> listAllProperties(Property[] properties, String city) {
		List<Property> result = new ArrayList<>();
		for (Property p : properties) {
			if (p.getAddress().getCity().equalsIgnoreCase(city)) {
				result.add(p);
			}
		}
		return result;
	}
}
