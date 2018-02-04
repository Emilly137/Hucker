package fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.hucker.hucker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment_Session_Notes extends Fragment {


    public Fragment_Session_Notes() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_session__notes, container, false);
    }

}
