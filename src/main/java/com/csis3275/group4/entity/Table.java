package com.csis3275.group4.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Table")
public class Table {
    @Id
    private String id;
    private String tableName;
    private int seatNumber;
    private boolean isAvailable;

    public Table(){}

    public Table(String tableName, int seatNumber, boolean isAvailable) {
        this.tableName = tableName;
        this.seatNumber = seatNumber;
        this.isAvailable = isAvailable;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(int seatNumber){
        this.seatNumber = seatNumber;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }
}
