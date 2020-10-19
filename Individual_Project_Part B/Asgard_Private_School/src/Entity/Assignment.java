
package Entity;

import java.util.Date;

/**
 *
 * @author ReMieL
 */
public class Assignment {
    
    private int assignmentId;
    private String assignmentTitle;
    private String assignmentDesc;
    private Date assignSubDate;
    private double assignTotalMark;

    public Assignment(int assignmentId, String assignmentTitle, String assignmentDesc, Date assignSubDate, double assignTotalMark) {
        this.assignmentId = assignmentId;
        this.assignmentTitle = assignmentTitle;
        this.assignmentDesc = assignmentDesc;
        this.assignSubDate = assignSubDate;
        this.assignTotalMark = assignTotalMark;
    }

    
    
    
    public int getAssignmentId() {
        return assignmentId;
    }

    public void setAssignmentId(int assignmentId) {
        this.assignmentId = assignmentId;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public void setAssignmentTitle(String assignmentTitle) {
        this.assignmentTitle = assignmentTitle;
    }

    public String getAssignmentDesc() {
        return assignmentDesc;
    }

    public void setAssignmentDesc(String assignmentDesc) {
        this.assignmentDesc = assignmentDesc;
    }

    public Date getAssignSubDate() {
        return assignSubDate;
    }

    public void setAssignSubDate(Date assignSubDate) {
        this.assignSubDate = assignSubDate;
    }

    public double getAssignTotalMark() {
        return assignTotalMark;
    }

    public void setAssignTotalMark(double assignTotalMark) {
        this.assignTotalMark = assignTotalMark;
    }
    
    
    
}
