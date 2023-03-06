public class ArrayMidSum {
    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println('\n' + "数组拼接排序-------------------");
        int[] nums1 = {4, 5, 6, 0, 0, 0};
        int[] nums2 = {1, 2, 3};
//        System.out.println("ALLlength:"+(nums1.length+nums2.length));
//        System.out.println(solution.findMedianSortedArrays(nums1,nums2));
        for (int i : nums1) {
            System.out.print("\t" + i);
        }
        System.out.println();
        for (int i : nums2) {
            System.out.print("\t" + i);
        }
        System.out.println();
        solution.merge(nums1, 3, nums2, 3);
        for (int i : nums1) {
            System.out.print("\t" + i);
        }
        System.out.println('\n' + "删除数组中的重复项-------------------");
        int[] nums = new int[]{0, 0, 1, 1, 1, 2, 2, 3, 3, 4}; // 输入数组
        int[] expectedNums = new int[5]; // 长度正确的期望答案

        int k = solution.removeDuplicates(nums); // 调用

        for (int i = 0; i < k; i++) {
            System.out.print("\t" + nums[i]);
        }
        System.out.println('\n' + "旋转数组-------------------");
        int[] nums3 = new int[]{1, 2, 3, 4, 5, 6, 7};
//        int[] nums3 = new int[] {-1,-100,3,99};

        solution.rotate(nums3, 3);


//        存在重复元素


//        二分查找法
        System.out.println('\n' + "二分查找法-------------------");
        int reslut = solution.binnarySearch(nums1, 3);
        System.out.println(reslut);

//      只出现一次的数字
        System.out.println('\n' + "只出现一次的数字-------------------");

//      两个数组的交集
        System.out.println('\n' + "两个数组的交集-------------------");
        int[] nums4 = solution.intersect(nums, nums3);

        for (int i : nums4) {
            System.out.print("\t" + i);
        }
//      数组加1
        System.out.println('\n' + "数组加1-------------------");
        int[] nums5 = {8, 9, 9, 9};
//        int[] nums5={7};
        int[] res = solution.plusOne(nums5);
        for (int i : res) {
            System.out.print("\t" + i);
        }
//        移动数组中的零到结尾
        System.out.println('\n' + "移动数组中的零到结尾-------------------");
        int[] nums6 = {0, 1, 0, 3, 12};
        solution.moveZeroes(nums6);
        for (int i : nums6) {
            System.out.print("\t" + i);
        }
//      有效的数独
        System.out.println('\n' + "有效的数独-------------------");
        char[][] board = {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}
                , {'6', '.', '.', '1', '9', '5', '.', '.', '.'}
                , {'.', '9', '8', '.', '.', '.', '.', '6', '.'}
                , {'8', '.', '.', '.', '6', '.', '.', '.', '3'}
                , {'4', '.', '.', '8', '.', '3', '.', '.', '1'}
                , {'7', '.', '.', '.', '2', '.', '.', '.', '6'}
                , {'.', '6', '.', '.', '.', '.', '2', '8', '.'}
                , {'.', '.', '.', '4', '1', '9', '.', '.', '5'}
                , {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        System.out.println(solution.isValidSudoku(board));
//      旋转图像
        System.out.println('\n' + "旋转图像-------------------");
        int[][] matrix={{5,1,9,11},{2,4,8,10},{13,3,6,7},{15,14,12,16}};
        solution.rotate(matrix);
        int len=matrix.length;
        for (int[] i:matrix){
            for (int num:i){
                System.out.print("\t"+num);
            }
            System.out.println();
        }
//        for (int i=0;i<len;i++){
//            for (int j=0;j<len;j++){
//                System.out.print("\t"+matrix[i][j]);
//            }
//            System.out.println();
//        }

        System.out.println();

//        字符串中的第一个唯一字符
        System.out.println('\n' + "字符串中的第一个唯一字符-------------------");

        System.out.println(solution.firstUniqChar("loveleetcode"));

//        有效的字母异位词(两个字符串中的字母出现频率相同)
        System.out.println('\n' + "有效的字母异位词-------------------");
        System.out.println(solution.isAnagram("xaaddy","xbbccy"));
//        验证回文串
        System.out.println('\n' + "验证回文串-------------------");
        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("a."));
        System.out.println();





    }
}




































