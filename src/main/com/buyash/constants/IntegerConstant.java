package com.buyash.constants;

public enum  IntegerConstant {

    LENGTH_POSITION(0), TITLE_POSITION(1), SIZE_POSITION(2),
    INSTRUMENT_POSITION(3), COMPOSER_POSITION(4), STYLE_POSITION(5),
    NARRATOR_POSITION(3), SINGER_POSITION(6);

    private int value;

    private IntegerConstant(int value){
        this.value = value;
    }

    public int getValue(){
        return value;
    }
}
