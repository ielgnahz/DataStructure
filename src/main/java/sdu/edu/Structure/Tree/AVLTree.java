package sdu.edu.Structure.Tree;

public class AVLTree {
    class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;
        int height;
        public TreeNode(int val,TreeNode left,TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
            this.height = 0;
        }
    }

    public TreeNode LeftLeftRotation(TreeNode k2){
        TreeNode k1;
        k1 = k2.left;
        k2.left = k1.right;
        k2.right = k2;

        k1.height = Math.max(height(k1.left), height(k1.right))+1;
        k2.height = Math.max(height(k2.left), height(k2.right))+1;
        return k1;
    }

    public TreeNode RightRightRotation(TreeNode k2){
        TreeNode k1;
        k1 = k2.right;
        k1.right = k2.left;
        k2.left = k1;

        k1.height = Math.max(height(k1.left), height(k1.right))+1;
        k2.height = Math.max(height(k2.left), height(k2.right))+1;
        return k1;
    }

    public TreeNode LeftRightRotation(TreeNode k2){
        k2.left = LeftLeftRotation(k2.left);

        return RightRightRotation(k2);
    }

    public TreeNode RightLeftRotation(TreeNode k2){
        k2.right = RightRightRotation(k2.right);

        return LeftLeftRotation(k2);
    }

    public TreeNode insert(TreeNode tree,int key){
        if(tree == null){
            tree = new TreeNode(key, null, null);
        }else{
            int cmp = key - tree.val;
            if(cmp < 0){
                tree.left = insert(tree.left, key);
                if(height(tree.left) - height(tree.right) == 2){
                    if(key < tree.left.val){
                        tree = LeftLeftRotation(tree);
                    }else{
                        tree = LeftRightRotation(tree);
                    }
                }
            }else if(cmp > 0){
                tree.right = insert(tree.right, key);
                if(height(tree.right) - height(tree.left) == 2){
                    if(key < tree.right.val){
                        tree = RightLeftRotation(tree);
                    }else{
                        tree = RightRightRotation(tree);
                    }
                }
            }else{
                System.out.println("不允许添加相同的节点");
            }
        }
        tree.height = Math.max(height(tree.left), height(tree.right));
        return tree;
    }

    public TreeNode remove(TreeNode tree,TreeNode z){
        if(tree == null || z == null){
            return null;
        }
        if(tree.val > z.val){
            tree.left = remove(tree.left, z);
            if(height(tree.right) - height(tree.left) == 2){
                TreeNode right = tree.right;
                if(height(right.left) > height(right.right)){
                    tree = RightLeftRotation(tree);
                }else{
                    tree = RightRightRotation(tree);
                }
            }
        }else if(tree.val < z.val){
            tree.right = remove(tree.right, z);
            if(height(tree.left) - height(tree.right) == 2){
                TreeNode left = tree.left;
                if(height(left.left) > height(left.right)){
                    tree = LeftLeftRotation(tree);
                }else{
                    tree = LeftRightRotation(tree);
                }
            }
        }else{
            if(tree.left != null && tree.right != null){
                if(height(tree.left) > height(tree.right)){
                    TreeNode max = LeftMax(tree.left);
                    tree.val = max.val;
                    tree.left = remove(tree.left, max);
                }else{
                    TreeNode min = RightMin(tree.right);
                    tree.val = min.val;
                    tree.right = remove(tree.right, min);
                }
            }else{
                tree = tree.left!= null?tree.left:tree.right;
            }
        }
        return tree;
    }

    public TreeNode LeftMax(TreeNode tree){
        while(tree.right != null){
            tree = tree.right;
        }
        return tree;
    }

    public TreeNode RightMin(TreeNode tree){
        while(tree.left != null){
            tree = tree.left;
        }
        return tree;
    }

    public int height(TreeNode node){
        if(node != null){
            return node.height;
        }
        return 0;
    }

}
