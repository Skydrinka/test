package kf5012;
import java.sql.*;
import java.util.ArrayList;

public class DBMain {
	private DBConnection database;
	
	// Establishing connection
	public DBMain() {
		database = new DBConnection();
		database.Connect("/Users/nikitaskaouslides/eclipse-workspace/SEPDatabase/src/PSEPDatabase.db");
	}
	
	//Deleting order
	public void DeleteOrder(int orderID) {
		String sql = new String("delete from \"motorInformation\" where orderID = "+orderID+";");
		boolean success = database.RunSQL(sql);
		if(!success) {
			System.out.println("Failed to delete records. Error: "+sql);
		}
		else if (success) {
			System.out.println("The order was deleted.");
		}
	} 
	
	//Delete order
	public void DeleteProblem(int motorID) {
		String sql = new String ("delete from \"motorProblem\" where motorID = "+ motorID);
		boolean success = database.RunSQL(sql);
		if(!success) {
			System.out.println("Failed to delete records. Error: "+sql);
		}
		else if (success) {
			System.out.println("The order was deleted.");
		}
	}
	
	//Add motor
	public void AddMotor(String keydet, String predicCost) {
		String sql = new String ("insert into \"motorInformation\" values (NULL,"+max()+",\"Unknown\",\"Not set\","); 
		sql = sql + keydet+", \"Not set\", ";
		sql = sql + predicCost;
		sql = sql + ");";
		boolean success = database.RunSQL(sql);
		if(!success) {
			System.out.println("Failed to add records. Error: "+sql);
		}
		if (success) {
			System.out.println("Motor added successfully.");
		}
	}
	
	//Add problem
		public void AddProblem(String problem, String probDet, String expecDur, Object motorID) {
			String sql = new String ("insert into \"motorProblem\" values (NULL,"+motorID+",\"Unknown\","+problem+","+probDet+","+expecDur+")"); 
			boolean success = database.RunSQL(sql);
			if(!success) {
				System.out.println("Failed to add records. Error: "+sql);
			}
			if (success) {
				System.out.println("Problem added successfully.");
			}
		}
		
	//Max motorID
	public int max() {
		int max = 0;
		String maxsql = new String("select max(motorID) from \"motorInformation\";");
		ResultSet s = database.RunSQLQuery(maxsql);
		try {
			while (s.next()) {
				 max = s.getInt(1);
				 System.out.println(max);
			}
		} catch (Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
		return max +1;
	}
	
	//Update motor details
	public void UpdateMotor(String keydet, String prediccost, String status, String finalinspection, String completionDate,Object input) {
		String sql = new String ("update \"motorInformation\" set keyDetails =");
		sql = sql +keydet+", predictedCost ="+prediccost+",status ="+status+",finalInspection ="; 
		sql = sql + finalinspection+",completionDate ="+completionDate+" where orderID = "+input+";";
		boolean success = database.RunSQL(sql);
		if(!success) {
			System.out.println("Failed to update records. Try again. Error: "+sql);
		}
		else if (success) {
			System.out.println("Records updated successfully.");
		}
	}
	
	//Update problem details
		public void UpdateProblem(String problem, String probDet, String expecDur, String status) {
			String sql = new String ("update \"motorProblem\" set problem =");
			sql = sql +problem+", problemDetails ="+probDet+",expecDuration ="+expecDur+",taskStatus ="+status+" where taskStatus = "+status+";";
			boolean success = database.RunSQL(sql);
			if(!success) {
				System.out.println("Failed to update records. Try again. Error: "+sql);
			}
			else if (success) {
				System.out.println("Records updated successfully.");
			}
		}
	
	//Retrieving all information from the database
	 public ArrayList<MotorInformation> GetAllMotors() {
		String sql = new String("select orderID,motorID,keyDetails,predictedCost,status,finalInspection,completionDate from \"motorInformation\";");
		ArrayList<MotorInformation> answer = new ArrayList<MotorInformation>();
		ResultSet orderList = database.RunSQLQuery(sql);
		try {
			while(orderList.next()) {
				MotorInformation n = new MotorInformation();
                n.setOrderID(orderList.getInt(1));
                n.setMotorID(orderList.getInt(2));
                n.setStatus(orderList.getString(5));
                n.setFinalInspection(orderList.getString(6));
                n.setKeyDetails(orderList.getString(3));
                n.setCompletionDate(orderList.getString(7));
                n.setPredictedCost(orderList.getInt(4));
                answer.add(n);
			}
			
		} 
		
		catch (Exception e) {
			System.err.println("Got an exception");
			System.err.println(e.getMessage());
		}
		return answer;
	} 
	 
	 public ArrayList<MotorProblems> GetAllProblems() {
	    ArrayList<MotorProblems> answer = new ArrayList<MotorProblems>();
	     String sql = "select motorID,problem,problemDetails,expecDuration,taskStatus from \"motorProblem\";";
	      ResultSet orderList = database.RunSQLQuery(sql);
	      try {
	      while(orderList.next())
	       {
	    	 MotorProblems n = new MotorProblems();
	         n.setMotorID(orderList.getInt(1));
	         n.setProblem(orderList.getString(2));
	         n.setProblemDetails(orderList.getString(3));
	         n.setExpecDuration(orderList.getInt(4));
	         n.setTaskStatus(orderList.getString(5));
	         answer.add(n);
	       }
	      }
	      catch (Exception e) {
	    	  System.err.println("Got an exception");
	    	  System.err.println(e.getMessage());
	      }
	                 return answer;
	 }

//	public static void main(String[] args) {
//		DBMain obj = new DBMain();
//		System.out.println("Test 1 - Connecting to the databse");
//		obj.Connection();
//		System.out.println("Test 2 - Getting all motors");
//		obj.GetAllMotors();
//		System.out.println("Test 3 - Deleting order");
//	    obj.DeleteOrder(9);
		//obj.GetAllOrders();
		//System.out.println("test");
	}
	

