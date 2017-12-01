/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.main;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;
import pa6.model.Histogram;
import pa6.model.Mail;
import pa6.view.HistogramDisplay;
import pa6.view.MailHistogramBuilder;
import pa6.view.MailListReader;

/**
 *
 * @author Marcos
 */
public class Kata6 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws FileNotFoundException, IOException {
        // TODO code application logic here
        
        

        histoDisplay.execute();
    }
    
    private String filename;
    private List<Mail> mailList;
    private Histogram<String> histogram;
    private static HistogramDisplay histoDisplay;
    
    private void execute() throws Exception{
        input();
        process();
        output();
    }
    
    private void input() throws IOException{
        filename = "C:\\Users\\Marcos\\Documents\\NetBeansProjects\\Kata4\\src\\emails.txt";
        mailList = MailListReader.read(filename);
    }
    
    private void process() throws Exception{
        histogram = MailHistogramBuilder.build(mailList);
    }
    
    private void output(){
        histoDisplay = new HistogramDisplay(histogram);
    }
        
    
}
