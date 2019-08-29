package sdu.edu.Structure;

public class RBTree{

    public RBNode root;

    public void insert_case1(RBNode node){
        if(node.parent == null){
            node.color = false;
        }else{
            insert_case2(node);
        }
    }

    public void insert_case2(RBNode node){
        if(node.parent.color == false){
            return;
        }else{
            insert_case3(node);
        }
    }

    public void insert_case3(RBNode node){
        if(uncle(node) != null && uncle(node).color == true){
            uncle(node).color = false;
            node.parent.color = false;
            grandparent(node).color = true;
            insert_case1(grandparent(node));
        }else{
            insert_case4(node);
        }
    }

    public void insert_case4(RBNode node){
        if(node == node.parent.right && grandparent(node).left == node.parent){
            leftRotate(node.parent);
            node = node.left;
        }else if(node == node.parent.left && grandparent(node).right == node.parent){
            rightRotate(node.parent);
            node = node.right;
        }
        insert_case5(node);
    }

    public void insert_case5(RBNode node){
        node.parent.color = false;
        grandparent(node).color = true;
        if(node == node.parent.left && grandparent(node).left == node.parent){
            rightRotate(grandparent(node));
        }else if(node == node.parent.right && grandparent(node).right == node.right){
            leftRotate(grandparent(node));
        }
    }

    private RBNode sibling(RBNode node){
        if(node == node.parent.left){
            return node.parent.right;
        }else{
            return node.parent.left;
        }
    }

    private void replace_node(RBNode r1,RBNode r2){
        r1.key = r2.key;
        if(r1.parent.left == r1){
            r1.parent.left = r2;
        }else{
            r1.parent.right = r2;
        }
        r2.parent = r1.parent;

    }

    public void delete_one_child(RBNode node){
        RBNode child = node.left == null?node.right:node.left;
        replace_node(node, child);
        if(node.color == false){
            if(child.color == true){
                child.color = false;
            }else{
                delete_case1(child);
            }
        }
    }

    public void delete_case1(RBNode node){
        if(node.parent != null){
            delete_case2(node);
        }
    }

    public void delete_case2(RBNode node){
        RBNode s = sibling(node);
        if(s.color == true){
            node.parent.color = true;
            s.color = false;
            if(node == node.parent.left){
                leftRotate(node.parent);
            }else{
                rightRotate(node.parent);
            }
        }
        delete_case3(node);
    }

    public void delete_case3(RBNode node){
        RBNode s = sibling(node);
        if(node.parent.color == false &&
        s.color == false &&
        s.left.color == false &&
        s.right.color == false){
            s.color = false;
            delete_case1(node.parent);
        }else{
            delete_case4(node);
        }
    }

    public void delete_case4(RBNode node){
        RBNode s = sibling(node);
        if(node.parent.color == true &&
        s.color == false &&
        s.left.color == false &&
        s.right.color == false){
            s.color = true;
            node.parent.color = false;
        }else{
            delete_case5(node);
        }
    }

    public void delete_case5(RBNode node){
        RBNode s = sibling(node);
        if(s.color == false){
            if(node == node.parent.left &&
            s.left.color == true &&
            s.right.color == false){
                s.left.color = false;
                s.color = true;
                rightRotate(s);
            }else if(node == node.parent.right &&
            s.color == false &&
            s.left.color == false &&
            s.right.color == true ){
                s.color = true;
                s.right.color = false;
                leftRotate(s);
            }
        }
        delete_case6(node);
    }

    public void delete_case6(RBNode node){
        RBNode s = sibling(node);
        s.color = node.parent.color;
        node.parent.color = false;
        if(node == node.parent.left){
            s.right.color = false;
            leftRotate(node.parent);
        }else{
            s.left.color = false;
            rightRotate(node.parent);
        }
    }





    /*
     * 左旋示意图：对节点x进行左旋
     *     p                       p
     *    /                       /
     *   x                       y
     *  / \                     / \
     * lx  y      ----->       x  ry
     *    / \                 / \
     *   ly ry               lx ly
     * 左旋做了三件事：
     * 1. 将y的左子节点赋给x的右子节点,并将x赋给y左子节点的父节点(y左子节点非空时)
     * 2. 将x的父节点p(非空时)赋给y的父节点，同时更新p的子节点为y(左或右)
     * 3. 将y的左子节点设为x，将x的父节点设为y
     */
    private void leftRotate(RBNode x){
        RBNode y = x.right;
        x.right = y.left;
        if(y.left != null){
            y.left.parent = x;
        }
        y.parent = x.parent;
        if(x.parent == null){
            this.root = y;
        }else{
            if(x == x.parent.left){
                x.parent.left = y;
            }else{
                x.parent.right = y;
            }
        }
        x.parent = y;
        y.left = x;
    }

    /*
     * 左旋示意图：对节点y进行右旋
     *        p                   p
     *       /                   /
     *      y                   x
     *     / \                 / \
     *    x  ry   ----->      lx  y
     *   / \                     / \
     * lx  rx                   rx ry
     * 右旋做了三件事：
     * 1. 将x的右子节点赋给y的左子节点,并将y赋给x右子节点的父节点(x右子节点非空时)
     * 2. 将y的父节点p(非空时)赋给x的父节点，同时更新p的子节点为x(左或右)
     * 3. 将x的右子节点设为y，将y的父节点设为x
     */
    private void rightRotate(RBNode y){
        RBNode x = y.left;
        y.left = x.right;
        if(x.right != null){
            x.right.parent = y;
        }
        x.parent = y.parent;
        if(y.parent == null){
            this.root = x;
        }else{
            if(y == y.parent.left){
                y.parent.left = x;
            }else{
                y.parent.right = x;
            }
        }
        x.right = y;
        y.parent = x;
    }

    private RBNode grandparent(RBNode node){
        return node.parent.parent;
    }

    private RBNode uncle(RBNode node){
        if(node.parent == grandparent(node).left){
            return grandparent(node).right;
        }else{
            return grandparent(node).left;
        }
    }

    class RBNode{
        //true为红，false为黑
        boolean color;
        Integer key;
        RBNode left;
        RBNode right;
        RBNode parent;
    }
}
