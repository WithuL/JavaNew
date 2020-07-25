package Java_0724;

public class GongG {
    int lca = 1;
    int max = 0;
    public int getLCA(int a, int b) {
        // write code here
        max = a > b ? a : b;
        help(1, a, b);
        return lca;
    }
    private boolean help(int root, int p , int q) {
        if(root > max) {
            return false;
        }
        int left = help( 2*root, p, q) ? 1 : 0;
        int right = help(2*root + 1, p , q) ? 1 : 0;
        int mid = root == p || root == q ? 1 : 0;
        if((left + right + mid) >= 2) {
            lca = root;
        }
        return (left + right + mid) > 0;
    }

    public static void main(String[] args) {
        GongG g = new GongG();
        System.out.println(g.getLCA(2, 3));
    }
}
