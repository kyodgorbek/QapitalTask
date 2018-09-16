package database;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import pojo.SavingsGoal;

@Dao
public interface SavingsGoalDao {





    @Insert
    void insert (SavingsGoal savingsGoal6);

    @Insert
    void insertAll (SavingsGoal... savingsGoals);


    @Query("DELETE FROM savingsGoals_table")
    void deleteAll();

    @Query("SELECT * from savingsGoals_table ORDER BY goalImageURL, targetAmount ASC")
   List<SavingsGoal> getAllGoals();
}


