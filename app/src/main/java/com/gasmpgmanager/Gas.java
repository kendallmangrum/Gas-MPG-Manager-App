package com.gasmpgmanager;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "gasHistory")
public class Gas {
    @PrimaryKey (autoGenerate = true)
    @NonNull private int id;
    private String StationName;
    private String date;
    private String pricePerGallon;
    private String totalPrice;
    private String totalGallons;
    private String mpg;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStationName() {
        return StationName;
    }

    public void setStationName(String stationName) {
        StationName = stationName;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getPricePerGallon() {
        return pricePerGallon;
    }

    public void setPricePerGallon(String pricePerGallon) {
        this.pricePerGallon = pricePerGallon;
    }

    public String getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(String totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getTotalGallons() {
        return totalGallons;
    }

    public void setTotalGallons(String totalGallons) {
        this.totalGallons = totalGallons;
    }

    public String getMpg() {
        return mpg;
    }

    public void setMpg(String mpg) {
        this.mpg = mpg;
    }
}
