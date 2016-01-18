package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rafal on 2016-01-17.
 */
public class queueDetailsAdapter extends ArrayAdapter<queueDetails> {

    Context context;
    int layoutResourceId;
    private View refreshParentView;
    String refreshTextConent;

    List<queueDetails> newData;


    public void setItemList(queueDetailsModelView m)
    {
        this.newData = m.queueDetailsArrayList;
        this.refreshTextConent = "Odświeżono: " + m.updateDate + " " + m.updateTime;
    }

    public queueDetailsAdapter(Context context, int layoutResourceId, List<queueDetails> _ndata, View refreshTextViewParent) {
        super(context, layoutResourceId, _ndata);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.newData = _ndata;
        refreshTextConent = "";
        this.refreshParentView = refreshTextViewParent;
    }

    @Override
    public int getCount() {
        if(newData != null)
            return newData.size();
        return  0;
    }

    @Override
    public long getItemId(int position) {
        if(newData != null)
            return newData.get(position).hashCode();
        return 0;
    }

    @Override
    public queueDetails getItem(int position) {
        if(newData != null)
            return newData.get(position);
        return null;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        //QueueHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

//            holder = new QueueHolder();
//
//
//            holder.txtGroupName = (TextView)row.findViewById(R.id.textView3);
//            holder.txtCode = (TextView)row.findViewById(R.id.textView4);
//
//            row.setTag(holder);
        }
//        else
//        {
//            holder = (QueueHolder)row.getTag();
//        }

        queueDetails queue = this.newData.get(position);
//        holder.txtGroupName.setText(queue.name);
//        holder.txtCode.setText(queue.code);

        TextView txtGroupName = (TextView)row.findViewById(R.id.textView3);
        txtGroupName.setText(queue.name);

        TextView txtCode = (TextView)row.findViewById(R.id.textView4);
        txtCode.setText(queue.code);

        TextView rfrshText = (TextView)refreshParentView.findViewById(R.id.refreshText);
        rfrshText.setText(this.refreshTextConent);

        return row;
    }

    static class QueueHolder
    {

        TextView txtGroupName;
        TextView txtCode;
    }

}
