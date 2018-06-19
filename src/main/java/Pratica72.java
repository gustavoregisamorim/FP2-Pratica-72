
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import utfpr.ct.dainf.if62c.pratica.ContadorPalavras;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná DAINF - Departamento
 * Acadêmico de Informática
 *
 * Template de projeto de programa Java usando Maven.
 *
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */
public class Pratica72 {

    public static void main(String[] args) throws FileNotFoundException, IOException {

        Scanner scanner = new Scanner(System.in);
        String arq;

        System.out.print("Diretório completo do arquivo: ");
        arq = scanner.next();

        ContadorPalavras cP = new ContadorPalavras(arq);
        BufferedWriter bw = new BufferedWriter(new FileWriter(arq + ".out"));
        HashMap<String, Integer> vocabulario = cP.getPalavras();

        int maior = 1;

        Set<String> chaves = vocabulario.keySet();
        
        for(String chave: chaves){
            if(vocabulario.get(chave)> maior){
                maior = vocabulario.get(chave);
            }
        }

        while (maior > 0) {
            for (String chave : chaves) {
                if (vocabulario.get(chave) == maior) {
                    bw.write(String.format("%s,%d", chave, vocabulario.get(chave)));
                    bw.newLine();
                }
            }
            maior--;
        }
        
        bw.close();
        scanner.close();
    }
} 
