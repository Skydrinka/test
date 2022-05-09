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

public class TechnicianInformation implements Comparable<TechnicianInformation> {
    
    private int techID;
    private String name;
    private String talents;

    public TechnicianInformation() {
        techID = 0;
        name = "not set";
        talents = "none";
    }

    public int getTechID() {
        return techID;
    }

    public void setTechID(int techID) {
        this.techID = techID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTalents() {
        return talents;
    }

    public void setTalents(String talents) {
        this.talents = talents;
    }
    
        @Override
    public int compareTo(TechnicianInformation o) {
return o.techID-this.techID;    
    }
}
