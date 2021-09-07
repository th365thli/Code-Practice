package Utilities;

public class Semaphore {
  
  int capacity = 0;
  int permits = 0;
  
  
  public Semaphore(int capacity) {
   this.capacity = capacity;
    
  }
    
    
  public synchronized void acquire() throws InterruptedException {
      
    while (permits == capacity) {
        wait(); 
    }
    
    permits++;
    
    notifyAll();
      
    
  }
  
  public synchronized void release() throws InterruptedException {
    
    while (permits == 0) {
      wait();
    }
    
    permits--;
    
    notifyAll();
  }
  
  
  
  
  
  public static void main(String[] args) throws InterruptedException {
    Semaphore sem = new Semaphore(1);
    
    Thread t = new Thread(new Runnable() {
      
      public void run() {
        try {
          sem.acquire(); 
          System.out.println("Thread 1 has the semaphore!");
          Thread.sleep(1000);
          sem.release();
          System.out.println("Thread 1 released the semaphore!");
        } catch (InterruptedException e) {
         //do something 
        }
      }
      
      
    });
    
     Thread t2 = new Thread(new Runnable() {
      
      public void run() {
        try {
          sem.acquire(); 
          System.out.println("Thread 2 has the semaphore!");
          Thread.sleep(1000);
          sem.release();
          System.out.println("Thread 2 released the semaphore!");
        } catch (InterruptedException e) {
          //do something 
        }
      }
      
      
    });
    
    
    t.start();
    t2.start();
    
    t.join();
    t2.join();
  

  }
}
