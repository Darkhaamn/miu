package lesson3.labs.prob1;

public class PersonWithJob  {
	// not extend Person use instance field. it means PersonWithJob must have person not inheritance
	private Person person;
	private double salary;
	
	public double getSalary() {
		return salary;
	}

	PersonWithJob(String n, double s) {
		person = new Person(n);
		salary = s;
	}

	@Override
	public boolean equals(Object aPerson) {
		if(aPerson == null) return false;

		// Checking for 2 cases is that aPerson is PersonWithJob or Person class
		// If PersonWithJob class then we need person name and salary
		if (aPerson instanceof PersonWithJob) {
			PersonWithJob p = (PersonWithJob) aPerson;
			return person.equals(p.person) &&
					salary == p.salary;
		}

		// If is it Person class we just pass to the person.equals method. it's check person name equals.
		if (aPerson instanceof Person) {
			return person.equals(aPerson);
		}

		return false;
	}

	public static void main(String[] args) {
		PersonWithJob p1 = new PersonWithJob("Joe", 30000);
		Person p2 = new Person("Joe");
		PersonWithJob p3 = new PersonWithJob("Joe", 1000);

		//As PersonsWithJobs, p1 should be equal to p2
		// this case p1 (PersonWithJob) == p2 (Person) is checking names.
		System.out.println("p1.equals(p2)? " + p1.equals(p2));

		// this case is p2 (Person) == p1 (PersonWithJob) is checking names and salaries.
		System.out.println("p2.equals(p1)? " + p2.equals(p1));

		// this case is p1 (PersonWithJob) == p3 (PersonWithJob) is checking names and salaries
		System.out.println("p1.equals(p3)? " + p1.equals(p3));
	}
}
