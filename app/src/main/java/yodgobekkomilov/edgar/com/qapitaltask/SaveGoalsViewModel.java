package yodgobekkomilov.edgar.com.qapitaltask;

import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.BindingAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import pojo.SavingsGoal;

public class SaveGoalsViewModel extends BaseObservable {

    private Context mContext;

    private SavingsGoal model;

    @BindingAdapter("imageUrl")
    public static void loadImage(ImageView view, String url) {
        Picasso.get().load(url).into(view);
    }

    public SaveGoalsViewModel(Context context) {
        this.mContext = context;
    }

    public void changeModel(SavingsGoal model) {
        this.model = model;
        notifyPropertyChanged(BR._all);
        // BRO WHAT IS HAPPENING HERE CAN YOU EXPLAIN
    }


    public String getImageName() {
        return model == null ? "" : model.getName();
    }

    public String getImageUrl() {
        return model == null ? "" : model.getGoalImageURL();
    }

    public String getAmountText() {
        if (model == null)
            return "";
        if (model.getTargetAmount() == null || model.getTargetAmount().equals("")) {
            return mContext.getString(R.string.amount_value_only, model.getCurrentBalance());
        } else {

            return mContext.getString(R.string.amount_value_of, model.getCurrentBalance(), model.getTargetAmount().toString());
        }
    }
}
