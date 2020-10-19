package asgard_private_school;

import Entity.Assignment;
import Entity.Course;
import Entity.Student;
import Entity.Trainer;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author ReMieL
 */
public class Database {

    public static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    public static final String DB_URL = "jdbc:mysql://localhost/asgard_private_school?serverTimezone=UTC";
    public static final String USERNAME = "odin";
    public static final String PASSWORD = "root";

    public static List<Student> getAllStudents() {

        List<Student> students = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT ID, FIRST_NAME, LAST_NAME, DATE_OF_BIRTH, TUITION_FEES FROM STUDENTS";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int studentId = resultSet.getInt(1);
                String studentFirstName = resultSet.getString(2);
                String studentLastName = resultSet.getString(3);
                Date dateOfBirth = resultSet.getDate(4);
                double tuitionFees = resultSet.getDouble(5);

                Student student = new Student(studentId, studentFirstName, studentLastName, dateOfBirth, tuitionFees);
                students.add(student);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return students;

    }

    public static List<Trainer> getAllTrainers() {

        List<Trainer> trainers = new ArrayList();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT ID, FIRST_NAME, LAST_NAME, SUBJECT FROM TRAINERS";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int trainerId = resultSet.getInt(1);
                String trainerFirstName = resultSet.getString(2);
                String trainerLastName = resultSet.getString(3);
                String trainerSubject = resultSet.getString(4);

                Trainer trainer = new Trainer(trainerId, trainerFirstName, trainerLastName, trainerSubject);
                trainers.add(trainer);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return trainers;
    }

    public static List<Course> getAllCourses() {

        List<Course> courses = new ArrayList<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT ID, TITLE, STREAM, TYPE, START_DATE, END_DATE FROM COURSES";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int coursetId = resultSet.getInt(1);
                String courseTitle = resultSet.getString(2);
                String courseStream = resultSet.getString(3);
                String courseType = resultSet.getString(4);
                Date courseStartDate = resultSet.getDate(5);
                Date courseEndDate = resultSet.getDate(6);

                Course course = new Course(coursetId, courseTitle, courseStream, courseTitle, courseStartDate, courseEndDate);
                courses.add(course);

            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return courses;
    }

    public static List<Assignment> getAllAssignments() {

        List<Assignment> assignments = new ArrayList();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT ID, TITLE, DESCRIPTION, SUB_DATE, TOTAL_MARK FROM ASSIGNMENTS";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int assignmentId = resultSet.getInt(1);
                String assignmentTitle = resultSet.getString(2);
                String assignmentDescription = resultSet.getString(3);
                Date assignmentSubDate = resultSet.getDate(4);
                double assignmentTotalMark = resultSet.getDouble(5);

                Assignment assignment = new Assignment(assignmentId, assignmentTitle, assignmentTitle, assignmentSubDate, assignmentTotalMark);
                assignments.add(assignment);
            }

        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
        return assignments;
    }

    public static void getStudentsPerCourse() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT TITLE , FIRST_NAME , LAST_NAME \n"
                    + "FROM COURSES ,STUDENTS, STUDENTS_PER_COURSE\n"
                    + "WHERE STUDENTS_PER_COURSE.STUDENT_ID = STUDENTS.ID\n"
                    + "AND  COURSES.ID = STUDENTS_PER_COURSE.COURSE_ID";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("==========================================================================");
                String courseTitle = resultSet.getString("TITLE");
                String studentFirstName = resultSet.getString("FIRST_NAME");
                String studentLastName = resultSet.getString("LAST_NAME");

                System.out.println("Course Title: " + courseTitle
                        + "\tStudent First Name : " + studentFirstName
                        + " \tStudent Last Name: " + studentLastName);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

    }

    public static void getAllTrainersPerCourse() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT TITLE , FIRST_NAME , LAST_NAME \n"
                    + "FROM COURSES ,TRAINERS, TRAINERS_PER_COURSE\n"
                    + "WHERE TRAINERS_PER_COURSE.TRAINER_ID = TRAINERS.ID\n"
                    + "AND  COURSES.ID = TRAINERS_PER_COURSE.COURSE_ID";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("=====================================================================");
                String courseTitle = resultSet.getString("TITLE");
                String trainerFirstName = resultSet.getString("FIRST_NAME");
                String trainerLastName = resultSet.getString("LAST_NAME");

                System.out.println("Course Title: " + courseTitle
                        + "\tTrainer First Name : " + trainerFirstName
                        + " \tTrainer Last Name: " + trainerLastName);

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void getallAssignmentsPerCourse() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT COURSES.TITLE , COURSES.STREAM, COURSES.TYPE, ASSIGNMENTS.TITLE, ASSIGNMENTS.DESCRIPTION, \n"
                    + "FROM COURSES ,ASSIGNMENTS, ASSIGNMENTS_PER_COURSE\n"
                    + "WHERE ASSIGNMENTS_PER_COURSE.ASSIGNMENT_ID = ASSIGNMENTS.ID\n"
                    + "AND  COURSES.ID = ASSIGNMENTS_PER_COURSE.COURSE_ID";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                System.out.println("=====================================================================");
                String courseTitle = resultSet.getString("COURSES.TITLE");
                String courseStream = resultSet.getString("COURSES.STREAM");
                String courseType = resultSet.getString("COURSES.TYPE");
                String assignTitle = resultSet.getString("ASSIGNMENTS.TITLE");
                String assignDescr = resultSet.getString("ASSIGNMENTS.DESCRIPTION");

                System.out.println("Course Title: " + courseTitle
                        + " \tCourse Stream : " + courseStream
                        + " \tCourse Type : " + courseType
                        + " \tAssignment Title : " + assignTitle
                        + " \tAssignment Description: " + assignDescr);

                System.out.println("=====================================================================");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static void getAllAssignmentsPerCoursePerStudent() {

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = "SELECT  COURSES.ID, COURSES.TITLE , COURSES.STREAM, COURSES.TYPE, ASSIGNMENTS.ID, ASSIGNMENTS.TITLE, ASSIGNMENTS.DESCRIPTION, STUDENTS.ID, STUDENTS.FIRST_NAME, STUDENTS.LAST_NAME \n"
                    + "FROM COURSES ,ASSIGNMENTS, STUDENTS, ASSIGNMENTS_PER_COURSE_PER_STUDENT\n"
                    + "WHERE ASSIGNMENTS_PER_COURSE_PER_STUDENT.ASSIGNMENT_ID = ASSIGNMENTS.ID\n"
                    + "AND  ASSIGNMENTS_PER_COURSE_PER_STUDENT.COURSE_ID = COURSES.ID AND ASSIGNMENTS_PER_COURSE_PER_STUDENT.STUDENT_ID = STUDENTS.ID";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int courseId = resultSet.getInt("COURSES.ID");
                String courseTitle = resultSet.getString("COURSES.TITLE");
                String courseStream = resultSet.getString("COURSES.STREAM");
                String courseType = resultSet.getString("COURSES.TYPE");
                int assignmentId = resultSet.getInt("ASSIGNMENTS.ID");
                String assignTitle = resultSet.getString("ASSIGNMENTS.TITLE");
                String assignDescr = resultSet.getString("ASSIGNMENTS.DESCRIPTION");
                int studentId = resultSet.getInt("STUDENTS.ID");
                String studentFirstName = resultSet.getString("FIRST_NAME");
                String studentLastName = resultSet.getString("LAST_NAME");

                System.out.println("Course Id: " + courseId
                        + " \tCourse Title: " + courseTitle
                        + " \tCourse Stream : " + courseStream
                        + " \tCourse Type : " + courseType
                        + " \tAssignments Id: " + assignmentId
                        + " \tAssignment Title : " + assignTitle
                        + " \tAssignment Description: " + assignDescr
                        + " \tStudent Id: " + studentId
                        + " \tStudent First Name: " + studentFirstName
                        + " \tStudent Last Name: " + studentLastName
                );

                System.out.println("=====================================================================================================================");

            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }
    }

    public static Map<Student, Integer> getStudentsWhoBelongtoMorethanOneCourse() {

        Map<Student, Integer> studentsMap = new HashMap<>();

        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            Class.forName(JDBC_DRIVER);

            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " SELECT STUDENTS_PER_COURSE.STUDENT_ID, STUDENTS.FIRST_NAME, STUDENTS.LAST_NAME, COUNT(STUDENTS_PER_COURSE.STUDENT_ID) AS TOTAL_COURSES "
                    + "FROM STUDENTS, STUDENTS_PER_COURSE "
                    + "WHERE STUDENTS.ID = STUDENTS_PER_COURSE.STUDENT_ID "
                    + "GROUP BY STUDENTS_PER_COURSE.STUDENT_ID "
                    + "HAVING COUNT(STUDENTS_PER_COURSE.STUDENT_ID) > 1 "
                    + "ORDER BY STUDENTS_PER_COURSE.STUDENT_ID ";

            preparedStatement = conn.prepareStatement(query);

            resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {

                int studentId = resultSet.getInt("STUDENTS.ID");
                String studentFirstName = resultSet.getString("STUDENTS.FIRST_NAME");
                String studentLastName = resultSet.getString("STUDENTS.LAST_NAME");
                int count = resultSet.getInt("TOTAL_COURSES");

                Student student = new Student(studentId, USERNAME, USERNAME);
                studentsMap.put(student, count);
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        } catch (SQLException e) {
            e.printStackTrace();

        } finally {

            if (resultSet != null) {

                try {
                    resultSet.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }

                if (preparedStatement != null) {

                    try {
                        preparedStatement.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

                if (conn != null) {

                    try {
                        conn.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }

            }
        }

        return studentsMap;
    }

    public static int insertNewTrainer(String firstName, String lastName, String subject) {

        int rowsAffected = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO TRAINERS(FIRST_NAME, LAST_NAME, SUBJECT) VALUES (?, ?, ?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, firstName);
            preparedStatement.setString(2, lastName);
            preparedStatement.setString(3, subject);

            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }

    public static int selectStudentId() {

        List<Student> students = getAllStudents();
        Scanner input = new Scanner(System.in);
        boolean studentExists = false;
        int studentId = -1;

        do {
            System.out.println("This is the List Of Students: ");

            students.forEach((student) -> {
                System.out.println("Id: " + student.getStudentID()
                        + " \tStudent First Name: " + student.getFirstName()
                        + " \tStudent Last Name: " + student.getLastName()
                        + " \tStudent Date Of Birth: " + student.getDateOfBirth());
            });

            System.out.print("\n> ");
            studentId = UtilityClass.readInt("Select the id of the Student you would like to enlist: ", "Please enter a valid number");

            for (Student s : students) {
                if (s.getStudentID() == studentId) {
                    studentExists = true;
                    break;
                }
            }
            if (!studentExists) {
                System.out.println("This Student does not exist. Select another Student id.");
            }
        } while (!studentExists);
        return studentId;
    }

    public static int selectCourseId() {

        List<Course> courses = getAllCourses();
        Scanner input = new Scanner(System.in);
        boolean courseExists = false;
        int courseId = -1;

        do {
            System.out.println("This is the List Of Courses: ");

            courses.forEach((course) -> {
                System.out.println("Id: " + course.getCourseId()
                        + " \tCourse Title: " + course.getCourseTitle()
                        + " \tCourse Stream: " + course.getCourseStream()
                        + " \tCourse Type: " + course.getCourseType()
                        + " \tCourse Start Date: " + course.getCourseStartDate()
                        + " \tCourse End Date:" + course.getCourseEndDate());
            });

            System.out.print("\n> ");
            courseId = UtilityClass.readInt("Select the id of the Course you would like to choose: ", "Please enter a valid number");

            for (Course c : courses) {
                if (c.getCourseId() == courseId) {
                    courseExists = true;
                    break;
                }
            }
            if (!courseExists) {
                System.out.println("This Course does not exist. Select another Course id.");
            }
        } while (!courseExists);
        return courseId;
    }

    public static int insertStudentToCourse(int studentId, int courseId) {
        int rowsAffected = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO STUDENTS_PER_COURSE(COURSE_ID, STUDENT_ID) VALUES (?, ?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, studentId);
            

            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }
    
    public static int selectTrainerId(){
        
        List<Trainer> trainers = getAllTrainers();
        Scanner input = new Scanner(System.in);
        boolean trainerExists = false;
        int trainerId = -1;

        do {
            System.out.println("This is the List Of Trainers: ");

            trainers.forEach((trainer) -> {
                System.out.println(" Trainer Id: " + trainer.getTrainerId()
                        + " \tTrainer First Name: " + trainer.getTrainerFirstName()
                        + " \tTrainer Last Name : " + trainer.getTrainerLastName()
                        + " \tTrainer Subject: " + trainer.getTrainerSubject()
                     );
            });

            System.out.print("\n> ");
            trainerId = UtilityClass.readInt("Select the id of the Trainer you would like to choose: ", "Please enter a valid number");

            for (Trainer t : trainers) {
                if (t.getTrainerId()== trainerId) {
                    trainerExists = true;
                    break;
                }
            }
            if (!trainerExists) {
                System.out.println("This Trainer does not exist. Select another Trainer id.");
            }
        } while (!trainerExists);
        return trainerId;
        
    }
    
    
    public static int insertTrainerToCourse(int trainerId, int courseId){
        
         int rowsAffected = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO TRAINERS_PER_COURSE(COURSE_ID, STUDENT_ID) VALUES (?, ?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, trainerId);
            

            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
    }
    
    
    public static int selectAssignmentId (){
          List<Assignment> assignments= getAllAssignments();
        Scanner input = new Scanner(System.in);
        boolean assignmentExists = false;
        int assignmentId = -1;

        do {
            System.out.println("This is the List Of the Assignments: ");

            assignments.forEach((assign) -> {
                System.out.println(" Assignment Id: " + assign.getAssignmentId()
                        + " \tAssignment Title: " + assign.getAssignmentTitle()
                        + " \tAssignment Description : " + assign.getAssignmentDesc()
                        + " \tAssignment Submision Date: " + assign.getAssignSubDate()
                     );
            });

            System.out.print("\n> ");
            assignmentId = UtilityClass.readInt("Select the id of the Assignment you would like to choose: ", "Please enter a valid number");

            for (Assignment a : assignments) {
                if (a.getAssignmentId() == assignmentId) {
                    assignmentExists = true;
                    break;
                }
            }
            if (!assignmentExists) {
                System.out.println("This Assignment does not exist. Select another Assignment id.");
            }
        } while (!assignmentExists);
        return assignmentId;
        
    }
    
    
    public static int insertAssignmentToStudentsToCourses ( int assignmentId, int studentId, int courseId){
        
        
         int rowsAffected = 0;

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            Class.forName(JDBC_DRIVER);

            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            String query = " INSERT INTO ASSIGNMENTS_PER_COURSE_PER_STUDENT(COURSE_ID, ASSIGNMENT_ID, STUDENT_ID) VALUES (?, ?, ?) ";

            preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, courseId);
            preparedStatement.setInt(2, assignmentId);
            preparedStatement.setInt(3, studentId);
            

            rowsAffected = preparedStatement.executeUpdate();
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        } finally {
            if (preparedStatement != null) {
                try {
                    preparedStatement.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {
                try {
                    connection.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }

        return rowsAffected;
        
    }
}
