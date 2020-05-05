package studentGenerator;

import java.io.*;
import java.util.*;

public class Generator {
	
	public void generate(int num) throws IOException {

		Random rand = new Random();
		int how_many_names = num;
		String first_name = "";
		String last_name = "";
		String full_name;

		try {
			
			FileWriter name_writer = new FileWriter("names_list_unsorted.txt");

			for (int i = 0; i < how_many_names; i++) {
				
				File first_names_file = new File("first_names.txt");
				File last_names_file = new File("last_names.txt");
				Scanner scan_first_names_file = new Scanner(first_names_file);
				Scanner scan_last_names_file = new Scanner(last_names_file);

				/*
				 * Creates a random number that will be used to pick the name in that number's
				 * index within the first_names.txt file.
				 */
				int first_name_random_int = rand.nextInt(201);

				/*
				 * Creates a random number that will be used to pick the name in that number's
				 * index within the last_names.txt file.
				 */
				int last_name_random_int = rand.nextInt(981);
				
				int no_last_name_prob = rand.nextInt(100);
				int first_count = 0;
				int last_count = 0;

				while (scan_first_names_file.hasNextLine()) {

					String name_in_file = scan_first_names_file.nextLine();
					
					if (first_count == first_name_random_int) {
						first_name = name_in_file;
						break;
					}
					
					first_count++;
				}

				while (scan_last_names_file.hasNextLine()) {

					String name_in_file = scan_last_names_file.nextLine();
					
					if(no_last_name_prob > 89) {
						last_name = " ";
						break;
					} else if (last_count == last_name_random_int) {
						last_name = name_in_file;
						break;
					}
					
					last_count++;
				}

				full_name = first_name + " " + last_name;
				name_writer.write(full_name + "\n");
				
				scan_first_names_file.close();
				scan_last_names_file.close();

			}

			
			name_writer.close();

		} catch (FileNotFoundException e) {

			System.out.println("Could not open first/last names file!");

		}

	}

}
