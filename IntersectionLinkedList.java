public class IntersectionLinkedList {
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
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static Node getIntersectNode(Node head1, Node head2) {
        Node curr = head1;
        int a = 0;
        int b = 0;
        while (curr != null) {
            a++;
            curr = curr.next;
        }
        curr = head2;
        while (curr != null) {
            b++;
            curr = curr.next;
        }
        int diff = Math.abs(a - b);

        if (a < b) {
            while (diff-- > 0) {
                head2 = head2.next;
            }
        } else {
            while (diff-- > 0) {
                head1 = head1.next;
            }
        }
        while (head1 != null && head2 != null) {
            if (head1 == head2) {
                return head1;
            }
            head1 = head1.next;
            head2 = head2.next;
        }
        return null;
    }

    public static void main(String[] args) {
        Node head1 = new Node(4);
        head1.next = new Node(1);
        head1.next.next = new Node(8);
        head1.next.next.next = new Node(4);
        head1.next.next.next.next = new Node(5);
        Node head2 = new Node(5);
        head2.next = new Node(6);
        head2.next.next = new Node(1);
        head2.next.next.next = head1.next.next;
        Node result = getIntersectNode(head1, head2);
        if(result != null) {
            System.out.println(result.data);
        } else {
            System.out.println("No intersecion");
        }
    }
}