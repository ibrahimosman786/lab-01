package com.example.petshop;

import java.util.Date;

public class HappyMood extends Mood {

    public HappyMood() {
        super();
    }

    public HappyMood(Date date) {
        super(date);
    }

    @Override
    public String describe() {
        return "happy";
    }
}