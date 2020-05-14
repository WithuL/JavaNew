package Java_0514;

public class BinarySearchTree {
    static class Node{
        public int key;
        public int value;
        public Node left;
        public Node right;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root = null;

    //查找操作
    public Node find(int key) {
        //先让cur指向根结点
        Node cur = root;
        //开始循环  当cur指向空时就跳出
        while(cur != null) {
            //如果比较值小于节点值则向节点的左子树寻找
            if(key < cur.key) {
                cur = cur.left;
            //如果比较值大于节点值则向节点的右子树寻找
            }else if (key > cur.key) {
                cur = cur.right;
            //走到这里就说明val == cur.key
            }else{
                return cur;
            }
        }
        //运行到这里时就说明没有找到相关值，则返回空
        return null;
    }

    //插入操作
    //进行插入操作时，需要查找到待插入位置，并且记录此此节点的父结点
    public Node insert(int key,int value) {
        //如果当前树是空树，那么就让root指向新的节点
        if(root == null) {
            root = new Node(key,value);
            return root;
        }
        //此时利用cur找到应插入的位置
        //利用prev记录cur的父结点
        Node cur = root ;
        Node prev = null;
        //开始寻找应插入的位置
        while(cur != null) {
            //如果将插入的值小于当前节点的值，则向当前节点的左节点寻找
            if(key < cur.key) {
                prev = cur;
                cur = cur.left;
                //如果将插入的值大于当前节点的值，则向当前节点的右节点寻找
            }else if( key > cur.key) {
                prev = cur;
                cur = cur.right;
            }else {
                //找到了key相同的元素
                //此时处理情况有很多种
                //可以直接使插入失败
                //也可以把当前节点的value改成新的value
                cur.value = value;
                return cur;
            }
        }
        //当循环结束时，cur 就为 null了
        //经过上面的查找一定能找到合适的位置
        //要把新节点插到prev的下面
        Node newNode = new Node(key,value);
        if(newNode.value < prev.value) {
            prev.left = newNode;
        }else {
            prev.right = newNode;
        }
        return newNode;
    }

    public void remove(int key) {
        //先找到要删除的节点，同时记录该节点的父结点位置
        Node cur = root;
        Node parent = null;
        while(cur != null) {
            //跟上面相同的操作
            if(key < cur.key) {
                parent = cur;
                cur = cur.left;
            }else if( key > cur.key) {
                parent = cur;
                cur = cur.right;
            }else{
                //走到这里代表已经找到要删除的位置，进入辅助方法
                removeNode(cur,parent);
                return;
            }
        }
        return ;
    }

    private void removeNode(Node cur, Node parent) {
        //搜索树的删除操作需要考虑的要素较多
        //1.要删除的节点没有左子树
        //2.要删除的节点没有右子树
        //3.要删的节点左右子树都存在
        if(cur.left == null) {
            //如果要删除的节点没有左子树
            if(cur == root) {
                //如果要删除的节点为根结点
                //因为此时的根结点没有左子树
                cur = cur.right;
            }else if(cur == parent.left){
                //如果此时要删除的节点为父节点的左子树
                parent.left = cur.right;
            }else if(cur == parent.right) {
                //如果此时要删除的节点为父结点的右子树
                parent.right = cur.right;
            }
        }else if(cur.right == null) {
            //如果要删除的节点没有右子树
            if(cur == root) {
                cur = cur.left;
            }else if (cur == parent.left) {
                parent.left = cur.left;
            }else {
                parent.right = cur.left;
            }
        }else{
            //如果要删除的节点左右子树都存在
            //那么找到当前节点右子树的最左侧的节点
            //找到的节点之比当前节点的值大，而比当前节点右子树中其他节点的值窦骁
            Node scapeGoat = cur.right;
            Node scapeGoatParent = cur;
            //下面这个条件是判断寻找的节点存在左子树，如果不存在，则当前节点就是最左侧的节点
            while(scapeGoat.left != null){
                scapeGoatParent = scapeGoat;
                scapeGoat = scapeGoat.left;
            }
            //将当前节点的key和value更新为scapeGoat的相关值
            cur.key = scapeGoat.key;
            cur.value = scapeGoat.value;
            //然后删除scapeGoat节点
            if(scapeGoat == scapeGoatParent.left) {
                scapeGoatParent.left = scapeGoat.right;
            }else{
                scapeGoatParent.right = scapeGoat.right;
            }
        }
    }
}










