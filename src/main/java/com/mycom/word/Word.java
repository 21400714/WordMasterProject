package com.mycom.word;

/**
 * 데이터클래스입니다.
 * 영단어 마스터 프로그램의 데이터인 영단어를 구성하는 번호, 레벨, 영단어, 뜻을 변수화하고
 * 이 영단어 데이터를 사용할 수 있게 getter, setter 등의 메소드를 추가한 클래스입니다.
 */

public class Word {
    private int id;
    private int level;
    private String word;
    private String meaning;

    Word() {}

    Word(int id, int level, String word, String meaning) {
        this.id = id;
        this.level = level;
        this.word = word;
        this.meaning = meaning;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    /*
    1 *         electric  전기의, 전기를 생산하는
    2 *             pole  기둥, 장대
    */

    @Override
    public String toString() {
        String slevel = "";

        for (int i = 0; i < level; i++) {
            slevel += "*";
        }

        String str = String.format("%-3s", slevel)
                + String.format("%15s", word)
                + "  " + meaning;

        return str;
    }
}
