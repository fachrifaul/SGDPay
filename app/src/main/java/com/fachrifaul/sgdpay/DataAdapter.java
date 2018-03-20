package com.fachrifaul.sgdpay;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.fachrifaul.sgdpay.model.ServiceType;

import java.util.ArrayList;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {
    private ArrayList<ServiceType> android;
    private OnItemClickListener mListener;

    DataAdapter(ArrayList<ServiceType> android) {
        this.android = android;
    }

    void setClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_layout, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        holder.setOnClickListener(mListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder viewHolder, int i) {
        viewHolder.serviceTextView.setText(android.get(i).getServiceName());
        viewHolder.serviceImageView.setImageDrawable(android.get(i).getServiceImage());
    }

    @Override
    public int getItemCount() {
        return android.size();
    }

    interface OnItemClickListener {
        void onClick(View view, int position);
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        private TextView serviceTextView;
        private ImageView serviceImageView;
        private View serviceLayout;

        ViewHolder(View view) {
            super(view);
            serviceLayout = view.findViewById(R.id.serviceLayout);
            serviceTextView = (TextView) view.findViewById(R.id.serviceTextView);
            serviceImageView = (ImageView) view.findViewById(R.id.serviceImageView);
        }

        void setOnClickListener(final OnItemClickListener listener) {
            serviceLayout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onClick(serviceLayout, getAdapterPosition());
                }
            });
        }
    }

}