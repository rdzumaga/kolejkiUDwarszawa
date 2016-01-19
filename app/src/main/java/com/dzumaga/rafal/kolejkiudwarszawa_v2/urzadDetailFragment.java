package com.dzumaga.rafal.kolejkiudwarszawa_v2;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

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


        TextView refreshTextViewHolder = (TextView) rootView.findViewById(R.id.refreshText);

        RecyclerView recyclerListView = (RecyclerView) rootView.findViewById(R.id.list);

        adapter = new queueDetailsAdapter(new queueDetailsModelView(), refreshTextViewHolder);

        recyclerListView.setAdapter(adapter);



        fab = (FloatingActionButton) getActivity().findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                fab.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate));

                (new LoadQueueData(getActivity(), url, adapter)).execute();


            }
        });


        fab.startAnimation(AnimationUtils.loadAnimation(getActivity(), R.anim.rotate));

        (new LoadQueueData(getActivity(), url, adapter)).execute();

        return rootView;
    }
}
