/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package kf5012;

/**
 *
 * @author w19007581
 */
public class tableData implements Comparable<tableData> {

private int MotorID;
private int orderID;
private float predictedCost;
private String keyDetails;
private String finalInspection;
private int completionDate;
private String Problem; 
private String Status;

    public tableData() {
orderID = 0;
Status = "Not set";
finalInspection = "Not set";
keyDetails = "Not set";
completionDate = 0;
Problem = "View";
predictedCost = 0;
MotorID = 0;
        
    }

    public int getMotorID() {
        return MotorID;
    }

    public void setMotorID(int MotorID) {
        this.MotorID = MotorID;
    }

    public float getPredictedCost() {
        return predictedCost;
    }

    public void setPredictedCost(float predictedCost) {
        this.predictedCost = predictedCost;
    }

    public String getProblem() {
        return Problem;
    }

    public void setProblem(String Problem) {
        this.Problem = Problem;
    }


    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public String getKeyDetails() {
        return keyDetails;
    }

    public void setKeyDetails(String keyDetails) {
        this.keyDetails = keyDetails;
    }

    public int getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(int completionDate) {
        this.completionDate = completionDate;
    }

    public String getFinalInspection() {
        return finalInspection;
    }

    public void setFinalInspection(String finalInspection) {
        this.finalInspection = finalInspection;
    }

    public int getOrderID() {
        return orderID;
    }

    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }





    @Override
    public int compareTo(tableData o) {
return o.MotorID-this.MotorID;    
    }
    
}
