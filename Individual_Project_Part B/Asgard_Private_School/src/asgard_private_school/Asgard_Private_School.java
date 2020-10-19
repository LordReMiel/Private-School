package asgard_private_school;

import Entity.Course;
import Entity.Student;
import Entity.Trainer;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ReMieL
 */
public class Asgard_Private_School {
    
    public static void main(String[] args) {
        
        String option = "";
        
        System.out.println("Welcome to Asgard Private School");
        
        do {
            
            UtilityClass.printMenu();
            Scanner choice = new Scanner(System.in);
            System.out.println("Please enter the number of your choice: ");
            System.out.print("\n> ");
            option = choice.next();
            
            switch (option) {
                
                case "1":
                    
                    UtilityClass.printStudents(Database.getAllStudents());
                    break;
                
                case "2":
                    
                    UtilityClass.printTrainers(Database.getAllTrainers());
                    break;
                
                case "3":
                    
                    UtilityClass.printAssignments(Database.getAllAssignments());
                    break;
                
                case "4":
                    
                    UtilityClass.printCourses(Database.getAllCourses());
                    break;
                
                case "5":
                    Database.getStudentsPerCourse();
                    break;
                case "6":
                    Database.getAllTrainersPerCourse();
                    
                    break;
                
                case "7":
                    Database.getallAssignmentsPerCourse();
                    break;
                
                case "8":
                    Database.getAllAssignmentsPerCoursePerStudent();
                    break;
                    
                case "9":
                    UtilityClass.printStudentsThatBelongToMoreThanOneCourse(Database.getStudentsWhoBelongtoMorethanOneCourse());
                    break;
                case "10":
                         String trainerName = UtilityClass.readStrings("Please enter the name of the Trainer?", "Please provide a valid First name");
                         String trainerLastName = UtilityClass.readStrings("Please enter Trainer's Last Name?", "Please provide a valid Last Name");
                         String trainerSubject = UtilityClass.readStrings("Please enter Trainer's Subject?", "Please provide a valid Subject");
                         
                         int rowsAffected = Database.insertNewTrainer(trainerName, trainerName, trainerSubject);
                         UtilityClass.successfullTrainerEntry(trainerName, trainerName, trainerSubject, rowsAffected);

                           
                    break;
                case "11":
                          int studentId = Database.selectStudentId();
                          int courseId = Database.selectCourseId();
                          int row =Database.insertStudentToCourse(studentId, courseId);
                          UtilityClass.successfulStudentToCourseEntry(studentId, courseId, courseId);
                   break;
                   
                case "12":
                         int trainerId = Database.selectTrainerId();
                         courseId = Database.selectCourseId();
                          row = Database.insertTrainerToCourse(trainerId, courseId);
                         UtilityClass.successfulTrainerToCourseEntry(trainerId, courseId, row);
                   break;
                   
                case "13":
                           studentId = Database.selectStudentId();
                           courseId = Database.selectCourseId();
                        int assignId = Database.selectAssignmentId();
                            row = Database.insertAssignmentToStudentsToCourses(assignId, studentId, courseId);
                            UtilityClass.successfulAssignmentToStudentToCourseEntry(studentId, courseId, assignId, row);
                        
                        
                default:
                    break;
            }
        } while (!option.toLowerCase().equals("quit"));
        
        
    }
    
}
