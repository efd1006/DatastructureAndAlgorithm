//sample generic datatype using mutator and accessor
class sample_generic{
	public static void main(String[] args){
		Student[] students = new Student[3];
		students[0] = new Student(1, "Edmar", "Diaz");
		students[1] = new Student(2, "Tami", "Ascano");
		students[2] = new Student(3, "Adrian", "Borruel");
		
		for(Student student : students) {
			System.out.println("Student Number: " + student.getUsn());
			System.out.println("Full Name: " + student.getFirstName() + " " + student.getLastName());
		}
	}
}

class Student{
	private int _usn;
	private String _FirstName;
	private String _LastName;
	
	Student(int usn, String firstname, String lastname){
		this._usn = usn;
		this._FirstName = firstname;
		this._LastName = lastname;
	}
	
	public int getUsn(){
		return _usn;
	}
	
	public String getFirstName() {
		return _FirstName;
	}
	
	public String getLastName() {
		return _LastName;
	}
}