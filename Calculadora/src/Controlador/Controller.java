package Controlador;
import Vista.Calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author Eduardo Cadavid Garcia
 */
public class Controller implements ActionListener {
    Calc calc = new Calc();
    String num1;
    String signo;
    String num2;

    public void Controller(){
        this.calc = calc;

    }
    
    public void iniciar(){
        calc.setVisible(true);
        calc.setTitle("Calculadora EMDSOFT");
        calc.setLocationRelativeTo(null);
        this.calc.sumar.addActionListener(this);
        this.calc.restar.addActionListener(this);
        this.calc.multiplicacion.addActionListener(this);
        this.calc.division.addActionListener(this);
        this.calc.cero.addActionListener(this);
        this.calc.uno.addActionListener(this);
        this.calc.dos.addActionListener(this);
        this.calc.tres.addActionListener(this);
        this.calc.cuatro.addActionListener(this);
        this.calc.cinco.addActionListener(this);
        this.calc.seis.addActionListener(this);
        this.calc.siete.addActionListener(this);
        this.calc.ocho.addActionListener(this);
        this.calc.nueve.addActionListener(this);
        this.calc.borrar.addActionListener(this);
        this.calc.limpiar.addActionListener(this);
        this.calc.decimal.addActionListener(this);
        this.calc.porcentaje.addActionListener(this);
        this.calc.pos_neg.addActionListener(this);
        this.calc.igual.addActionListener(this);
    }
    
    public static boolean ExistePunto(String cadena){
        boolean resultado;
        resultado = false;
        for (int i = 0; i < cadena.length(); i++) {
            if(cadena.substring(i,i+1).equals(".")){
                resultado = true;
                break;
            }   
        }
        return resultado;
    }
    
    public static String Calculadora(String num1,String num2, String signo){
        Double resultado = 0.0;
        String respuesta;
        if(signo.equals("+")){
            resultado = Double.parseDouble(num1)+ Double.parseDouble(num2);
        }
        if(signo.equals("-")){
            resultado = Double.parseDouble(num1) - Double.parseDouble(num2);
        }
        if(signo.equals("*")){
            resultado = Double.parseDouble(num1) * Double.parseDouble(num2);
        }
        if(signo.equals("/")){
            resultado = Double.parseDouble(num1) / Double.parseDouble(num2);
        }
        respuesta = resultado.toString();
        return respuesta;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == calc.uno){calc.pantalla.setText(calc.pantalla.getText()+"1");}
        if(e.getSource() == calc.dos){calc.pantalla.setText(calc.pantalla.getText()+"2");}
        if(e.getSource() == calc.tres){calc.pantalla.setText(calc.pantalla.getText()+"3");}
        if(e.getSource() == calc.cuatro){calc.pantalla.setText(calc.pantalla.getText()+"4");}
        if(e.getSource() == calc.cinco){calc.pantalla.setText(calc.pantalla.getText()+"5");}
        if(e.getSource() == calc.seis){calc.pantalla.setText(calc.pantalla.getText()+"6");}
        if(e.getSource() == calc.siete){calc.pantalla.setText(calc.pantalla.getText()+"7");}
        if(e.getSource() == calc.ocho){calc.pantalla.setText(calc.pantalla.getText()+"8");}
        if(e.getSource() == calc.nueve){calc.pantalla.setText(calc.pantalla.getText()+"9");}
        if(e.getSource() == calc.cero){calc.pantalla.setText(calc.pantalla.getText()+"0");}
        
        if(e.getSource() == calc.sumar){
           if(!calc.pantalla.getText().equals("")){
               num1 = calc.pantalla.getText();
               signo = "+";
               calc.num_guardado.setText(calc.pantalla.getText()+signo);
               calc.pantalla.setText("");
           }
        }
        if(e.getSource() == calc.restar){
            if(!calc.pantalla.getText().equals("")){
               num1 = calc.pantalla.getText();
               signo = "-";
               calc.num_guardado.setText(calc.pantalla.getText()+signo);
               calc.pantalla.setText("");
            }
        }
        if(e.getSource() == calc.multiplicacion){
           if(!calc.pantalla.getText().equals("")){
               num1 = calc.pantalla.getText();
               signo = "*";
               calc.num_guardado.setText(calc.pantalla.getText()+signo);
               calc.pantalla.setText("");
           }
        }
        if(e.getSource() == calc.division){
           if(!calc.pantalla.getText().equals("")){
               num1 = calc.pantalla.getText();
               signo = "/";
               calc.num_guardado.setText(calc.pantalla.getText()+signo);
               calc.pantalla.setText("");
            }
        }
        if(e.getSource() == calc.borrar){
            String cadena;
            cadena = calc.pantalla.getText();
            if(cadena.length()>0){
                cadena = cadena.substring(0,cadena.length()-1);
                calc.pantalla.setText(cadena);
            }
        }
        if(e.getSource() == calc.limpiar){
            calc.pantalla.setText("");
            calc.num_guardado.setText("");
        }
        if(e.getSource() == calc.decimal){
            String cadena;
            cadena = calc.pantalla.getText();
            if(cadena.length()<=0){
                calc.pantalla.setText("0.");
            }else{
                if(!ExistePunto(calc.pantalla.getText())){
                    calc.pantalla.setText(calc.pantalla.getText()+".");
                }
            }
        }
        if(e.getSource() == calc.porcentaje){
            String number = calc.pantalla.getText();    
            double porcentaje = Double.parseDouble(number) * (0.01);
            calc.pantalla.setText(String.valueOf(porcentaje));
        }
        if(e.getSource() == calc.pos_neg){
            Double num;
            String cadena;
            cadena = calc.pantalla.getText();
            if(cadena.length()>0){
                num=(-1)*Double.parseDouble(cadena);
                calc.pantalla.setText(String.valueOf(num));
            }
        }
        if(e.getSource() == calc.igual){
            String resultado="";
            num2 = calc.pantalla.getText();
            if(!num2.equals(""))
                resultado=Calculadora(num1,num2,signo);
                calc.pantalla.setText(resultado);
                    calc.num_guardado.setText("");
        }
    }   
}
