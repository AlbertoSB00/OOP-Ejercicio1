import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class TrainingActivity implements Cloneable {

    // Properties.
    private String code;
    private String title;
    private String description;
    private int inPersonHours;
    private int noInPersonHours;
    private int onlineHours;
    private LocalDate startDate;
    private LocalDate endDate;
    private char level;
    private float fee;
    private String schedule;

    // Static properties.
    public static final int MAX_ONLINE_HOURS = 100;
    public static final int MAX_IN_PERSON_HOURS = 200;
    public static final String LEVELS = "ABC";
    public static final char DEFAULT_LEVEL = 'C';

    // Constructor.
    TrainingActivity(String code, String title, String description, int inPersonHours, int noInPersonHours, int onlineHours, LocalDate startDate, LocalDate endDate, char level, float fee) throws Exception{

        // this.code
        this.code = code;

        //this.title
        this.title = title;

        // this.description
        this.description = description;

        // this.inPersonHours
        if( inPersonHours >= 0 && inPersonHours <= this.MAX_IN_PERSON_HOURS ){
            this.inPersonHours = inPersonHours;
        }
        else {
            if( inPersonHours < 0 ){
                this.inPersonHours = 0;
                System.out.println("The in person hours are not valid.\n" +
                                   "It is set to 0 due to they are negative.");
            }
            else{
                this.inPersonHours = this.MAX_IN_PERSON_HOURS;
                System.out.println("The in person hours are not valid.\n" +
                                   "It is set to " + this.MAX_IN_PERSON_HOURS + " hours due to they are above the maximum.");
            }
        }

        // this.noInPersonHours
        this.noInPersonHours = noInPersonHours;

        // this.onlineHours
        if( onlineHours >= 0 && onlineHours <= this.MAX_ONLINE_HOURS ){
            this.onlineHours = onlineHours;
        }
        else {
            if( onlineHours < 0 ){
                this.onlineHours = 0;
                System.out.println("The online hours are not valid.\n" +
                        "It is set to 0 due to they are negative.");
            }
            else{
                this.onlineHours = this.MAX_ONLINE_HOURS;
                System.out.println("The online hours are not valid.\n" +
                        "It is set to " + this.MAX_ONLINE_HOURS + " hours due to they are above the maximum.");
            }
        }

        // this.startDate
        if( startDate.isAfter(endDate) ){
            throw new Exception("The start date cannot be after the end date.");
        }
        else {
            this.startDate = startDate;
        }

        // this.endDate
        this.endDate = endDate;

        // this.level
        if( this.LEVELS.indexOf( Character.toUpperCase(level) ) > -1 ){
            this.level = Character.toUpperCase(level);
        }
        else {
            this.level = this.DEFAULT_LEVEL;
            System.out.println("The level is not valid. It is set to the value " + this.DEFAULT_LEVEL + " by default.");
        }

        // this.fee
        this.fee = fee;
    }

    // Get & Set Methods.

    // String code
    public String getCode(){ return code; }
    public void setCode( String code ){ this.code = code; }

    // String title
    public String getTitle(){ return title; }
    public void setTitle( String title ){ this.title = title; }

    // String description
    public String getDescription(){ return description; }
    public void setDescription( String description ){ this.description = description; }

    // int inPersonHours
    public int getInPersonHours(){ return inPersonHours; }
    public void setInPersonHours( int inPersonHours ){
        if( inPersonHours >= 0 && inPersonHours <= this.MAX_IN_PERSON_HOURS ){
            this.inPersonHours = inPersonHours;
        }
    }

    // int noInPersonHours
    public int getNoInPersonHours(){ return noInPersonHours; }
    public void setNoInPersonHours( int noInPersonHours ){ this.noInPersonHours = noInPersonHours; }

    // int onlineHours
    public int getOnlineHours(){ return onlineHours; }
    public void setOnlineHours( int onlineHours ){
        if( onlineHours >= 0 && onlineHours <= this.MAX_ONLINE_HOURS ){
            this.onlineHours = onlineHours;
        }
    }

    // LocalDate startDate
    public LocalDate getStartDate(){ return startDate; }
    public void setStartDate( LocalDate startDate ){ this.startDate = startDate; }

    // LocalDate endDate
    public LocalDate getEndDate(){ return endDate; }
    public void setEndDate( LocalDate endDate ){ this.endDate = endDate; }

    // char level
    public char getLevel(){ return level; }
    public void setLevel( char level ){
        if( this.LEVELS.indexOf( Character.toUpperCase(level) ) > -1 ){
            this.level = Character.toUpperCase(level);
        }
    }

    // float fee
    public float getFee(){ return fee; }
    public void setFee( float fee ){ this.fee = fee; }

    // String schedule
    public String getSchedule(){ return schedule; }
    public void setSchedule( String schedule ){ this.schedule = schedule; }

    // copy() Method.
    public TrainingActivity copyTrainingActivity() {
        try{
            return (TrainingActivity) clone();
        }
        catch ( CloneNotSupportedException cnse){
            System.out.println("The class doesn't support clone operation.");
            return null;
        }
    }

    // toString() Method.
    @Override
    public String toString() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("d/M/yyyy");
        return "TrainingActivity{" +
                "code='" + code + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", inPersonHours=" + inPersonHours +
                ", noInPersonHours=" + noInPersonHours +
                ", onlineHours=" + onlineHours +
                ", startDate=" + startDate.format(dtf) +
                ", endDate=" + endDate.format(dtf) +
                ", level=" + level +
                ", fee=" + fee +
                ", schedule='" + (schedule == null ? "": schedule)  + '\'' +
                '}';
    }
}