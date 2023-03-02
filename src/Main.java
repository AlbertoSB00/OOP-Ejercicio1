import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {

        // We create a TrainingActivity object.
        TrainingActivity ta1;
        try {
            ta1 = new TrainingActivity("ENG01", "Basic English", "Activity for the beginners in english", 100, 0, 50, LocalDate.of(2023, 4, 10), LocalDate.of(2023, 6, 30), 'C', 500);
        }
        catch ( Exception e){
            System.out.println(e.getMessage());
            ta1 = null;
        }
        System.out.println(ta1);

        // We create a Partner object.
        Partner p1 = new Partner("pepe", "Pepe", "López López", "957727272", "pepe@gmail.com", LocalDate.of(2017, 7, 31), Partner.MORNING);
        System.out.println(p1);

        // We clone the p1 object.
        Partner p2 = (Partner) p1.clone();
        System.out.println(p2);
        if( p1 != p2 ){
            System.out.println("The both are different.");
        }

        // Partner p1 can do the training activity ta1.
        p1.setTrainingActivity(ta1);
        System.out.println("The partner p1 has got: " + ta1);

        // We create a RegisteredPerson object.
        RegisteredPerson rp1 = new RegisteredPerson(1, "Pablo Nicolas", "Pérez González", "pablobellotitamostro@gmail.com", LocalDate.of(2023, 1, 23));
        System.out.println(rp1);

        // We set the same ta1 to rp1.
        rp1.setTrainingActivity(ta1);

        // We calculate the fee for partner and registered person.
        float partnerFee = p1.getFee();
        float rpFee = rp1.getFee();

        // We show it.
        System.out.println("The partner's fee is: " + partnerFee);
        System.out.println("The registered person's fee is: " + rpFee);

        // We calculate the schedule for partner and registered person.
        String schedulePartner = p1.assignSchedule();
        String scheduleRp1 = rp1.assignSchedule();

        // We show it.
        System.out.println("The partner's schedule is: " + schedulePartner);
        System.out.println("The registered person's schedule is: " + scheduleRp1);
    }
}