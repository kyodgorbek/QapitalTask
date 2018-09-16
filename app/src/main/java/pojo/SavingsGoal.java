package pojo;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;
import android.arch.persistence.room.TypeConverters;
import android.support.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

@Entity(tableName = "savingsGoals_table")
public class SavingsGoal {
    @NonNull
    @SerializedName("goalImageURL")
    @Expose
    private String goalImageURL;
    @SerializedName("userId")
    @Expose
    private int userId;
    @SerializedName("targetAmount")
    @Expose
    private String targetAmount="";
    @SerializedName("currentBalance")
    @Expose
    private int currentBalance;
    @SerializedName("created")
    @Expose
    @TypeConverters(Converters.class)
    private List<Integer> created = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("name")
    @Expose
    private String name;
    @PrimaryKey
    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("connectedUsers")
    @Expose
    @TypeConverters(Converters.class)
    private Object connectedUsers;

    public String getGoalImageURL() {
        return goalImageURL;
    }

    public void setGoalImageURL(String goalImageURL) {
        this.goalImageURL = goalImageURL;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(String targetAmount) {
        this.targetAmount = targetAmount;
    }

    public int getCurrentBalance() {
        return currentBalance;
    }

    public void setCurrentBalance(Integer currentBalance) {
        this.currentBalance = currentBalance;
    }

    public List<Integer> getCreated() {
        return created;
    }

    public void setCreated(List<Integer> created) {
        this.created = created;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Object getConnectedUsers() {
        return connectedUsers;
    }

    public void setConnectedUsers(Object connectedUsers) {
        this.connectedUsers = connectedUsers;
    }

}