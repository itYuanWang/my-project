/**
 * @Copyright (C) 2019 本内容属于商业秘密，金瓜子科技发展（北京）有限公司拥有版权等所有权利.
 */
package com.example.myproject.算法.search;

import org.springframework.stereotype.Component;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-21 20:20
 **/
@Component
public class SequentialSearch {

    public Integer sequentialSearch1(Integer[] arr, int n, int key){
        for (int i=1; i<n; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return 0;
    }

    //优化之后的方法
    //方法一每次循环都需要对i是否越界做判断，可以使用哨兵 来解决这个问题
    //哨兵不一定要在数组的开始，也可以在末端
    public Integer sequentialSearch2(Integer[] arr, int n, int key){
        arr[0] = key;
        int i = n;
        while (arr[i] != key) {
            i--;
        }
        return i;
    }
}
