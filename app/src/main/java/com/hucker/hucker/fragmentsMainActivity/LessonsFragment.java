package com.hucker.hucker.fragmentsMainActivity;

import android.content.Context;
import android.os.Bundle;
import android.support.constraint.ConstraintLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

import com.hucker.hucker.MainActivity;
import com.hucker.hucker.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class LessonsFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_lessons, null);
        ExpandableListView elv = (ExpandableListView) view.findViewById(R.id.expListView);
        elv.setAdapter(new SavedTabsListAdapter(getActivity().getApplicationContext()));
        return view;
    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {
        private Context mContext = null;

        private String[] groups = { "Beginners", "Intermediate riding" , "Buttering" , "Jumping" , "Jibbing" , "Half-piping"};

        public SavedTabsListAdapter (Context context){
            mContext = context;
        }

        private String[][] children = {
                { "Are you Regular or Goofy?", "Parts of Snowboard", "How to Strap in", "How to skate on a snowboard", "How to Traverse on a snowboard" , "First turns Helicopter" },
                { "Pressure control through turns", "How to Eurocarve on a snowboard", "How to ride Switch", "Backcountry Safety" },
                { "What is buttering", "Buttering like a Boss" },
                { "How to make a tramplin ", "Backcountry jumping" },
                {"coming soon"},
                {"coming soon"}
        };

//        @Override
//        public View getGroupView(int i, boolean b, View view, ViewGroup viewGroup) {
//            TextView textView = new TextView(LessonsFragment.this.getActivity());
//            textView.setText(getGroup(i).toString());
//            return textView;
//        }

//        @Override
//        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
//            TextView textView = new TextView(LessonsFragment.this.getActivity());
//            textView.setText(getChild(i, i1).toString());
//            return textView;
//        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View convertView,
                                 ViewGroup parent) {

            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.group_view, null);
            }

            if (isExpanded){
                //Изменяем что-нибудь, если текущая Group раскрыта
            }
            else{
                //Изменяем что-нибудь, если текущая Group скрыта
            }

            TextView textGroup = (TextView) convertView.findViewById(R.id.textGroup);
            textGroup.setText(getGroup(groupPosition).toString());

            return convertView;

        }

        @Override
        public View getChildView(int groupPosition, int childPosition, boolean isLastChild,
                                 View convertView, ViewGroup parent) {
            if (convertView == null) {
                LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(R.layout.child_view, null);
            }

            TextView textChild = (TextView) convertView.findViewById(R.id.textChild);
            textChild.setText(getChild(groupPosition, childPosition).toString());

            return convertView;
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