/**
 * @Copyright (C) 2019 本内容属于商业秘密，金瓜子科技发展（北京）有限公司拥有版权等所有权利.
 */
package com.example.myproject.算法.brushQuestions;

import com.example.myproject.common.ListNode;
import org.springframework.stereotype.Component;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-26 12:48
 **/
@Component
public class Linked {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode cur1 = dummy;
        ListNode pre1 = null;
        for(int i=0; i<m; i++){
            pre1 = cur1;
            cur1 = cur1.next;
        }

        ListNode cur2 = cur1;
        ListNode pre2 = pre1;
        for(int i=m; i<=n; i++){
            ListNode temp = cur2.next;
            cur2.next = pre2;
            pre2 = cur2;
            cur2 = temp;
        }

        pre1.next = pre2;
        cur1.next = cur2;

        return dummy.next;
    }
}
