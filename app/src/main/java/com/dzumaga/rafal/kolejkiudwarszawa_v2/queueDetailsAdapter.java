package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
//
///**
// * Created by Rafal on 2016-01-17.
// */


public class queueDetailsAdapter extends RecyclerView.Adapter<queueDetailsAdapter.QueueHolder> {

    public queueDetailsModelView _model;
    private TextView refreshTextView;

    public queueDetailsAdapter(queueDetailsModelView m, TextView refreshParent)
    {
        this._model = m;
        this.refreshTextView = refreshParent;
    }

    @Override
    public QueueHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.row, parent, false);
        return new QueueHolder(view);
    }

    @Override
    public void onBindViewHolder(QueueHolder holder, int position) {
        holder.txtCode.setText(_model.queueDetailsArrayList.get(position).code);
        holder.txtGroupName.setText(_model.queueDetailsArrayList.get(position).name);
        holder.refreshText.setText("Odświeżono: " + _model.updateDate + " " + _model.updateTime);
    }

    @Override
    public int getItemCount() {
        return _model.queueDetailsArrayList.size();
    }

    public class QueueHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView txtGroupName;
        public final TextView txtCode;
        public final TextView refreshText;

        public QueueHolder(View view) {
            super(view);
            mView = view;
            txtGroupName = (TextView) view.findViewById(R.id.textView3);
            txtCode = (TextView) view.findViewById(R.id.textView4);
            refreshText = refreshTextView;
        }

//        @Override
//        public String toString() {
//            return super.toString() + " overriden.";
//        }
    }
}