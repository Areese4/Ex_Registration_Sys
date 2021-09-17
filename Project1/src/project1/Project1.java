package project1;

import java.util.*;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalTime;

public class Project1 {
    
    ArrayList<Course> classes;
    ArrayList<Course> schedule;
    
    public void start() {
        
        
        classes = getCourseData("input.csv");
        schedule = new ArrayList<>();
        
        
        mainMenu();
              
        
        System.out.println("Thanks for using the Student Registration System!");
        
    }
    
    private ArrayList<Course> getCourseData(String filename) {
        
        String[] row;
        
        ArrayList<Course> data = new ArrayList<>();
        
        try {
            
            Scanner in = new Scanner(Paths.get(filename), "UTF-8");
            
            while (in.hasNext()) {

                String details = in.nextLine();
                row = details.split("\t");
                
                if (row.length == 11) {

                    String cName = row[0];
                    int crn = Integer.parseInt(row[1]);
                    String cNum = row[2];
                    int sNum = Integer.parseInt(row[3]);
                    int cHours = Integer.parseInt(row[4]);
                    LocalTime start = LocalTime.parse(row[5]);
                    LocalTime stop = LocalTime.parse(row[6]);
                    String days = row[7];
                    String location = row[8];
                    String cType = row[9];
                    String instructor = row[10];

                    TraditionalCourse a = new TraditionalCourse(cName, crn, cNum, 
                            sNum, cHours, start, stop, days, location, cType, instructor);

                    data.add(a);
                    
                }
                

                else  { 
                    String cName = row[0];
                    int crn = Integer.parseInt(row[1]);
                    String cNum = row[2];
                    int sNum = Integer.parseInt(row[3]);
                    int cHours = Integer.parseInt(row[4]);
                    String cType = row[5];
                    String instructor = row[6];

                    OnlineCourse b = new OnlineCourse(cName, crn, cNum, sNum, 
                                                    cHours, cType, instructor);

                    data.add(b);
                    
                }   

            }

            System.out.println("Courses Read from File: " + data.size());
                
        }
        catch (IOException e) {
            System.err.println(e.toString());
        }
        
        return data;
        
    }

   
    private void mainMenu() {
        
        Scanner choose = new Scanner(System.in);

        boolean finished = false;
        

        while (!finished) {
        
            System.out.println("1) Search Courses");
            System.out.println("2) Register for Courses");
            System.out.println("3) View Trial Schedule");
            System.out.println("4) Quit");
            System.out.print("Your Choice? ");

            int choice = choose.nextInt();

            switch (choice) {

                case 1:
                    
                    System.out.print("Enter course number in the format SS NNN (for example, CS 201): ");

                    String subject = choose.next().toUpperCase();
                    String number = choose.next().toUpperCase();
                    String courseNumber = subject + " " + number;

                    for (Course c: classes) {

                        if (c.getcNum().equals(courseNumber)) {
                            System.out.println(c);
                        }

                    }
                    break;

                case 2:
                    

                    System.out.print("Enter your CRN number: ");

                    int crn = choose.nextInt();

                    Course selected = null;

                    for (Course c: classes) {

                        if (c.getCrn() == crn) {

                            selected = c;

                        }

                    }

                    if (selected != null) {
                        
                        boolean conflict = false;

                        for (Course c: schedule) {
                            if (c.conflictsWith(selected)) {
                                conflict = true;
                            }
                        }
                        
                        // If No Conflict Found, Add

                        if (!conflict) {
                            schedule.add(selected);
                            System.out.println("Course successfully added! \n");
                        }
                        
                        // If Conflict Found, Report Error
                        
                        else {
                            System.out.println("ERROR: Selected course conflicts with your current schedule!");
                        }

                    }
                    else {
                        System.out.println("ERROR: Course Not Found!");
                    }

                    break;

                case 3:
                    
                    System.out.println("Your classes are: ");
                    System.out.print(schedule.toString());
                    break;

                case 4:
                    
                    finished = true;
                    break;

                default:
                    System.out.println("Choose one of the given options! ");
                    break;

            }
            
        }
        
    }
    
    public static void main(String[] args) throws IOException {
   
        Project1 p = new Project1();
        p.start();
        
    }    
    
}
    
    