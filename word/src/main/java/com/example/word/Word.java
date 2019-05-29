package com.example.word;

public class Word {

    public String word;

    public Word() {
        super();
    }

    public Word(String word) {
        this();
        this.word = word;
    }

    public String getWord() {
        return word;
    }

    public String getTest(){
        return "test";
    }

    public void setWord(String word) {
        this.word = word;
    }


}
