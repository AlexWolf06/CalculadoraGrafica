import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class Calculadoragrafica extends JFrame implements ActionListener {
   JButton btnsuma,btnresta,btnmulti,btndivi,btnlimpiar,btnsalir;
   JTextField numero1,numero2,resultado;
   JLabel label1,label2;
   
   public void Controles(){
      Container contenedor = getContentPane();
      contenedor.setLayout(new FlowLayout());
      
      label1 = new JLabel("Nùmero 1");
      contenedor.add(label1);
      numero1 = new JTextField(10);
      contenedor.add(numero1);
  
      label2 = new JLabel("Nùmero 2");
      contenedor.add(label2); 
      numero2 = new JTextField(10);
      contenedor.add(numero2);
      
      btnsuma = new JButton("+");
      contenedor.add(btnsuma);
      btnsuma.addActionListener(this);
      
      btnresta = new JButton("-");
      contenedor.add(btnresta);
      btnresta.addActionListener(this);
      
      btnmulti = new JButton("x");
      contenedor.add(btnmulti);
      btnmulti.addActionListener(this);
      
      btndivi = new JButton("/");
      btndivi.addActionListener(this);
      contenedor.add(btndivi);

      resultado = new JTextField(10);
      contenedor.add(resultado);
      
      btnlimpiar = new JButton("Limpiar");
      contenedor.add(btnlimpiar);
      btnlimpiar.addActionListener(this);
      
      btnsalir=new JButton("Salir");
      btnsalir.setBackground(Color.green);
      contenedor.add(btnsalir);
      btnsalir.addActionListener(this);
   }
  
   public Calculadoragrafica(){
      super("Mi primera calculadora gràfica");
      Controles();
      setSize(380,150);
      setLocationRelativeTo(null);
      setVisible(true);
    }
  
   public void actionPerformed(ActionEvent a) {
      double  num1,num2,resulta;
      String resultad;
      
      if (a.getSource()==btnsuma) {//SUMA
          if(numero1.getText().equals("") || numero2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de llenar TODOS los campos correspondientes",
            "-ERROR-",JOptionPane.WARNING_MESSAGE); 
      } 
         else {  
          num1=Double.parseDouble(numero1.getText());
          num2=Double.parseDouble(numero2.getText());
          resulta=num1+num2;
          resultad=String.valueOf(resulta);
          resultado.setText(resultad);
         }          
      }
        
      if (a.getSource()==btnresta) {//RESTA
         if(numero1.getText().equals("") || numero2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de llenar TODOS los campos correspondientes",
               "-ERROR-",JOptionPane.WARNING_MESSAGE); 
         }
         else{
          num1=Double.parseDouble(numero1.getText());
          num2=Double.parseDouble(numero2.getText());
          resulta=num1-num2;
          resultad=String.valueOf(resulta);
          resultado.setText(resultad);
         }          
      } 
      
      if (a.getSource()==btnmulti) {//MULTIPLICACION   
         if(numero1.getText().equals("") || numero2.getText().equals("")){
            JOptionPane.showMessageDialog(null, "Favor de llenar TODOS los campos correspondientes",
               "-ERROR-",JOptionPane.WARNING_MESSAGE); 
         }      
         else{
            num1=Double.parseDouble(numero1.getText());
            num2=Double.parseDouble(numero2.getText());
            resulta=num1*num2;
            resultad=String.valueOf(resulta);
            resultado.setText(resultad);
         }          
      }
      
      if (a.getSource() == btndivi) {//DIVISION
         if(numero1.getText().equals("") || numero2.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Favor de llenar TODOS los campos correspondientes",
               "-ERROR-",JOptionPane.WARNING_MESSAGE);
         }
         else {  
            if (numero2.getText().equals("0")) {
               JOptionPane.showMessageDialog(null, "La divisiòn entre 0 no es posible",
               "-ERROR-",JOptionPane.ERROR_MESSAGE);
               numero2.setText(null);
               numero2.requestFocus();
            }
            else {
               num1=Double.parseDouble(numero1.getText());
               num2=Double.parseDouble(numero2.getText());
               resulta=num1/num2;
               resultad=String.format("%.4f",resulta);
               resultado.setText(resultad);
            }
         }
      }
          
      if (a.getSource()==btnlimpiar) {
         numero1.setText("");
         numero2.setText("");
         resultado.setText("");   
      } 
      
      if(a.getSource()==btnsalir) {
         System.exit(0);   
      }
   }
}