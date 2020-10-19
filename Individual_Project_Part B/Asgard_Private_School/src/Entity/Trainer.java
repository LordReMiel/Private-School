
package Entity;

/**
 *
 * @author ReMieL
 */
public class Trainer {
    private int trainerId;
    private String trainerFirstName;
    private String trainerLastName;
    private String trainerSubject;

    public Trainer(int trainerId, String trainerFirstName, String trainerLastName, String trainerSubject) {
        this.trainerId = trainerId;
        this.trainerFirstName = trainerFirstName;
        this.trainerLastName = trainerLastName;
        this.trainerSubject = trainerSubject;
    }

    
    
    
    
    public int getTrainerId() {
        return trainerId;
    }

    public void setTrainerId(int trainerId) {
        this.trainerId = trainerId;
    }

    public String getTrainerFirstName() {
        return trainerFirstName;
    }

    public void setTrainerFirstName(String trainerFirstName) {
        this.trainerFirstName = trainerFirstName;
    }

    public String getTrainerLastName() {
        return trainerLastName;
    }

    public void setTrainerLastName(String trainerLastName) {
        this.trainerLastName = trainerLastName;
    }

    public String getTrainerSubject() {
        return trainerSubject;
    }

    public void setTrainerSubject(String trainerSubject) {
        this.trainerSubject = trainerSubject;
    }
    
    
}
