
package com.example.myproject.算法.tree;

import java.util.List;

/**
 * @Description: 双亲表示法
 * @Author: wangyuanyuan10
 * @Date: 2019-12-09 15:47
 **/
public class TreeDataStructure {
    private static final Long MAX_TREE_SIZE = 100L;
    private Integer tElemType;
    private PTNode ptNode;
    private TStructure tStructure;

    /**
     * 节点结构
     */
    class PTNode {
        private Object data;
        private Integer parent;
    }

    /**
     * 树结构
     */
    class TStructure {
        private List<PTNode> nodes;
        private Integer rootPosition;
        private Integer nodeNumber;
    }
}