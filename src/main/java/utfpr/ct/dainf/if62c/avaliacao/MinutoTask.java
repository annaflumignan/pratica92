/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utfpr.ct.dainf.if62c.avaliacao;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Anna
 */
public class MinutoTask extends TimerTask {
    
    private final Date now = new Date();
    private final SimpleDateFormat sdf = new SimpleDateFormat("'Hora:' HH:mm:ss");
    Timer t;
    MensagemImparTask mti;
    
    public MinutoTask(Timer t){
        this.t = t;
    }
    
    public boolean eimpar(){
        return System.currentTimeMillis() % 120000 >= 60000;
    }
    
    @Override
    public void run(){
        now.setTime(System.currentTimeMillis());
        System.out.println(sdf.format(now));
        if(eimpar()){
            mti = new MensagemImparTask();
            t.schedule(mti, 10000, 10000);
        }
        else {
            if(mti!=null){
                  mti.cancel();
            }
        }
    }
}
