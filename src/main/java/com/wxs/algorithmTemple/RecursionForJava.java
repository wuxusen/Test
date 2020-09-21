package com.wxs.algorithmTemple;

import com.wxs.algorithm.week03.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 类描述  ：
 * 创建人  : 吴绪森
 * 创建时间：2020-06-22
 * 修改人  ：
 * 修改时间：
 * 修改备注：
 * 版    本： V1.0
 */

public class RecursionForJava {


    /**
     * 递归代码：
     * 1、参数列表：记录当前层级，以及当前层需要的参数
     * 2、终止条件 比如 level> 最大层 跳出循环
     * 3、处理当前层逻辑
     * 4、下钻到下一层。。。。。
     */

    // 递归终止条件
    public int maxLevel = 10;


    public void recursion(int level, String param1, String param2, String... params) {

        // recursion terminator
        if (level > maxLevel) {
            return;
        }

        // process logic in current level

        // process(level, data ....)

        // drill down
        recursion(level + 1, "param1", "param2", "param2");

    }

    /**
     * 广度优先算法模板:
     *  1、前提，广度优先算法需要使用队列完成，需要指出先进先出
     *  2、创建生成结果集的list ，创建循环遍历先进先出队列
     *
     *  注意：循环编列的结束是 队列为空
     *
     *  3、将第一个node放入队列中，while 队列不为空进行循环
     *  （广度优先算法需要遍历每一层的所有节点，如果拿到当前层节点？
     *  当前层节点，只需要在循环开始时，记录队列中的size，就标识当前层数量，依次pop就能拿到当前层的所有数据）
     *
     *  4、拿到当前层所有数据后，进行业务处理
     *  5、根据当前节点 node.right 或 node.left 如果不为null，就依次放入队列
     *
     *
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder(TreeNode root){
        List<List<Integer>> allRes = new ArrayList<>();

        if(root == null){
            return allRes;
        }

        LinkedList<TreeNode> nodes = new LinkedList<>();
        nodes.add(root);

        while (!nodes.isEmpty()){

            int size = nodes.size();
            List<Integer> results = new ArrayList<>();
            for(int i = 0;i < size; i++){
                TreeNode node = nodes.pop();

                results.add(node.val);

                if(node.left!=null){
                    nodes.add(node.left);
                }
                if(node.right != null){
                    nodes.add(node.right);
                }
            }
            allRes.add(results);

        }
             return allRes;
    }


    /**
     * dfs 递归
     * @param root
     * @return
     */
    public List<List<Integer>> levelOrder1(TreeNode root){
        // 结果集
        List<List<Integer>> allRes = new ArrayList<>();
        if(root == null){
            return allRes;
        }

        // recursion
        dfs(root,0,allRes);

        return allRes;
    }

    private void dfs(TreeNode root, int level, List<List<Integer>> allRes) {

        // 终止条件
        if(allRes.size() == level){
            allRes.add(new ArrayList<>());
        }

        allRes.get(level).add(root.val);

        if(root.left != null){
            dfs(root.left,level+1,allRes);
        }
        if(root.right != null){
            dfs(root.right,level+1,allRes);
        }


    }


}
