package ordenamiento;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class mezcla extends JFrame{
    int a[]=new int[5];
    int b[]=new int[5];
    int c[]=new int[10];
    
    int i, n, j,m,lon;
    int max, mayor;
    String salida1="", salida2="";    
    JTextArea areaSalida=new JTextArea(6,6);
    JTextArea areaSalida2=new JTextArea(6,6);
    JTextArea areaSalida3=new JTextArea(6,6);
    
    JTextField numero=new JTextField(15);
    
    public mezcla(){
        super("Ordenamiento por mezcla");        
        JLabel etiqueta=new JLabel("Ingresa los numeros.");
        JLabel etiqueta1=new JLabel("Los numeros son:");
            
        JButton capturar=new JButton("Capturar");
        capturar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evento){                        
                        if(m!=5){
                            captura(b);
                            m=n;                           
                        }
                        else 
                            captura(a); 
                    }
                }
        );         
        JButton ordenar=new JButton("Ordenar");
        ordenar.addActionListener(
                new ActionListener(){
                    public void actionPerformed(ActionEvent evento){
                        ordenaMezcla(a,b,c,n,m);                         
                    }
                }
        );        
        Container contenedor=getContentPane();
        contenedor.setLayout(new FlowLayout());        
        contenedor.add(etiqueta);
        contenedor.add(numero);
        contenedor.add(capturar);
        contenedor.add(etiqueta1);
        contenedor.add(areaSalida);
        contenedor.add(areaSalida2);
        contenedor.add(ordenar);
        contenedor.add(areaSalida3);        
        setSize(300,300);
        setVisible(true);
    }
    
    public void captura(int lista[]){        
        if (numero.getText().equals("")){
           JOptionPane.showMessageDialog(null,"Escriba un nombre");
           numero.setText("");
       }        
       else{
           int num=0;
           num=Integer.parseInt(numero.getText());
           lista[i]=num;
           
           salida2+=lista[i]+"\n";
           i++;
           numero.setText("");           
           
           if(m!=0){
               areaSalida.setText(salida2);               
            }
           else
               if (m==0){
                   areaSalida2.setText(salida2);                  
               }
               
           if (i==5){
               n=i;
               JOptionPane.showMessageDialog(null,"Fin de la captura");
               i=0;               
               salida2=""; 
               Burbuja(lista);
               }
       }
   }
    
    public void muestra(int nn,int a3[]){
        for(int k=0;k<nn;k++)
            salida1+=a3[k]+"\n";
        
        areaSalida3.setText(salida1);
    }
    
    public void Burbuja(int a1[]){
        int aux;
        String sal="";
        for (int i=0;i<5;i++){
            for (int j=0;j<5;j++){
                if (a1[i]<=a1[j]){
                    aux=a1[i];
                    a1[i]=a1[j];
                    a1[j]=aux;
                }
            }
        }
        for (int v=0;v<5;v++)
            sal+=a1[v]+" ";
        JOptionPane.showMessageDialog(null,"Datos ordenados:"+sal);                
    }
   
    public void ordenaMezcla(int a[],int b[],int c[],int m, int n){
        int i=0,j=0,k=0;
    	while((i<m)&&(j<n)){
    		  if(a[i]<=b[j]){
    		 c[k]=a[i];
    		 i++;
    		 }
    		  else{
    		   c[k]=b[j];
    		   j++;
    		  }
    		  k++;
    	}
    	if(i>m){
    	   do{
    		  c[k]=a[i];
    		  k++;
    		  i++;
    		 } while(i<=m);
    	}
    	else {
    	   do{
    		  c[k]=b[j];
    		  k++;
    		  j++;
    		 } while(j<n);
    	}
    	muestra(k,c);
    }

    public static void main(String[] args) {
        mezcla aplicacion2 =new mezcla();
        aplicacion2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}