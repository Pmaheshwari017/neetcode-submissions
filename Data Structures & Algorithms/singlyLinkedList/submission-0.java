
class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
    }
}

class LinkedList {

    private ListNode head;
    private ListNode tail;
    private int size;

    public LinkedList() {
        head = null;
        tail = null;
        size = 0;
    }

    public int get(int index) {
        if (index < 0 || index >= size)
            return -1;

        ListNode curr = head;

        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }

        return curr.val;
    }

    public void insertHead(int val) {
        ListNode node = new ListNode(val);

        node.next = head;
        head = node;

        if (size == 0)
            tail = node;

        size++;
    }

    public void insertTail(int val) {
        ListNode node = new ListNode(val);

        if (size == 0) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = node;
        }

        size++;
    }

    public boolean remove(int index) {
        if (index < 0 || index >= size)
            return false;

        if (index == 0) {
            head = head.next;

            if (size == 1)
                tail = null;

            size--;
            return true;
        }

        ListNode curr = head;

        for (int i = 0; i < index - 1; i++) {
            curr = curr.next;
        }

        if (curr.next == tail)
            tail = curr;

        curr.next = curr.next.next;
        size--;

        return true;
    }

    public ArrayList<Integer> getValues() {
        ArrayList<Integer> ans = new ArrayList<>();

        ListNode curr = head;

        while (curr != null) {
            ans.add(curr.val);
            curr = curr.next;
        }

        return ans;
    }
}