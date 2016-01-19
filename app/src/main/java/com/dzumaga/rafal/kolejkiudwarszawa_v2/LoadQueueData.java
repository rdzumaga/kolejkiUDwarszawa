package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by Rafal on 2016-01-17.
 */
public class LoadQueueData extends AsyncTask<String, Integer , queueDetailsModelView> {

    private final ProgressDialog dialog;
    Context mContext;
    String mUrl;
    queueDetailsAdapter mAdapter;




    public LoadQueueData(Context _context, String _url, queueDetailsAdapter _adapter)
    {
        this.mUrl = _url;
        this.mContext = _context;
        this.mAdapter = _adapter;

        this.dialog = new ProgressDialog(_context);
    }



    @Override
    protected void onPostExecute(queueDetailsModelView queueDetailses) {
        super.onPostExecute(queueDetailses);
        mAdapter._model = queueDetailses;
        mAdapter.notifyDataSetChanged();
        dialog.dismiss();
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        dialog.setMessage("Pobieram dane...");
        dialog.show();
    }

    @Override
    protected queueDetailsModelView doInBackground(String... params) {

        try {
            Thread.sleep(1000, 0);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        queueDetailsModelView mModelView = new queueDetailsModelView();

        try {
            URL u = new URL(mUrl);

            HttpURLConnection conn = (HttpURLConnection) u.openConnection();
            conn.setRequestMethod("GET");

            conn.connect();
            InputStream is = conn.getInputStream();

            // Read the stream
            byte[] b = new byte[1024];
            ByteArrayOutputStream baos = new ByteArrayOutputStream();

            while ( is.read(b) != -1)
                baos.write(b);

            String JSONResp = new String(baos.toByteArray());

            JSONObject response = new JSONObject(JSONResp);

            mModelView.updateDate = response.getJSONObject("result").getString("date");
            mModelView.updateTime = response.getJSONObject("result").getString("time");

            JSONArray jsonObjArray = response.getJSONObject("result").getJSONArray("grupy");

            for (int i = 0; i < jsonObjArray.length(); i++) {
                JSONObject singleQueue = jsonObjArray.getJSONObject(i);

                queueDetails _details = new queueDetails();
                _details.name = singleQueue.getString("nazwaGrupy");
                _details.code = singleQueue.getString("literaGrupy");
                _details.avgTime = singleQueue.getString("czasObslugi") + " min";
                _details.currentlyServed = singleQueue.getString("aktualnyNumer");
                _details.openedDesks = singleQueue.getString("liczbaCzynnychStan");
                _details.lp = singleQueue.getString("lp");
                _details.status = singleQueue.getString("status");
                _details.groupId = singleQueue.getString("idGrupy");
                _details.waitingCount = singleQueue.getString("liczbaKlwKolejce");


                mModelView.queueDetailsArrayList.add(_details);
            }

            Collections.sort(mModelView.queueDetailsArrayList, new CustomComparator());

            return mModelView;
        }
        catch(Throwable t) {
            t.printStackTrace();
        }
        return null;

    }

    public class CustomComparator implements Comparator<queueDetails> {
        @Override
        public int compare(queueDetails o1, queueDetails o2) {
            return o1.name.compareTo(o2.name);
        }
    }


}
