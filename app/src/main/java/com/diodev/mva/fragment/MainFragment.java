package com.diodev.mva.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;

import com.diodev.mva.R;
import com.diodev.mva.activity.HomeActivity;
import com.diodev.mva.activity.MainActivity;


public class MainFragment extends Fragment implements IMainFragment, View.OnClickListener {

    private EditText inputEmail;
    private EditText inputPassword;
    private Button btnSignIn;
    private ProgressBar progressBar;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initComponents();
        initListeners();
    }

    private void initComponents() {
        inputEmail = (EditText) getView().findViewById(R.id.editTxtEmail);
        inputPassword = (EditText) getView().findViewById(R.id.editTxtPassword);
        btnSignIn = (Button) getView().findViewById(R.id.btnSignin);
        progressBar = (ProgressBar) getView().findViewById(R.id.progressBar);
    }

    private void initListeners() {
        btnSignIn.setOnClickListener(this);
    }

    @Override
    public void enableInputs() {
        setInputs(true);
    }

    @Override
    public void disableInputs() {
        setInputs(false);
    }

    @Override
    public void showProgress() {
        progressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        progressBar.setVisibility(View.GONE);
    }

    @Override
    public void navigateToHomeActivity() {
        startActivity(new Intent(getActivity(), HomeActivity.class));
    }

    @Override
    public void loginError(String error) {
        inputPassword.setText("");
        String msgError = String.format(getString(R.string.login_error_message_signin), error);
        inputPassword.setError(msgError);
    }

    private void setInputs(boolean enabled) {
        inputEmail.setEnabled(enabled);
        inputPassword.setEnabled(enabled);
        btnSignIn.setEnabled(enabled);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnSignin:
                ((MainActivity)getActivity()).doLogin(inputEmail.getText().toString(), inputPassword.getText().toString());
                break;
        }
    }
}
