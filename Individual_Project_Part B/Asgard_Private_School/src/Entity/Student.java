
package Entity;

import java.util.Date;

/**
 *
 * @author ReMieL
 */
public class Student {
    
    private int studentID;
    private String firstName;
    private String lastName;
    private Date dateOfBirth;
    private double tuitionFees;

    public Student(int studentID, String firstName, String lastName, Date dateOfBirth, double tuitionFees) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.tuitionFees = tuitionFees;
    }

    public Student(int studentID, String firstName, String lastName) {
        this.studentID = studentID;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    
    
    
    
    public int getStudentID() {
        return studentID;
    }

    public void setStudentID(int studentID) {
        this.studentID = studentID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public double getTuitionFees() {
        return tuitionFees;
    }

    public void setTuitionFees(double tuitionFees) {
        this.tuitionFees = tuitionFees;
    }
    
    
    
    
}
