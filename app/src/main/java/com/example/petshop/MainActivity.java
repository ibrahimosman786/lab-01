package com.example.petshop;

import android.os.Bundle;
import android.util.Log;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import java.util.ArrayList;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.outputText), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Cat cat = new Cat("kitty");
        Dog dog = new Dog("Snoopy");
        Scorpion scorpion = new Scorpion("Scorponok");

        ArrayList<Pet> petList = new ArrayList<>();
        petList.add(cat);
        petList.add(dog);
        petList.add(scorpion);

        ArrayList<Pettable> pettablePets = new ArrayList<>();
        pettablePets.add(cat);
        pettablePets.add(dog);


        Mood m1 = new HappyMood();
        Mood m2 = new SadMood();

        // Logcat output
        for (Pet p : petList) {
            Log.d("PetShop", p.getName() + " says " + p.speak());
        }
        Log.d("PetShop", "Mood1: " + m1.describe() + " at " + m1.getDate());
        Log.d("PetShop", "Mood2: " + m2.describe() + " at " + m2.getDate());

        // Screen output 
        TextView output = findViewById(R.id.outputText);

        StringBuilder sb = new StringBuilder();
        for (Pet p : petList) {
            sb.append(p.getName()).append(" says ").append(p.speak()).append("\n");
        }

        sb.append("\nMood1: ").append(m1.describe()).append(" at ").append(m1.getDate()).append("\n");
        sb.append("Mood2: ").append(m2.describe()).append(" at ").append(m2.getDate()).append("\n");

        output.setText(sb.toString());
    }
}

