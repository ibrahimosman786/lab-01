package com.example.petshop;
import java.util.Date;

public class SadMood extends Mood {

    public SadMood() {
        super();
    }

    public SadMood(Date date) {
        super(date);
    }

    @Override
    public String describe() {
        return "sad";
    }
}
