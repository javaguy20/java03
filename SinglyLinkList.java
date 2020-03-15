package singlylinklist;

public class SinglyLinkList {
  private   Node head;
    private static int cnt;
    static class Node{
         Integer data;
          Node next;
        Node(Integer data){
            this.data=data;
            this.next=null;
        }
        @Override
        public String toString() {
            return "Node{" +
                    "data=" + data +
                    ", next=" + next +
                    '}';
        }
    }
    // add new node at the end
    public void insert(Integer data){
        Node newNode=new Node(data);
        Node current=head;
        // if there is no node then it will be the first node
        if (null==current){
            head=newNode;
            cnt++;
            return;
        }
        // need to check the null for current.next bcz it will be assigned to current  in line 35 and next will called on it at
        // line no 38
        while (current.next!=null){
            current=current.next;
        }
        // because newNode will be set at current.next location therefor current.next need to check  against null
        current.next=newNode;
        cnt++;
    }

    // print entire list
    public  void print(){
        Node current=head;
        // check if current is not null then print it and  move to the next
        while (current!=null){
            System.out.print("" + current.data + "->");
            current=current.next;
        }
        System.out.println("size is "+size());
    }
    // find a given node at given index
    public  Node findAtIndex(int i) throws InvalidIndexException{
        if (i>size() || i==0 ||i<0){
            throw new InvalidIndexException(i+" is Invalid index");
        }
        int counter=1;
        Node current=head;
        while (current!=null){
            if (counter==i){
                    return current;
            }
            current=current.next;
            counter++;
        }
        return null;
    }

    // remove node at given index
    public  Boolean removeNodeAtGivenIndex(int index ) throws InvalidIndexException{
        if (index==1){

        }
        else if (index>1 && index<size() ) {
            Node targetNode = findAtIndex(index);
            Node preNode = findAtIndex(index - 1);
            Node nextNode = findAtIndex(index + 1);
        }else if (index==size()){

        }else
        throw  new InvalidIndexException("Invalid index");
        return null;
      /*  Node current=head;
        int nodeNumber=0;
        if (index<=cnt) {
            while (null != current) {
                current = current.next;
                nodeNumber++;
            }
            return null;
        }else
            throw new InvalidIndexException("given index is invalid !!!");*/
    }

    public int size(){
        return cnt;
    }
    public static void main(String[] args) {
        SinglyLinkList list=new SinglyLinkList();
        list.insert(81);
        list.insert(25);
        list.insert(33);
        list.insert(41);
        list.print();
        Node n1= null;
        try {
            n1 = list.findAtIndex(0);
        } catch (InvalidIndexException e) {
            System.out.println(e.getMessage());
            return;
        }
        System.out.println(n1.data);
    }

}

