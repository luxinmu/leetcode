package test;

public class T11_ContainerWithMostWater {

	public static void main(String[] args) {
		System.out.println(maxArea(new int[] { 1, 8, 6, 2, 5, 4, 8, 3, 7 }));
	}

	public static int maxArea(int[] height) {
		int max = 0;
		int i = 0;
		int j = height.length - 1;
		while (i < j) {
			max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
			if (height[i] < height[j])
				i++;
			else
				j--;
		}
		return max;
	}

	public static int maxArea10(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++)
			for (int j = i + 1; j < height.length; j++)
				max = Math.max(max, (j - i) * Math.min(height[i], height[j]));
		return max;
	}

}
