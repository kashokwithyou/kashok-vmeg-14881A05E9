import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
public class StudentGroup implements StudentArrayOperation {

	private Student[] students;
	
	public StudentGroup(int length) {
        students = new Student[0];
	}

	
	public Student[] getStudents() {
         return this.students;
	}

	
	public void setStudents(Student[] students) {
         this.students = students;
	}

	
	public Student getStudent(int index) {
          return students[index];
	}

	
	public void setStudent(Student student, int index) {
           this.getStudents()[index] = student;
	}

	public void addFirst(Student student) {
         Student[] temp = new Student[this.students.length+1];
		 temp[0] = student;
		 for(int i = 1; i < temp.length; i++)
			 temp[i] = this.students[i-1];
		 this.students = temp;
	}

	
	public void addLast(Student student) {
         Student[] temp = new Student[this.getStudents().length+1];
		 for(int i = 0; i < this.students.length; i++)
			 temp[i] = this.students[i];
		 temp[temp.length - 1] = student;
		 this.students = temp;
	}

	
	public void remove(int index) {
         Student[] temp = new Student[this.students.length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.students.length; i++)
			 if(i != index) temp[c++] = this.students[i];
		 this.students = temp;
	}

	
	public void remove(Student student) {
         Student[] temp = new Student[this.students.length-1]; 
		 int c = 0;
		 for(int i = 0; i < this.students.length; i++)
			 if(this.students[i] != student) temp[c++] = this.students[i];
		 this.students = temp;
	}

	
	public void removeFromIndex(int index) {
         Student[] temp = new Student[index]; 
		 int c = 0;
		 for(int i = 0; i < index; i++)
			 temp[i] = this.students[i];
		 this.students = temp; 
	}

	
	public void removeFromElement(Student student) {
           int ind = getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = 0; i < ind; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	
	public void removeToIndex(int index) {
         Student[] temp = new Student[this.students.length-index]; 
		 int c = 0;
		 for(int i = index; i < this.students.length; i++)
			 temp[i-index] = this.students[i];
		 this.students = temp;
	}

	
	public void removeToElement(Student student) {
           int ind = getStudentIndex(student);
		   ArrayList<Student> temp = new ArrayList<>();
		   for(int i = ind; i < this.students.length; i++)
			   temp.add(this.students[i]);
		   this.students = temp.toArray(new Student[temp.size()]);
	}

	
	public void bubbleSort() {
          for(int i = 0; i < this.students.length; i++)
		  {
			  
	          for(int j = 0; j < this.students.length-i-1; j++)
			  {
                   if(this.students[j].getId() > this.students[j+1].getId())
				   {
					   Student temp = this.students[j];
					   this.students[j] = this.students[j+1];
					   this.students[j+1] = temp;
				   }
			  }	   
		  }
	}


	public Student[] getByBirthDate(Date date) {
           ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().compareTo(date) == 0)
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]);
	}

	
	public Student[] getBetweenBirthDates(Date firstDate, Date lastDate) {
         ArrayList<Student> temp = new ArrayList<>();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().after(firstDate) && s.getBirthDate().before(lastDate))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]); 
	}

	
	public Student[] getNearBirthDate(Date date, int days) {
           ArrayList<Student> temp = new ArrayList<>();
		   Calendar cal = getCalendar(date);
		   cal.add(Calendar.DATE, days);
           date = cal.getTime();
		   for(Student s : this.students)
		   {
		       if(s.getBirthDate().before(date))
				   temp.add(s);
		   }
		   return  temp.toArray(new Student[temp.size()]); 
	}

	
	public int getCurrentAgeByDate(int indexOfStudent) {
		   Date now = new Date();
           return this.students[indexOfStudent].getBirthDate().getYear() - now.getYear();
	}


	public Student[] getStudentsByAge(int age) {
          ArrayList<Student> temp = new ArrayList<>();
		  for(int i = 0; i < this.students.length; i++)
		  {
		      if(getCurrentAgeByDate(i) == age)
				  temp.add(this.students[i]);
		  }
          return  temp.toArray(new Student[temp.size()]);
	}

	
	public Student[] getStudentsWithMaxAvgMark() {
          double maxavg = 0;
		  for(Student s : this.students)
			  if(s.getAvgMark() > maxavg) maxavg = s.getAvgMark();
		  ArrayList<Student> temp = new ArrayList<>();
		  for(Student s : this.students)
			  if(s.getAvgMark() == maxavg)  temp.add(s);
		  return  temp.toArray(new Student[temp.size()]);
	}

	
	public Student getNextStudent(Student student) {
           this.bubbleSort();
		   int i;
		   for(i = 0; i < this.students.length; i++)
			   if(this.students[i].equals(student)) break;
		   return this.students[i+1];

	}

	
	public void add(Student student, int index) {
         Student[] temp = new Student[this.students.length+1];
		 for(int i = 0; i < index; i++)
			 temp[i] = this.students[i];
		 temp[index] = student;
		 for(int i = index; i < this.students.length; i++)
			 temp[i+1] = this.students[i];
		 this.students = temp;
	}

	private int getStudentIndex(Student student) {
         for(int i = 0; i < this.students.length; i++)
			 if(this.students[i].equals(student)) return i;
		 return -1;
    }

	private int getDiffYears(Date first, Date last) {
            return first.getYear() - last.getYear();
	}

	private Calendar getCalendar(Date date) {
          Calendar aDay = Calendar.getInstance();
          aDay.setTime(date);
		  return aDay;
	}

}