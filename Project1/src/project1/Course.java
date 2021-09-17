package project1;

public abstract class Course {
    
    private final String cName;
    private final int crn;
    private final String cNum;
    private final int sNum;
    private final int cHours;
    private final String instructor;
    private final String cType;

    public Course(String courseName, int rNum, String courseNumber,
                  int section, int credits, String type, String inst) {

        this.cName = courseName;
        this.crn = rNum;
        this.cNum = courseNumber;
        this.sNum = section;
        this.cHours = credits;
        this.cType = type;
        this.instructor = inst;

    }

    public String getcName() {
        return cName;
    }

    public int getCrn() {
        return crn;
    }

    public String getcNum() {
        return cNum;
    }

    public int getsNum() {
        return sNum;
    }

    public int getcHours() {
        return cHours;
    }

    public String getInstructor() {
        return instructor;
    }

    public String getcType() {
        return cType;
    }

    public abstract boolean conflictsWith(Course c);
    
}