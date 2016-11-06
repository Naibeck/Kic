package com.indigitous.hack.sansalvador.kic.ui.fragment;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;

import com.google.zxing.WriterException;
import com.indigitous.hack.sansalvador.kic.R;
import com.indigitous.hack.sansalvador.kic.helper.GenerateQrCode;

import butterknife.BindView;

public class QrCodeFragment extends BaseFragment {

    @BindView(R.id.iv_qr_code)
    ImageView ivQrCode;

    @Override
    public int getLayoutId() {
        return R.layout.fragment_qr_code;
    }

    public static QrCodeFragment getInstance() {
        return new QrCodeFragment();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        GenerateQrCode qrCode = new GenerateQrCode();
        try {
            Bitmap qr = qrCode.generateQr(getContext(), getPreferences().getToken().getId(), 700);
            ivQrCode.setImageBitmap(qr);
        } catch (WriterException e) {
            e.printStackTrace();
        }

    }
}
