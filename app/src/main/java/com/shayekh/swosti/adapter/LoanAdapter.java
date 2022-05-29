package com.shayekh.swosti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shayekh.swosti.R;
import com.shayekh.swosti.loan.CollectionSheetBean;
import com.shayekh.swosti.member.BorrowerInfo;

import java.util.List;

public class LoanAdapter extends RecyclerView.Adapter<LoanAdapter.LoanViewHolder> {

    private Context context;
    private List<CollectionSheetBean> items;

    public LoanAdapter(Context context, List<CollectionSheetBean> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public LoanViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_loan, parent, false);
        return new LoanViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LoanViewHolder holder, int position) {

        CollectionSheetBean item=items.get(position);
        holder.loanRoll.setText(item.getPa().toString());
        holder.gs.setText(item.getSc().toString());
        holder.vs.setText(item.getVs().toString());
        holder.dps.setText(item.getDis().toString());
        holder.cpa.setText(item.getSc().toString());
        holder.csc.setText(item.getVs().toString());
        holder.paRec.setText(item.getDis().toString());
        holder.scRec.setText(item.getDis().toString());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class LoanViewHolder extends RecyclerView.ViewHolder {

        TextView loanRoll, gs, vs, dps,cpa,csc,paRec,scRec;


        public LoanViewHolder(@NonNull View itemView) {
            super(itemView);
            loanRoll = itemView.findViewById(R.id.loanRoll);
            gs = itemView.findViewById(R.id.gs);
            vs = itemView.findViewById(R.id.vs);
            dps = itemView.findViewById(R.id.dps);
            cpa = itemView.findViewById(R.id.cpa);
            csc = itemView.findViewById(R.id.csc);
            paRec = itemView.findViewById(R.id.paRec);
            scRec = itemView.findViewById(R.id.scRec);

        }
    }
}
