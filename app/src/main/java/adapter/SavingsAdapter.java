package adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.ArrayList;

import database.SavingsRoomDatabase;
import pojo.SavingsGoal;
import yodgobekkomilov.edgar.com.qapitaltask.SaveGoalsViewModel;
import yodgobekkomilov.edgar.com.qapitaltask.databinding.SavingsItemBinding;

public class SavingsAdapter extends RecyclerView.Adapter<SavingsAdapter.SavingsViewHolder> {


    private ArrayList<SavingsGoal> savingGoals;
    private Context mContext;

    public SavingsAdapter(Context context) {
        mContext = context;
        savingGoals = new ArrayList<>();
    }

    public void refreshData() {
        savingGoals.clear();
        savingGoals.addAll(SavingsRoomDatabase.getDatabase(this.mContext).savingsGoalDao().getAllGoals());
        this.notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SavingsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final SavingsItemBinding binding = SavingsItemBinding.inflate(LayoutInflater.from(viewGroup.getContext()), viewGroup, false);
        return new SavingsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SavingsViewHolder savingsViewHolder, int position) {
        savingsViewHolder.viewModel.changeModel(savingGoals.get(position));
    }

    @Override
    public int getItemCount() {
        return savingGoals.size();
    }

    public static class SavingsViewHolder extends RecyclerView.ViewHolder {
        final public SaveGoalsViewModel viewModel;

        public SavingsViewHolder(SavingsItemBinding binding) {
            super(binding.getRoot());
            viewModel = new SaveGoalsViewModel(itemView.getContext());
            binding.setViewModel(viewModel);
        }
    }
}






















































