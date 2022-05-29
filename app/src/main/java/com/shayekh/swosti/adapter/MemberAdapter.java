package com.shayekh.swosti.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shayekh.swosti.R;
import com.shayekh.swosti.member.BorrowerInfo;

import java.util.List;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.MemberViewHolder> {

    private Context context;
    private List<BorrowerInfo> items;

    public MemberAdapter(Context context, List<BorrowerInfo> items) {
        this.context = context;
        this.items = items;
    }


    @NonNull
    @Override
    public MemberViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_member, parent, false);
        return new MemberViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MemberViewHolder holder, int position) {

        BorrowerInfo item=items.get(position);
        holder.sl.setText(item.getL().toString());
        holder.mId.setText(item.getI());
        holder.mName.setText(item.getG());
        holder.wp.setText(item.getGroupNo());
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class MemberViewHolder extends RecyclerView.ViewHolder {

        TextView sl, mId, mName, wp;


        public MemberViewHolder(@NonNull View itemView) {
            super(itemView);
            sl = itemView.findViewById(R.id.sl);
            mId = itemView.findViewById(R.id.mId);
            mName = itemView.findViewById(R.id.mName);
            wp = itemView.findViewById(R.id.wp);
        }
    }
}
