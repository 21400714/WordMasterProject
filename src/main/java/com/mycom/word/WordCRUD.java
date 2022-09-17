package com.mycom.word;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * ICRUD interface 구현체입니다.
 * 영단어 마스터 프로그램에서 실제로 CRUD 기능을 수행하는 클래스입니다.
 */

public class WordCRUD implements ICRUD {
    ArrayList<Word> wordList;
    Scanner s = new Scanner(System.in);
    final String fileName = "vocabulary.txt";

    WordCRUD() { wordList = new ArrayList<>(); }

    @Override
    public void create() {
        System.out.print("=> 난이도(1: 초급, 2: 중급, 3: 고급)를 입력하세요: ");
        int level = s.nextInt();
        s.nextLine();
        System.out.print("=> 단어를 입력하세요: ");
        String word = s.nextLine();
        System.out.print("=> 뜻을 입력하세요: ");
        String meaning = s.nextLine();

        Word wordItem = new Word(0, level, word, meaning);
        wordList.add(wordItem);
        System.out.println("\n[단어 추가 완료]");
    }

    @Override
    public void update() {
        System.out.print("=> 뜻을 수정할 단어를 입력하세요: ");
        String keyword = s.next();
        ArrayList<Integer> indexList = showWordList(keyword);
        System.out.print("=> 뜻을 수정할 단어의 번호를 입력하세요: ");
        int inputIndex = s.nextInt();
        s.nextLine();
        System.out.print("=> 뜻을 입력하세요: ");
        String newMeaning = s.nextLine();

        int indexListIndex = inputIndex - 1;
        int wordListIndex = indexList.get(indexListIndex);
        Word word = wordList.get(wordListIndex);
        word.setMeaning(newMeaning);
        System.out.println("\n[단어 수정 완료]");
    }

    @Override
    public void delete() {
        System.out.print("=> 삭제할 단어를 입력하세요: ");
        String keyword = s.next();
        ArrayList<Integer> indexList = showWordList(keyword);
        System.out.print("=> 삭제할 단어의 번호를 입력하세요: ");
        int inputIndex = s.nextInt();

        while (true) {
            System.out.print("=> 정말로 삭제하실래요? (y/n) ");
            String answer = s.next();

            if (answer.equalsIgnoreCase("y")) {
                int indexListIndex = inputIndex - 1;
                int wordListIndex = indexList.get(indexListIndex);
                wordList.remove(wordListIndex);
                System.out.println("\n[단어 삭제 완료]");
                break;
            }
            else if (answer.equalsIgnoreCase("n")) {
                System.out.println("\n[단어 삭제 취소]");
                break;
            }
            else {
                System.out.println("\n[올바르지 않은 입력]\n");
            }
        }
    }

    public void showWordList() {
        System.out.println("\n---------------------------------------------------------------------------");

        for (int wordListIndex = 0; wordListIndex < wordList.size(); wordListIndex++) {
            System.out.printf(" %3d ", (wordListIndex + 1));
            System.out.println(wordList.get(wordListIndex).toString());
        }

        System.out.println("---------------------------------------------------------------------------");
    }

    public void showWordList(int inputLevel) {
        int indexListIndex = 0;

        System.out.println("\n---------------------------------------------------------------------------");

        for (Word word : wordList) {
            int wordLevel = word.getLevel();

            if (wordLevel == inputLevel) {
                System.out.printf(" %3d ", (indexListIndex + 1));
                System.out.println(word);
                indexListIndex++;
            }
        }

        System.out.println("---------------------------------------------------------------------------");
    }

    public ArrayList<Integer> showWordList(String keyword) {
        ArrayList<Integer> indexList = new ArrayList<>();
        int indexListIndex = 0;

        System.out.println("\n---------------------------------------------------------------------------");

        for (int wordListIndex = 0; wordListIndex < wordList.size(); wordListIndex++) {
            String word = wordList.get(wordListIndex).getWord();

            if (word.contains(keyword)) {
                System.out.printf(" %3d ", (indexListIndex + 1));
                System.out.println(wordList.get(wordListIndex).toString());
                indexList.add(wordListIndex);
                indexListIndex++;
            }
        }

        System.out.println("---------------------------------------------------------------------------");

        return indexList;
    }

    public void searchByLevel() {
        System.out.print("=> 원하는 레벨(1: 초급, 2: 중급, 3: 고급)을 입력하세요: ");
        int level = s.nextInt();
        showWordList(level);
    }

    public void searchByKeyword() {
        System.out.print("=> 원하는 단어를 입력하세요: ");
        String keyword = s.next();
        showWordList(keyword);
    }

    public void loadFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;
            int count = 0;

            while (true) {
                line = br.readLine();

                if (line == null) {
                    break;
                }

                String[] wordData = line.split("\\|");
                int level = Integer.parseInt(wordData[0]);
                String word = wordData[1];
                String meaning = wordData[2];
                wordList.add(new Word(0, level, word, meaning));
                count++;
            }

            br.close();

            System.out.println("\n[파일 로딩 완료 " + "(" + count + "개)]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveFile() {
        try {
            PrintWriter pr = new PrintWriter(new FileWriter("test.txt"));

            for (Word wordItem : wordList) {
                pr.write(wordItem.toFileString() + "\n");
            }

            pr.close();

            System.out.println("\n[파일 저장 완료]");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
