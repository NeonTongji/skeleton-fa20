public class SLList{
    public class IntNode {
        public int item;
        public IntNode next;

        public IntNode(int item, IntNode next) {
            this.item = item;
            this.next = next;
        }
    }
    private IntNode first;

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public void insert(int item, int position){
        IntNode p = first;
        int pos = 1;

        if(position == 0 || first == null){
            addFirst(item);
            return;
        }

        while (pos < position && p != null){
            p = p.next;
            pos ++;
        }
        IntNode newNode = new IntNode(item, p.next);
        p.next = newNode;
    }

    public void removeItem(int x){
        first = removeItemHelper(x, first);
    }

    private IntNode removeItemHelper(int x, IntNode current){
        if (current == null){
            return current;
        }
        else if(current.item == x){
            return removeItemHelper(x, current.next);
        }
        else {
            current.next = removeItemHelper(x, current.next);
            return current;
        }
    }

    public void reverse(){
//        IntNode reversed = null;
//        while (first != null){
//           reversed = new IntNode(first.item, reversed);
//           first = first.next;
//       }
        IntNode ptr = first.next;
        first.next = null;
        while (ptr != null){
            IntNode temp = ptr.next;
            ptr.next = first;
            first = ptr;
            ptr = temp;
        }
    }

    public static void evenodd(IntNode lst){
        if(lst == null || lst.next == null || lst.next.next ==null){
            return;
        }
        IntNode second = lst.next;
        int index = 0;
//        while (!(index % 2 == 0 && (lst.next == null || lst.next.next == null))){
//            IntNode temp = lst.next;
//            lst.next = lst.next.next;
//            lst = temp;
//            index ++;
//        }
//        lst.next = second;


        IntNode even = lst;
        IntNode odd = lst.next;
        while (!(index % 2 == 0 && (even.next == null || even.next.next == null ))){
            even.next = even.next.next;
            even = even.next;
            odd.next = odd.next.next;
            odd = odd.next;
            index ++;
        }
        even.next = second;
    }

    public static void main(String[] args){
        SLList s = new SLList();
        s.addFirst(5);
        s.addFirst(2);
        s.addFirst(4);
        s.addFirst(1);
        s.addFirst(3);
        s.addFirst(0);
        evenodd(s.first);
        IntNode ptr = s.first;
        while (ptr != null) {
            System.out.println(ptr.item);
            ptr = ptr.next;
        }
    }


}
