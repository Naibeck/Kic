package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.indigitous.hack.sansalvador.kic.KicApplication;
import com.indigitous.hack.sansalvador.kic.util.KicPreferences;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, root);
        return root;
    }

    public abstract @LayoutRes int getLayoutId();

    public KicPreferences getPreferences() {
        return KicApplication.getInstance().getPreferences();
    }
}
