package com.example.demo_project;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo_project.entity.ToDo;
import com.example.demo_project.service.ifs.ToDoservice;

//@SpringBootTest
public class DemoProjectApplicationTest_ToDo {
//	@Autowired
//	ToDoservice toDoservice;

	@Test
	public int[] twoSum(int[] nums, int target) {
//		int[] a = { 2, 7, 11, 15 };
		for (int xxx = 0; xxx < nums.length; xxx++) {
			for (int xx = xxx + 1; xx < nums.length; xx++) {
				int a1 = nums[xxx];
				int a2 = nums[xx];
				if (target == (a1 + a2)) {
					int[] aa = { a1 + a2 };
					return aa;
				}
			}
		}
		return null;
	}

	@Test
	public int[] twoSum2(int[] nums, int target) {
//		int[]nums = { 2, 7, 11, 15 };
//	    target=9
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int total = target - nums[i];
			if (map.containsKey(total)) {
								//index[value]/ps.ByKey , i >>> index[0],[1]
				return new int[] { map.get(nums[i]), i };
			}
			map.put(nums[i], i);
		}
		return null;
	}
}
