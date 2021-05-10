package SmileyDict;

import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Search {
    private Word w;
    private String txt;
    private ArrayList<Word> listWord;

    Search(String _text,ArrayList<Word> _listWord){
        txt = _text;
        w = new Word();
        listWord = _listWord;
    }
    private int BinarySearch(){
        ArrayList<Word> list = this.listWord;
        int size = list.size() -1;
        int min = 0,max = size,mid;
        mid = (size/2);
        while(max > min){
            w = list.get(max);
             if(txt.compareToIgnoreCase(w.getWord()) == 0 ){
                
                return max;
            }
            w = list.get(min);
            if(txt.compareToIgnoreCase(w.getWord()) == 0){
                return min;
            }
            w = list.get(mid);
            if(txt.compareToIgnoreCase(w.getWord()) == 0){
                return mid;
            }else if(txt.compareToIgnoreCase(w.getWord()) < 0){
                max = mid-1;
                min = min + 1;
                mid = (int)(min+max)/2;
            }else if(txt.compareToIgnoreCase(w.getWord()) > 0){
                min = mid+1;
                max = max -1;
                mid = (int)(min+max)/2;
            }
        }
        return -1;
    }
    private int BinarySearchApproximate(){
        int sub = this.txt.length();
        ArrayList<Word> list = this.listWord;
        int size = list.size() -1;
        int min = 0,max = size,mid;
        mid = (size/2);
        String temp = null;
        while(max > min){
            w = list.get(max);
            temp = w.getWord().length() > sub ? w.getWord().substring(0, sub) : w.getWord();
            if(txt.compareToIgnoreCase(temp) == 0 ){
                
                return max;
            }
            w = list.get(min);
            temp = w.getWord().length() > sub ? w.getWord().substring(0, sub) : w.getWord(); 
            if(txt.compareToIgnoreCase(temp) == 0){
                return min;
            }
            w = list.get(mid);
            temp = w.getWord().length() > sub ? w.getWord().substring(0, sub) : w.getWord();
            if(txt.compareToIgnoreCase(temp) == 0){
                return mid;
            } else if(txt.compareToIgnoreCase(temp) < 0){
                max = mid-1;
                min = min + 1;
                mid = (int)(min+max)/2;
                

            } else if(txt.compareToIgnoreCase(temp) > 0){
                min = mid+1;
                max = max -1;
                mid = (int)(min+max)/2;
            }
            
        }
        return 0;
        
    }
    public int getIndex(){
        return BinarySearch() == -1 ? BinarySearchApproximate() : BinarySearch() ;
    }
}
