
package privateschool.vol3;

import java.util.Objects;

/**
 *
 * @author ReMieL
 */
public class Assignment {
    
    private String title ;
    
    private String description;
    
    private String subDateTime;
    
    private int totalMark;

    public Assignment() {
    }
    
    
    
    

    public Assignment(String title, String description, String subDateTime, int totalMark) {
        this.title = title;
        this.description = description;
        this.subDateTime = subDateTime;
        this.totalMark = totalMark;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setSubDateTime(String subDateTime) {
        this.subDateTime = subDateTime;
    }

    public void setTotalMark(int totalMark) {
        this.totalMark = totalMark;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getSubDateTime() {
        return subDateTime;
    }

    public int getTotalMark() {
        return totalMark;
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
        final Assignment other = (Assignment) obj;
        if (this.totalMark != other.totalMark) {
            return false;
        }
        if (!Objects.equals(this.title, other.title)) {
            return false;
        }
        if (!Objects.equals(this.description, other.description)) {
            return false;
        }
        if (!Objects.equals(this.subDateTime, other.subDateTime)) {
            return false;
        }
        return true;
    }
    
    
    

    @Override
    public String toString() {
        return "Assignment{" + "title=" + title + ", description=" + description + ", subDateTime=" + subDateTime + ", totalMark=" + totalMark + '}';
    }
    
    
    
    
    
    
}
