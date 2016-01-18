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

        queueDetails currentData = _model.queueDetailsArrayList.get(position);

        holder.txtGroupName.setText(currentData.name);
        holder.refreshText.setText("Odświeżono: " + _model.updateDate + " " + _model.updateTime);
        holder.txtWaitingCount.setText(currentData.waitingCount);
        holder.txtOpenedDesks.setText(currentData.openedDesks);
        holder.txtAverageTime.setText(currentData.avgTime);
        holder.txtCurrentClient.setText(currentData.currentlyServed);
        holder.txtStatus.setText(currentData.status);
    }

    @Override
    public int getItemCount() {
        return _model.queueDetailsArrayList.size();
    }

    public class QueueHolder extends RecyclerView.ViewHolder {

        public final View mView;
        public final TextView txtGroupName;
        public final TextView txtStatus;
        public final TextView txtAverageTime;
        public final TextView txtOpenedDesks;
        public final TextView txtWaitingCount;
        public final TextView txtCurrentClient;

        public final TextView refreshText;

        public QueueHolder(View view) {
            super(view);
            mView = view;

            refreshText = refreshTextView;

            txtGroupName = (TextView) view.findViewById(R.id.groupNameTextView);
            txtCurrentClient = (TextView) view.findViewById(R.id.currentClientTextView);
            txtStatus = (TextView) view.findViewById(R.id.statusTextView);
            txtAverageTime = (TextView) view.findViewById(R.id.averageTimeTextView);
            txtOpenedDesks = (TextView) view.findViewById(R.id.openedDesksTextView);
            txtWaitingCount = (TextView) view.findViewById(R.id.waitingCountTextView);

        }


    }
}