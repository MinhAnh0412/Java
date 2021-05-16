/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package smileydictionary;

import java.io.File;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author DELL
 */
public class SmileyDictionary {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        File f = new File("av.txt");
        ParseData pd = new ParseData(f);
        pd.start();
        try {
            pd.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(SmileyDictionary.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        ArrayList<Word> lw = pd.getWordList();
        
        Scanner input = new Scanner(System.in);
        int index;
        do{
            System.out.print("Enter a word: ");
            String word = input.nextLine();


            Search s = new Search(word,lw);
            index = s.getIndex();
            if(index ==0){
                System.out.println("No found your word");
            }else{
                Word aw = lw.get(index);
                System.out.println(aw.getWord() + " : "+ aw.getMind());
            }
        }while(index != 0);
    }
    
}
