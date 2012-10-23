/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package BBK.PiJ01.linkedLists.elements;

/**
 *
 * @author Sam Wright <swrigh11@dcs.bbk.ac.uk>
 */
public interface ContainerInterface<T> extends ElementInterface {
    void setObject(T obj);
    T getObject();
}
