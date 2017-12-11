/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.view;

import pa6.main.Attribute;
import java.util.List;
import pa6.model.Histogram;
import pa6.model.Mail;

/**
 *
 * @author Marcos
 * @param <T>
 */
public class HistogramBuilder<T> {
    // el objetivo de esta clase es construir a partir de una lista de emails un Histograma
    
    private final List <T> items;	
   
    
    public HistogramBuilder(List<T> items){
        this.items = items;
    }
    public <A>Histogram<A> build(Attribute<T,A> attribute){
        	Histogram<A> histo = new Histogram<>();
                for(T item : items){	
                    A value = attribute.get(item);	
                    histo.increment(value);
                }
        return histo;
    }
}