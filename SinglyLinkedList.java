public class SinglyLinkedList {
    
    MyNode head;
    MyNode tail;

    public static void main(String[] args) {

        SinglyLinkedList myList = new SinglyLinkedList();
        
        myList.removeAll(2);
        myList.append(1);
        myList.append(2);
        myList.append(3);
        myList.append(20);
        myList.append(10);
        myList.removeAll(2);
        myList.append(5);
        myList.append(10);
        myList.append(10);
        myList.print();

    }
    SinglyLinkedList(){
        head = new MyNode(0);
        tail = head;
    }
    public void append(int val){
        MyNode node = new MyNode(val);
        tail.next = node;
        tail = tail.next;
    }
    public void remove(){
        if (head == tail) return;
        MyNode curr = head;
        while (curr.next!=tail){
            curr = curr.next;
        }
        curr.next = null;
        tail = curr;
    }
    public void removeAll(int target){
        MyNode curr = head.next,  next;
        tail = head;
        while (curr!=null){
            //remove the node with value > target value
            if (curr.value > target){
                next = curr.next;
                curr.next = null;
                curr = next;
            }
            else{
                tail.next = curr;
                tail = curr;
                curr = curr.next;
            }
        }
        tail.next = null;
    }
    public void print(){
        MyNode curr = head.next;
        while (curr!=null){
            System.out.print(curr.value + "  >>  ");
            curr = curr.next;        
        }
        System.out.println("  end");
    }
}

class MyNode{
    int value;
    MyNode next;
    MyNode(int value){
        this.value = value;
        this.next = null;
    }
}