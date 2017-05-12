package gy.java.thread.producer.consumer;

class Producer implements Runnable {
    Iphone iphone ;  
      
    public Producer(Iphone iphone) {  
        this.iphone = iphone;  
    }  
      
    @Override  
    public void run() {  
        for (int i=0;i<10;i++) {  
            try {  
                this.iphone.setName(i+1);  
                Thread.sleep(500);  
            } catch (InterruptedException e) {  
                // TODO Auto-generated catch block  
                e.printStackTrace();  
            }  
        }  
    }  
      
}  