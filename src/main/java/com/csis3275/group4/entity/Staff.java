package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Document(collection = "Staff")
public class Staff {
    @Id
    private String id;
    private String staffName;
    private LocalDate staffDOB;
    private String staffAddress;
    private List<String> staffShift;

    public Staff() {}

    public Staff(String staffName, LocalDate staffDOB, String staffAddress, List<String> staffShift){
        this.staffName = staffName;
        this.staffDOB = staffDOB;
        this.staffAddress = staffAddress;
        this.staffShift = staffShift;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStaffName() {
        return staffName;
    }

    public void setStaffName(String staffName) {
        this.staffName = staffName;
    }

    public LocalDate getStaffDOB() {
        return staffDOB;
    }

    public void setStaffDOB(LocalDate staffDOB) {
        this.staffDOB = staffDOB;
    }

    public String getStaffAddress() {
        return staffAddress;
    }

    public void setStaffAddress(String staffAddress) {
        this.staffAddress = staffAddress;
    }

    public List<String> getStaffShift() {
        return staffShift;
    }

    public void setStaffShift(List<String> staffShift) {
        this.staffShift = staffShift;
    }
}
