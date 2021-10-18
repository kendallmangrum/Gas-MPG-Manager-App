package com.gasmpgmanager;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GasDao {

    @Insert
    public void insert(Gas... gases);

    @Update
    public void update(Gas... gases);

    @Delete
    public void delete(Gas... gases);

    @Query("SELECT * FROM gasHistory")
    List<Gas> getAllGasHistory();

    @Query("SELECT pricePerGallon FROM gasHistory")
    List<String> getAllPricePerGallon();

    @Query("SELECT totalPrice FROM gasHistory")
    List<String> getAllTotalPrice();

    @Query("SELECT totalGallons FROM gasHistory")
    List<String> getAllTotalGallons();

}
