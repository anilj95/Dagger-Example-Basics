package com.example.dagger_example.basics;

import com.example.dagger_example.network.NetworkClient;

import javax.inject.Inject; // Coming from JSR(java specification request 330)

//JSR is a Combination of some basic annotations used for different different dependency framework.
// Advantages: you dont need to remove depndencies if your project is moving from one DI framework to other.
public class MainViewModel {

    private NetworkClient client;

    //Below annotation tells Dagger how to create object and what are dependecies. But how to create dependencies that also
    // we have to tell. go to NetworkClient class do constructor injection.
    @Inject
    public MainViewModel(NetworkClient networkClient) {

        this.client = networkClient;
    }

    public String fetDocs() {

        return client.fetchData();
    }
}
