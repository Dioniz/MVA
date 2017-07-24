package com.diodev.mva;


import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.test.ActivityInstrumentationTestCase2;

import com.diodev.mva.fragment.MainFragment;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
public class MainFragmentTest extends ActivityInstrumentationTestCase2<FragmentUtilActivity> {

    private MainFragment fragment;

    public MainFragmentTest() {
        super(FragmentUtilActivity.class);
    }

    @Before
    public void setup() {
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        fragment = new MainFragment();
        getActivity().getSupportFragmentManager().beginTransaction().add(1, fragment).commit();
    }

    @Test
    public void aTest() {
        fragment.getView().findViewById(R.id.fragment);
    }
}