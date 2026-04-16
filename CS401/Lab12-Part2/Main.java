import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        Address add1 = new Address("500 E Broadway Ave", "Fairfield", "IA", 52556);
        Address add2 = new Address("103 W Adams Ave", "Fairfield", "IA", 52556);

        Section cs545_1 = new Section(900, "CS545");
        Section cs545_2 = new Section(901, "CS545");
        Section cs401 = new Section(902, "CS401");
        Section cs221 = new Section(903, "CS221");

        List<Student> students = new ArrayList<>(Arrays.asList(
                new Student(111, "Yasmeen", new ArrayList<>(Arrays.asList(3.9, 4.0, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs545_1, cs401))),
                new Student(112, "Mira", new ArrayList<>(Arrays.asList(4.0, 4.0, 3.9)), add1,
                        new ArrayList<>(Arrays.asList(cs545_2, cs401, cs221))),
                new Student(113, "Zaina", new ArrayList<>(Arrays.asList(3.6, 3.3, 3.7)), add1,
                        new ArrayList<>(Arrays.asList(cs221, cs401))),
                new Student(114, "Khaled", new ArrayList<>(Arrays.asList(3.0, 2.8, 3.1)), add2)
        ));

        // Find all the students that are taking a given course
        System.out.println("1. Find all the students that are taking a given course");
        students.stream()
                .filter(s-> s.sections != null && !s.sections.isEmpty())
                .forEach(System.out::println);

        // Get the address of any student that is taking a given course (e.g., "CS401")
        System.out.println("2. Get the address of any student that is taking a given course (e.g., \"CS401\")");
        students.stream().filter(s ->s.sections != null && s.sections.stream()
                        .anyMatch(sec->sec.getCourseCode().equals("CS401")))
                .map((e) -> e.address.toString())
                .forEach(System.out::println);

        // Calculate the GPA for a given student
        System.out.println("3. Calculate the GPA for a given student");
        System.out.println("Mira GPA is: ");
        System.out.println(students.stream()
                .filter(student -> student.getName().equals("Mira"))
                .findFirst()
                .map(s -> s.grades.stream()
                        .mapToDouble((grade) -> grade)
                        .average()
                        .orElse(0.0)));

        // Find the student with the highest GPA
        System.out.println("4. Find the student with the highest GPA");
        Optional<Student> max = students.stream()
                .max(Comparator.comparingDouble(s -> s.grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0)));
        System.out.println(max.orElse(null));

        // Get a list of all unique courses taken by students
        System.out.println("5. Get a list of all unique courses taken by students");
      students.stream()
              .filter(s-> s.sections != null)
            .flatMap(s -> s.sections.stream()).distinct().collect(Collectors.toList())
              .forEach(System.out::println);

        // Find all students who live in a given city (e.g., "Fairfield") sorted in alphabetical order
        System.out.println("6. Find all students who live in a given city (e.g., 'Fairfield') sorted in alphabetical order");
        students.stream()
                .filter(s->s.address.getCity().equals("Fairfield"))
                .sorted((s1, s2) -> s1.getName().compareTo(s2.getName()))
                .forEach(System.out::println);


        // Count the number of students enrolled in a specific course (e.g., "CS401")
        System.out.println("7. Count the number of students enrolled in a specific course (e.g., \"CS401\")");
        long count = students.stream()
                .filter(s-> s.sections !=null)
                .flatMap(s-> s.sections.stream())
                .filter(c -> c.getCourseCode().equals("CS401"))
                .count();
        System.out.println(count);

        // Get a list of students in a specific section
        System.out.println("8. Get a list of students in a specific section)");
        students.stream()
                .filter(s-> s.sections !=null)
                .flatMap(s-> s.sections.stream())
                .filter(c -> c.getCourseCode().equals("CS401"))
                .forEach(System.out::println);

        //  Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)
        System.out.println("9. Get the names of students who have enrolled in more than a given number of courses (e.g., more than 2 courses)");
        students.stream()
                .filter(s-> s.sections !=null && s.sections.size() > 2)
                .forEach(student -> System.out.println(student.getName()));


        // Get a list of unique course names taken by students who live in a given city (e.g., "Fairfield")
        System.out.println("10. Get a list of unique course names taken by students who live in a given city (e.g., \"Fairfield\")");
        students.stream()
                .filter(student -> student.address.getCity().equals("Fairfield"))
                .filter(student -> student.sections != null)
                .flatMap(student -> student.sections.stream())
                .distinct()
                .forEach(System.out::println);

        // Get a list of distinct addresses of students who are taking a specific course (e.g., "CS401")
        System.out.println("11. Get a list of distinct addresses of students who are taking a specific course (e.g., \"CS401\")");
        students.stream()
                .filter(s-> s.sections != null)
                .filter(s -> s.sections.stream()
                    .anyMatch(sec -> sec.getCourseCode().equals("CS401")))
                .map(student -> student.address)
                .distinct()
                .forEach(System.out::println);

        // Get a mapping of students' names to the list of courses they are taking
        System.out.println("12. Get a mapping of students' names to the list of courses they are taking");
        students.stream()
                .filter(student -> student.sections != null)
                .collect(Collectors.toMap(
                        Student::getName,
                        s -> s.sections.stream()
                                .map(Section::getCourseCode)
                                .collect(Collectors.toList())
                ))
                .forEach((name, courses) ->
                        System.out.println(name + " -> " + courses)
                );
    }
}
