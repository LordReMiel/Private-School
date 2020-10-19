
package asgard_private_school;

import Entity.Assignment;
import Entity.Course;
import Entity.Student;
import Entity.Trainer;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ReMieL
 */
public class UtilityClass {
    
    
    
   public static void printMenu(){
       
        
        System.out.println("Please enter the number of the option that you would like to  perform or write Quit if you would like to quit the programm");
        System.out.println("");
        System.out.println("1. List of all Students.");
        System.out.println("2. List of all Trainers.");
        System.out.println("3. List of all Assignments.");
        System.out.println("4. List of all Courses.");
        System.out.println("5. List of all Students Per Course.");
        System.out.println("6. List of all Trainers Per Course.");
        System.out.println("7. List of all Assignments Per Course.");
        System.out.println("8. List of all Assignments Per Course Per Student");
        System.out.println("9. List of all Students that belong to more than one Course.");
        System.out.println("10.Insert a New Trainer");
        System.out.println("11.Insert a Student to Course");
        System.out.println("12.Insert a Trainer to Course");
        System.out.println("13.Insert an Assignment to Student to Course");
   }
   
   public  static void printStudents(List<Student> list){
       
       for (Student listOfStudents: list){
       System.out.println(             "Student ID: " + listOfStudents.getStudentID()+ 
                                                    " \tStudent First Name : " + listOfStudents.getFirstName() +
                                                    " \tStudent Last Name : " + listOfStudents.getLastName() +
                                                    " \tStudent Date Of Birth : " + listOfStudents.getDateOfBirth()+
                                                    " \tStudent Tuitions : " + listOfStudents.getTuitionFees() );    
                    System.out.println("");
       
       
   }
  
}
   
   public static void printCourses(List<Course> list){
        
       for (Course listOfCourses: list){
       System.out.println(             "CourseID: " + listOfCourses.getCourseId()+ 
                                                    " \tCourse Title : " + listOfCourses.getCourseTitle() +
                                                    " \tCourse Stream : " + listOfCourses.getCourseStream() +
                                                    " \tCourse Type : " + listOfCourses.getCourseType()+
                                                    " \tCourse Start Date : " + listOfCourses.getCourseStartDate()+
                                                    " \tCourse End Date : " + listOfCourses.getCourseEndDate());    
                    System.out.println("");
       
              }
   
   }
   
   
    public static void printTrainers(List<Trainer> list){
        
       for (Trainer listOfTrainers: list){
       System.out.println(             "TrainerID: " + listOfTrainers.getTrainerId()+ 
                                                    " \tTrainer First Name : " + listOfTrainers.getTrainerFirstName() +
                                                    " \tTrainer Last Name : " + listOfTrainers.getTrainerLastName() +
                                                    " \tTrainer Subject : " + listOfTrainers.getTrainerSubject());
                                                      
                    System.out.println("");
       
              }
   
   }
    
    
     public  static void printAssignments(List<Assignment> list){
       
       for (Assignment listOfAssignments: list){
       System.out.println(              "Assignment ID: " + listOfAssignments.getAssignmentId()+ 
                                                    " \tAssignment Title : " + listOfAssignments.getAssignmentTitle()+
                                                    " \tAssignment Description : " + listOfAssignments.getAssignmentDesc()+
                                                    " \tAssignment Submission Date : " + listOfAssignments.getAssignTotalMark()+
                                                    " \tAssignmnet Total Mark : " + listOfAssignments.getAssignTotalMark() );    
                    System.out.println("");
       
       
          }
   }
     
     public static void printStudentsThatBelongToMoreThanOneCourse(Map <Student, Integer> list){
         
         list.forEach((student, count)->
                        System.out.println( "Student Id: " + student.getStudentID()
                        +" ,First Name : " + student.getFirstName()
                        +" ,Last Name : " + student.getLastName()
                        +" and attends to " + count + " course(s) " )) ;
         
         
     }
     
     
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
     
     
     public static void successfullTrainerEntry (String firstName, String lastName, String subject, int row){
         
         if (row== 0) {
                        System.out.println("Something went wrong.");
                    } else {
                        System.out.println("A new Trainer was  inserted successfully." + 
                                                         " \t Trainer's First Name: " + firstName +
                                                          " \t Trainer's Last Name: " + lastName + 
                                                         " \t Trainer's Subject : " + subject);
                    }
     }
     
     public static int readInt(String message, String validationMessage) {
		Scanner input = new Scanner(System.in);
		System.out.println(message);
		while (input.hasNext()) {
			System.out.println(validationMessage);
			input.next();
		}
		int number = input.nextInt();
		return number;
	}
     
     
     public static void successfulTrainerToCourseEntry(int trainerId, int courseId, int row){
         
         System.out.println("The Trainer with ID: " +trainerId + " was successfully entered to the Course with id: " + courseId + " ,"+ row +" row(s) was updated");
     }
     
      public static void successfulStudentToCourseEntry(int studentId, int courseId, int row){
         
         System.out.println("The Student with ID: " +studentId + " was successfully entered to the Course with id: " + courseId + " ,"+ row +" row(s) was updated");
     }
      
      public static void successfulAssignmentToStudentToCourseEntry(int studentId, int courseId,int assignId, int row){
         
         System.out.println("The Student with ID: " +studentId + " was successfully entered to the Course with id: " + courseId + " and the Assignment with id: "+ assignId+" , " +row +" row(s) was updated.");
     }
     
}
