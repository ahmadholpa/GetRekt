import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

import java.util.*;
/**
 * Write a description of class GraphicalOthello here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GraphicalOthello extends Othello implements ActionListener
{
    private JFrame gameFrame;
    private JButton[][] buttons;
    private JPanel gridPanel;
    private JButton Rbutton;
    private JButton Fbutton;
    private JButton Gbutton;
    private JPanel DPanel;
    private JOptionPane JOP;
    private JButton aButton;
    private int result;
    //private ButtonHandler bh;
    //private JButton Button= new JButton();
    public GraphicalOthello()
    {
        super(SIZE);
        gameFrame= new JFrame("Graphical Othello");
        
       buttons=new JButton[SIZE][SIZE];
        JOP= new JOptionPane();
        
  
        gridPanel = new JPanel();
        gridPanel.setLayout(new GridLayout(SIZE,SIZE));
        gameFrame.add(gridPanel);

        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE; j++)
            {
                buttons[i][j]= new JButton("");
                buttons[i][j].addActionListener(this);
                buttons[i][j].setActionCommand("" + i + j);
                gridPanel.add(buttons[i][j]);
            }
        }
        
        DPanel = new JPanel();
        gameFrame.add(BorderLayout.SOUTH,DPanel);
        
        
        
        
        Rbutton= new JButton("Random");
        Rbutton.addActionListener(this);
        DPanel.add(Rbutton);
        
        Fbutton= new JButton("First Available Move");
        Fbutton.addActionListener(this);
        DPanel.add(Fbutton);
        
        Gbutton= new JButton("Greedy");
        Gbutton.addActionListener(this);
        DPanel.add(Gbutton);
        
        gameFrame.setSize(500,500);
        gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.print();
        
        gameFrame.setVisible(true);
        
        
        result = JOptionPane.showConfirmDialog(null,"Do you want to start first?",
                 "Answer this Question", JOptionPane.YES_NO_OPTION);
                 
                 
         if (result == 1) 
         {
             machinePlay();
             this.toggleTurn();
             print();
            }       
        
        
        
        //gameFrame.pack();
        
        
    }
    
    //private void Gamestarter
    
    public void print()
    {
        
        for(int i=0; i<SIZE; i++)
        {
            for(int j=0; j<SIZE;j++)
            {
                if(grid[i][j]=='o')
                {
                //grid[i][j]= new JButton("o");
                buttons[i][j].setText("o");
                //gridPanel.add(buttons[i][j]);
               }else if(grid[i][j]=='x')
               {
                //grid[i][j]= new JButton("x");
                buttons[i][j].setText("x");
                //gridPanel.add(buttons[i][j]);
                }else if(grid[i][j]=='_')
                {
                //grid[i][j]= new JButton("_");
                //gridPanel.add(buttons[i][j]);
                buttons[i][j].setText("_");
                
               }
        }
       }
       //gameFrame.setVisible(true);
    }
    
    public void actionPerformed(ActionEvent E)
    {
        
        int row;
        int col;
        int counter;

       
        if(E.getSource()==Rbutton)
       {
          this.setMoveStrategy(new RandomMove());
       }
        else if(E.getSource()== Fbutton)
       {
          this.setMoveStrategy(new FirstAvailableMove());
       }else if(E.getSource()==Gbutton)
       {
          this.setMoveStrategy(new GreedyMove());
        }else{
            JButton button= (JButton) E.getSource();
            String command = button.getActionCommand();
            
            row= Integer.parseInt(command.substring(0,1));
            col= Integer.parseInt(command.substring(1,2));
            if(canPlay(new Move(row,col)))
            {
              play(new Move(row,col));
            button.setEnabled(false);
            //grid[row][col]=turn;
            this.toggleTurn();
            //machinePlay();
            print(); 
           }else
           {
               this.toggleTurn();
               //machinePlay();
               //this.toggleTurn();
               //print();
            }
            counter=machinePlay();
            this.toggleTurn();
            print();
              //             JOP.showMessageDialog(null,"hello");
            if(counter==NO_MOVE)
            {
                determineWinner();
                if(status==4)
                {
                 JOP.showMessageDialog(null,"O_WON", "Information", JOptionPane.INFORMATION_MESSAGE);
                }else
                {
                    JOP.showMessageDialog(null,"X_WON", "Information", JOptionPane.INFORMATION_MESSAGE);
                }
                //displayStatus(status);}
           }
            
        }
     }

    
    
    public static void main(String[] args)
    {
        GraphicalOthello GOT = new GraphicalOthello();
        
    }
 
    
}
