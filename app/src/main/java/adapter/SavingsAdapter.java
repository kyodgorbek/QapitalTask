package adapter;

import android.annotation.SuppressLint;
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

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import pojo.SavingGoals;

import pojo.SavingsGoal;
import yodgobekkomilov.edgar.com.qapitaltask.MainActivity;
import yodgobekkomilov.edgar.com.qapitaltask.R;

public class SavingsAdapter  extends BaseAdapter {

    private  Context mContext;
    private List<SavingsGoal> savings;



    public class ViewHolder {
        TextView username,country;
        ImageView profilePic;

    }




    // 1
    public SavingsAdapter(List<SavingsGoal> savings, Context context) {
        this.mContext = context;
        this.savings = savings;
    }



    @Override
    public int getCount() {
        return savings.size();
    }

    @Override
    public Object getItem(int position) {
        return position;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @SuppressLint("SetTextI18n")
    public View getView(int position, View convertView, ViewGroup parent) {

        View rowView = convertView;
        ViewHolder viewHolder;

        if (rowView == null) {
            //LayoutInflater inflater =  getLayoutInflater;
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            rowView = inflater.inflate(R.layout.savings_item, parent,false);
            // configure view holder
            viewHolder = new ViewHolder();
//                viewHolder.copy = (ImageView) rowView.findViewById(R.id.copy);
//                viewHolder.share = (ImageView) rowView.findViewById(R.id.share);
             viewHolder.username = (TextView) rowView.findViewById(R.id.imgProfile);
            viewHolder.username = (TextView) rowView.findViewById(R.id.txtUsername);
            viewHolder.country = (TextView) rowView.findViewById(R.id.txtCountry);
            rowView.setTag(viewHolder);

        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }


        viewHolder.username.setText((Integer) savings.get(position).getId());
        viewHolder.country.setText((Integer) savings.get(position).getTargetAmount());


       // Glide.with(mContext).load(savings.get(position).getGoalImageURL()).into(viewHolder.profilePic));
       // Picasso.with(mContext) //
           //     .load(savings.get(position).getGoalImageURL()) //

        Picasso.get().load(String.valueOf(savings.get(position).getConnectedUsers())).into(viewHolder.profilePic);
        return convertView;
    }
}