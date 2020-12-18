import java.io.*;
import java.io.IOException;
public class DictionaryCommandline {
    public void showAllWords(Dictionary dict,NewWord list_word) {
        System.out.println("No\t|English\t|Vietnamese");
        int i = 1;
        for(Word word : dict.listWord) {
            System.out.println(i + "\t" + "|" + word.word_target + "\t" + "|" + word.word_explain);
            i++;
        }
        /*int j=1;
        for(String line: list_word.listNewWord) {
            System.out.println(j + line);
            j++;
        }
        int index = list_word.listNewWord.indexOf("School");
        System.out.println(index);
        Word word = dict.listWord.get(index);
        System.out.println(word.word_target);
        System.out.println(word.word_explain);
        */
    }

    public static void main(String[] args) throws Exception {
        Dictionary dict = new Dictionary();
        NewWord list_word = new NewWord();
        DictionaryManagement dictManage = new DictionaryManagement();
        dictManage.insertFromFile(dict,list_word);
        DictionaryCommandline dictCommand = new DictionaryCommandline();
        dictCommand.showAllWords(dict,list_word);
        dictManage.dicionaryLookup(dict,list_word);
        dictManage.addNewWord(dict,list_word);
        dictManage.modify(dict,list_word);
        dictManage.remove(dict,list_word);
        dictCommand.showAllWords(dict,list_word);
        dictManage.writeToFile(dict);


    }

    public void dictionaryBasic() throws Exception {
        Dictionary dict = new Dictionary();
        NewWord list_word = new NewWord();
        DictionaryManagement dictManage = new DictionaryManagement();
        dictManage.insertFromCommandline(dict,list_word);
        DictionaryCommandline dictCommand = new DictionaryCommandline();
        dictCommand.showAllWords(dict,list_word);
    }

    public void dictionaryAdvanced() throws Exception {
        Dictionary dict = new Dictionary();
        NewWord list_word = new NewWord();
        DictionaryManagement dictManage = new DictionaryManagement();
        dictManage.insertFromFile(dict,list_word);
        DictionaryCommandline dictCommand = new DictionaryCommandline();
        dictCommand.showAllWords(dict,list_word);
        dictManage.dicionaryLookup(dict,list_word);
    }

}
