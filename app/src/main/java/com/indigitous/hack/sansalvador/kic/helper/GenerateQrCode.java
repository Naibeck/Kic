package com.indigitous.hack.sansalvador.kic.helper;

import android.content.Context;
import android.graphics.Bitmap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.indigitous.hack.sansalvador.kic.R;

public class GenerateQrCode {

    public Bitmap generateQr(Context context, String token, int size) throws WriterException {
        BitMatrix result;
        try {
            result = new MultiFormatWriter().encode(token,
                    BarcodeFormat.QR_CODE, size, size, null);
        } catch (IllegalArgumentException iae) {
            // Unsupported format
            return null;
        }
        int w = result.getWidth();
        int h = result.getHeight();
        int[] pixels = new int[w * h];
        for (int y = 0; y < h; y++) {
            int offset = y * w;
            for (int x = 0; x < w; x++) {
                pixels[offset + x] = result.get(x, y) ?
                        context.getResources().getColor(R.color.sunset_orange) :
                        context.getResources().getColor(android.R.color.transparent);
            }
        }
        Bitmap bitmap = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        bitmap.setPixels(pixels, 0, 700, 0, 0, w, h);
        return bitmap;
    }

}
