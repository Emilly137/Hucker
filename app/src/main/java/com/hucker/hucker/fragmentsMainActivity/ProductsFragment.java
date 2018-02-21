package com.hucker.hucker.fragmentsMainActivity;


import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.hucker.hucker.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ProductsFragment extends Fragment {


    public ProductsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_products, null);
        ExpandableListView elv = (ExpandableListView) view.findViewById(R.id.expListProductView);
        elv.setAdapter(new ProductsFragment.SavedTabsListAdapter(getActivity().getApplicationContext()));
        return view;
    }

    public class SavedTabsListAdapter extends BaseExpandableListAdapter {
        private Context mContext = null;

        private String[] groups = { "Snowboards", "Boots" , "Fastening" };

        public SavedTabsListAdapter (Context context){
            mContext = context;
        }

        private String[][] children = {
                { "All mountain /Freeride", "Freestyle", "Curving", "Directional" , "Sandwich","Hybrid" , "Twin" },
                { "Low", "Medium", "Hard" },
                { "Noboard", "Strap-in", "Winged hi-backs","Cap-strap" }
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
