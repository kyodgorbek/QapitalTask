package adapter;

import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import pojo.SavingGoals;
import pojo.SavingsGoal;
import yodgobekkomilov.edgar.com.qapitaltask.R;

public class SavingsAdapter  extends BaseAdapter {

    private final Context mContext;
    private final SavingGoals[] savings;
    TextView text;




    // 1
    public SavingsAdapter(Context context, SavingGoals[] savings) {
        this.mContext = context;
        this.savings = savings;
    }


    public void getText(SavingGoals goals){



        text.setText((CharSequence) goals.getSavingsGoals());


    }

    @Override
    public int getCount() {
        return savings.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout linearlayout = new LinearLayout(mContext);
        ImageView imageView = new ImageView(mContext);
        text = new TextView(mContext);
        linearlayout.setOrientation(LinearLayout.VERTICAL);
        imageView.setImageResource(mThumbIds[position]);
        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
        imageView.setLayoutParams(new GridView.LayoutParams(270, 270));
        text.setText(mThumbTxt[position]);

        linearlayout.addView(imageView);
        linearlayout.addView(text);
        return linearlayout;
    }
}