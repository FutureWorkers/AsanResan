package com.example.distribution.p007;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class CompanyActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        CompanyDetail currentCompany = (CompanyDetail) getIntent().getSerializableExtra("company");
        TextView companyName = (TextView) findViewById(R.id.companyName);
        companyName.setText(currentCompany.getCompanyName());
    }
}
