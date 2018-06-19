/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.pratica;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 * @author Gustavo
 */
public class ContadorPalavras{
    
    private BufferedReader reader;
     
    public ContadorPalavras(String pathname) throws FileNotFoundException{
        
        reader = new BufferedReader(new FileReader(pathname));
    }

    /**
     *
     * @return
     * @throws java.io.IOException
     */
    public HashMap<String, Integer> getPalavras(){
        
        HashMap<String, Integer> vocabulario = new HashMap<>();
        
        String linha;
       
        try{
            while ((linha = reader.readLine()) != null){
                String[] palavras = linha.split(" ");
                for(String p: palavras){
                    p = p.replaceAll("[^\\p{L}\\- ]", "");
                    
                    if(vocabulario.containsKey(p)){
                        Integer valor = vocabulario.get(p) + 1;
                        vocabulario.put(p, valor);
                    }else{
                        vocabulario.put(p, Integer.valueOf(1));
                    }
                }
            }
        }catch(IOException ex){
            System.out.println(ex.getLocalizedMessage());
        }
        
        try{
            reader.close();
        }catch(IOException ex){
            System.out.println("O arquivo não foi fechado!");
        }
        
        return vocabulario;      
    }  
}
