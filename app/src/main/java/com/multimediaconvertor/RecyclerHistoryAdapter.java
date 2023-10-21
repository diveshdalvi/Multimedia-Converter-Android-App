package com.multimediaconvertor;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.multimediaconvertor.model.History;
import java.util.ArrayList;
import java.util.List;

public class RecyclerHistoryAdapter extends RecyclerView.Adapter<RecyclerHistoryAdapter.ViewHolder>
{
    Context context;
    List<History> historyList;
    RecyclerHistoryAdapter(Context context , List<History> historyList){
        this.context = context;
        this.historyList = historyList;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.history_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        History history = historyList.get(position);
        holder.historyId.setText(String.valueOf(history.getId()));
        holder.historyName.setText(history.getName());
        holder.historyDate.setText(history.getDate());
    }

    @Override
    public int getItemCount() {
        return historyList.size();
    }

    public class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
        TextView historyId , historyName , historyDate;
        public ViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            historyId = itemView.findViewById(R.id.history_id);
            historyName = itemView.findViewById(R.id.history_name);
            historyDate = itemView.findViewById(R.id.history_id);
        }

        @Override
        public void onClick(View v) {
            Log.d("dbHistoryClick","History Button is Clicked");
        }
    }
}
