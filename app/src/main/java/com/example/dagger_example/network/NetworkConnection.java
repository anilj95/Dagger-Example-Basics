package com.example.dagger_example.network;

import android.os.Build;

import com.example.dagger_example.BuildConfig;
import com.example.dagger_example.basics.Constants;

import javax.inject.Inject;

public class NetworkConnection {

    private String mEndPoint;

    // if below annotation is not present : Compiler error : network.NetworkConnection cannot be provided without an @Inject constructor
    @Inject
    public NetworkConnection() {
        if (BuildConfig.DEBUG) {
            this.mEndPoint = Constants.DEBUG;

        } else {
            this.mEndPoint = Constants.RELEASE;
        }

    }

    public String doRequest() {

        return this.mEndPoint;
    }
}
