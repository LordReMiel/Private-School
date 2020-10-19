/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package privateschool.vol3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ReMieL
 */
public class AssignmentsPerStudent {
    
    private Student student;
    
    private List<Assignment> assignments = new ArrayList<Assignment>();

    public AssignmentsPerStudent(Student student,List<Assignment> assignments) {
        
        this.assignments = assignments;
        this.student = student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Student getStudent() {
        return student;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
    
    
}
