public class LinkedList0s1s2sSort {
    public static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public static Node head;
    public static Node tail;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head = newNode;
    }

    public void addLast(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        tail.next = newNode;
        tail = newNode;
    }

    public void print() {
        if (head == null) {
            System.out.println("ll is empty.");
            return;
        }
        Node temp = head;
        while (temp != head) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node segregate(Node head) {
        Node ZeroHead = new Node(-1);
        Node zerotail = ZeroHead;
        Node oneHead = new Node(-1);
        Node onetail = oneHead;
        Node twoHead = new Node(-1);
        Node twoTail = twoHead;
        Node temp = head;
        while (temp != null) {
            Node nextNode = temp.next;
            if (temp.data == 0) {
                temp.next = null;
                zerotail.next = temp;
                zerotail = zerotail.next;
            } else if (temp.data == 1) {
                temp.next = null;
                onetail.next = temp;
                onetail = onetail.next;
            } else {
                temp.next = null;
                twoTail.next = temp;
                twoTail = twoTail.next;
            }
            temp = nextNode;
        }
        if (oneHead.next == null) {
            zerotail.next = twoHead.next;
        } else {
            zerotail.next = oneHead.next;
            onetail.next = twoHead.next;
        }
        oneHead.next = null;
        twoHead.next = null;
        Node t1 = ZeroHead;
        ZeroHead = ZeroHead.next;
        t1.next = null;
        return ZeroHead;
    }

    public static void main(String[] args) {
        Node ZeroHead = new Node(1);
        Node oneHead = new Node(2);
        Node twoHead = new Node(1);
        ZeroHead.next = oneHead;
        oneHead.next = new Node(2);
        oneHead.next.next = twoHead;
        twoHead.next = new Node(2);
        twoHead.next.next = new Node(0);
        twoHead.next.next.next = new Node(2);
        twoHead.next.next.next.next = new Node(2);
        twoHead.next.next.next.next.next = null;
        Node temp = segregate(ZeroHead);
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}
