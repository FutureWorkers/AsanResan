package com.example.distribution.p007;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final ArrayList<CompanyDetail> companies = new ArrayList<>();
        CompanyDetail company;
        for(int i= 0;i<10;i++){
            company = new CompanyDetail();
            company.setCompanyName("شرکت"+i);
            company.setCompanyAddress("آدرس شرکت"+i);
            company.setCompanyId(i);
            companies.add(company);

            Log.v("companies",companies.get(i).getCompanyName());
        }

        MainAdapter adapter = new MainAdapter(this,0,companies);
        ListView list = (ListView) findViewById(R.id.list_view);
        list.setAdapter(adapter);
        //----------------------- company item selection --------------
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            Intent intent = new Intent(MainActivity.this,CompanyActivity.class);
            intent.putExtra("company", companies.get(position));
            startActivity(intent);

            }
        });

    }
}
