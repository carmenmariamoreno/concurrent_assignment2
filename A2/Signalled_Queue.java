package concurrent_assignment2.A2;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Use the synchronized keyword and signals so that
 * you do not need to busy wait.
 * But of course you still need your variable to know
 * whose's turn it is.
 *
 */
 
class Signalled_Queue implements Queue{
	int n=0;
        boolean readersTurn=false;
	
	
        @Override
	public synchronized void read() {
            /*while(!readersTurn){
                try {
                wait();
                } catch (InterruptedException ex) {
                Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
                }
                }*/
            
            if(!readersTurn){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.out.println("Reading: "+n);
            readersTurn=false;
            notify();
	}

	@Override
	public synchronized void write(int x) {
            /*while(readersTurn){
                try {
                wait();
                } catch (InterruptedException ex) {
                Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
                }
                }*/
            
            if(readersTurn){
                try {
                    wait();
                } catch (InterruptedException ex) {
                    Logger.getLogger(Signalled_Queue.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            n=x;
            System.out.println("Writting "+n);
            readersTurn=true;
            notify();
            
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
}


