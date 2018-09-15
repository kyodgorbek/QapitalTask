package adapter;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
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



import pojo.SavingsGoal;
import yodgobekkomilov.edgar.com.qapitaltask.MainActivity;
import yodgobekkomilov.edgar.com.qapitaltask.R;

public class SavingsAdapter  extends RecyclerView.Adapter<SavingsAdapter.SavingsViewHolder> {


    ArrayList<SavingsGoal> savingGoals;

    public SavingsAdapter(ArrayList<SavingsGoal> savingsGoals){
        this.savingGoals = savingsGoals;
    }

    @NonNull
    @Override
    public SavingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.savings_item, viewGroup, false);
        SavingsViewHolder pvh = new SavingsViewHolder(v);
        return pvh;
    }

    @Override
    public void onBindViewHolder(@NonNull SavingsViewHolder savingsViewHolder, int position) {


        Picasso.get().load(savingGoals.get(position).getGoalImageURL()).into(savingsViewHolder.imgSavings);
        savingsViewHolder.userId.setText(savingGoals.get(position).getUserId());
        savingsViewHolder.targetAmount.setText((Integer) savingGoals.get(position).getTargetAmount());
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public static class SavingsViewHolder extends RecyclerView.ViewHolder {
       CardView cardview;
       TextView userId, targetAmount;
       ImageView imgSavings;
        public SavingsViewHolder(@NonNull View itemView) {
            super(itemView);

                cardview = (CardView)itemView.findViewById(R.id.card_view);
                userId = (TextView)itemView.findViewById(R.id.userId);
                targetAmount= (TextView)itemView.findViewById(R.id.targetAmount);
                imgSavings = (ImageView)itemView.findViewById(R.id.imgSavings);
            }
        }


    }






















































