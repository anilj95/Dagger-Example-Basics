package com.example.dagger_example.basics;

import com.example.dagger_example.network.NetworkClient;

import javax.inject.Inject; // Coming from JSR(java specification request 330)

//JSR is a Combination of some basic annotations used for different different dependency framework.
// Advantages: you dont need to remove depndencies if your project is moving from one DI framework to other.
public class MainViewModel {

    @Inject NetworkClient mClient;
    //private NetworkClient client;

    //Below annotation tells Dagger how to create object and what are dependecies. But how to create dependencies that also
    // we have to tell. go to NetworkClient class do constructor injection.

    //If constructor injection is being called, field & method injection will trigger automatically.  i.e for field injection we have to
    // follow 3 steps, here we are doing only one step i.e annotation the member which we want to inject, next 2 steps not required.
    // i.e wriritng 1 method & manually triggering that method to create object of NetworkClient.
    @Inject
    public MainViewModel() {

        //this.client = networkClient;
    }

    public String fetDocs() {

        return mClient.fetchData();
    }
}
