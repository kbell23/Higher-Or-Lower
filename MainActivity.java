package com.asp.kevinbell.higherorlower;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    public static int randomNumber;

    public void makeToast(String string){
        Toast.makeText(MainActivity.this, string, Toast.LENGTH_SHORT).show();
    }

    // guess function where all the work will be done
    public void guess(View view){

        //gets the users integer and displays both the users and random integers in the logs
        EditText userInput = (EditText) findViewById(R.id.userInput);
        Integer userInputInteger = Integer.parseInt(userInput.getText().toString());
        Log.i("UserInput", userInputInteger.toString());
        String randomNumberString = Integer.toString(randomNumber); // converts integer to string to be printed in the logs
        Log.i("Random", randomNumberString);

        // check the conditions based off the user's input
        if(userInputInteger > randomNumber){
            makeToast("Lower!");
        }
        else if(userInputInteger < randomNumber){
            makeToast("Higher!");
        }
        else{ // the user's input is equal to the random number
            makeToast("You got it!!!");
            Random random = new Random();
            randomNumber = random.nextInt(1000) + 1;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // create the random variable and set the bounds
        Random random = new Random();
        int min = 1;
        int max = 1000;
        randomNumber = min + random.nextInt(max); // number between 1 and 1000
        String randomNumberString = Integer.toString(randomNumber); // converts integer to string to be printed in the logs
        Log.i("Random", randomNumberString);
    }
}
