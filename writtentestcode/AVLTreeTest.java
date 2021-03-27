import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
public class AVLTreeTest {
    AVLTree tree1;
    AVLTree tree2;
    AVLTree tree3;
    AVLTree tree4;
    AVLTree tree5;

    @Before
    public void init(){
        this.tree1 = new AVLTree();
        this.tree2 = new AVLTree();
        this.tree3 = new AVLTree();
        this.tree4 = new AVLTree();
        this.tree5 = new AVLTree();

        this.tree1.insert(3);
        this.tree1.insert(4);
        this.tree1.insert(1);
        this.tree1.insert(2);

        this.tree2.insert(1);
        this.tree2.insert(2);
        this.tree2.insert(3);
        this.tree2.insert(4);
        this.tree2.insert(5);

        this.tree3.insert(3);
        this.tree3.insert(6);
        this.tree3.insert(8);
        this.tree3.insert(4);
        this.tree3.insert(2);
        this.tree3.insert(1);

        this.tree4.insert(10);
        this.tree4.insert(8);
        this.tree4.insert(7);
        this.tree4.insert(12);
        this.tree4.insert(5);

        this.tree5.insert(10);
        this.tree5.insert(15);
        this.tree5.insert(5);
        this.tree5.insert(18);
        this.tree5.insert(20);
        this.tree5.insert(3);
        this.tree5.insert(7);


    }

    @Test
    public void testTree1() { assertTrue(this.tree1.isBalanced(this.tree1.root)); }

    @Test
    public void testTree2() {
        assertFalse(this.tree2.isBalanced(this.tree2.root));
    }

    @Test
    public void testTree3() {
        assertTrue(this.tree3.isBalanced(this.tree3.root));
    }

    @Test
    public void testTree4() {
        assertFalse(this.tree4.isBalanced(this.tree4.root));
    }

    @Test
    public void testTree5() { assertFalse(this.tree5.isBalanced(this.tree5.root)); }
}