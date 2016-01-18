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
//public class queueDetailsAdapter extends ArrayAdapter<queueDetails> {
//
//    Context context;
//    int layoutResourceId;
//    private View refreshParentView;
//    String refreshTextConent;
//
//    List<queueDetails> newData;
//
//
//    public void setItemList(queueDetailsModelView m)
//    {
//        this.newData = m.queueDetailsArrayList;
//        this.refreshTextConent = "Odświeżono: " + m.updateDate + " " + m.updateTime;
//    }
//
//    public queueDetailsAdapter(Context context, int layoutResourceId, List<queueDetails> _ndata, View refreshTextViewParent) {
//        super(context, layoutResourceId, _ndata);
//        this.layoutResourceId = layoutResourceId;
//        this.context = context;
//        this.newData = _ndata;
//        refreshTextConent = "";
//        this.refreshParentView = refreshTextViewParent;
//    }
//
//    @Override
//    public int getCount() {
//        if(newData != null)
//            return newData.size();
//        return  0;
//    }
//
//    @Override
//    public long getItemId(int position) {
//        if(newData != null)
//            return newData.get(position).hashCode();
//        return 0;
//    }
//
//    @Override
//    public queueDetails getItem(int position) {
//        if(newData != null)
//            return newData.get(position);
//        return null;
//    }
//
//    @Override
//    public View getView(int position, View convertView, ViewGroup parent) {
//        View row = convertView;
//        //QueueHolder holder = null;
//
//        if(row == null)
//        {
//            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
//            row = inflater.inflate(layoutResourceId, parent, false);
//
////            holder = new QueueHolder();
////
////
////            holder.txtGroupName = (TextView)row.findViewById(R.id.textView3);
////            holder.txtCode = (TextView)row.findViewById(R.id.textView4);
////
////            row.setTag(holder);
//        }
////        else
////        {
////            holder = (QueueHolder)row.getTag();
////        }
//
//        queueDetails queue = this.newData.get(position);
////        holder.txtGroupName.setText(queue.name);
////        holder.txtCode.setText(queue.code);
//
//        TextView txtGroupName = (TextView)row.findViewById(R.id.textView3);
//        txtGroupName.setText(queue.name);
//
//        TextView txtCode = (TextView)row.findViewById(R.id.textView4);
//        txtCode.setText(queue.code);
//
//        TextView rfrshText = (TextView)refreshParentView.findViewById(R.id.refreshText);
//        rfrshText.setText(this.refreshTextConent);
//
//        return row;
//    }
//
//    static class QueueHolder
//    {
//
//        TextView txtGroupName;
//        TextView txtCode;
//    }
//
//}


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

        @Override
        public String toString() {
            return super.toString() + " overriden.";
        }
    }
}