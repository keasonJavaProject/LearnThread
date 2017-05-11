package gy.thread.producer.consumer;

class Salesman implements Runnable {
    Iphone iphone;  
    Salesman(Iphone iphone) {  
        this.iphone = iphone;  
    }  
    @Override  
    public void run() {  
        for (int i=0;i<10;i++) {  
            this.iphone.getName(i+1);  
            try {  
                Thread.sleep(1000);  
            } catch (InterruptedException e) {  
                e.printStackTrace();  
            }  
        }  
    }  
      
}  