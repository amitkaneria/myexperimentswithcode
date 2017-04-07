package v1;

import java.util.concurrent.BlockingQueue;

public class Producer implements Runnable {

    private BlockingQueue<Message> queue;

    public Producer(BlockingQueue<Message> q){
        this.queue=q;
    }

    public void run() {
        //produce messages
        for(int i=0; i<10; i++){
            Message msg = new Message(""+i);
            try {
                Thread.sleep(5000);
                queue.put(msg);
                System.out.println("producing :"+msg.getText()+"      queueSize:" + queue.size()+" remainingCapacity:"+queue.remainingCapacity());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //adding exit message
        Message msg = new Message("exit");
        try {
            queue.put(msg);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}