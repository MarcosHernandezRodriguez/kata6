/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pa6.main;

/**
 *
 * @author Marcos
 */
public interface Attribute<T,S>{
    S get (T item);
}