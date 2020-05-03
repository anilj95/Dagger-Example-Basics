package com.example.dagger_example.network;

import javax.inject.Inject;

public class NetworkClient {

    private NetworkConnection mConnection;

    @Inject
    public NetworkClient(NetworkConnection mConnection) { // Again we have to tell how to create NetworkConnection dependency, which is being used here.
        this.mConnection = mConnection;
    }

    public String fetchData() {

        return mConnection.doRequest();
    }
}
