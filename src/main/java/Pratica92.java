import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.Timer;
import utfpr.ct.dainf.if62c.avaliacao.MinutoTask;
import utfpr.ct.dainf.if62c.avaliacao.MensagemImparTask;

/**
 * UTFPR - Universidade Tecnológica Federal do Paraná
 * DAINF - Departamento Acadêmico de Informática
 * 
 * Template de projeto de programa Java usando Maven.
 * @author Wilson Horstmeyer Bogado <wilson@utfpr.edu.br>
 */

public class Pratica92 {
    
    private static final SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            
    public static void main(String[] args) throws IOException{
        
        System.out.println("Pressione Enter para terminar");
        System.out.println("Hora de início: " + sdf.format(new Date()));
        long atraso = 60000 - new Date().getTime()%60000;
        Timer t1 = new Timer("minuto-cheio");
        Timer t2 = new Timer("minuto-impar");
        t1.schedule(new MinutoTask(t2), atraso, 60000);
        
        System.in.read();
        t1.cancel();
        t2.cancel();
        
        System.out.println("Hora de Término: "+ sdf.format(new Date()));
    }
}
