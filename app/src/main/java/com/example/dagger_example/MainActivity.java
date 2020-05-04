package com.example.dagger_example;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.dagger_example.basics.MainViewModel;
import com.example.dagger_example.di.DaggerMainViewModelComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {

    // private MainViewModel mModel;

    //for field injection: 3 steps: 1) annotated with @inject to the field(can not be private) you want to inject. 2) create a method in
    // Top level component interface 3) call DaggerMainViewMOdel.create().injectFields() to initialize mMainViewModel.

    @Inject
    MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView tv = findViewById(R.id.textView);
        Button btn = findViewById(R.id.button);

        // Dagger is generated code for us at compille time, added Dagger as prefix in 'MainViewModelComponent', which was created by us.
        //  mModel = DaggerMainViewModelComponent.create().getMainViewModel();
        // chain of events: Dagger returns MainViewModel ->NetworkClient ->NetworkConnection
        //Dagger created DaggerMainViewModelComponent class, for more information got o java(generated) folder you can find all generated classes.

        //For field injection : Here we are manually triggering injectFields() to create object of mainviewmodel.

        DaggerMainViewModelComponent.create().injectFields(this);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //tv.setText(mModel.fetDocs());
                tv.setText(mainViewModel.fetDocs());
            }
        });
    }
}
