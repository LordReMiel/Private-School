
package privateschool.vol3;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ReMieL
 */
public class UtilityClass {

	public static String readStrings(String message, String validationMessage) {
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		while (input.hasNextInt()) {
			System.out.println(validationMessage);
			input.nextInt();
		}
		String text = input.next();
		return text;
	}

	public static boolean readAnswer(String message, String validationMessage) {
		System.out.println(message);
		Scanner input = new Scanner(System.in);
		String text = input.next();
		while (!(text.toLowerCase().equals("yes") || text.toLowerCase().equals("no"))) {
			System.out.println(validationMessage);
			text = input.next();
		}
		if (text.toLowerCase().equals("yes")) {
			return true;
		} else {
			return false;
		}
	}

	public static String readDates(String message, String validationMessage) {
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		System.out.println("(Please provide a date in the following format : (dd/MM/yyyy)");
		String text = "";
		boolean valid = false;
		do {
			while (input.hasNextInt()) {
				System.out.println(validationMessage);
				input.nextInt();
			}
			String date = input.next();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			try {
				LocalDate.parse(date, formatter);
				valid = true;
				text = date;
			} catch (DateTimeParseException ex) {
				System.err.println("Please try again");
			}

		} while (!valid);
		return text;
	}

	public static void printingListofStudents(List<Student> list) {

		for (Student listOfStudent : list) {
			System.out.println(listOfStudent);
		}
	}

	public static int numberOfStudents() {
		Scanner input = new Scanner(System.in);
		int students;

		do {
			System.out.println("Please enter how many students you would like to enlist:");

			while (!input.hasNextInt()) {
				System.out.println("Please provide a valid number");
				input.next();
			}
			students = input.nextInt();
		} while (students <= 0);

		System.out.println("You entered that you want to enlist " + students + " students");

		return students;
	}

	public static int numberOfTrainers() {
		Scanner input = new Scanner(System.in);
		int trainers;

		do {
			System.out.println("Please enter how many trainers you would like to enlist:");

			while (!input.hasNextInt()) {
				System.out.println("Please provide a valid number");
				input.next();
			}
			trainers = input.nextInt();
		} while (trainers <= 0);

		System.out.println("You entered that you want to enlist " + trainers + " Trainers");

		return trainers;
	}

	public static void printintListOfTrainers(List<Trainer> list) {

		for (Trainer trainer : list) {

			System.out.println("Trainer Name: " + trainer.getFirstName() + " Last name : " + trainer.getLastName()
					+ " Subject: " + trainer.getSubject());
		}
	}

	public static int numberOfCourses() {
		Scanner input = new Scanner(System.in);
		int courses;

		do {
			System.out.println("Please enter how many courses you would like to enlist:");

			while (!input.hasNextInt()) {
				System.out.println("Please provide a valid number");
				input.next();
			}
			courses = input.nextInt();
		} while (courses <= 0);

		System.out.println("You entered that you want to enlist " + courses + " Courses");

		return courses;
	}

	public static void printingListofCourses(List<Course> list) {
		for (Course listOfCourse : list) {
			System.out.println(listOfCourse);
		}
	}

	public static int numberOfAssignments() {
		Scanner input = new Scanner(System.in);
		int assignments;

		do {
			System.out.println("Please enter how many assignments you would like to enter:");

			while (!input.hasNextInt()) {
				System.out.println("Please provide a valid number");
				input.next();
			}
			assignments = input.nextInt();
		} while (assignments <= 0);

		System.out.println("You entered that you want to enlist " + assignments + " Assignments");

		return assignments;

	}

	public static void printingListOfAssignments(List<Assignment> list) {

		for (Assignment listOfAssignment : list) {

			System.out.println(listOfAssignment);
		}
	}
}
