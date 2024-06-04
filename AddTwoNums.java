public class AddTwoNums {
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
    // private static AddTwoNums.Node ans;

    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
            return;
        }
        newNode.next = head;
        head.next = newNode;
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

    public static Node addTwoNumbers(Node l1, Node l2) {
        Node temp = new Node(0);
        int carry = 0;
        Node head = temp;
        while (l1 != null || l2 != null) {
            if (l1 != null) {
                carry += l1.data;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.data;
                l2 = l2.next;
            }
            temp.next = new Node(carry % 10);
            temp = temp.next;
            carry = carry / 10;
        }
        if (carry == 1) {
            temp.next = new Node(1);
        }
        return head.next;
    }

    public static void main(String[] args) {
        Node l1 = new Node(2);
        l1.next = new Node(4);
        l1.next.next = new Node(3);
        Node l2 = new Node(5);
        l2.next = new Node(6);
        l2.next.next = new Node(4);
        Node result = addTwoNumbers(l1, l2);
        while (result != null) {
            System.out.print(result.data + " ");
            result = result.next;
        }
        System.out.println();
    }
}
