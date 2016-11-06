package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import com.indigitous.hack.sansalvador.kic.R;

/**
 * Created by Trainee-Dev on 11/6/2016.
 */
public class ContactFragment extends BaseFragment {

    public static ContactFragment getInstance() {
        return new ContactFragment();
    }

    @Override
    public int getLayoutId() {
        return R.layout.fragment_contact_list;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

    }
}
