package com.indigitous.hack.sansalvador.kic.ui.fragment;

import com.indigitous.hack.sansalvador.kic.R;

/**
 * Created by Trainee-Dev on 11/5/2016.
 */
public class QrCodeFragment extends BaseFragment {
    @Override
    public int getLayoutId() {
        return R.layout.fragment_qr_code;
    }

    public static QrCodeFragment getInstance() {
        return new QrCodeFragment();
    }
}
