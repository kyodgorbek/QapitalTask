package pojo;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SavingsGoal {

    @SerializedName("goalImageURL")
    @Expose
    private String goalImageURL;
    @SerializedName("userId")
    @Expose
    private Integer userId;
    @SerializedName("targetAmount")
    @Expose
    private Object targetAmount;
    @SerializedName("currentBalance")
    @Expose
    private Integer currentBalance;
    @SerializedName("created")
    @Expose
    private List<Integer> created = null;
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("id")
    @Expose
    private Integer id;
    @SerializedName("connectedUsers")
    @Expose
    private Object connectedUsers;

    public String getGoalImageURL() {
        return goalImageURL;
    }

    public void setGoalImageURL(String goalImageURL) {
        this.goalImageURL = goalImageURL;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Object getTargetAmount() {
        return targetAmount;
    }

    public void setTargetAmount(Object targetAmount) {
        this.targetAmount = targetAmount;
    }

    public Integer getCurrentBalance() {
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

    public Integer getId() {
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