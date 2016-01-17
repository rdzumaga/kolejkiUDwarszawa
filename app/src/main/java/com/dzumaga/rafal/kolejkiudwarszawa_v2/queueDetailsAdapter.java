package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Rafal on 2016-01-17.
 */
public class queueDetailsAdapter extends ArrayAdapter<queueDetails> {

    Context context;
    int layoutResourceId;
    queueDetails data[] = null;

    public void setItemList(queueDetailsModelView m)
    {
        this.data = m.queueDetailsArrayList.toArray(new queueDetails[m.queueDetailsArrayList.size()]);
        //notifyDataSetChanged();
    }

    public queueDetailsAdapter(Context context, int layoutResourceId, queueDetails[] data) {
        super(context, layoutResourceId, data);
        this.layoutResourceId = layoutResourceId;
        this.context = context;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        QueueHolder holder = null;

        if(row == null)
        {
            LayoutInflater inflater = ((Activity)context).getLayoutInflater();
            row = inflater.inflate(layoutResourceId, parent, false);

            holder = new QueueHolder();


            holder.txtGroupName = (TextView)row.findViewById(R.id.textView3);
            holder.txtCode = (TextView)row.findViewById(R.id.textView4);

            row.setTag(holder);
        }
        else
        {
            holder = (QueueHolder)row.getTag();
        }

        queueDetails queue = data[position];
        holder.txtGroupName.setText(queue.name);
        holder.txtCode.setText(queue.code);


        return row;
    }

    static class QueueHolder
    {

        TextView txtGroupName;
        TextView txtCode;
    }

}
