package kf5012;
import java.util.ArrayList; // import the ArrayList class
import java.util.Collections;

public class ViewAllocations{
	
	taskAllocation theMainWindow;			// The GUI to communicate with user
	ArrayList<TechnicianInformation> techList;	// List of students. Will be replaced later with a database connection
	ArrayList<MotorProblems> problemsList;

	// This is just to run the program
	public static void main(String[] args) {
		ViewAllocations mh = new ViewAllocations();

	}
	
	// Constructor. Creates the GUI and displays the data.
	// This does more than I normally like a constructor to do,
	// but I am trying to keep things simple.
	public ViewAllocations(){
		theMainWindow = new taskAllocation(this);
		theMainWindow.setVisible(true);
		

		problemsList = getAllProblems();
		techList = getAllTechnicians();
		
		// Tempted to convert to an Object[][] at this point.
		// But I'll let the GUI do it, since it will be replaced by
		// database ResultSet, anyway.
		theMainWindow.displayTableData(techList, problemsList);
	}
	
	
	// Eventually, this will connect to a database.
	// For now, I am faking it. 
	ArrayList<TechnicianInformation> getAllTechnicians()
	{
                ArrayList<TechnicianInformation> t = new ArrayList<TechnicianInformation>();
		TechnicianInformation s = new TechnicianInformation();
		s.setName("Augustus DeMorgan");
		s.setTalents("Something");
		t.add(s);

		
		Collections.sort(t);
                
                

              
               return t; 
                
	}
        ArrayList<MotorProblems> getAllProblems()
        {
            ArrayList<MotorProblems> p = new ArrayList();
            
              MotorProblems p1 = new MotorProblems();
                p1.setProblem("Stuck");
                p1.setExpecDuration(15);
                
                p.add(p1);
                                		
                Collections.sort(p);
            
        return p;
        }
        
        
	
	
	// Eventually this will save data to a database but I am faking
	// it for now

	
	// Deletes a specific student, and updates the jTable.
	// What happens if two students have the same name?
	// Ignore that for this example, but that's what
	// a studentID is for.

	


	
	
}
