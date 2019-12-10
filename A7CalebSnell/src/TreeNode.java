// TreeNode class
// Written by Chris Dufour for COS 225

import com.sun.source.tree.Tree;

public class TreeNode<T> {
    private T element;
    private TreeNode<T> left;
    private TreeNode<T> right;

    //-----CONSTRUCTORS-----//
    public TreeNode(T element) {
        this.element = element;
    }

    public TreeNode() {
        this.element = null;
    }

    //------ACCESSORS------//
    public T getElement() {
        return element;
    }

    public TreeNode<T> getLeft() {
        return left;
    }

    public TreeNode<T> getRight() {
        return right;
    }

    public boolean isLeaf() {
        return this.getLeft() == null && this.getRight() == null;
    }

    public int height() {
        if (this.isLeaf()) {
            return 0;
        } else if (this.getLeft() != null && this.getRight() == null) {
            return this.getLeft().height() + 1;
        } else if (this.getLeft() == null && this.getRight() != null) {
            return this.getRight().height() + 1;
        } else {
            return Math.max(this.getLeft().height(), this.getRight().height()) + 1;
        }
    }

    public String morse2char(TreeNode<T> root, String morseCode) {

        TreeNode<T> tempNode = root;
        String tempString = "";


        // Catch when we've hit the end of the morse code
        if (height() == morseCode.length()) {
            tempString = tempString + getElement().toString();
        }

        // Recurse through until we hit the end of the morse code (see above)
        if (morseCode.charAt(height()) == 'o') {
            tempNode = tempNode.getLeft();
            morse2char(tempNode, morseCode);
        }
        else if (morseCode.charAt(height()) == '-') {
            tempNode = tempNode.getRight();
            morse2char(tempNode, morseCode);
        }
        // Print invalid morse code if invalid morse code character
        else{
            System.out.println("Invalid morse code");
        }

        // should only hit this if we fail out of the recursion
        // above with invalid morse data
        return null;
    }

    public String string2morse(TreeNode<T>, string )

    //-----MODIFIERS-----//
    public void setLeft(TreeNode<T> t) {
        left = t;
    }

    public void setRight(TreeNode<T> t) {
        right = t;
    }

    public void insert(T element) {
        TreeNode<T> insertTarget = new TreeNode<T>(element);

        if (height() == 0) {
            this.setLeft(insertTarget);
        } else {
            if (this.getLeft() == null) {
                this.setLeft(insertTarget);
            } else if (this.getRight() == null) {
                this.setRight(insertTarget);
            } else {
                if (this.getLeft().height() <= this.getRight().height()) {
                    this.getLeft().insert(element);
                } else if (this.getLeft().height() > this.getRight().height()) {
                    this.getRight().insert(element);
                }
            }
        }
    }

    public void insertLeft(T element) {
        if (this.getLeft() == null) {
            this.setLeft(new TreeNode<T>(element));
        } else {
            System.out.println("Tried to insert a node overwriting an existing node on the left!");
        }
    }

    public void insertRight(T element) {
        if (this.getRight() == null) {
            this.setRight(new TreeNode<T>(element));
        } else {
            System.out.println("Tried to insert a node overwriting an existing node on the right!");
        }
    }

    //-------MISC-------//
    public void preorder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        System.out.println(node.getElement());
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(TreeNode<T> node) {
        if (node == null) {
            return;
        }
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getElement());
    }


}




