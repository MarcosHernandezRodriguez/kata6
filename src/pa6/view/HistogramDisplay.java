  /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.view;

import static com.sun.glass.ui.Cursor.setVisible;
import java.awt.Dimension;
import javax.swing.JPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.ui.ApplicationFrame;

import pa6.model.Histogram;

/**
 *
 * @author Marcos
 * @param <T>
 */
public final class HistogramDisplay <T> extends ApplicationFrame{
    
    private final Histogram<T> histogram;
    private final String nameEjeX;
    
    public  HistogramDisplay(Histogram<T> histogram, String nameEjeX){
        super("Histograma");
        this.histogram = histogram;
        this.nameEjeX = nameEjeX;
        setContentPane(createPanel());
        pack();
    }
    
    public void execute(){
        setVisible(true);
    }
    
    public JPanel createPanel(){
        ChartPanel chartpanel = new ChartPanel(createChart(createDataset()));
        chartpanel.setPreferredSize(new Dimension(500, 400));
        return chartpanel;
    }
    
    private JFreeChart createChart(DefaultCategoryDataset dataSet){
        JFreeChart chart = ChartFactory.createBarChart(
                "Histograma de emails", 
                "dominios email", 
                "nº de emails recibidos", 
                dataSet, 
                PlotOrientation.VERTICAL,
                false,
                rootPaneCheckingEnabled,
                rootPaneCheckingEnabled);
        return chart;
    }
    
    private DefaultCategoryDataset createDataset(){
        DefaultCategoryDataset dataSet = new DefaultCategoryDataset();
        
        for(T key : histogram.keySet()){
            dataSet.addValue(histogram.get(key), "", (Comparable) key);
        }
        return dataSet;
    }    
}