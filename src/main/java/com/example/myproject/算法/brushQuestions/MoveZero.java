/**
 * @Copyright (C) 2019 本内容属于商业秘密，金瓜子科技发展（北京）有限公司拥有版权等所有权利.
 */
package com.example.myproject.算法.brushQuestions;

/**
 * @Description: []
 * @Author: wangyuanyuan10
 * @Date: 2019-12-23 17:42
 **/

import org.springframework.stereotype.Component;

import java.util.HashMap;

/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 *
 * 示例:
 *
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 *
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/move-zeroes
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
@Component
public class MoveZero {
    public void moveZeroes(int[] nums) {
        int j = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) {
                nums[j] = nums[i];
                if(i != j) {
                    nums[i] = 0;
                }
                j++;
            }
        }
    }




    public int maxArea(int[] height) {

        int m = 0;
        int maxM = 0;
        for(int i=0; i < height.length-1; i++) {
            for(int j=i+1; i < height.length; j++) {
                m = (j-i) * Math.min(height[i],height[j]);
                if (m > maxM) {
                    maxM = m;
                }
            }
        }
        return maxM;
    }
}
