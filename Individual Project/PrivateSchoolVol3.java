package privateschool.vol3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author ReMieL
 */
public class PrivateSchoolVol3 {

    public static void main(String[] args) {

        List<Student> listOfStudents = new ArrayList<Student>();

        List<Trainer> listOfTrainers = new ArrayList<Trainer>();

        List<Course> listOfCourses = new ArrayList<Course>();

        List<Assignment> listOfAssignment = new ArrayList<Assignment>();

        System.out.println("========= Welcome to Asgard :The School of Gods =========\n");

        System.out.println("In Order for our Ranks to be filled\n");
        int y = UtilityClass.numberOfStudents();
        for (int i = 0; i < y; i++) {

            listOfStudents.add(enterNewStudent());

        }
        System.out.println("================== Printing Students===============\n");
        UtilityClass.printingListofStudents(listOfStudents);

        System.out.println("============ Trainers ============\n");

        int z = UtilityClass.numberOfTrainers();
        for (int i = 0; i < z; i++) {

            listOfTrainers.add(enterTrainerDetails());

        }

        System.out.println("================== Printing Trainers ===============\n");
        UtilityClass.printintListOfTrainers(listOfTrainers);

        System.out.println("============ Courses ============\n");

        int j = UtilityClass.numberOfCourses();
        for (int i = 0; i < j; i++) {
            listOfCourses.add(enterNewCourse());
        }

        System.out.println("================== Printing Courses ===============\n");
        UtilityClass.printingListofCourses(listOfCourses);

        System.out.println("============ Assignments ============\n");

        int x = UtilityClass.numberOfAssignments();

        for (int i = 0; i < x; i++) {
            listOfAssignment.add(enterNewAssignment());
        }

        System.out.println("================== Printing Assignments ===============\n");
        UtilityClass.printingListOfAssignments(listOfAssignment);

        List<StudentsPerCourse> spcList = getStudentsPerCourse(listOfCourses, listOfStudents);

        List<TrainersPerCourse> trainersPerCourse = getTrainersPerCourse(listOfCourses, listOfTrainers);

        List<AssignmentsPerCourse> assignmentsPerCourse = getAssignmentsPerCourse(listOfCourses, listOfAssignment);
        
        List<AssignmentsPerStudent> assPerStd = getAssignmentsPerStudent(listOfStudents, spcList, assignmentsPerCourse);

    }

    private static Student enterNewStudent() {
        System.out.println("\n============ Please enter the details of the Student ============");
        Scanner input = new Scanner(System.in);
        Student newStudent = new Student();

        newStudent.setFirstName(UtilityClass.readStrings("Please enter the name of the student?", "Please provide a valid firstname"));

        newStudent.setLastName(UtilityClass.readStrings("Please enter Student's Last Name:", "Please provide a valid lastname"));

        do {
            System.out.println("Please enter the tuition fees of student");

            while (!input.hasNextInt()) {
                System.out.println("Please provide a valid number");
                input.next();
            }
            newStudent.setTuitionFees(input.nextInt());
        } while (newStudent.getTuitionFees() < 0);

        newStudent.setDateOfBirth(UtilityClass.readDates("Please enter student's date of birth", "Please enter valid date"));

        return newStudent;

    }

    private static Trainer enterTrainerDetails() {
        System.out.println("\n============ Please enter the details of the Trainer ============");
        Trainer newTrainer = new Trainer();

        newTrainer.setFirstName(UtilityClass.readStrings("Please enter the name of the Trainer?", "Please provide a valid firstname"));

        newTrainer.setLastName(UtilityClass.readStrings("Please enter Trainer's Last Name:", "Please provide a valid lastname"));

        newTrainer.setSubject(UtilityClass.readStrings("Please enter the subject of the Trainer", "Please provide a valid name of subject"));

        return newTrainer;
    }

    private static Course enterNewCourse() {

        System.out.println("\n============ Please enter the details of the Course============");

        Scanner input = new Scanner(System.in);

        Course newCourse = new Course();

        newCourse.setTitle(UtilityClass.readStrings("Please enter the Title of the Course?", "Please provide a valid name"));

        newCourse.setStream(UtilityClass.readStrings("Please enter Courses Stream:", "Please provide a valid name"));

        newCourse.setType(UtilityClass.readStrings("Please enter the Type of the Course", "Please provide a valid name"));

        newCourse.setStart_date(UtilityClass.readDates("Please enter the Start Date of the Course", "Please provide a valid date in the form of dd//MM/yyyy"));

        newCourse.setEnd_date(UtilityClass.readDates("Please enter the End Date of the Course", "Please provide a valid date in the form of dd//MM/yyyy"));

        return newCourse;

    }

    private static Assignment enterNewAssignment() {

        System.out.println("\n============ Please enter the details of the Assignment ============");

        Scanner input = new Scanner(System.in);

        Assignment newAssignment = new Assignment();

        newAssignment.setTitle(UtilityClass.readStrings("Please enter the title of the assignment?", "Please provide a valid title"));
        newAssignment.setDescription(UtilityClass.readStrings("Please enter the description of the assignment?", "Please provide a valid description"));
        newAssignment.setSubDateTime(UtilityClass.readDates("Please enter the submission date of the assignment", "Please enter a valid date"));

        return newAssignment;

    }

    private static List<StudentsPerCourse> getStudentsPerCourse(List<Course> listOfCourses, List<Student> listOfStudents) {

        System.out.println("============ Students Per Course : ============\n");

        List<StudentsPerCourse> spcList = new ArrayList<StudentsPerCourse>();

        for (Course course : listOfCourses) {

            System.out.println("Please enter the Students you would like to add for the course: " + course.getTitle());
            List<Student> courseStudents = new ArrayList<Student>();
            for (Student student : listOfStudents) {
                System.out.println("Do you want to add the Student: " + student.getFirstName() + student.getLastName());
                if (UtilityClass.readAnswer("Please use (Yes) for yes and (No) for no", "Invalid input")) {
                    courseStudents.add(student);
                }
            }
            StudentsPerCourse studentsPerCourse = new StudentsPerCourse(course, courseStudents);
            spcList.add(studentsPerCourse);
        }

        System.out.println("========= Printing Students Per Course ===============\n");

        for (StudentsPerCourse studentsPerCourse : spcList) {
            System.out.println("For Course: " + studentsPerCourse.getCourse().getTitle() + " we have the following students\n");
            UtilityClass.printingListofStudents(studentsPerCourse.getStudents());
        }
		return spcList;
    }

    private static List<TrainersPerCourse> getTrainersPerCourse(List<Course> listOfCourses, List<Trainer> listOfTrainers) {
        System.out.println("============ Trainers Per Course : ============\n");

        List<TrainersPerCourse> trainersPerCourse = new ArrayList<TrainersPerCourse>();

        for (Course course : listOfCourses) {

            System.out.println("Please enter the Trainers you would like to add for the course: " + course.getTitle());
            List<Trainer> courseTrainers = new ArrayList<Trainer>();

            for (Trainer trainer : listOfTrainers) {

                System.out.println("Do you want to add the Trainer: " + trainer.getFirstName() + trainer.getLastName());
                if (UtilityClass.readAnswer("Please use (Yes) for yes and (No) for No", "Invalid input")) {
                    courseTrainers.add(trainer);
                }

            }

            TrainersPerCourse trainerPerCourse = new TrainersPerCourse(course, courseTrainers);
            trainersPerCourse.add(trainerPerCourse);
        }

        System.out.println("========= Printing Trainers Per Course ===============\n");

        for (TrainersPerCourse trainerPerCourse : trainersPerCourse) {
            System.out.println("For Course: " + trainerPerCourse.getCourse().getTitle() + " we have the following trainers\n");
            UtilityClass.printintListOfTrainers(trainerPerCourse.getTrainers());
        }
		return trainersPerCourse;

    }

    private static List<AssignmentsPerCourse> getAssignmentsPerCourse(List<Course> listOfCourses, List<Assignment> listOfAssignment) {

        System.out.println("============ Assignments Per Course : ============\n");

        List<AssignmentsPerCourse> assignmentsPerCourse = new ArrayList<AssignmentsPerCourse>();

        for (Course course : listOfCourses) {

            System.out.println("Please enter the Assignments you would like to add for the course: " + course.getTitle());

            List<Assignment> courseAssignments = new ArrayList<Assignment>();

            for (Assignment assignment : listOfAssignment) {

                System.out.println("Do you want to add the Assignment: " + assignment.getTitle() + "with description " + assignment.getDescription() + " and submision date " + assignment.getSubDateTime());

                if (UtilityClass.readAnswer("Please use (Yes) for yes and (No) for no", "Invalid input")) {

                    courseAssignments.add(assignment);

                }

            }

            AssignmentsPerCourse assignmentPerCourse = new AssignmentsPerCourse(course, courseAssignments);
            assignmentsPerCourse.add(assignmentPerCourse);
        }

        System.out.println("========= Printing Assignments Per Course ===============\n");

        for (AssignmentsPerCourse assignmentPerCourse : assignmentsPerCourse) {

            System.out.println("\nFor Course: " + assignmentPerCourse.getCourse().getTitle() + " we have the following Assignments ");

            UtilityClass.printingListOfAssignments(assignmentPerCourse.getAssignments());

        }
		return assignmentsPerCourse;

    }
    
    private static List<AssignmentsPerStudent> getAssignmentsPerStudent(List<Student> listOfStudents, List<StudentsPerCourse> spcList,
    		List<AssignmentsPerCourse> assignmentsPerCourse){
    	List<AssignmentsPerStudent> assPerStd = new ArrayList<AssignmentsPerStudent>();
        for(Student student : listOfStudents) {
        	List<Course> courses = new ArrayList<Course>();
        	for(StudentsPerCourse spc : spcList) {
        		for(Student std : spc.getStudents()) {
        			if(student.equals(std)) {
        				courses.add(spc.getCourse());
        			}
        		}
        	}
        	if(courses.size() > 1) {
        		System.out.println("\n Student: " + student.getFirstName() + " " + student.getLastName() + " has " +  courses.size() + " Courses");
        	}
        	List<Assignment> assignments = new ArrayList<Assignment>();
        	for(Course course : courses) {
        		for(AssignmentsPerCourse apc : assignmentsPerCourse) {
        			if(apc.getCourse().equals(course)) {
        				assignments.addAll(apc.getAssignments());
        			}
        		}
        	}
        	assPerStd.add(new AssignmentsPerStudent(student, assignments));
        	System.out.println("\nFor Student: " + student.getFirstName() + " " + student.getLastName() + " we have the following Assignments ");
        	UtilityClass.printingListOfAssignments(assignments);
        }
        
        return assPerStd;
    }

}
