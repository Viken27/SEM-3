class StackImplement {

    class Node {

        int info;
        Node link;

        public Node(int info) {

            this.info = info;
            this.link = null;
        }
    }

    public Node first = null;

    public void push(int info) {

        Node newNode = new Node(info);

        newNode.link = first;
        first = newNode;
    }

    public void pop(int info) {

        if (first == null) {

            System.out.println("\nStack Is Empty");
            return;
        }

        int popData = first.info;
        first = first.link;

        System.out.println("Poped Element :> " + popData);

        System.out.println("After Poped Element :-> ");
        displayStack();
    }

    public int countStack() {

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

    public void peep(int position) {

        int top = countStack();

        System.out.println("Top Is :-> " + top);

        if (first == null || position <= 0 || position > top) {

            System.out.println("Stack Underflow ");
            return;
        }

        Node save = first;

        for (int i = 1; i < position; i++) {

            save = save.link;
        }

        System.out.println("Element From Top Is :-> " + save.info);
    }

    public void change(int position, int info) {

        int top = countStack();

        System.out.println("Top Is :-> " + top);

        if (first == null || position <= 0 || position > top) {

            System.out.println("Stack Underflow ");
            return;
        }

        Node save = first;

        for (int i = 1; i < position; i++) {

            save = save.link;
        }

        save.info = info;

        System.out.println("Changed Element From Top Is :-> " + save.info);

        displayStack();
    }

    public void displayStack() {

        if (first == null) {

            System.out.println("Stack Is  Empty");
            return;
        }

        Node save = first;

        System.out.print("Stack = [\n");

        while (save != null) {

            System.out.println(save.info);

            save = save.link;
        }

        System.out.println("]");
    }
}