import java.nio.channels.SelectableChannel;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

public class Partner implements Cloneable, TrainingData {

    // Properties.
    private String login;
    private String password;
    private String name;
    private String surname;
    private String telephone;
    private String email;
    private LocalDate membershipDate;
    private int availability;
    private TrainingActivity trainingActivity;

    // Static properties.
    public static final int MORNING = 1;
    public static final int AFTERNOON = 2;

    // Constructor.
    public Partner( String login, String name, String surname, String telephone, String email, LocalDate membershipDate, int availability ){

        // this.login
        this.login = login;

        // this.name
        this.name = name;

        // this.surname
        this.surname = surname;

        // this.telephone
        this.telephone = telephone;

        // this.email
        this.email = email;

        // this.membershipDate
        this.membershipDate = membershipDate;

        // this.availability
        this.availability = availability;
    }

    // Get & Set Methods.

    // String login;
    public String getLogin(){ return this.login; }
    public void setLogin( String login ){ this.login = login; }

    // String password;


    // String name;
    public String getName(){ return this.name; }
    public void setName( String name ){ this.name = name; }

    // String surname;
    public String getSurname(){ return this.surname; }
    public void setSurname( String surname ){ this.surname = surname; }

    // String telephone;
    public String getTelephone(){ return this.telephone; }
    public void setTelephone( String telephone ){ this.telephone = telephone; }

    // String email;
    public String getEmail(){ return this.email; }
    public void setEmail( String email ){ this.email = email; }

    // LocalDate membershipDate;
    public LocalDate getMembershipDate(){ return this.membershipDate; }
    public void setMembershipDate( LocalDate membershipDate ){ this.membershipDate = membershipDate; }

    // int availability;
    public int getAvailability(){ return availability; }
    public void setAvailability( int availability ){ this.availability = availability; }

    // TrainingActivity trainingActivity;
    public TrainingActivity getTrainingActivity(){ return trainingActivity; }
    public void setTrainingActivity( TrainingActivity trainingActivity ){ this.trainingActivity = trainingActivity; }

    // Other methods.
    public float getFee(){
        LocalDate today = LocalDate.now();
        Period p = this.membershipDate.until(today);
        int years = p.getYears();
        float fee = 0;

        if( years > 6 ){
            fee = 5 * this.getTrainingActivity().getInPersonHours();
        }
        else if( years > 3 && years <= 6 ){
            fee = 10 * ( this.getTrainingActivity().getInPersonHours() +
                        this.getTrainingActivity().getOnlineHours());
        }
        else {
            fee = 20 * ( this.getTrainingActivity().getInPersonHours() +
                    this.getTrainingActivity().getOnlineHours());
        }
        return fee;
    }

    public String assignSchedule(){
        String schedule = "";

        if( this.getTrainingActivity().getInPersonHours() >= 100 && this.getTrainingActivity().getInPersonHours() <= 200 ){
            if( this.getAvailability() == this.MORNING ){
                schedule = "In person lessons: Mo to Fry, 9:00 to 13:00";
            }
            else {
                schedule = "In person lessons: Mo to Fry, 16:00 to 20:00";
            }
        }
        else if( this.getTrainingActivity().getInPersonHours() < 100 ) {
            if( this.getAvailability() == this.MORNING ){
                schedule = "In person lessons: Mo to Fr, 9:00 to 13:00";
            }
            else {
                schedule = "In person lessons: Mo to Fry, 16:00 to 20:00";
            }
        }

        if( this.getTrainingActivity().getOnlineHours() >= 50 && this.getTrainingActivity().getOnlineHours() <= 100 ){
            schedule = "\nOnline lessons: Sa and Su, 9:00 to 12:00";
        }
        else if( this.getTrainingActivity().getOnlineHours() < 50 ){
            schedule = "\nOnline lessons: Sa 8:00 to 10:00";
        }

        this.getTrainingActivity().setSchedule(schedule);
        return schedule;
    }

    // Overriding copy() Method.
    @Override
    public Object clone(){
        try{
            return (Partner) super.clone();
        }
        catch ( CloneNotSupportedException cnse ){
            System.out.println("The class doesn't support clone operations.");
            return null;
        }
    }

    // toString() Method.
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("/d/M/yyyy");
        return "Partner{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", telephone='" + telephone + '\'' +
                ", email='" + email + '\'' +
                ", membershipDate=" + membershipDate.format(dtf) +
                '}';
    }
}
