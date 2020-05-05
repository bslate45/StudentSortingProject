package sorter;

import java.io.*;
import java.util.*;

import studentGenerator.Generator;
import students.Student;

public class MainSorter {

	public static void main(String[] args) throws IOException {

		Scanner scanner = new Scanner(System.in);
		Generator generator = new Generator();

		int number_of_students = 0;

		try {

			System.out.print("Please input how many students to generate: ");
			number_of_students = scanner.nextInt();

			while (number_of_students <= 0) {

				System.out.println("Number of students cannot be less than or equal to zero.");
				System.out.print("Please re-enter how many students to generate: ");
				number_of_students = scanner.nextInt();

			}

		} catch (InputMismatchException e) {

			System.out.println("Input was not a number!");

		}
		scanner.close();

		generator.generate(number_of_students);
		System.out.println("\nGenerate list of " + number_of_students + " students: Success");
		LinkedList<Student> list = create_student_list();

		Collections.sort(list);

		FileWriter name_writer = new FileWriter("names_list_sorted.txt");

		for (int i = 0; i < list.size(); i++) {
			name_writer.write(list.get(i).getFirst_name() + " " + list.get(i).getLast_name() + "\n");
		}

		name_writer.close();

		System.out.println("Sort list: Success");
		System.out.println("Write list to file: Success.");

	}

	private static LinkedList<Student> create_student_list() {

		LinkedList<Student> student_object_linkedlist = new LinkedList<Student>();

		try {

			File names_file = new File("names_list_unsorted.txt");
			Scanner scan_names_file = new Scanner(names_file);

			while (scan_names_file.hasNextLine()) {

				String name_in_file = scan_names_file.nextLine();
				student_object_linkedlist.add(create_student_objects(name_in_file));

			}

			scan_names_file.close();

		} catch (FileNotFoundException e) {

			System.out.println("Could not open names list file!");

		}

		return student_object_linkedlist;
	}

	private static Student create_student_objects(String full_name) {

		Student new_student = new Student(full_name);
		return new_student;

	}

}
