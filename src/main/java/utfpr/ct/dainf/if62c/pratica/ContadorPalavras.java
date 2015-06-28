/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import static java.lang.Character.isAlphabetic;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author User
 */
public class ContadorPalavras{
    private BufferedReader reader;
    private BufferedWriter writer;
    private HashMap<String, Integer> words;
    private TreeMap<String, Integer> sortedwords;
    private WordComparator wc;
    
    public ContadorPalavras(String path) throws FileNotFoundException, IOException{
        reader = new BufferedReader(new FileReader(new File(path)));
        writer = new BufferedWriter(new FileWriter(new File(path + ".out")));
    }    
    
    public HashMap getPalavras() throws IOException{
        words = new HashMap<>();
        String line, word = "";
              
        while((line = reader.readLine()) != null){
            line = (line + ' ').toLowerCase();
            for(int i = 0 ; i < line.length() ; i++){
                if(isAlphabetic(line.charAt(i))){
                    word = word + line.charAt(i);   
                }
                else if(words.containsKey(word) && !"".equals(word)){ 
                    words.put(word, words.get(word)+1);
                    word = "";
                }
                else if(!"".equals(word)){
                    words.put(word, 1);
                    word = "";
                }  
            }
        }
        reader.close();
        return words;
    }
    
    public void csv(HashMap<String, Integer> words) throws IOException{
        wc = new WordComparator(words);
        sortedwords = new TreeMap<>(wc);
        
        sortedwords.putAll(words);
        
        for(Map.Entry<String,Integer> entry : sortedwords.entrySet()) {
            String str = (entry.getKey() + "," + entry.getValue());
            writer.write(str);
            writer.newLine();
        }
        writer.close();        
    } 
    
}
