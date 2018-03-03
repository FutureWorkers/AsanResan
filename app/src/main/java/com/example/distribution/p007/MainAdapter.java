package com.example.distribution.p007;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Z50 on 2018-02-18.
 */

public class MainAdapter extends ArrayAdapter<CompanyDetail>{



    public MainAdapter(@NonNull Context context, int resource, @NonNull List<CompanyDetail> objects) {
        super(context, 0, objects);

    }
    //------------------------make list view------------------------
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View listItemView = convertView;

        if(listItemView==null){
            listItemView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_view,parent,false);
        }

        final CompanyDetail currentCompany = getItem(position);
        //-----------------------set item views------------------------
        TextView textView = (TextView) listItemView.findViewById(R.id.company_item);
        textView.setText(currentCompany.getCompanyName());

        return listItemView;
    }
}
