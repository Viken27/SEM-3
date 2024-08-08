import java.util.*;
class QueueCirc{
    int f;
    int r;
    int size;
    int array[];

    public QueueCirc(int size){
      this.r=-1;
      this.f=-1;
      this.size=size;
      this.array=new int[size];
    }
    public void cirEnqueue(int x){
      if(f== r+1 || (r >= size && f == -1)){
        System.out.println(" Queue underflow !");
        return;
      }
      r=(r+1)%size;
      array[r]=x;
      if(f==-1){
        f=0;
      }
    }
    public void display(){
        if(f==-1){
            System.out.println("queue overflow!");
            return;
        }
        for(int i = f;i!=r;i=(i+1)%size){
           System.out.println(array[i]+",");
        }
        System.out.println(array[r]);
    }
    public int cirDequeue(){
       if(f == -1){
        System.out.println("Queue overflow!");
        return 1;
       }
       int y=array[f];
       if(f==r){
        f=-1;
        r=-1; 
        return 0;
       }
       if(f==size-1){
        f=0;
       }
        else{
            f++;
        }       
        return y;
    }
}
public class Lab_9_51 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter size");
        int size=sc.nextInt();
        QueueCirc q1=new QueueCirc(size);
        q1.cirEnqueue(10);
        q1.cirEnqueue(20);
        q1.cirEnqueue(30);
        q1.cirEnqueue(40);
        q1.display();
        System.out.println("DeQueued!");
        q1.cirDequeue();
        q1.display();   

    }
}
