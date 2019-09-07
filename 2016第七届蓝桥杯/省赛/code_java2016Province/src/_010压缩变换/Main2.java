package _010压缩变换;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main2 {
    static Map<Integer, Integer> lastIndex = new HashMap<Integer, Integer>();//数字与下标的映射
    static int[] a;//记录原始数据
    static int[] ans;//记录答案
    static int[] b;//这是一个01序列，某一个位置p上的数字为1，代表着a[p]这个数字最后出现的位置是p，而a[p]曾经出现过的位置上都是0
    private static int n;
    private static SegTree root;

    public static void main(String[] args) throws FileNotFoundException {
     //  处理输入
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        a = new int[n];
        ans = new int[n];
        b=new int[n];
        root = buildSegTree(0, n - 1);

        for (int i = 0; i < n; i++) {
            int num = sc.nextInt();
            a[i] = num;
            Integer preIndex = lastIndex.get(num);
            if (preIndex == null)//没出现过
            {
                ans[i] = -num;
                b[i] = 1;
                update(root, i, 1);
            } else {
                //统计p_num和i之间有多少不同的数字
                ans[i] = query(root, preIndex + 1, i - 1);//统计两个位置之间的1的个数==>求区间和
                b[preIndex] = 0;
                b[i] = 1;
                update(root, preIndex, -1);
                update(root, i, 1);
            }
            lastIndex.put(num, i);//更新
        }
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
    }

    private static int query(SegTree tree, int x, int y) {
        int l = tree.l;
        int r = tree.r;
        if (x <= l && y >= r) return tree.sum;
        int mid = (l + r) / 2;
        int ans = 0;
        if (x <= mid) ans += query(tree.lson, x, y);
        if (y > mid) ans += query(tree.rson, x, y);
        return ans;
    }

    /*构建线段树*/
    private static SegTree buildSegTree(int l, int r) {
        SegTree segTree = new SegTree(l, r);
        if (l == r) {
            segTree.sum = b[l];
            return segTree;
        }
        int mid = (l + r) / 2;
        SegTree lson = buildSegTree(l, mid);
        SegTree rson = buildSegTree(mid + 1, r);
        segTree.lson = lson;
        segTree.rson = rson;
        segTree.sum = lson.sum + rson.sum;
        return segTree;
    }

    static void update(SegTree tree, int p, int i) {
        if (tree == null) return;
        //更新根节点的sum
        tree.sum += i;
        int l = tree.l;
        int r = tree.r;
        int mid = (l + r) >> 1;
        if (p <= mid) {
            update(tree.lson, p, i);
        } else {
            update(tree.rson, p, i);
        }
    }

    static class SegTree {
        int l, r;//所有区间
        int sum;//区间和

        SegTree lson;//左子树
        SegTree rson;//右子树

        public SegTree(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }
}
