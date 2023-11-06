//author: Erblin Berisha

/*University assignment to create a working (basic) calculator that provides a usable GUI using
 * JFrame and JPanel etc.
 */


import java.awt.*;                                                                                                                               
import java.awt.event.ActionEvent;                                                                                                               
import java.awt.event.ActionListener;                                                                                                            
                                                                                                                                                 
import javax.swing.*;                                                                                                                            
import java.util.*;                                                                                                                              
                                                                                                                                                 
import javax.swing.JFrame;                                                                                                                       
import javax.swing.JTextArea;                                                                                                                    
                                                                                                                                                 
public class Main extends JFrame implements ActionListener {                                                                                     
    // initialised fields of core calculator components.                                                                                         
    private JTextArea display;                                                                                                                   
    private JPanel buttonGUI;                                                                                                                    
    private String operator;                                                                                                                     
    private double operand1, operand2;                                                                                                           
                                                                                                                                                 
    // CLASS CONSTRUCTOR----------------------------------------------------                                                                     
    public Main() {                                                                                                                              
        // small fixes to add QOL and set SIZE of window.                                                                                        
        super("Calculator");                                                                                                                     
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);                                                                                          
        setSize(300, 400);                                                                                                                       
                                                                                                                                                 
        // basic FIELD INITIALISING for the display and buttons.                                                                                 
        display = new JTextArea();                                                                                                               
        display.setEditable(false);                                                                                                              
        display.setPreferredSize(new Dimension(300, 100));                                                                                       
        display.setComponentOrientation(ComponentOrientation.RIGHT_TO_LEFT);                                                                     
        Font font = new Font("Arial", Font.PLAIN, 40);                                                                                           
        display.setFont(font);                                                                                                                   
        buttonGUI = buttons();                                                                                                                   
                                                                                                                                                 
        //jframe displays added                                                                                                                  
        add(display, BorderLayout.NORTH);                                                                                                        
        add(buttonGUI, BorderLayout.CENTER);                                                                                                     
                                                                                                                                                 
    }                                                                                                                                            
                                                                                                                                                 
    // JPANEL OBJECT--------------------------------------------------------                                                                     
    // grid is created as 4x4 and assigned to field buttonGUI inside constructor.                                                                
    private JPanel buttons() {                                                                                                                   
        JPanel grid = new JPanel(new GridLayout(4, 4));                                                                                          
                                                                                                                                                 
        // BUTTONS ADDED                                                                                                                         
        grid.add(new JButton("7")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("8")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("9")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("/")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("4")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("5")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("6")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("*")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("1")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("2")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("3")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("-")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("AC")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                  
        grid.add(new JButton("0")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("=")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
        grid.add(new JButton("+")).setFont(new Font("Arial", Font.PLAIN, 24));                                                                   
                                                                                                                                                 
        //iteration to implement action listeners to all buttons.                                                                                
        for (Component c : grid.getComponents()){                                                                                                
            if (c instanceof JButton){                                                                                                           
                ((JButton)c).addActionListener(this);                                                                                            
            }                                                                                                                                    
        }                                                                                                                                        
        return grid;                                                                                                                             
    }                                                                                                                                            
                                                                                                                                                 
    // ACTION LISTENER---------------------------------------------------------                                                                  
    public void actionPerformed(ActionEvent e) {                                                                                                 
        String buttonText = ((JButton) e.getSource()).getText();                                                                                 
        switch (buttonText) {                                                                                                                    
            case "0":                                                                                                                            
            case "1":                                                                                                                            
            case "2":                                                                                                                            
            case "3":                                                                                                                            
            case "4":                                                                                                                            
            case "5":                                                                                                                            
            case "6":                                                                                                                            
            case "7":                                                                                                                            
            case "8":                                                                                                                            
            case "9":                                                                                                                            
                display.setText(display.getText() + buttonText);                                                                                 
                break;                                                                                                                           
            case "+":                                                                                                                            
            case "-":                                                                                                                            
            case "*":                                                                                                                            
            case "/":                                                                                                                            
                operator = buttonText;                                                                                                           
                operand1 = Double.parseDouble(display.getText());                                                                                
                display.setText("");                                                                                                             
                break;                                                                                                                           
            case "AC":                                                                                                                           
                display.setText("");                                                                                                             
                break;                                                                                                                           
            case "=":                                                                                                                            
                operand2 = Double.parseDouble(display.getText());                                                                                
                double result = 0.0;                                                                                                             
                switch (operator) {                                                                                                              
                    case "+":                                                                                                                    
                        result = operand1 + operand2;                                                                                            
                        break;                                                                                                                   
                    case "-":                                                                                                                    
                        result = operand1 - operand2;                                                                                            
                        break;                                                                                                                   
                    case "*":                                                                                                                    
                        result = operand1 * operand2;                                                                                            
                        break;                                                                                                                   
                    case "/":                                                                                                                    
                        result = operand1 / operand2;                                                                                            
                        break;                                                                                                                   
                }                                                                                                                                
                display.setText(String.valueOf(result));                                                                                         
                break;                                                                                                                           
        }
    }                                                                                                                                            
                                                                                                                                                 
                                                                                                                                                 
                                                                                                                                                 
    public static void main(String[] args) {                                                                                                     
        Main calculator = new Main();                                                                                                            
            calculator.setLayout(new BorderLayout());                                                                                            
            calculator.add(calculator.display, BorderLayout.NORTH);                                                                              
            calculator.add(calculator.buttonGUI, BorderLayout.CENTER);                                                                           
            calculator.setVisible(true);                                                                                                         
                                                                                                                                                 
                                                                                                                                                 
                                                                                                                                                 
    }                                                                                                                                            
                                                                                                                                                 
}                                                                                                                                                
                                                                                                                                                 