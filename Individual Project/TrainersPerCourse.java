
package privateschool.vol3;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ReMieL
 */
public class TrainersPerCourse {
    
    private Course course;
    
    private List<Trainer> trainers = new ArrayList<Trainer>();

 
    public TrainersPerCourse(Course course, List<Trainer> trainers){
        
        this.course = course;
        
        this .trainers = trainers;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public void setTrainers(List<Trainer> trainers) {
        this.trainers = trainers;
    }

    public Course getCourse() {
        return course;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    @Override
    public String toString() {
        return "TrainersPerCourse{" + "course=" + course + ", trainers=" + trainers + '}';
    }
    
    
    
}
