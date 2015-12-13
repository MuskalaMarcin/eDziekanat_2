package edziekanat.applet;
 
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.*;
 
import javax.swing.*;
import javax.swing.GroupLayout.SequentialGroup;
import javax.swing.text.NumberFormatter;
 
import static javax.swing.GroupLayout.Alignment.*;
 
public class AppletMain extends JApplet implements ActionListener {
 
        private JLabel login, haslo;
        private JButton zaloguj, uzytkownicy, oceny, wykladowcy,
                        exit, sale, planZajec, przedmioty, sprBytowe, komunikacja,
                        wyszukiwarka;
        private JFormattedTextField loginWpis;
        private JPasswordField hasloWpis;
        private GroupLayout layout = new GroupLayout(getContentPane());
       
        public void init() {
 
                login = new JLabel("Login:");
                haslo = new JLabel("Has³o:");
 
                NumberFormat intFormat = NumberFormat.getIntegerInstance();
                NumberFormatter numberFormatter = new NumberFormatter(intFormat);
                numberFormatter.setValueClass(Integer.class);
                numberFormatter.setAllowsInvalid(false);
                numberFormatter.setMaximum(99999);
                loginWpis = new JFormattedTextField(numberFormatter);
                loginWpis.setMaximumSize(new Dimension(150, 24));
               
                hasloWpis = new JPasswordField();
                hasloWpis.addActionListener(this);
                hasloWpis.setMaximumSize(new Dimension(150, 24));
 
                zaloguj = new JButton("Zaloguj siê");
                exit = new JButton("Wyjœcie");
                zaloguj.addActionListener(this);
                exit.addActionListener(this);
               
                initMenu(0);
               
        }
 
       
 
        private void initMenu(int flaga) {     
               
                SequentialGroup wiersze = layout.createSequentialGroup();
                SequentialGroup kolumny = layout.createSequentialGroup();
               
                planZajec = new JButton("Plan zajêæ");
                przedmioty = new JButton("Przedmioty");
                sprBytowe = new JButton("Sprawy bytowe");
                komunikacja = new JButton("Wiadomoœci");
                wyszukiwarka = new JButton("Wyszukiwarka");
 
                przedmioty.addActionListener(this);
                sprBytowe.addActionListener(this);
                komunikacja.addActionListener(this);
                planZajec.addActionListener(this);     
               
                if(flaga == 0){
                       
                        getContentPane().setLayout(layout);
                        layout.setAutoCreateGaps(true);
                        layout.setAutoCreateContainerGaps(true);
 
                        layout.linkSize(SwingConstants.VERTICAL, login, loginWpis);
                        layout.linkSize(SwingConstants.VERTICAL, haslo, hasloWpis);
                        layout.linkSize(SwingConstants.HORIZONTAL, zaloguj, exit);
               
                        wiersze.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(login)
                                                .addComponent(haslo))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(loginWpis)
                                                .addComponent(hasloWpis)
                                                .addComponent(zaloguj)
                                                .addComponent(exit)
                        );     
                       
                        kolumny.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(login)
                                                .addComponent(loginWpis))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(haslo)
                                                .addComponent(hasloWpis))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(zaloguj))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                        .addComponent(exit)                    
                        );
                       
                       
                        layout.setHorizontalGroup(wiersze);
                        layout.setVerticalGroup(kolumny);
                        getContentPane().setLayout(layout);
                }
               
                else if(flaga == 1){
                       
                        login.setVisible(false);
                        loginWpis.setVisible(false);
                        haslo.setVisible(false);
                        hasloWpis.setVisible(false);
                        zaloguj.setVisible(false);
                       
                        wiersze.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty)
                                                .addComponent(planZajec)
                                                .addComponent(sprBytowe)
                                                .addComponent(komunikacja)
                                                .addComponent(exit)
                        );
                       
                        kolumny.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(planZajec))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(sprBytowe))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(komunikacja))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(exit)
                        );
                       
                        layout.linkSize(SwingConstants.HORIZONTAL, przedmioty, sprBytowe, planZajec, komunikacja, exit);
                        layout.setHorizontalGroup(wiersze);
                        layout.setVerticalGroup(kolumny);
                       
                }
               
                else if (flaga == 2){
                       
                        login.setVisible(false);
                        loginWpis.setVisible(false);
                        haslo.setVisible(false);
                        hasloWpis.setVisible(false);
                        zaloguj.setVisible(false);
                       
                        wiersze.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty)
                                                .addComponent(wyszukiwarka)
                                                .addComponent(komunikacja)
                                                .addComponent(exit)
                        );
                       
                        kolumny.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(wyszukiwarka))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(komunikacja))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(exit)
                        );
                       
                        layout.linkSize(SwingConstants.HORIZONTAL, przedmioty, wyszukiwarka, komunikacja, exit);
                        layout.setHorizontalGroup(wiersze);
                        layout.setVerticalGroup(kolumny);
                }
               
                else if (flaga == 3){
                       
                        login.setVisible(false);
                        loginWpis.setVisible(false);
                        haslo.setVisible(false);
                        hasloWpis.setVisible(false);
                        zaloguj.setVisible(false);
                       
                        wiersze.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty)
                                                .addComponent(wyszukiwarka)
                                                .addComponent(komunikacja)
                                                .addComponent(exit)
                        );
                       
                        kolumny.addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(przedmioty))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(wyszukiwarka))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(komunikacja))
                                        .addGroup(layout.createParallelGroup(LEADING)
                                                .addComponent(exit)
                        );
                       
                        layout.linkSize(SwingConstants.HORIZONTAL, przedmioty, wyszukiwarka, komunikacja, exit);
                        layout.setHorizontalGroup(wiersze);
                        layout.setVerticalGroup(kolumny);
                }
        }
 
       
       
       
        public void actionPerformed(ActionEvent e) {
 
                Object zrodlo = e.getSource();
 
                if (zrodlo == zaloguj) {
 
                        char[] password = hasloWpis.getPassword();
                       
                        /*
                         * Walidacja hasla
                         */
                        if(1>0){
                                initMenu(2);
                        }
                       
                }
 
 
                if (zrodlo == exit) {
                        System.exit(0);
                }
 
        }
}