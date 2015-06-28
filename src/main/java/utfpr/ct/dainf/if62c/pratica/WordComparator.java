/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.util.Comparator;
import java.util.HashMap;

/**
 *
 * @author User
 */
public class WordComparator implements Comparator<String>{
    
    HashMap<String, Integer> words;
    
    public WordComparator(HashMap<String, Integer> words){
        this.words = words;
    }
    
    @Override
    public int compare(String a, String b){
        if(words.get(a) > words.get(b)){
            return -1;
        }
        else return 1;
    }
}
