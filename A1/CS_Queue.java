package concurrent_assignment2.A1;

import concurrent_assignment2.A_intro.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;

/**Use condition synchronization by means of busy wait.
 * 
 * What kind of variable do you need to implement busy
 * wait synchronization?
 * 
 * Set a meaningful name for such variable.
 * */
 
class CS_Queue implements Queue{
	volatile int n=0;
	volatile boolean reading=false; 
        
	@Override
	public void read() {
         
                // TODO Auto-generated method stub
                while(reading==false);
                
                System.out.println("Reading: "+n);
                
                reading=false;
                
	}

	@Override
	public void write(int x) {
         
                // TODO Auto-generated method stub
                while(reading==true);
                
                n=x;
                System.out.println("Writting: "+n);
                reading=true;
                
	}

	@Override
	public void read(int ID) {
		// no need to implement this
		
	}
	
	
	
	
}


