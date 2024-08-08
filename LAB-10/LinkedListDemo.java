class LinkedListDemo {

    class Node {

        int info;
        Node link;

        public Node(int info) {

            this.info = info;
            this.link = null;
        }
    }

    public Node first = null;

    public void insertAtFirst(int info) {

        Node newNode = new Node(info);

        newNode.link = first;
        first = newNode;
    }

    public void insertAtLast(int info) {

        Node newNode = new Node(info);

        if (first == null) {

            first = newNode;

            return;
        }

        Node save = first;

        while (save.link != null) {

            save = save.link;
        }

        save.link = newNode;
    }

    public void insertInOrder(int info) {

        Node newNode = new Node(info);

        if (first == null || newNode.info <= first.info) {

            newNode.link = first;
            first = newNode;

            return;
        }

        Node save = first;

        if (save.link != null && newNode.info >= save.link.info) {

            save = save.link;
        }

        newNode.link = save.link;
        save.link = newNode;
    }

    public void displayNode(LinkedListDemo l) {

        if (first == null) {

            System.out.println("Linked List Is  Empty");
        }

        Node save = l.first;

        while (save != null) {

            System.out.print(save.info);

            if (save.link != null) {

                System.out.print(" -> ");
            }

            save = save.link;
        }

        System.out.println();
    }

    public void deleteNode(int info) {

        if (first == null) {

            System.out.println("Linked List Is Empty");
            return;
        }

        if (first.info == info) {

            first = first.link;

            return;
        }

        Node save = first;

        while (save.link != null && save.link.info != info) {

            save = save.link;
        }

        if (save.link == null) {

            System.out.println("Node Not Found");
            return;
        }

        save.link = save.link.link;
    }

    public int countNode() {

        Node save = first;
        int count = 0;

        while (save != null) {

            save = save.link;
            count++;
        }

        if (count == 0) {

            return 0;
        } else {

            return count;
        }
    }

    public void copyLinkedList() {

        if (first == null) {

            System.out.println("Linked List Is Empty");
            return;
        }

        Node save = first;

        LinkedListDemo node = new LinkedListDemo();
        node.first = new Node(save.info);
        Node saveCopy = node.first;

        save = save.link;

        while (save != null) {

            saveCopy.link = new Node(save.info);
            // node.insertAtLast(save.info);
            saveCopy = saveCopy.link;
            save = save.link;
        }

        displayNode(node);
    }

    public void reverseLinkedList() {

        if (first == null) {

            System.out.println("Linked List Is Empty");
            return;
        }

        Node save = first;
        Node prev = null;
        Node next = null;

        while (save != null) {

            next = save.link;
            save.link = prev;
            prev = save;
            save = next;
        }

        first = prev;
    }

    public void sortLinkedList() {

        if (first == null) {

            System.out.println("Linked List Is Empty");
            return;
        }

        Node save = first;

        int n = countNode();

        for (int i = 0; i < n; i++) {

            while (save.link != null) {

                if (save.info >= save.link.info) {

                    int temp = save.info;

                    save.info = save.link.info;
                    save.link.info = temp;
                }

                save = save.link;
            }

            save = first;
        }

        displayNode(this);
    }

    public void checkEquality( LinkedListDemo l ){

        if( this.countNode() != l.countNode() ){

            System.out.println("Linked List Is Not Same");
            return;
        }
        
        Node save = this.first;
        Node save_l = l.first;

        while( save != null ){

            if( save.info != save_l.info ){

                System.out.println("Linked List Is Not Same");
                return;
            }

            save = save.link;
            save_l = save_l.link;
        }

        System.out.println("Both Linked List Is Same");
    }

    public void removeDuplicate(){

        if( first == null ){

            System.out.println("Linked List Is Empty");
            return;
        }

        Node save = first;
        Node temp = first;
        Node prev = first;

        while( temp != null ){

            prev = temp;
            save = temp.link;
            
            while(save != null ){

                if( temp.info == save.info ){
                    
                    prev.link = save.link;
                }
                else{

                    prev = save;
                }
                
                save = save.link;
            }

            temp = temp.link;
        }

        displayNode(this);
    }

    public void swapNode(int position){

        if(first == null){

            System.out.println("Linked List Is Empty");
            return;
        }

        if(position < 0 || position >= countNode()){

            System.out.println("Index Out Of Bound");
            return;
        }

        Node save = first;
        Node temp = null;
        Node temp2 = null;

        int count = 0;

        while (save != null) {
            
            if(count == position){

                temp = save;
            }
            else{

                if(count == countNode()-count+1){

                    temp2 = save;
                    break;
                }
            }
        }

        temp2.info = temp.info;
        temp.info = save.info;
    }
}