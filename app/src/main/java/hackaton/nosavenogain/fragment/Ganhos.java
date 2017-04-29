package hackaton.nosavenogain.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import hackaton.nosavenogain.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Ganhos extends Fragment
{

    public Ganhos()
    {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        // Inflate the layout for this fragment
        final View view = inflater.inflate(R.layout.fragment_ganhos, container, false);
        return view;
    }

}
