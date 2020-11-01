package com.bstu.fit.yarmolik.cinema;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.core.hardware.fingerprint.FingerprintManagerCompat;

public class CheckFingerPrintCompatibility {
    public static boolean checkFingerprintCompatibility(@NonNull Context context) {
        return FingerprintManagerCompat.from(context).isHardwareDetected();
    }
}
