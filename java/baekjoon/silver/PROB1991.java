package silver;

import java.io.*;
import java.util.*;

public class PROB1991 {
    static class Node {
        String parent;
        String left, right;

        public Node(String value) {
            this.parent = value;
            this.left = null;
            this.right = null;
        }
    }


    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static StringBuilder sb = new StringBuilder();

    static final String DOT = ".";

    static int N;
    static Map<String, Node> nodes = new HashMap<>();


    public static void main(String[] args) throws IOException {
        init();
        solve();
    }

    public static void init() throws IOException {
        N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i ++) {
            st = new StringTokenizer(br.readLine());
            String parent = st.nextToken();
            String left = st.nextToken();
            String right = st.nextToken();

            nodes.putIfAbsent(parent, new Node(parent));
            Node node = nodes.get(parent);

            if (!left.equals(DOT)) {
                nodes.putIfAbsent(left, new Node(left));
                node.left = left;
            }

            if (!right.equals(DOT)) {
                nodes.putIfAbsent(right, new Node(right));
                node.right = right;
            }
        }
    }

    public static void solve() {
        preorder(nodes.get("A"));
        sb.append("\n");

        inorder(nodes.get("A"));
        sb.append("\n");

        postorder(nodes.get("A"));
        System.out.println(sb);
    }

    public static void preorder(Node node) {
        if (node == null || node.parent.equals(DOT))
            return;

        sb.append(node.parent);
        preorder(nodes.get(node.left));
        preorder(nodes.get(node.right));
    }

    public static void inorder(Node node) {
        if (node == null || node.parent.equals(DOT))
            return;

        inorder(nodes.get(node.left));
        sb.append(node.parent);
        inorder(nodes.get(node.right));
    }

    public static void postorder(Node node) {
        if (node == null || node.parent.equals(DOT))
            return;

        postorder(nodes.get(node.left));
        postorder(nodes.get(node.right));
        sb.append(node.parent);
    }
}
