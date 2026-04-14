package prob2.a;

import java.util.Comparator;

/* A functor, but not a closure */
public class EmployeeNameComparator implements Comparator<Employee> {
	@Override
	public int compare(Employee e1, Employee e2) {
		// return e1.name.compareTo(e2.name);
		int nameCompara = e1.name.compareTo(e2.name);
		if (nameCompara != 0) {
			return nameCompara;
		}
		return Integer.compare(e1.salary, e2.salary);
	}
}
