package com.diodev.mva.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.diodev.mva.R;
import com.diodev.mva.fragment.IMainFragment;
import com.diodev.mva.fragment.MainFragment;
import com.diodev.mva.repository.IRepository;
import com.diodev.mva.repository.Repository;

public class MainActivity extends AppCompatActivity implements IMainActivity {

    private IMainFragment mIMainFragment;
    private IRepository mIRepository;

    public MainActivity() {
        mIRepository = new Repository(this);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        mIMainFragment = (MainFragment)fragmentManager.findFragmentById(R.id.fragment);
        initComponents();
    }

    private void initComponents() {
        initToolbar();
        initFAB();
    }

    private void initToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }

    private void initFAB() {
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        if (fab != null) {
            fab.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                            .setAction("Action", null).show();
                }
            });
        }
    }

    public void doLogin(String email, String password){
        if (mIMainFragment != null) {
            mIMainFragment.disableInputs();
            mIMainFragment.showProgress();
        }
        mIRepository.login(email, password);
    }

    @Override
    public void onLoginSuccess() {
        if (mIMainFragment != null) {
            mIMainFragment.enableInputs();
            mIMainFragment.hideProgress();
            mIMainFragment.navigateToHomeActivity();
        }
    }

    @Override
    public void onLoginError(String error) {
        if (mIMainFragment != null) {
            mIMainFragment.enableInputs();
            mIMainFragment.hideProgress();
            mIMainFragment.loginError(error);
        }
    }
}
