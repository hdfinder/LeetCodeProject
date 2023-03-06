import java.lang.reflect.Array;
import java.util.*;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        Map<Integer, Integer> hashTable = new HashMap<Integer, Integer>();
        int i = 0, j = 0;
        int HTlength = 1;
        //遍历任意一个数组
        while (i < nums1.length && j < nums2.length) {
            //逐个对另一个数组中的元素进行比较（前提是另一个数组没有结束）
            //如果小于另一个数组中的元素，那么将元素存入Hash表中，并且i++,
            //如果大于另一个数组中的元素，那么将另一数组的元素存入Hash表中，并且j++；

            if (nums1[i] < nums2[j]) {
                hashTable.put(HTlength, nums1[i]);
                i++;
            } else {
                hashTable.put(HTlength, nums2[j]);
                j++;
            }

            HTlength++;
        }
        //如果数组没有循环结束,将剩余元素存到Hash表中
        if (j < nums2.length) {
            while (j < nums2.length) {
                hashTable.put(HTlength, nums2[j]);
                j++;
                HTlength++;
            }
        }
        if (i < nums1.length) {
            while (i < nums1.length) {
                hashTable.put(HTlength, nums1[i]);
                i++;
                HTlength++;
            }
        }
        HTlength--;
        if (HTlength % 2 == 0) {
            return (double) (hashTable.get(HTlength / 2) + hashTable.get(HTlength / 2 + 1)) / 2;
        } else {
            return hashTable.get(HTlength / 2 + 1);
        }
    }

    //将数组num2合并到num1中，并且排序
    /*
     *方法1：
     *  先存后排序
     *方法2：
     *  额外创建一个数组，将num2和num1看做两个队列，取队列头最小的元素存储到数组中
     *
     * */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        //取最长
//        int arrL = m > n ? m : n;
        //方法1
        //如果nums1[]长度为m=0，直接将nums2[]第一个元素复制到nums1[]中
/*        int lenth1=nums1.length;
        if (m == 0) {
            for (int j=0;j<lenth1;j++){
                nums1[j] = nums2[j];
            }
        }
        if (m != 0 && n != 0) {
            int i = m, j = 0;
            for (; i < nums1.length && j < n; i++, j++) {
                nums1[i] = nums2[j];
            }
        }
        //冒泡排序
        for (int i = 0; i < lenth1; i++) {
            for (int j = 0; j < lenth1 - i -1; j++) {
                if (nums1[j] > nums1[j+1]) {
                    int tmp = nums1[j];
                    nums1[j] = nums1[j+1];
                    nums1[j+1] = tmp;
                }
            }
        }
    */
        //方法2
        int[] arr = new int[m + n];
        //对num1数组从头遍历
        int arri = 0;
        int i = 0, j = 0;
        while (j < n) {
            if (nums1[i] <= nums2[j] && i < m) {
                arr[arri] = nums1[i];
                i++;
            } else {
                arr[arri] = nums2[j];
                j++;
            }
            arri++;
        }
        while (i < m) {
            arr[arri++] = nums1[i++];
        }
//        for (int each: arr) {
//            System.out.print(each);
//        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = arr[i];
        }
    }


    public int removeDuplicates(int[] nums) {
        //设置两个指针遍历子串
        int lp = 0, rp = 1, length = 1;
        while (rp < nums.length) {
            if (nums[lp] == nums[rp]) {
                rp++;
            } else {
                nums[length] = nums[rp];
                length++;
                lp = rp;
            }
        }
        return length;
    }
//-------------旋转数组-----------------//
    /*
     * 1、利用中间数组
     * 2、对数据整个反转
     *
     * */

    public void rotate(int[] nums, int k) {
        int length = nums.length;
        k %= length;
/*
        //利用中间数组
        int length = nums.length;
        int[] numsTmp = new int[length];
        for (int i = 0; i < length; i++) {

            numsTmp[i] = nums[i];

        }
        for (int i = 0; i < length; i++) {

            nums[(i + k) % length] = numsTmp[i];

        }
        for (int i : nums) {
            System.out.print("\t" + i);
        }
*/
        reverse(nums, 0, length - 1);
//        for (int i : nums) {
//            System.out.print("\t" + i);
//        }
//        System.out.println();
        reverse(nums, k, length - 1);
//        for (int i : nums) {
//            System.out.print("\t" + i);
//        }
        reverse(nums, 0, k - 1);
//        System.out.println();
        for (int i : nums) {
            System.out.print("\t" + i);
        }
    }

    //      对数组中n到m个元素反转
    public void reverse(int[] nums, int n, int m) {
        while (n < m) {
            int tmp = nums[n];
            nums[n++] = nums[m];
            nums[m--] = tmp;
        }
    }

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashTable = new HashSet<Integer>();
        int i = 0, length = nums.length;
        for (; i < length; i++) {
            if (hashTable.contains(nums[i])) {
                return true;
            } else {
                hashTable.add(nums[i]);
            }
        }
        return false;
    }


    //    二分法查找数组中的元素
    public int binnarySearch(int[] nums, int key) {
        int leftPoint = 0, rightPoint = nums.length - 1;
        while (leftPoint < rightPoint) {
            int mid = (leftPoint + rightPoint) / 2;
            if (key < nums[mid]) {
                rightPoint = mid - 1;
            } else if (key > nums[mid]) {
                leftPoint = mid + 1;
            } else return mid;
        }
        return -1;
    }

    //      只出现一次的数字
    public int singleNumber(int[] nums) {
        int length = nums.length;
        int i = 0, j = 0;
        for (; i < length; i++) {
            j = i + 1;
            while (j < length) {
                if (nums[i] == nums[j]) break;
                j++;
            }
            if (j == length) break;
        }
        if (j == length) return nums[i];
        return -1;
    }

    //    两个数组的交集
    public int[] intersect(int[] nums1, int[] nums2) {
/*        Map<Integer, Integer> set = new HashMap<>();
        ArrayList<Integer> list = new ArrayList<>();
        int length1 = nums1.length;
        int length2 = nums2.length;
        int minLength = length1 < length2 ? length1 : length2;
        int[] numsTmp = new int[minLength];
        if (length1 == 0 || length2 == 0) {
            return numsTmp;
        }
        int p1 = 0, p2 = 0, k = 0;
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        while (p1 < length1 && p2 < length2) {
            if (nums1[p1]==nums2[p2]){
                numsTmp[k++]=nums1[p1];
                p1++;
                p2++;
            }else if(nums1[p1]<nums2[p2]){
                p1++;
            }else {
                p2++;
            }
        }
        return Arrays.copyOfRange(numsTmp,0,k);
    }*/
        int[] con = new int[1001];
        int index = 0;
        for (int i = 0; i < nums1.length; i++) {
            con[nums1[i]]++;
        }
        for (int i = 0; i < nums2.length; i++) {
            if (con[nums2[i]] != 0) {
                nums1[index++] = nums2[i];
                con[nums2[i]]--;
            }
        }
        return Arrays.copyOf(nums1, index);
    }

    //数组加1
    public int[] plusOne(int[] digits) {
        int len = digits.length;
        int i = len - 1;
        //先把最后一位加1
        digits[i] += 1;
        //排除数组长度=1的情况
        if (len == 1) {
            if (digits[0] == 10) {
                return new int[]{1, 0};
            }
            return digits;
        }
        //从结尾开始遍历数组，遍历到第二位结束
        for (; i > 0; i--) {
            //如果当前元素等于10，则赋0，前一个元素值+1；否则结束循环
            if (digits[i] == 10) {
                digits[i] = 0;
                digits[i - 1] += 1;
            } else break;
        }
        //如果循环一直到第一位元素，则需要对第一位元素判断是否等于10；是：创建新数组，第一位=1，之后全为0.否则直接返回数组；
        if (i == 0) {
            if (digits[i] == 10) {
                int[] arr = new int[len + 1];
                arr[0] = 1;
                return arr;
            }
        }
        return digits;
    }

    //移动零
    public void moveZeroes(int[] nums) {
//    定义变量来记录0出现的次数
        int count = 0, j = 0;
        ;
        int len = nums.length;
/*        if (len > 1) {
            for (int i = 0; i < len; i++) {
                if (nums[i] == 0) {
                    count++;
                }
            }
            for (int i = 0; i < len; i++) {
                if (nums[i]!=0){
                    nums[j++]=nums[i];
                }
            }
            for (int i=len-count;i<len;i++){
                nums[j++]=0;
            }
        }
        */
//优化
        int index = 0;
        if (len > 1 || nums != null) {
//            非0网前挪
            for (int i = 0; i < len; i++) {
                if (nums[i] != 0) {
                    nums[index++] = nums[i];
                }
            }
            while (index < len) {
                nums[index++] = 0;
            }
        }
    }

    public boolean isValidSudoku(char[][] board) {
//        定义三个二维数组，分别记录行，列，三维矩阵中存在的数字
        int len = board.length;
        int[][] line = new int[len][len];
        int[][] row = new int[len][len];
        int[][] cell = new int[len][len];
        int num = 0, k = 0;
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                //如果还没有填数字，直接跳过
                if (board[i][j] == '.') continue;
                //num是当前格子的数字
                num = board[i][j] - '0' - 1;
                //k是第几个单元格，9宫格数独横着和竖着都是3个单元格
                k = i / 3 * 3 + j / 3;
                if (line[i][num] != 0 || row[j][num] != 0 || cell[k][num] != 0)
                    return false;
                //表示第i行有num这个数字，第j列有num这个数字，对应的单元格内也有num这个数字
                line[i][num] = row[j][num] = cell[k][num] = 1;
            }
        }
        return true;
    }

    public void rotate(int[][] matrix) {
//        根据规律发现，先将矩阵沿斜对角线对称，然后交换第一列和最后一列，第二列和倒数第二列，如此循环
//        将矩阵沿对角线对称
        int len = matrix.length;
        int[] tmpMt = new int[len];
        for (int i = 0; i < len; i++) {
            for (int j = i; j < len; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        for (int j = 0; j < len / 2; j++) {
            for (int i = 0; i < len; i++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[i][len - j - 1];
                matrix[i][len - j - 1] = tmp;
            }
        }
    }

    //    字符串中的第一个唯一字符
    public int firstUniqChar(String s) {
        char[] str = s.toCharArray();
        int len = s.length();
//        双指针
     /*   int i,j;
        for (i=0;i<len;i++){
            for(j=0;j<len;j++){
                if (str[i]==str[j]&&i!=j){
                    break;
                }
            }
            if (j==len) return i;
        }
        return -1;*/

//        hashMap
        int[] nums = new int[26];
        for (int i = 0; i < len; i++) {
            nums[str[i] - 'a']++;
        }
        for (int i = 0; i < len; i++) {
            if (nums[str[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }

    //    有效的字母异位词
    public boolean isAnagram(String s, String t) {
        char[] str = s.toCharArray();
        char[] str1 = t.toCharArray();
        int[] strc = new int[26];
        int len = str.length;
        int len1 = str1.length;
        if (len != len1) return false;
//        利用中间数组统计出现的字符次数
        for (int i = 0; i < len; i++) {
            strc[str[i] - 'a']++;
        }
//        遍历另一个对中间数组进行减操作，小于0则不符合条件
        for (int i = 0; i < len1; i++) {
            if (strc[str1[i] - 'a'] <= 0) {
                return false;
            }
            strc[str1[i] - 'a']--;
        }
        return true;
    }

    /*
// 利用异或操作，将两个字符串拼接，然后逐个异或，最后判断是否为0
    int amount = 0;
    String str = s + t;
    char[] strarr = str.toCharArray();
//        首先判断一下，防止出现aa,bb
    char[] sstr = s.toCharArray();
    char[] tstr = t.toCharArray();
    int slen = sstr.length;
    int tlen = tstr.length;
    int counts=0,countt=0;
    if (slen != tlen) {
        return false;
    }
    for (int i = 0; i < sstr.length; i++) {
        counts+=sstr[i];
        countt+=tstr[i];
    }
    if (countt!=counts) return false;
    for (int i = 0; i < strarr.length; i++) {
        amount = amount ^ (strarr[i]);
    }
    if (amount == 0) return true;
    return false;
}*/
//验证回文串
    /*
     * 如果在将所有大写字符转换为小写字符、并移除所有非字母数字字符之后，
     * 短语正着读和反着读都一样。则可以认为该短语是一个 回文串
     *
     *字母和数字都属于字母数字字符。
     * */
    public boolean isPalindrome(String s) {
//        设置头尾指针，头指针<尾指针
//        先全部转换成大写
//        String s0 = s.toLowerCase();
        System.out.println(s);
        char[] str = s.toCharArray();
        int len =str.length;
        if (len == 0) return true;
        int head = 0, tail = s.length() - 1;
        while (head < tail) {
//        过滤干扰字符，除了大小写字符，其他都是干扰
            while (head < tail&&!Character.isLetterOrDigit(s.charAt(head))){
                head++;
            }
            while (head < tail&&!Character.isLetterOrDigit(s.charAt(tail))){
                tail--;
            }
            if (Character.toLowerCase(s.charAt(head))!=Character.toLowerCase(s.charAt(tail))){
                return false;
            }
            head++;
            tail--;
        }
        return true;
    }
}















































































