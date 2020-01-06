/**
 * @Copyright (C) 2019 本内容属于商业秘密，金瓜子科技发展（北京）有限公司拥有版权等所有权利.
 */
package com.example.myproject.common;

import lombok.Data;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-26 12:48
 **/
@Data
public class ListNode {
    private int val;
    public static ListNode next;
    public ListNode(int x) {
        val = x;
    }
}
