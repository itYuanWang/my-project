/**
 * @Copyright (C) 2019 本内容属于商业秘密，金瓜子科技发展（北京）有限公司拥有版权等所有权利.
 */
package com.example.myproject.algorithm.question;

import com.example.myproject.MyProjectApplicationTests;
import com.example.myproject.common.ListNode;
import com.example.myproject.算法.brushQuestions.Linked;
import com.example.myproject.算法.brushQuestions.MoveZero;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-23 17:43
 **/
public class myTest extends MyProjectApplicationTests {
    @Autowired
    private MoveZero moveZero;
    @Autowired
    private Linked linked;

    @Test
    public void reverseBetweenTest(){
        ListNode node = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        linked.reverseBetween(node,2,4);
    }

    @Test
    public void maxAreaTest(){
        int[] arr = {1,8,6,2,5,4,8,3,7};
        moveZero.maxArea(arr);
    }

    @Test
    public void moveZeroesTest(){
        int[] arr = {0,1,0,3,12};
        moveZero.moveZeroes(arr);
    }
}
