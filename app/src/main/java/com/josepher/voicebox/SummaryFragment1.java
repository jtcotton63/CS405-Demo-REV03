package com.josepher.voicebox;

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

public class SummaryFragment1 extends Fragment {
    private OnFragmentInteractionListener mListener;

    private boolean expandedDescription = false;

    public SummaryFragment1() {
        // Required empty public constructor
    }

    public static SummaryFragment1 newInstance() {
        SummaryFragment1 fragment = new SummaryFragment1();
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_summary, container, false);

        TextView ideaDescription = (TextView) view.findViewById(R.id.idea_description);
        ideaDescription.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView tv = (TextView) v.findViewById(R.id.idea_description);
                if(!expandedDescription) {
                    tv.setLines(6);
                } else {
                    tv.setLines(3);
                }
                expandedDescription = !expandedDescription;
            }
        });

        Button viewHistoryButton1 = (Button) view.findViewById(R.id.viewHistoryButton1);
        viewHistoryButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), HistoryActivity1.class);
                startActivity(intent);
            }
        });

        Button contributeButton1 = (Button) view.findViewById(R.id.contributeButton1);
        contributeButton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ContributeActivity.class);
                startActivity(intent);
            }
        });

        Button createIdeaButton = (Button) view.findViewById(R.id.finish_button);
        createIdeaButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), CreateIdeaActivity.class);
                startActivity(intent);
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
