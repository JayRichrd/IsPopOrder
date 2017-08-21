package com.jy;

import java.util.ArrayDeque;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) {
		// 入栈序列
		int[] pushOrder = new int[] { 1, 2, 3, 4, 5 };
		// 出栈序列
		int[] popOrder1 = new int[] { 4, 5, 3, 2, 1 };
		int[] popOrder2 = new int[] { 4, 3, 5, 1, 2 };
		// 判定
		System.out.println("入栈序列：" + Arrays.toString(pushOrder));
		System.out.println("序列：" + Arrays.toString(popOrder1) + "是否是它的一个出栈序列：" + isPopOrder(pushOrder, popOrder1));
		System.out.println("序列：" + Arrays.toString(popOrder2) + "是否是它的一个出栈序列：" + isPopOrder(pushOrder, popOrder2));
	}

	/**
	 * 判断一个序列是否是另一个入栈序列的出栈序列
	 * 
	 * @param pushOrder
	 *            入栈序列
	 * @param popOrder
	 *            用来判断的出栈序列
	 * @return 是就返回true，否则返回false
	 */
	public static boolean isPopOrder(int[] pushOrder, int[] popOrder) {
		boolean isPossible = false;
		int pushLength = pushOrder.length;
		int popLength = popOrder.length;
		if (pushOrder != null && popOrder != null && pushLength != 0 && pushLength == popLength) {
			// 新建辅助栈
			ArrayDeque<Integer> dataStack = new ArrayDeque<Integer>();
			int indexPop = 0;
			int indexPush = 0;
			while (indexPop < popLength) { // 根据出栈序列来判断
				while (dataStack.isEmpty() || dataStack.peek() != popOrder[indexPop]) {
					// 按照入栈序列已经全部入栈
					if (indexPush >= pushLength)
						break;
					dataStack.push(pushOrder[indexPush++]);

				}
				// 按照入栈序列已经全部入栈，仍然找不到出栈序列的元素
				if (dataStack.peek() != popOrder[indexPop])
					break;
				dataStack.pop();
				indexPop++;
			}
			// 辅助栈全部出栈，且已经遍历完出栈序列
			if (dataStack.isEmpty() && indexPop == popLength)
				isPossible = true;
		}
		return isPossible;
	}

}
