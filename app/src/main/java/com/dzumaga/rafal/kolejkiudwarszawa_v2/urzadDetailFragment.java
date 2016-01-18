package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

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
    queueDetailsAdapter adapter;
    FloatingActionButton fab;
    private List values = new ArrayList(officeContent.officeList.values());
    private String url, officeName;
    private int officeIndex;


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
            officeIndex = (getArguments().getInt(OFFICE_INDEX));
            officeName = new ArrayList(officeContent.officeList.keySet()).get(officeIndex).toString();
            url = (String)values.get(officeIndex);

            setRetainInstance(true);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.urzad_detail, container, false);

        CollapsingToolbarLayout appBarLayout = (CollapsingToolbarLayout) getActivity().findViewById(R.id.toolbar_layout);
        if (appBarLayout != null) {
            appBarLayout.setTitle(officeName);
        }

        adapter = new queueDetailsAdapter(getContext(), R.layout.row, new ArrayList<queueDetails>(), rootView);

        ListView list = (ListView) rootView.findViewById(R.id.list);

        list.setAdapter(adapter);

        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Odświeżam...", Snackbar.LENGTH_SHORT)
                        .setAction("Action", null).show();

                (new LoadQueueData(getActivity(), url, adapter)).execute();
            }
        });

        (new LoadQueueData(getActivity(), url, adapter)).execute();

        return rootView;
    }
}
