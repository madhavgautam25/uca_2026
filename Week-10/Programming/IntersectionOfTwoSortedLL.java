class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class IntersectionOfTwoSortedLL {

    static Node intersection(Node head1, Node head2) {
        Node dummy = new Node(0);
        Node tail = dummy;

        while (head1 != null && head2 != null) {
            if (head1.data == head2.data) {
                tail.next = new Node(head1.data);
                tail = tail.next;
                head1 = head1.next;
                head2 = head2.next;
            } else if (head1.data < head2.data) {
                head1 = head1.next;
            } else {
                head2 = head2.next;
            }
        }

        return dummy.next;
    }

    static void printList(Node head) {
        while (head != null) {
            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" -> ");
            }

            head = head.next;
        }
    }

    public static void main(String[] args) {
        Node head1 = new Node(1);
        head1.next = new Node(2);
        head1.next.next = new Node(2);
        head1.next.next.next = new Node(3);
        head1.next.next.next.next = new Node(4);

        Node head2 = new Node(2);
        head2.next = new Node(2);
        head2.next.next = new Node(2);
        head2.next.next.next = new Node(4);

        Node result = intersection(head1, head2);

        printList(result);
    }
}