package com.mycom.word;

/**
 * 데이터클래스입니다.
 * 영단어 마스터 프로그램의 데이터인 영단어를 구성하는 번호, 레벨, 영단어, 뜻을 변수화하고
 * 이 영단어 데이터를 사용할 수 있게 getter, setter 등의 메소드를 추가한 클래스입니다.
 */

public class Word {
    private int index;
    private int level;
    private String word;
    private String meaning;

    Word() {}

    Word(int index, int level, String word, String meaning) {
        this.index = index;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getMeaning() {
        return meaning;
    }

    public void setMeaning(String meaning) {
        this.meaning = meaning;
    }

    @Override
    public String toString() {
        return String.format("%-3s", "*".repeat(Math.max(0, level)))
                + String.format("%20s", word)
                + "   " + meaning;
    }

    public String toFileString() {
        return this.level + "|" + this.word + "|" + this.meaning;
    }
}
