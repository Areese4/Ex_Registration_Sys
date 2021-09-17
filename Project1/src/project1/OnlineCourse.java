package project1;

public class OnlineCourse extends Course {
    
    public OnlineCourse (String courseName, int rNum, String courseNumber,
                        int section, int credits, String type, String inst) {
        
        super(courseName, rNum, courseNumber, section, credits, type, inst);  
        

    }
    
    @Override
    public String toString() {
        return (" #" + super.getCrn() + ": " + super.getcNum() + "-" + super.getsNum() + ", " + "(" + super.getcName() + "), "
                + super.getInstructor() + ", " + super.getcType() + "\n");
    }
    
    @Override
    public boolean conflictsWith(Course c) {
        return false;
    }
    
}
