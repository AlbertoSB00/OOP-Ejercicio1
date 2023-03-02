import java.lang.reflect.AccessibleObject;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class RegisteredPerson implements Cloneable, TrainingData {
    // Properties.
    private int number;
    private String name;
    private String surname;
    private String email;
    private LocalDate registeredDate;
    private TrainingActivity trainingActivity;

    // Constructor.
    public RegisteredPerson( int number, String name, String surname, String email, LocalDate registeredDate ){

        // this.number
        this.number = number;

        // this.name
        this.name = name;

        // this.surname
        this.surname = surname;

        // this.email;
        this.email = email;

        // this.registeredDate
        this.registeredDate = registeredDate;
    }

    // Get & Set Methods.

    // int number
    public int getNumber(){ return this.number; }
    public void setName( int number ){ this.number = number; }

    // String name
    public String getName(){ return this.name; }
    public void setName( String name ){ this.name = name; }

    // String surname
    public String getSurname(){ return this.surname; }
    public void setSurname( String surname ){ this.surname = surname; }

    // String email
    public String getEmail(){ return this.email; }
    public void setEmail( String email ){ this.email = email; }

    // LocalDate registeredDate
    public LocalDate getRegisteredDate(){ return this.registeredDate; }
    public void setTrainingActivity( LocalDate registeredDate ){ this.registeredDate = registeredDate; }

    // TrainingActivity trainingActivity
    public TrainingActivity getTrainingActivity(){ return this.trainingActivity; }
    public void setTrainingActivity( TrainingActivity trainingActivity ){ this.trainingActivity = trainingActivity; }

    // Other methods.
    public float getFee(){
        int inPersonHours = this.getTrainingActivity().getInPersonHours();
        int onlineHours = this.getTrainingActivity().getOnlineHours();

        float fee = 50 * inPersonHours + 50 * onlineHours;

        return fee;
    }

    public String assignSchedule(){
        String schedule = "";

        if( this.getTrainingActivity().getLevel() == 'A' || this.getTrainingActivity().getLevel() == 'B' ){
            schedule = "In person lessons: Mo to Sa, 9:00 to 12:00 \n";
        }
        else{
            schedule = "In person lessons: Mo to Sa, 10:00 to 14:00 and 16:00 to 20:00";
        }

        if( this.getTrainingActivity().getLevel() == 'A' ){
            schedule = "Online lessons: Su, 9:00 to 12:00";
        }
        else {
            schedule = "Online lessons: Su, 16:00 to 19:00";
        }

        this.getTrainingActivity().setSchedule(schedule);
        return schedule;

    }

    // clone() Method.
    public RegisteredPerson cloneRegisteredPerson(){
        try{
            return ( RegisteredPerson ) clone();
        }
        catch ( CloneNotSupportedException cnse ){
            System.out.println("The class doesn't support clone operation.");
            return null;
        }
    }

    // toString() Method.
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("/d/M/yyyy");
        return "RegisteredPerson{" +
                "number=" + number +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", registeredDate=" + registeredDate.format(dtf) +
                '}';
    }
}
