
package Entity;

import java.util.Date;



/**
 *
 * @author ReMieL
 */
public class Course {
    
    private int courseId;
    private String courseTitle;
    private String courseStream;
    private String courseType;
    private Date courseStartDate;
    private Date courseEndDate;

    public Course(int courseId, String courseTitle, String courseStream, String courseType, Date courseStartDate, Date courseEndDate) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.courseStream = courseStream;
        this.courseType = courseType;
        this.courseStartDate = courseStartDate;
        this.courseEndDate = courseEndDate;
    }

    
    
    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public String getCourseStream() {
        return courseStream;
    }

    public void setCourseStream(String courseStream) {
        this.courseStream = courseStream;
    }

    public String getCourseType() {
        return courseType;
    }

    public void setCourseType(String courseType) {
        this.courseType = courseType;
    }

    public Date getCourseStartDate() {
        return courseStartDate;
    }

    public void setCourseStartDate(Date courseStartDate) {
        this.courseStartDate = courseStartDate;
    }

    public Date getCourseEndDate() {
        return courseEndDate;
    }

    public void setCourseEndDate(Date courseEndDate) {
        this.courseEndDate = courseEndDate;
    }
    
    
    
    
}
