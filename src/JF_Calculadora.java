import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.lulu.pack1.JDialog_lulu;


public class JF_Calculadora extends JFrame {
    JFormattedTextField jft_visor = new JFormattedTextField();
    float operando1 = 0;
    float operando2= 0;
    float resultado;
    String str_operando1 = "";
    String str_operando2 = "";
    String str_operacion = "waiting...";
    JTextField tf_operando1,tf_operando2, tf_operacion;
    boolean operando1_busy;



    public JF_Calculadora(){
        super("Calculadora Lulu");
        this.setBounds(300,100,600,540);
        this.setIconImage(new ImageIcon("res/calc2.gif").getImage());
        build_gui(this.getContentPane());
        this.setVisible(true);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        refresh();
    }
    public void build_gui(Container contentPane){
        JPanel jp_main = new JPanel(new BorderLayout());

        JPanel jp_header = new JPanel();
            JLabel lb_enunciado = new JLabel("<html>Esta es una aplicación de calculadora para practicar JAVA</html>");
                jp_header.add(lb_enunciado);
            jp_main.add(jp_header,BorderLayout.NORTH);

        JPanel jp_foot = new JPanel(new GridLayout(2,0,10,10));
            JPanel jp_extrafoot = new JPanel(new FlowLayout());
                JLabel lb_operando1 = new JLabel("Operando 1");
                tf_operando1 = new JTextField((int) operando1);
                tf_operando1.setPreferredSize(new Dimension(80,30));
                tf_operando1.setEditable(false);
                JLabel lb_operando2 = new JLabel("Operando 2");
                tf_operando2 = new JTextField((int) operando2);
                tf_operando2.setPreferredSize(new Dimension(80,30));
                tf_operando2.setEditable(false);
                JLabel lb_operacion = new JLabel("Operación");
                tf_operacion = new JTextField((int) operando2);
                tf_operacion.setPreferredSize(new Dimension(100,30));
                tf_operacion.setEditable(false);
                    jp_extrafoot.add(lb_operando1);
                    jp_extrafoot.add(tf_operando1);
                    jp_extrafoot.add(lb_operando2);
                    jp_extrafoot.add(tf_operando2);
                    jp_extrafoot.add(lb_operacion);
                    jp_extrafoot.add(tf_operacion);
                jp_foot.add(jp_extrafoot);

            JPanel jp_copyleft = new JPanel();
                JLabel lb_copyleft = new JLabel("copy left Lulu2780h");
                jp_copyleft.add(lb_copyleft);
                jp_foot.add(jp_copyleft);

            jp_main.add(jp_foot,BorderLayout.SOUTH);


        JPanel jp_body = new JPanel();
            jp_body.setBackground(Color.orange);
            jp_body.setAlignmentY(Component.BOTTOM_ALIGNMENT);

            JPanel jp_visor = new JPanel(new FlowLayout());
                jft_visor.setText("0");
                jft_visor.setPreferredSize(new Dimension(300,50));
                jft_visor.setBackground(Color.lightGray);
                jft_visor.setHorizontalAlignment(SwingConstants.RIGHT);
                jft_visor.setFont(new Font("Serif",Font.PLAIN,20));
                jft_visor.setForeground(Color.black);
                jft_visor.setEditable(false);
                jp_visor.add(jft_visor);
                jp_body.add(jp_visor);

            JPanel jp_body_buttons = new JPanel(new GridLayout(5,4,10,10));
                fn_build_boton_pane(jp_body_buttons);
                
            jp_body.add(jp_body_buttons);

        jp_main.add(jp_body,BorderLayout.CENTER);

        contentPane.add(jp_main);
    }
    public void fn_build_boton_pane(Container container_botones){
        container_botones.setBackground(Color.orange);
        container_botones.setPreferredSize(new Dimension(300,300));

        // Create buttons

        var jb_C1 = new JButton("C");
            JButton jb_C2 = new JButton(":P");
            JButton jb_C3 = new JButton(":)");
            JButton jb_C4 = new JButton(":(");

            JButton jb_0 = new JButton("0");
            JButton jb_1 = new JButton("1");
            JButton jb_2 = new JButton("2");
            JButton jb_3 = new JButton("3");
            JButton jb_4 = new JButton("4");
            JButton jb_5 = new JButton("5");
            JButton jb_6 = new JButton("6");
            JButton jb_7 = new JButton("7");
            JButton jb_8 = new JButton("8");
            JButton jb_9 = new JButton("9");
            JButton jb_coma = new JButton(".");

            JButton jb_sum = new JButton("+");
            JButton jb_rest = new JButton("-");
            JButton jb_mult = new JButton("x");
            JButton jb_div = new JButton("/");

            JButton jb_equal = new JButton("=");


        container_botones.add(jb_C1);
        container_botones.add(jb_C2);
        container_botones.add(jb_C3);
        container_botones.add(jb_C4);
        container_botones.add(jb_7);
        container_botones.add(jb_8);
        container_botones.add(jb_9);
        container_botones.add(jb_div);
        container_botones.add(jb_4);
        container_botones.add(jb_5);
        container_botones.add(jb_6);
        container_botones.add(jb_mult);
        container_botones.add(jb_1);
        container_botones.add(jb_2);
        container_botones.add(jb_3);
        container_botones.add(jb_rest);
        container_botones.add(jb_0);
        container_botones.add(jb_coma);
        container_botones.add(jb_equal);
        container_botones.add(jb_sum);

        //LISTENERS
        jb_C1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_clear();
            }
        });
        jb_C2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog_lulu jDialog_lulu = new JDialog_lulu(container_botones,"Be happy");

                JLabel imgLabel = new JLabel(new ImageIcon("res/lengua-emoji.jpeg"));
                jDialog_lulu.add(imgLabel);
                jDialog_lulu.setVisible(true);
            }
        });
        jb_C3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog_lulu jDialog_lulu = new JDialog_lulu(container_botones,"Be happy");
                JLabel imgLabel = new JLabel(new ImageIcon("res/forrestgump5.jpg"));
                jDialog_lulu.add(imgLabel);
                jDialog_lulu.setVisible(true);
            }
        });
        jb_C4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JDialog jd_c4 = new JDialog();
                    JPanel jp_jd_c4 = new JPanel();
                    jp_jd_c4.setBackground(Color.GREEN);
                        JLabel jl = new JLabel("asdf");
                        //jp_jd_c4.add(jl);
                        JLabel imgLabel = new JLabel(new ImageIcon("res/spongebobcrying.jpg"));
                        jp_jd_c4.add(imgLabel);
                    jd_c4.add(jp_jd_c4);

                jd_c4.setSize(200,200);
                jd_c4.setVisible(true);
            }
        });
        jb_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("0");
            }
        });
        jb_1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("1");
            }
        });
        jb_2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("2");
            }
        });
        jb_3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("3");
            }
        });
        jb_4.addActionListener(actionEvent -> fn_completar_operandos("4"));
        jb_5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("5");
            }
        });
        jb_6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("6");
            }
        });
        jb_7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("7");
            }
        });
        jb_8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("8");
            }
        });
        jb_9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fn_completar_operandos("9");
            }
        });
        jb_coma.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                    fn_completar_operandos(".");
                }

        });
        jb_sum.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (operando1 == 0)
                {
                    if(Float.parseFloat(jft_visor.getText())!=0)
                    {
                        //hay dato en el visor pero no se ha pulsado numero, ergo se quiere tomar el dato del visor como operando1
                        operando1_busy=true;
                        operando1 = Float.parseFloat(jft_visor.getText());
                        str_operacion="suma";
                        refresh();
                    }else
                        {
                            //operando 1 = 0 además jft visor = 0, no debería hacer nada
                        }
                }
                else {
                    //operando1 != 0,
                    operando1_busy = true;
                    str_operacion = "suma";
                    refresh();
                }
            }
        });
        jb_rest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (operando1 == 0)
                {
                    if(Float.parseFloat(jft_visor.getText())!=0)
                    {
                        //hay dato en el visor pero no se ha pulsado numero, ergo se quiere tomar el dato del visor como operando1
                        operando1_busy=true;
                        operando1 = Float.parseFloat(jft_visor.getText());
                        str_operacion="resta";
                        refresh();
                    }else
                    {
                        //operando 1 = 0 además jft visor = 0, no debería hacer nada
                    }
                }
                else {
                    //operando1 != 0,
                    operando1_busy = true;
                    str_operacion = "resta";
                    refresh();
                }
            }
        });
        jb_mult.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (operando1 == 0)
                {
                    if(Float.parseFloat(jft_visor.getText())!=0)
                    {
                        //hay dato en el visor pero no se ha pulsado numero, ergo se quiere tomar el dato del visor como operando1
                        operando1_busy=true;
                        operando1 = Float.parseFloat(jft_visor.getText());
                        str_operacion="multiplicacion";
                        refresh();
                    }else
                    {
                        //operando 1 = 0 además jft visor = 0, no debería hacer nada
                    }
                }
                else {
                    //operando1 != 0,
                    operando1_busy = true;
                    str_operacion = "multiplicacion";
                    refresh();
                }
            }
        });
        jb_div.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (operando1 == 0)
                {
                    if(Float.parseFloat(jft_visor.getText())!=0)
                    {
                        //hay dato en el visor pero no se ha pulsado numero, ergo se quiere tomar el dato del visor como operando1
                        operando1_busy=true;
                        operando1 = Float.parseFloat(jft_visor.getText());
                        str_operacion="division";
                        refresh();
                    }else
                    {
                        //operando 1 = 0 además jft visor = 0, no debería hacer nada
                    }
                }
                else {
                    //operando1 != 0,
                    operando1_busy = true;
                    str_operacion = "division";
                    refresh();
                }
            }
        });

        jb_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String str_resultado;
                if(operando1 !=0) {
                    switch (str_operacion) {
                        case "suma":
                            resultado = operando1 + operando2;
                            str_resultado = Float.toString(resultado);
                            jft_visor.setText(str_resultado);
                            break;
                        case "resta":
                            resultado = operando1 - operando2;
                            str_resultado = Float.toString(resultado);
                            jft_visor.setText(str_resultado);
                            break;
                        case "multiplicacion":
                            resultado = operando1 * operando2;
                            str_resultado = Float.toString(resultado);
                            jft_visor.setText(str_resultado);
                            operando1_busy = false;
                            break;
                        case "division":
                            resultado = operando1 / operando2;
                            str_resultado = Float.toString(resultado);
                            jft_visor.setText(str_resultado);
                            break;
                        case "waiting...":
                            resultado = operando1;
                            str_resultado = Float.toString(resultado);
                            jft_visor.setText(str_resultado);
                            break;
                        default:
                            jft_visor.setText("fallo en operación");
                    }
                }
                else
                {
                    operando1 = Float.parseFloat(jft_visor.getText());
                    refresh();
                }
                fn_clear_postequal();
            }
        });

    }
    public void fn_clear(){
        jft_visor.setText("0");
        fn_clear_postequal();
    }
    public void fn_clear_postequal(){

        str_operacion = "waiting...";
        operando1 = 0;
        operando2 = 0;
        str_operando1 = "";
        str_operando2="";

        operando1_busy = false;
        refresh();

    }
    public void fn_completar_operandos(String op){


        if(operando1_busy)
            {   //hay dato en operando 1, luego el numero pulsado sera para el operando 2
                if ((str_operando2 == "")&& (op == "."))
                {
                    // se ha pulsado coma como primer numero, se entiende que hay que poner 0 delante
                    str_operando2 = str_operando2.concat("0"+op);
                }
                    else {
                        if(fn_is_integer(str_operando2))
                            {   //es entero (no tiene coma) le agregamos la cmoa
                                str_operando2 = str_operando2.concat(op);}
                            else{
                            //Ya tiene coma, concatenamos cifra, execpto la coma
                                    if (op!= "."){
                                    str_operando2 = str_operando2.concat(op);}
                                }
                        }
            jft_visor.setText(str_operando2);
            operando2 = Float.parseFloat(str_operando2);
            }
            else
                {
                //operando 1 esta libre
                if(Float.parseFloat(jft_visor.getText())==0)
                {   //operando 1 está libre y en el visor hay 0, luego el numero pulsado será par ael operando 1
                    if(op == ".")
                    { // en el visor hay cero y se ha pulsado coma
                        str_operando1 = str_operando1.concat("0"+op);
                    }
                    else
                        {// en el visor hay numero, pero se ha pulsado tecla, luego el numero del visor se pierde, y se establece nuevo op1
                            if(op == ".")
                            { //primera tecla pulsada es coma, ergo, hay que concatenar 0
                                str_operando1 = str_operando1.concat("0"+op);
                            }else {str_operando1 = str_operando1.concat(op);}

                        }
                    jft_visor.setText(str_operando1);
                    operando1 = Float.parseFloat(str_operando1);

                }
                    else {//operando 1 está libre y en el visor hay un numero ergo si pulsamos numero estaremos en el caso basico, el nuevo numero marcado será el operando 1
                    str_operando1 = str_operando1.concat(op);
                    jft_visor.setText(str_operando1);
                    operando1 = Float.parseFloat(str_operando1);
                    }
                }
  refresh();
    }

    public boolean fn_is_integer(String str_op) {

        for (int i = 0; i < str_op.length(); i++) {
            if (str_op.charAt(i) == '.') {
                //ya tiene una coma, luego ya es decimal, no es integer
                return false;

            }
        }
    return true;
    }

    public void refresh(){
        tf_operando1.setText(Float.toString(operando1));
        tf_operando1.setBackground(Color.YELLOW);
        tf_operando2.setText(Float.toString(operando2));
        tf_operando2.setBackground(Color.YELLOW);
        tf_operacion.setText(str_operacion);
        tf_operacion.setBackground(Color.YELLOW);
    }

    public void fn_do_nothing(){
            //TODO
            //SHOW DIALOG BOX
    }



}
