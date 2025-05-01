package fca;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import java.util.List;
import javax.swing.*;
public class fca{
    boolean w=true;
    int car=0;
    List<fc> list3;
    
    DefaultListModel<fc> cards=new DefaultListModel<>();
    public fca(){
        //initiates gui
        JFrame frame=new JFrame();
        frame.setLayout(null);
        frame.setSize(600, 340);
        JList list=new JList(cards);
        JTextField wordfield=new JTextField();
        JTextField deffield=new JTextField();
        JLabel label1=new JLabel("word:");
        JLabel label2=new JLabel("definition:");
        JButton addbut=new JButton("Add");
        JButton removebut=new JButton("Remove");
        JButton studybut=new JButton("Study");
        list.setBounds(10,10,200,200);
        wordfield.setBounds(220,50,200,50);
        deffield.setBounds(220,120,200,50);
        label1.setBounds(300,10,200,50);
        label2.setBounds(290,80,200,50);
        addbut.setBounds(220,180,200,50);
        removebut.setBounds(10,220,200,80);
        
        studybut.setBounds(440,50,100,100);
        frame.add(studybut);
        frame.add(addbut);
        frame.add(list);
        frame.add(label1);
        frame.add(label2);
        frame.add(wordfield);
        frame.add(deffield);
        frame.add(removebut);
        frame.setVisible(true);

        addbut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //takes data from user and makes a card element
                cards.addElement(new fc(wordfield.getText(),deffield.getText()));
                
            }
        });
        removebut.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e){
                //removes card depending on what is selected
                int index = list.getSelectedIndex();
                cards.remove(index);
                
            }
        });
        studybut.addActionListener(new ActionListener(){
            @Override
            //creates second gui for cards
            public void actionPerformed(ActionEvent e){
                car=0;
                w=true;
                list3=new ArrayList<>();
                //shuffles cards
                for (int i = 0; i < cards.size(); i++) {
                    list3.add(cards.getElementAt(i));
                }
                Collections.shuffle(list3);

                cards.clear();
                for (fc element : list3) {
                    cards.addElement(element);
                }
                JFrame studyframe=new JFrame();
                JButton nextbut=new JButton("Next");
                JButton flipbut=new JButton("Flip");
                JLabel label2=new JLabel(cards.get(0).getWord());
                studyframe.setLayout(null);
                flipbut.setBounds(400,250,200,50);
                nextbut.setBounds(400,200,200,50);
                label2.setBounds(200,20,300,100);
                studyframe.setSize(600, 340);
                studyframe.add(nextbut);
                studyframe.add(label2);
                studyframe.add(flipbut);
                studyframe.setVisible(true);
                label2.setFont(new Font("null",Font.PLAIN,30));
                //flips cards to see definition
                flipbut.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        if (w==true) {
                            label2.setText(cards.get(car).getDefinition());
                            w=false;
                        }else{
                            label2.setText(cards.get(car).getWord());
                            w=true;
                        }
                        
                    }
                });
                //goes to next card
                nextbut.addActionListener(new ActionListener(){
                    @Override
                    public void actionPerformed(ActionEvent e){
                        car+=1;
                        if (car>cards.size()-1) {
                            studyframe.dispose();
                        }
                        else if (w==true) {
                            label2.setText(cards.get(car).getWord());
                            
                           
                        }else{
                            label2.setText(cards.get(car).getDefinition());
                            
                        }
                        
                    }
                });
            }
        });
        
    }
    
    public static void main(String[] args) {
        new fca();
    }
}
