package database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.List;

import pojo.SavingsGoal;

public class SaveGoalsRepository {


    public SavingsGoalDao savingsGoalDao;
    List<SavingsGoal> savingGoals;

    SaveGoalsRepository(Application application) {
        SavingsRoomDatabase db = SavingsRoomDatabase.getDatabase(application);
        savingsGoalDao = db.savingsGoalDao();
        // savingGoals m = savingsGoalDao.getAllGoals();
        savingGoals = savingsGoalDao.getAllGoals();
    }

    List<SavingsGoal> getAllWords() {
        return savingGoals;
    }


    public void insert(SavingsGoal savingsGoal) {
        new insertAsyncTask(savingsGoalDao).execute(savingsGoal);
    }

    // bro are you here right bro look I want to ask one thing // I want to implement persistent task can you check my I am going right direction
    // I am following this tutorial you have seen requirment
    // are you familiar with viewmodel bromy approach is right for task above which was given by company. are you sure.
    //.......
    // I have done rest part it is showing goal and target amount wait I will show you
    private static class insertAsyncTask extends AsyncTask<SavingsGoal, Void, Void> {

        private SavingsGoalDao mAsyncTaskDao;

        insertAsyncTask(SavingsGoalDao dao) {
            mAsyncTaskDao = dao;
        }

        @Override
        protected Void doInBackground(final SavingsGoal... params) {
            mAsyncTaskDao.insertAll(params);
            return null;
        }

        // bro final ui should like this I have done until here others I was stuck. what do you think I have to  implement here becuase you more senior than me I am junior
    }
}
