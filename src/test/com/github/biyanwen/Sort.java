package com.github.biyanwen;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author byw
 * @Date 2022/3/9 13:04
 */
public class Sort {

	@Test
	public void HeapSortBeanTest() {
		HeapSortBean<Integer> sortBean = new HeapSortBean<>();
		sortBean.add(10);
		sortBean.add(1);
		sortBean.add(5);
		sortBean.add(9);
	}

	/**
	 * 排序算法
	 *
	 * @author byw
	 * @date 2022/03/09
	 */
	public static class SortAlgorithm {


	}

	/**
	 * 堆排序
	 * 父结点下标为(i-1)/2；其左右子结点分别为 (2i + 1)、(2i + 2)
	 *
	 * @author byw
	 * @date 2022/03/09
	 */
	public static class HeapSortBean<T extends Comparable<T>> {
		List<T> list = new ArrayList<>();

		public void add(T t) {
			int index = list.size();
			list.add(t);
			if (index > 0) {
				int fatherIndex = getFatherIndex(index);
				T fatherValue = list.get(fatherIndex);
				while (fatherValue.compareTo(t) > 0) {
					list.set(index, fatherValue);
					list.set(fatherIndex, t);
					index = fatherIndex;
					fatherValue = list.get(getFatherIndex(index));
				}
			}
		}

		public T poll() {
			if (list.isEmpty()) {
				return null;
			}
			return null;
		}

		/**
		 * 是空
		 *
		 * @return boolean
		 */
		public boolean isEmpty() {
			return list.isEmpty();
		}

		private int getRightChildIndex(int index) {
			return index * 2 + 2;
		}

		/**
		 * 得到左子节点索引
		 *
		 * @param index 索引
		 * @return int
		 */
		private int getLeftChildIndex(int index) {
			return index * 2 + 1;
		}

		/**
		 * 让父亲索引
		 *
		 * @param index 索引
		 * @return int
		 */
		private int getFatherIndex(int index) {
			return (index - 1) / 2;
		}
	}
}
