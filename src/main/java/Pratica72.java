
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class Pratica72 {
    public static void main(String[] args) throws FileNotFoundException, IOException{
        Scanner scanner = new Scanner(System.in);
        String path;
        ContadorPalavras counter;
        
        System.out.println("Path: ");
        counter = new ContadorPalavras(scanner.next());
        counter.csv(counter.getPalavras());
    }
    
    
}
