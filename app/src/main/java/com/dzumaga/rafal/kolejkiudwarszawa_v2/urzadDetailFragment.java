package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * A fragment representing a single urzad detail screen.
 * This fragment is either contained in a {@link urzadListActivity}
 * in two-pane mode (on tablets) or a {@link urzadDetailActivity}
 * on handsets.
 */
public class urzadDetailFragment extends Fragment {
    /**
     * The fragment argument representing the item ID that this fragment
     * represents.
     */

    public static final String OFFICE_INDEX = "com.rafal.office_index";

    private List values = new ArrayList (officeContent.officeList.values());

    private String url;

    private JSONObject data=null;

    private queueInfo info;

   private int officeIndex;

    private void getDataFromAPI()
    {

        RequestQueue queue = Volley.newRequestQueue(getActivity().getApplicationContext());



        JsonObjectRequest request = new JsonObjectRequest(JsonObjectRequest.Method.GET, url, null, null, null);

        /*response.getJSONObject("result").getString("date");
        response.getJSONObject("result").getString("time");

        JSONArray jsonObjArray = response.getJSONObject("result").getJSONArray("grupy");

        for (int i = 0; i < jsonObjArray.length(); i++) {
            JSONObject singleQueue = jsonObjArray.getJSONObject(i);
        }

        response.getJSONObject("result").getJSONArray("grupy").getJSONObject(0).getString("czasObslugi");

        data = response.getJSONObject("result");*/

        queue.add(request);



    }

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public urzadDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments().containsKey(OFFICE_INDEX)) {
            // Load the dummy content specified by the fragment
            // arguments. In a real-world scenario, use a Loader
            // to load content from a content provider.
            officeIndex = (getArguments().getInt(OFFICE_INDEX));
            String officeName = new ArrayList(officeContent.officeList.keySet()).get(officeIndex).toString();
            url = (String)values.get(officeIndex);


            Activity activity = this.getActivity();

            CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) activity.findViewById(R.id.toolbar_layout);
            if (appBarLayout != null) {
                appBarLayout.setTitle(officeName);
            }
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.urzad_detail, container, false);

        queueDetails dataX[] = new queueDetails[]
                {
                  new queueDetails("raz","r"),
                        new queueDetails("dwa","d"),
                        new queueDetails("trzy","t")
                };

        queueDetailsAdapter adapter = new queueDetailsAdapter(getContext(), R.layout.row, dataX);

        ListView list = (ListView) rootView.findViewById(R.id.list);

        list.setAdapter(adapter);

        return rootView;
    }
}
