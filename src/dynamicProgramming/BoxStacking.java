/*
 * BoxStackingI:
 * You are given a set of N types of rectangular 3-D boxes, where the ith box has height h, width w and length l. 
 * You task is to create a stack of boxes which is as tall as possible, but you can only stack a box on top of 
 * another box if the dimensions of the 2-D base of the lower box are each strictly larger than those of 
 * the 2-D base of the higher box. Of course, you can rotate a box so that any side functions as its base. 
 * It is also allowable to use multiple instances of the same type of box. You task is to write the function 
 * maxHeight which returns the height of the highest possible stack so formed.
 * 
 * BoxStacking_II:
 * Return the max number of boxes that you can put to form the max height
 */

package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;


public class BoxStacking {
	public static class Box {
		int length, width, height;
		
		Box(int length, int width, int height){
			this.length = length;
			this.height = height;
			this.width = width;
		}

		@Override
		public String toString() {
			return "[" + length + ", " + width + ", " + height + "]";
		}
	}
	
	public static class BoxStackingI {
		public static List<Box> createRotations(int[][] boxes){
			List<Box> rotations = new ArrayList<>();
			
			for(int[] arr: boxes) {
				int l = arr[0];
				int w = arr[1];
				int h = arr[2];
				
				rotations.add(new Box(Math.max(l, w), Math.min(l, w), h));
				rotations.add(new Box(Math.max(l, h), Math.min(l, h), w));
				rotations.add(new Box(Math.max(w, h), Math.min(w, h), l));
			}
			
			return rotations;
		}
		
		public static int maxHeight(int[][] boxes) {
			List<Box> rotations = createRotations(boxes);
			System.out.println(rotations);
			
			Collections.sort(rotations, (x, y) -> y.length*y.width - x.length*x.width);
			System.out.println(rotations);
			
			int max_height[] = new int[rotations.size()];
			
			for(int i = 0; i < rotations.size(); i++) {
				for(int j = 0; j < i; j++) {
					if(rotations.get(i).length < rotations.get(j).length && rotations.get(i).width < rotations.get(j).width)
						max_height[i] = Math.max(max_height[i], max_height[j]);
				}
				
				max_height[i] += rotations.get(i).height;
			}
			
			int max = Arrays.stream(max_height).max().getAsInt();
			return max;
		}
	}
	
	public static class BoxStacking_II {
		public static int solve1(int[][] nums) {
			Arrays.sort(nums, (a, b) -> a[0] == b[0] ? a[1] == b[1] ? a[2] - b[2] : a[1] - b[1] : a[0] - b[0]);
			int res = 0;
			int dp[] = new int[nums.length];
			
			for (int i = 0; i < nums.length; i++) {
				dp[i] = 1;
				for (int j = 0; j < i; j++) {
					if (nums[j][0] < nums[i][0] && nums[j][1] < nums[i][1] && nums[j][2] < nums[i][2])
						dp[i] = Math.max(dp[i], dp[j] + 1);
				}
				res = Math.max(dp[i], res);
			}
			
			return res;
		}
	}
	
	public static void main(String[] args) {
		int[][] x = {{7,6,4},
                	{3,2,1},
                	{6,5,4},
                	{32,12,10}};
		
		System.out.println(BoxStackingI.maxHeight(x));
		System.out.println(BoxStacking_II.solve1(x));
	}
}
