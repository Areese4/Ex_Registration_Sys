package project1;

import java.time.*;

public class TraditionalCourse extends Course {

    private final LocalTime start;
    private final LocalTime stop;
    private final String days;
    private final String location;

    public TraditionalCourse (String courseName, int rNum, String courseNumber,
                              int section, int credits, LocalTime start, LocalTime stop,
                             String days, String location, String type, String inst) {
        
        super(courseName, rNum, courseNumber, section, credits, type, inst);

        this.start = start;
        this.stop = stop;
        this.days = days;
        this.location = location;
    }

    @Override
    public String toString() {
        return(" #" + super.getCrn() + ": " + super.getcNum() + "-00"+ super.getsNum() + ", (" + super.getcName() + "), " 
                + super.getInstructor() + ", " + super.getcType() + ", " + start + " - " + stop + ", " 
                + days + ", " + location + "\n");
        
    }

    @Override
    public boolean conflictsWith(Course c) {
        if(start.isBefore(start) && start.isAfter(stop) || stop.isBefore(start) && stop.isAfter(stop));
        return false;
    } 
    
    public LocalTime getStart() {
        return start;
    }

    public LocalTime getStop() {
        return stop;
    }

    public String getDays() {
        return days;
    }

    public String getLocation() {
        return location;
    }

}

