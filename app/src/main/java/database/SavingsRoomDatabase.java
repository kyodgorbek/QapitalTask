package database;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import pojo.SavingsGoal;

@Database(entities = {SavingsGoal.class}, version = 3, exportSchema = false)
public abstract class SavingsRoomDatabase extends RoomDatabase {
    public abstract SavingsGoalDao savingsGoalDao();

    // marking the instance as volatile to ensure atomic access to the variable
    private static volatile SavingsRoomDatabase INSTANCE;

    static public SavingsRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (SavingsRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            SavingsRoomDatabase.class, "savingsGoals_table")
                            // Wipes and rebuilds instead of migrating if no Migration object.
                            // Migration is not part of this codelab.
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }
        return INSTANCE;
    }
}

