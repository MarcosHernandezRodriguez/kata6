/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import static java.util.stream.DoubleStream.builder;
import static java.util.stream.IntStream.builder;
import static java.util.stream.LongStream.builder;
import static javafx.scene.input.KeyCode.T;
import pa6.model.Histogram;
import pa6.model.Mail;
import pa6.view.HistogramDisplay;
import pa6.view.HistogramBuilder;
import pa6.view.MailListReader;

/**
 *
 * @author Marcos
 */
public class Kata6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException, Exception {
        Kata6 histo = new Kata6();
        histo.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    private HistogramBuilder<Mail> builder;
    private Histogram<String> domains;
    private Histogram<Character> letters;
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "C:\\Users\\Marcos\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
        mailList = MailListReader.read(filename);
        builder = new HistogramBuilder<Mail>(mailList);
    }
    
    private void process(){
        domains = builder.build(new Attribute<Mail, String>() {
        @Override
        public String get(Mail item) {
            return item.getMail().split("@")[1];
        }
    });
        
    letters = builder.build(new Attribute<Mail, Character>() {
        @Override
        public Character get(Mail item) {
            return item.getMail().charAt(0);
        }
    });
    }
    
    private void output(){
        new HistogramDisplay(domains, "Dominios").execute();
        new HistogramDisplay (letters,"Primer Caracter").execute();
        histoDisplay.execute();
    }
}