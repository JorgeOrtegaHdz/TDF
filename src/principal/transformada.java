package principal;
import javax.swing.*;
import java.math.*;

public class transformada extends JFrame{
    String num_sus[];
    Complejo W=new Complejo(0,0);
    Complejo matriz[][];
    Complejo muestras[];
    Complejo resultado[];
    public transformada(){
        String numeros=JOptionPane.showInputDialog(this, "Dame una secuancia de numeros");
        num_sus=numeros.split(",");
        muestras=new Complejo[num_sus.length];
        resultado=new Complejo[num_sus.length];
        for(int i=0;i<num_sus.length;i++){
            muestras[i]=new Complejo(Integer.parseInt(num_sus[i]),0);
        }
        matriz=new Complejo[num_sus.length][num_sus.length];
        double ex=(double)((2*Math.PI)/num_sus.length);
        double cero=0.0000000000001;
        W.r=Math.cos(ex);
        W.i=Math.sin(ex)*-1;
        if(W.r>0){
            if(W.r<cero){
                W.r=0;
            }
        }else{
            if(W.r>cero*-1){
                W.r=0;
            }
        }
        if(W.i>0){
            if(W.i<cero){
                W.i=0;
            }
        }else{
            if(W.i>(cero*-1)){
                W.i=0;
            }
        }
        for(int i=0;i<num_sus.length;i++){
            matriz[i][0]=Complejo.Potencia(W, 0);
        }
        for(int i=0;i<num_sus.length;i++){
            matriz[0][i]=Complejo.Potencia(W, 0);
        }
        Complejo W2=Complejo.Potencia(W, 2);
        Complejo W3=Complejo.Potencia(W, 3);
        Complejo W4=Complejo.Potencia(W, 4);
        int n=1,aux=0;
        for(int i=1;i<num_sus.length;i++){
            aux=0;
            for(int j=1;j<num_sus.length;j++){
                aux+=n;
                switch(aux%4){
                    case 0:
                        matriz[i][j]=W4;
                    break;
                    case 1:
                        matriz[i][j]=W;
                    break;
                    case 2:
                        matriz[i][j]=W2;
                    break;
                    case 3:
                        matriz[i][j]=W3;
                    break;
                }
                //System.out.print(matriz[i][j].r+" + "+matriz[i][j].i+" i Wa la:"+aux+"   ");
            }
            //System.out.println();
            n++;
        }
        for(int i=0;i<num_sus.length;i++){
            resultado[i]=new Complejo(0,0);
            for(int j=0;j<num_sus.length;j++){
                Complejo nuevo=Complejo.Multiplicacion(matriz[i][j],muestras[j]);
                resultado[i]=Complejo.Suma(resultado[i],nuevo);
            }
            System.out.println("Resultado "+i+": "+resultado[i].r+" "+resultado[i].i+" i");
        }
    }
    public static void main(String[]args){
        transformada t=new transformada();
        System.exit(0);
    }
    //9099 muestras tarda 1 minuto con 26 segundos
}
