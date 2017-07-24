package com.diodev.mva.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.diodev.mva.R;
import com.diodev.mva.entities.Session;

public class HomeActivity extends AppCompatActivity {

    private TextView mUserLoggedTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        initComponents();
    }

    private void initComponents() {
        mUserLoggedTextView = (TextView) findViewById(R.id.tv_user_logged);
        mUserLoggedTextView.setText(Session.getInstance().getUser().getId());
    }
}
