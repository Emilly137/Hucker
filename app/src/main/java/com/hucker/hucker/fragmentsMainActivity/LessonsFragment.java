package com.hucker.hucker.fragmentsMainActivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hucker.hucker.R;

public class LessonsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, null);
        ExpandableListView elv = (ExpandableListView) view.findViewById(R.id.expListView);
        elv.setAdapter(new SavedTabsListAdapter());
        return view;
    }


    public class SavedTabsListAdapter extends BaseExpandableListAdapter {

        private String[] groups = { "Beginners", "Intermediate riding" , "Buttering" , "Jumping" , "Jibbing" , "Half-piping"};

        private String[][] children = {
                { "Are you Regular or Goofy?", "Parts of Snowboard", "How to Strap in", "How to skate on a snowboard", "How to Traverse on a snowboard" , "First turns Helicopter" },
                { "Pressure control through turns", "How to Eurocarve on a snowboard", "How to ride Switch", "Backcountry Safety" },
                { "What is buttering", "Buttering like a Boss" },
                { "How to make a tramplin ", "Backcountry jumping" },
                {"coming soon"},
                {"coming soon"}
        };

        @Override
        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(LessonsFragment.this.getActivity());
            textView.setText(getGroup(i).toString());
            return textView;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            TextView textView = new TextView(LessonsFragment.this.getActivity());
            textView.setText(getChild(i, i1).toString());
            return textView;
        }


        @Override
        public int getGroupCount() {
            return groups.length;
        }

        @Override
        public int getChildrenCount(int i) {
            return children[i].length;
        }

        @Override
        public Object getGroup(int i) {
            return groups[i];
        }

        @Override
        public Object getChild(int i, int i1) {
            return children[i][i1];
        }

        @Override
        public long getGroupId(int i) {
            return i;
        }

        @Override
        public long getChildId(int i, int i1) {
            return i1;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public boolean isChildSelectable(int i, int i1) {
            return true;
        }

    }

}