package students;

public class Student implements java.lang.Comparable<Student> {
	
	private String first_name;
	private String last_name;
	
	public Student(String full_name) {
		
		String[] string_array = full_name.split(" ");
		this.setFirst_name(string_array[0]);
		
		try {
			this.setLast_name(string_array[1]);
		} catch (ArrayIndexOutOfBoundsException e){
			this.setLast_name(" ");
		}
		
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public int compareTo(Student other_student) {
		if(this.last_name.compareTo(other_student.last_name) > 0) {
			return 1; 
		}
		else if(this.last_name.compareTo(other_student.last_name) < 0) {
	    	return -1;
	    }
	    else {
	    	
	    	if(this.first_name.compareTo(other_student.first_name) > 0) {
				return 1; 
			}
			else if(this.first_name.compareTo(other_student.first_name) < 0) {
		    	return -1;
		    }
		    else {
		    	return 0;
		    }
	    }
	}

}
