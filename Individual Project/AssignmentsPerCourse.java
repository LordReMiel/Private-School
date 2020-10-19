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
public class AssignmentsPerCourse {
    
    private Course course;
    
    private List<Assignment> assignments = new ArrayList<Assignment>();

    public AssignmentsPerCourse(Course course,List<Assignment> assignments) {
        
        this.assignments = assignments;
        this.course = course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setAssignments(List<Assignment> assignments) {
        this.assignments = assignments;
    }

    public Course getCourse() {
        return course;
    }

    public List<Assignment> getAssignments() {
        return assignments;
    }
    
    
    
    
}
