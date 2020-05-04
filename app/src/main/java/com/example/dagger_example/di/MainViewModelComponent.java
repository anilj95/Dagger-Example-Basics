package com.example.dagger_example.di;

import com.example.dagger_example.MainActivity;
import com.example.dagger_example.basics.MainViewModel;

import dagger.Component;

// dagger works on Directed graph, we have to tell that which is the top most factory whrere all graphs will end
// @component is considered as Top level factory in Dagger, then we have to tell how to create the Object of this Factory.
// Using @Inject annotation.
@Component
public interface MainViewModelComponent {

    MainViewModel getMainViewModel();

    // for field injection: return type will be void, parameter will the class name where injection is happening.
    void injectFields(MainActivity mainActivity);
}
