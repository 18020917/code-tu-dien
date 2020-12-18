package sample;
import java.util.Scanner;
import java.io.*;

public class DictionaryManagement {
    public void insertFromFile(Dictionary dict, NewWord list_word) throws Exception {
        File file = new File("D:\\Dictionary.txt");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = null;
        while ((line = br.readLine()) != null) {
            Word word = new Word();
            word.word_target = line;
            list_word.listNewWord.add(line);
            line = br.readLine();
            word.word_explain = line;
            dict.listWord.add(word);
        }

    }

    public void writeToFile(Dictionary dict) throws Exception{
        File file = new File("D:\\Dictionary.txt");
        OutputStream outputStream = new FileOutputStream(file);
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(outputStream));
        for (Word word: dict.listWord) {
            writer.write(word.word_target);
            writer.newLine();
            writer.write(word.word_explain);
            writer.newLine();
        }
        writer.close();

    }


    public void showAllWords(Dictionary dict,NewWord list_word) {
        System.out.println("No\t|English\t|Vietnamese");
        int i = 1;
        for (Word word : dict.listWord) {
            System.out.println(i + "\t" + "|" + word.word_target + "\t" + "|" + word.word_explain);
            i++;
        }
    }

    public String dicionaryLookup(Dictionary dict, NewWord list_word, String new_word) {

        int index =list_word.listNewWord.indexOf(new_word);
        if ( index != -1) {
            Word word = dict.listWord.get(index);
            return word.word_explain;
        } else {
            return "Word not found";
        }

    }

    public void addNewWord(Dictionary dict, NewWord list_word, String new_word, String meaning) {
        Word word = new Word();
        word.word_target = new_word;
        word.word_explain = meaning;
        dict.listWord.add(word);
        list_word.listNewWord.add(new_word);


    }

    public void modify(Dictionary dict, NewWord list_word, String modifiedWord, String updatedWord, String updatedMeaning) {

        int index = list_word.listNewWord.indexOf(modifiedWord);
        dict.listWord.get(index).word_target = updatedWord;
        list_word.listNewWord.set(index,updatedWord);
        dict.listWord.get(index).word_explain =updatedMeaning;


    }


    public void remove(Dictionary dict, NewWord list_word, String removedWord) {

        int index = list_word.listNewWord.indexOf(removedWord);
        dict.listWord.remove(index);
        list_word.listNewWord.remove(index);

    }

}
