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
	
	//Add motor
	public void AddMotor(MotorInformation sm) {
		String sql1 = new String ("insert into \"motorProblem\" values (NULL,\"Not set\",\"Not set\",\"Not set\",0);");
		String sql = new String ("insert into \"motorInformation\" values (NULL,NULL,\"Unknown\",\"Not set\",'"); 
		sql = sql + sm.getKeyDetails()+"', \"Not set\", ";
		sql = sql + Float.toString(sm.getPredictedCost());
		sql = sql + ");";//+keyDetails+",\"Not set\","+predictedCost+");");
		boolean success = database.RunSQL(sql);
		boolean success1 = database.RunSQL(sql1);
		if(!success && !success1) {
			System.out.println("Failed to add records. Error: "+sql);
		}
		if (success && success1) {
			System.out.println("Motor added successfully.");
		}
	}
	
	public void UpdateMotor(String keyDetails, float predictedCost, String status, String finalInspection, String completionDate,int orderID) {
		String sql = new String ("update \"motorInformation\" set keyDetails ="+keyDetails+", predictedCost ="+predictedCost+",status ="+status+",finalInspection ="+finalInspection+", completionDate ="+completionDate+" where orderID = "+orderID+";");
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
	

