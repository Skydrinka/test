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



public class MotorProblems implements Comparable<MotorProblems> {
private int motorID;
private String problem;
private String problemDetails;
private String urgency;
private int expecDuration;
private String taskStatus;

public MotorProblems()
{
urgency = "Not Urgent";
taskStatus = "Not set";
problem = "Not set";
problemDetails = "Not set";
motorID = 0;
expecDuration = 0;
}

    public String getUrgency() {
        return urgency;
    }

    public void setUrgency(String urgency) {
        this.urgency = urgency;
    }

    public int getMotorID() {
        return motorID;
    }

    public void setMotorID(int motorID) {
        this.motorID = motorID;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getProblemDetails() {
        return problemDetails;
    }

    public void setProblemDetails(String problemDetails) {
        this.problemDetails = problemDetails;
    }

    public int getExpecDuration() {
        return expecDuration;
    }

    public void setExpecDuration(int expecDuration) {
        this.expecDuration = expecDuration;
    }

    public String getTaskStatus() {
        return taskStatus;
    }

    public void setTaskStatus(String taskStatus) {
        this.taskStatus = taskStatus;
    }

    
    
    @Override
    public int compareTo(MotorProblems o) {
return o.motorID-this.motorID;    
    }





}


