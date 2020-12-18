package sample;

import javafx.event.ActionEvent;
import java.io.*;
import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;


public class Controller {
    @FXML
    private TextField enteredWord ;

    @FXML
    private Label label;

    @FXML
    private Button add;

    @FXML
    private Button update;

    @FXML
    private Button remove;

    @FXML
    private Button loadData;

    @FXML
    private TextField newWord;

    @FXML
    private TextField meaning;

    @FXML
    private Button saveScene2;

    @FXML
    private Button backScene2;

    @FXML
    private Label labelScene2;

    @FXML
    private TextField modifiedWord;

    @FXML
    private TextField updatedWord;

    @FXML
    private TextField updatedMeaning;

    @FXML
    private Button saveScene3;

    @FXML
    private Button backScene3;

    @FXML
    private Label labelScene3;

    @FXML
    private TextField removedWord;

    @FXML
    private Button saveScene4;

    @FXML
    private Button backScene4;

    @FXML
    private Label labelScene4;



    Dictionary  dict = new Dictionary();
    DictionaryManagement dictManage = new DictionaryManagement();
    NewWord list_word = new NewWord();


    public void search(ActionEvent event) throws Exception {
        dictManage.insertFromFile(dict,list_word);
        String result = dictManage.dicionaryLookup(dict,list_word,enteredWord.getText());
        label.setText(result);

    }

    public void addNewWord(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("AddNewWord.fxml"));
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();

    }

    public void saveScene2(ActionEvent event) throws Exception{
        dictManage.insertFromFile(dict,list_word);
        String new_word = newWord.getText();
        String  explain = meaning.getText();
        dictManage.addNewWord(dict,list_word,new_word,explain);
        labelScene2.setText("Add word successfully");
        dictManage.writeToFile(dict);
    }

    public void backScene(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }

    public void modifyWord(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("UpdateWord.fxml"));
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }

    public void saveScene3(ActionEvent event) throws Exception {
        dictManage.insertFromFile(dict,list_word);
        String modified_word = modifiedWord.getText();
        String updated_word = updatedWord.getText();
        String updated_meaning = updatedMeaning.getText();
        dictManage.modify(dict,list_word,modified_word,updated_word,updated_meaning);
        labelScene3.setText("Modify word successfully");
        dictManage.writeToFile(dict);

    }


    public void removeWord(ActionEvent event) throws Exception {
        Stage primaryStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("RemoveWord.fxml"));
        primaryStage.setScene(new Scene(root, 350, 400));
        primaryStage.show();
    }


    public void saveScene4(ActionEvent event) throws Exception {
        dictManage.insertFromFile(dict,list_word);
        String removed_word = removedWord.getText();
        dictManage.remove(dict,list_word,removed_word);
        labelScene4.setText("Remove word successfully");
        dictManage.writeToFile(dict);
    }


}
