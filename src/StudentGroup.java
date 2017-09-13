import java.util.Date;

/**
 * A fix-sized array of students
 * array length should always be equal to the number of stored elements
 * after the element was removed the size of the array should be equal to the number of stored elements
 * after the element was added the size of the array should be equal to the number of stored elements
 * null elements are not allowed to be stored in the array
 * 
 * You may add new methods, fields to this class, but DO NOT RENAME any given class, interface or method
 * DO NOT PUT any classes into packages
 *
 */
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	/**
	 * DO NOT remove or change this constructor, it will be used during task check
	 * @param length
	 */
	public StudentGroup(int length) {
		this.students = new Student[length];
	}

	@Override
	public Student[] getStudents() {
		// Add your implementation here
                if(students.length>0) {
                    return students;
                } else {
                    return null;
                }
	}

	@Override
	public void setStudents(Student[] students) {
		// Add your implementation here
                for(int i=0;i<students.length;i++) {
                    this.students[i] = students[i];
                }
                
	}

	@Override
	public Student getStudent(int index) {
		// Add your implementation here
                if(index>students.length) {
                    return null;
                } else {
                    return students[index];
                }
	}

	@Override
	public void setStudent(Student student, int index) {
		// Add your implementation here
                 if(index>students.length) {
                    
                } else {
                    students[index] = student;
                 }
	}

	@Override
	public void addFirst(Student student) {
		// Add your implementation here
                for(int i=1;i<students.length;i++) {
                    students[i] = students[i+1];
                }
                students[0] = student;
	}

	@Override
	public void addLast(Student student) {
		// Add your implementation here
                students[students.length+1] = student;
	}

	@Override
	public void add(Student student, int index) {
		// Add your implementation here
                for(int i=index;i<students.length;i++) {
                    students[i] = students[i+1];
                }
                students[index] = student;
	}

	@Override
	public void remove(int index) {
		// Add your implementation here
                for(int i=index;i<students.length;i++) {
                    students[i] = students[i+1];
                }
	}

	@Override
	public void remove(Student student) {
		// Add your implementation here
                int i=0;
                for(i=0;students[i] != student;i++) {
                
                }
                for(int j=i;j<students.length;j++) {
                    students[j] = students[j+1];
                }
	}

	@Override
	public void removeFromIndex(int index) {
		// Add your implementation here
                for(int i=index;i<students.length;i++) {
                    students[i] = null;
                }
	}

	@Override
	public void removeFromElement(Student student) {
		// Add your implementation here
		int i=0;
		 Student[] temp=new Student[100];
		for(Student s:students)
		{
			if(s.equals(student))
			{
				break;
			}
			temp[i++]=s;
		     
		}
		students=temp;
		
	
               
	}

	@Override
	public void removeToIndex(int index) {
		// Add your implementation here
                for(int i=0;i<students.length;i++) {
                    if(i+index > students.length){
                        break;
                    }
                        students[i] = students[i+index];
                }
	}

	@Override
	public void removeToElement(Student student) {
		// Add your implementation here
		int i;
		Student[] temp=new Student[100];
		for( i=0;i<students.length;i++)
		{
			if(students[i]==student)
			{
				break;
			}
		}
		for(;i<students.length;i++)
		{
			temp[i]=students[i];
	    }
                
	}

	@Override
	public void bubbleSort() {
		// Add your implementation here
		int i;
		Student[] temp=new Student[100];
		for(i=0;i<students.length;i++)
		{
			/*if(students[i] > students[i+1])
			{
				temp[i]=students[i];
				students[i]=students[i+1];
				students[i+1]=temp[i];
			}*/
		}
               
                
	}

	@Override
	public Student[] getByBirthDate(Date date) {
		
		return null;
	}

	@Override
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
		// Add your implementation here
                return null;
	}

	@Override
	public Student[] getNearBirthDate(Date date, int days) {
		// Add your implementation here
		return null;
	}

	@Override
	public int getCurrentAgeByDate(int indexOfStudent) {
		// Add your implementation here
		return 0;
	}

	@Override
	public Student[] getStudentsByAge(int age) {
		// Add your implementation here
               
		return null;
	}

	@Override
	public Student[] getStudentsWithMaxAvgMark() {
		// Add your implementation here
                
		return null;
	}

	@Override
	public Student getNextStudent(Student student) {
		// Add your implementation here
                return null;
	}
}