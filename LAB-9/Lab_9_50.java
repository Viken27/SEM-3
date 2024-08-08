import java.util.*;
class QueueDemo{
    int f;
    int r;
    int size;
    int array[];

    public QueueDemo(int size){
      this.r=-1;
      this.f=-1;
      this.size=size;
      this.array=new int[size];
    }
    public void enqueue(int x){
      if(f==-1 && r==-1){
        f=0;
        r=0;
        array[r]=x;
        return;
      }
      r++;
      array[r]=x;
    }
    public void display(){
        if(f==-1 && r==-1){
            System.out.println("Empty Queue!");
            return;
        }
        for(int i=f;i<=r;i++){
            System.out.println(array[i] +" ");
        }
       
    }
    public int dequeue(int x){
        if(f==-1 && r==-1){
            f=0;
            r=0;
            array[r]=x;
            return 1;
          }
          int y=f;
          f++;
          return y;
    }
}

public class Lab_9_50 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the size of the Queue:");
        int size=sc.nextInt();
        QueueDemo q1=new QueueDemo(size);
        q1.enqueue(10);
        q1.enqueue(20);
        q1.enqueue(30);
        q1.display();
        q1.dequeue(10);
        // q1.enqueue(40);
        // q1.enqueue(50);
        q1.display();
    }
}