package v1;

import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable{

    private BlockingQueue<Message> queue;

    public Consumer(BlockingQueue<Message> q){
        this.queue=q;
    }

    public void run() {
        try{
            Message msg;
            //consuming messages until exit message is received
            while((msg = queue.take()).getText() !="exit"){
                Thread.sleep(20000);
                System.out.println(" consuming :"+msg.getText()+"      queueSize:" + queue.size()+" remainingCapacity:"+queue.remainingCapacity());
            }
        }catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}