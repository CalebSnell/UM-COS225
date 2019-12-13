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

    public String morse2char(String morseCode) {
        //create temp node
        TreeNode<T> temp = this;

        // Loop through tree morseCode.length times
        for (int i = 0; i < morseCode.length(); i++) {

            // if 'o' get the left node
            if (morseCode.charAt(i) == 'o') {
                temp = temp.getLeft();
            }
            // if '-' get left node
            else {
                temp = temp.getRight();
            }
        }
        // Return current element once above loop is done
        return temp.getElement().toString();

    }

    public void char2morse(Character key, StringBuilder morseCode) {

        // Check for valid element
        if (this.getElement() != null) {
            // Check for if requested key is current element, print if so
            if (this.getElement().equals(key)) {
                System.out.print(morseCode + " | ");
            }
        }

        // Go left if not null, go right if null
        if (this.getLeft() != null) {
            morseCode.append("o");
            this.getLeft().char2morse(key, morseCode);
            morseCode.deleteCharAt(morseCode.length() - 1);
        }
        if (this.getRight() != null) {
            morseCode.append("-");
            this.getRight().char2morse(key, morseCode);
            morseCode.deleteCharAt(morseCode.length() - 1);
        }


    }

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
        //PRE: TreeNode object of generic type
        //POST: Prints element of each tree node in postorder
        // Drop out of recursion when we hit a leaf node
        if (node == null) {
            return;
        }
        // Print element only if contains valid data
        if (node.getElement() != null) {
            System.out.println(node.getElement());
        }
        // Recurse through tree
        preorder(node.getLeft());
        preorder(node.getRight());
    }

    public void postorder(TreeNode<T> node) {
        //PRE: TreeNode object of generic type
        //POST: Prints element of each tree node in postorder
        // Drop out of recursion when we hit a leaf node
        if (node == null) {
            return;
        }
        // Print element only if contains valid data
        if (node.getElement() != null) {
            System.out.println(node.getElement());
        }
        // Recurse through tree
        postorder(node.getLeft());
        postorder(node.getRight());
    }


}




