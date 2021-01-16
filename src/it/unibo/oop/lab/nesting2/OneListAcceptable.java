/**
 * 
 */
package it.unibo.oop.lab.nesting2;

import java.util.List;

/**
 * @author marti
 *
 */
public class OneListAcceptable<T> implements Acceptable<T> {

    List<T> sequence;
    int i;
    
    public OneListAcceptable(List<T> sequence) {
        this.sequence = sequence;
        if(sequence != null && !sequence.isEmpty()) {
            this.i = 0;
        }
    }

    @Override
    public Acceptor<T> acceptor() {
        return new Acceptor<T>() {

            @Override
            public void accept(T newElement) throws ElementNotAcceptedException {
                if(i < sequence.size() && sequence.get(i).equals(newElement)) {
                    i++;
                } else {
                    throw new ElementNotAcceptedException(newElement);
                }
            }

            @Override
            public void end() throws EndNotAcceptedException {
                if(i != sequence.size()) {
                    throw new EndNotAcceptedException();
                }
            }
        };
    }
}
