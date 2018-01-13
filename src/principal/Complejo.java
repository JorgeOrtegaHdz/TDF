package principal;

import javax.swing.JOptionPane;

public class Complejo {
    double i;
    double r;
    public Complejo(int real,int img){
        r=real;
        i=img;
    }
    public Complejo(double real,double img){
        r=real;
        i=img;
    }
    public static Complejo Suma(Complejo a,Complejo b){
        Complejo c=new Complejo(0,0);
        c.r=a.r+b.r;
        c.i=a.i+b.i;
        return c;
    }
    
    public static Complejo Resta(Complejo a,Complejo b){
        Complejo c=new Complejo(0,0);
        c.r=a.r-b.r;
        c.i=a.i-b.i;
        return c;
    }
    
    public static Complejo Potencia(Complejo a, int ex){
        Complejo c=new Complejo(0,0);
        /*c.r=Math.pow(a.r, ex);
        c.i=Math.pow(a.i, ex);*/
        if(ex==0){
            c.r=1;
            c.i=0;
        }else{
            c=a;
            ex--;
        }
        for(int i=0;i<ex;i++){
            c=Complejo.Multiplicacion(c, a);
        }
        //System.out.println(c.r+" + "+c.i+" i Potencia: "+ex);
        Complejo aux=new Complejo(c.r,c.i);
        return aux;
    }
    
    public static Complejo Multiplicacion(Complejo a,Complejo b){
        Complejo c=new Complejo(0,0);
        c.r=(a.r*b.r)+(a.i*b.i*-1);
        c.i=(a.r*b.i)+(a.i*b.r);
        return c;
    }
    
    public Complejo Conjugado(){
        Complejo c=new Complejo(0,0);
        c.r=this.r;
        c.i=this.i*-1;
        return c;
    }
    
    public static Complejo Divicion(Complejo a,Complejo b){
        Complejo c=new Complejo(0,0);
        Complejo aux=new Complejo(0,0);
        Complejo aux2=new Complejo(0,0);
        aux=Complejo.Multiplicacion(a, aux);
        aux2=Complejo.Multiplicacion(b, b.Conjugado());
        if(aux2.i>0){
            JOptionPane.showMessageDialog(null, "Error con la divicion... La multiplicacion del conjugado salio mal");
            System.exit(-1);
        }
        c.r=aux.r/aux2.r;
        c.i=aux.i/aux2.r;
        return c;
    }
    /*public static void main(String[]args){
        Complejo W=new Complejo(0,0);
        Complejo aux=new Complejo(0,0);
        W.r=Math.cos(2*Math.PI/5);
        W.i=Math.sin(2*Math.PI/5)*-1;
        aux=Complejo.Potencia(W, 3);
        System.out.println(aux.r+" + "+aux.i+" i");
    }*/
}
