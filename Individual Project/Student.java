
package privateschool.vol3;

import java.util.Objects;

/**
 *
 * @author ReMieL
 */
public class Student {
       private String firstName;

    private String lastName;

    private double tuitionFees;
    
    private String dateOfBirth;
    

    //@ Contstructors
    public Student() {

    }

    public Student(String firstName, String lastName, double tuitionFees, String dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.tuitionFees = tuitionFees;
    }

    public void setFirstName(String firstName) {

        this.firstName = firstName;
    }

    public String getFirstName() {

        return firstName;
    }

    public void setLastName(String lastName) {

        this.lastName = lastName;
    }

    public String getLastName() {

        return lastName;
    }

    public void setTuitionFees(double tuitionFees) {

        this.tuitionFees = tuitionFees;
    }

    public double getTuitionFees() {

        return tuitionFees;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }    
    
    

    @Override
    public String toString() {
        return "Student{" + "firstName=" + firstName + ", lastName=" + lastName + ", tuitionFees=" + tuitionFees + ", dateOfBirth=" + dateOfBirth + '}';
    }
 

    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Student other = (Student) obj;
        if (Double.doubleToLongBits(this.tuitionFees) != Double.doubleToLongBits(other.tuitionFees)) {
            return false;
        }
        if (!Objects.equals(this.firstName, other.firstName)) {
            return false;
        }
        if (!Objects.equals(this.lastName, other.lastName)) {
            return false;
        }
        return true;
    }
    
}
    

