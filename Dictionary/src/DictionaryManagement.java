import java.util.Scanner;
import java.io.*;
public class DictionaryManagement {
    public void insertFromCommandline(Dictionary dict, NewWord list_word) {
        Scanner scanner = new Scanner(System.in);
        int n;
        System.out.println("Enter number of new words:");
        //n = scanner.nextInt();
        for(int i = 0; i < 2; i++ ) {
            System.out.println("Enter English word:");
            String engWord = scanner.nextLine();
            System.out.println("Enter Vietnamese meaning:");
            String meaning = scanner.nextLine();
            Word word = new Word();
            word.word_target = engWord;
            word.word_explain = meaning;
            dict.listWord.add(word);
            list_word.listNewWord.add(engWord);
        }

    }

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
       File file = new File("D:\\Data.txt");
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
    public void dicionaryLookup(Dictionary dict, NewWord list_word) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word:");
        String new_word = scanner.nextLine();
        int index =list_word.listNewWord.indexOf(new_word);
        Word word = dict.listWord.get(index);
        System.out.println("Meaning:" + word.word_explain);

    }

    public void addNewWord(Dictionary dict, NewWord list_word) {
        Scanner scanner = new Scanner(System.in);
        Word word = new Word();
        System.out.println("Enter new word");
        String engWord = scanner.nextLine();
        System.out.println("Enter meaning:");
        String meaning = scanner.nextLine();
        word.word_target = engWord;
        word.word_explain = meaning;
        dict.listWord.add(word);
        list_word.listNewWord.add(engWord);


    }

    public void modify(Dictionary dict, NewWord list_word) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word needs to be modified:");
        String modifiedWord = scanner.nextLine();
        int index = list_word.listNewWord.indexOf(modifiedWord);
        System.out.println("Word after updating:");
        String wordAfterUpdate = scanner.nextLine();
        dict.listWord.get(index).word_target = wordAfterUpdate;
        list_word.listNewWord.set(index,wordAfterUpdate);
        System.out.println("Meaning after updating:");
        dict.listWord.get(index).word_explain =scanner.nextLine();


    }


    public void remove(Dictionary dict, NewWord list_word) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter word needs to be removed:");
        String removedWord = scanner.nextLine();
        int index = list_word.listNewWord.indexOf(removedWord);
        dict.listWord.remove(index);
        list_word.listNewWord.remove(index);

    }


}
