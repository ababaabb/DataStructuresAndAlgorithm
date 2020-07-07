package main.java.com.linked;

public class MyLinked {

    class LinkedObject {
        LinkedObject next;
        String value;
        LinkedObject(){

        }
        LinkedObject(String value, LinkedObject next){
            this.value = value;
            this.next = next;
        }
    }

    LinkedObject first;
    LinkedObject last;

    public MyLinked(){
    }

    public MyLinked(String value){
        add(value);
    }

    private boolean addAll(MyLinked linked){
        return true;
    }

    /**
     * 添加节点
     * @param value
     * @return
     */
    public boolean add(String value){
        return addLast(value);
    }

    /**
     * 添加一个节点到链表的末尾
     * @param value
     * @return
     */
    private boolean addLast(String value){
        LinkedObject p = this.last;
        LinkedObject newNode = new LinkedObject(value,null);
        this.last = newNode;
        if(p == null){
            this.first = newNode;
        }else {
            p.next = newNode;
        }
        return true;
    }

    /**
     * 插入结点到指定位置
     * @param index
     * @param value
     * @return
     */
    public boolean insertNodeByIndex(int index, String value){
        if(index < 1 || index > length() + 1) {
            return false;
        }
        LinkedObject p = this.first;
        LinkedObject newNode = new LinkedObject(value,null);
        if(index == 1){
            newNode.next = p;
            this.first = newNode;
            return true;
        }
        int i = 1;
        while(p != null){
            if(i == index){
                newNode.next = p.next;
                p.next = newNode;
                return true;
            }
            p = p.next;
            i++;
        }
        return false;
    }

    /**
     * 删除指定位置的节点
     * @param index
     * @return
     */
    public boolean delNodeByIndex(int index){
        if(index < 1 || index > length()){
            return false;
        }
        if(index == 1){
            this.first = this.first.next;
            return true;
        }
        int i = 2;
        LinkedObject p = this.first;
        while(p != null){
            if(index == i++){
                p.next = p.next.next;
                return true;
            }
        }
        return false;
    }

    /**
     * 选择排序
     */
    public void selectSortNode(){
        if(length() < 2){
            return;
        }
        LinkedObject p1 = this.first;
        while(p1 != null){
            LinkedObject p2 = p1.next;
            while(p2 != null){
                if(p1.value.compareTo(p2.value) > 0){
                    String temp = p1.value;
                    p1.value = p2.value;
                    p2.value = temp;
                }
                p2 = p2.next;
            }
            p1 = p1.next;
        }
    }

    public void inserterSortNode(){
        if(length() < 2){
            return;
        }
        // 创建一个新链表，并将旧链表的第一个数据插入新链表中
        LinkedObject newFirst = new LinkedObject(this.first.value,null);
        // 创建新链表的移动指针并指向新链表的第一个元素
        newFirst = new LinkedObject(null,newFirst);
        LinkedObject newLinked = newFirst;
        // 创建旧链表的移动指针并指向第二个元素
        LinkedObject p = this.first;
        // 判断旧链表的移动指针指向的元素是否为空
        while (p != null){
            // 判断新链表的移动指针指向的元素是否为空
            while(newLinked.next != null){
                // 旧链表和新链表的移动指针所指向的元素进行大小判断
                if(p.value.compareTo(newLinked.next.value) > 1){
                    LinkedObject temp = newLinked.next;
                    LinkedObject newNode = new LinkedObject(p.value,null);
                    newLinked.next = newNode;
                    newNode.next = temp;
                    break;
                }
                newLinked = newLinked.next;
            }
            LinkedObject newNode = new LinkedObject(p.value,null);
            newLinked.next = newNode;
            p = p.next;
            newLinked = newFirst;
        }
        this.first = newFirst.next;
    }
    /**
     * 对链表进行插入排序，按从大到小的顺序，只要这里会写，那么手写用数组插入排序
     *    也是一样的。先要明白原理。什么是插入排序，这样才好写代码。
     *    插入排序：分两组，一组当成有序序列，一组当成无序，将无序组中的元素与有序组中的元素进行比较(如何比较，那么就要知道插入排序的原理是什么这里不过多阐述)
     *        这里我想到的方法是，构建一个空的链表当成有序序列，而原先的旧链表为无序序列，按照原理，一步步进行编码即可。
     *
     */
    public void insertSortNode(){
        //判断链表长度大于2，不然只有一个元素，就不用排序了。
        if(length()<2){
            System.out.println("无需排序");
            return;
        }
        //创建新链表
        LinkedObject temp = this.first;        //旧链表的移动指针
        LinkedObject newNode = new LinkedObject(temp.value,null);
        LinkedObject newHead = new LinkedObject(null,newNode);    //新链表的头结点
        LinkedObject newTemp = newHead;        //新链表的移动指针
        temp = temp.next;    //旧链表中指针移到下一位(第二个结点处)。
        while(temp != null){     //    遍历现有链表
            while(newTemp.next != null){
                //先跟新链表中的第一个结点进行比较,如果符合条件则添加到新链表，注意是在第一个位置上增加结点
                //如果不符合，则跟新链表中第二个结点进行比较，如果都不符合，跳出while，判断是否是到了新链表的最后一个结点，如果是则直接在新链表后面添加即可

                if(newTemp.next.value.compareTo(temp.value) > 0){
                    LinkedObject node = new LinkedObject(temp.value,null);
                    node.next = newTemp.next;
                    newTemp.next = node;
                    break;
                }
                newTemp = newTemp.next;
            }
            if(newTemp.next == null){//到达最末尾还没符合，那么说明该值是新链表中最小的数，直接添加即可到链表中即可
                //直接在新链表后面添加
                LinkedObject node = new LinkedObject(temp.value,null);
                newTemp.next = node;
            }
            //旧链表指针指向下一位结点，继续重复和新链表中的结点进行比较。
            temp = temp.next;
            //新链表中的移动指针需要复位，指向头结点
            newTemp = newHead;
        }
        //开始使用新链表，旧链表等待垃圾回收机制将其收回。
        this.first = newHead.next;
    }

    public int length(){
        int length = 0;
        LinkedObject temp = this.first;
        while(temp != null){
            temp = temp.next;
            length ++;
        }
        return length;
    }

    public String search(String value){
        if(value == null || this.first == null){
            return null;
        }
        LinkedObject temp = this.first;
        do{
            if(temp.value != null && temp.value.equals(value)){
                return temp.value;
            }
        }while(temp.next != null);
        return null;
    }

    public boolean isEnpty(){
        return this.first == null;
    }

    public void printList(){
        LinkedObject temp = this.first;
        while (temp != null){
            System.out.println(temp.value);
            temp = temp.next;
        }
    }

}
