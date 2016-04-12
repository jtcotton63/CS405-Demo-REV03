package com.josepher.voicebox.ideaCats;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.josepher.voicebox.ContributeActivity;
import com.josepher.voicebox.CreateIdeaActivity;
import com.josepher.voicebox.R;
import com.josepher.voicebox.ideaPool.HistoryActivityPool;

public class SummaryFragmentCats extends Fragment {
    private OnFragmentInteractionListener mListener;

    private boolean expandedDescription = false;

    public SummaryFragmentCats() {
        // Required empty public constructor
    }

    public static SummaryFragmentCats newInstance() {
        SummaryFragmentCats fragment = new SummaryFragmentCats();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.cats_fragment_summary, container, false);

        TextView ideaDescription = (TextView) view.findViewById(R.id.idea_description);
        ideaDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v.findViewById(R.id.idea_description);
                if(!expandedDescription) {
                    tv.setLines(5);
                } else {
                    tv.setLines(3);
                }
                expandedDescription = !expandedDescription;
            }
        });

        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
