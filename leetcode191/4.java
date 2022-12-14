
/**
 * @author think
 * @date 2022年11月10日
 */
public class Fourth {
    /**
     * 统计n的二进制形式中1的个数
     * @param n 要统计的1的个数的数字
     * @return n的二进制形式中1的个数
     */
    public static int hammingWeight(int n) {
         /*
         第一个n & 0x55555555是统计n当中“每两位二进制当中右边的1的个数”。
         第二个(n >>> 1) & 0x55555555是统计n当中“每两位二进制当中左边的1的个数”。为了方便操作，才需要
         进行无符号右移操作。
          */
        // 注意，这里的括号一定要扩上，因为+号的比&的优先级高。如果不加，+号先运算，最后就会导致结果错误。
        n = (n & 0x55555555) + ((n >>> 1) & 0x55555555);
        // 这里是4个二进制位的统计(每次统计4位二进制位当中的两位，先是左边然后是右边)
        n = (n & 0x33333333) + ((n >>> 2) & 0x33333333);
        // 这里是8个二进制位的统计(每次统计8位二进制位当中的4位，先是左边然后是右边)
        n = (n & 0x0f0f0f0f) + ((n >>> 4) & 0x0f0f0f0f);
        // 这里是16个二进制位的统计(每次统计16位二进制位当中的8位，先是左边然后是右边)
        n = (n & 0x00ff00ff) + ((n >>> 8) & 0x00ff00ff);
        // 这里是32个二进制位的统计(每次统计32位二进制位当中的16位，先是左边然后是右边)
        n = (n & 0x0000ffff) + ((n >>> 16) & 0x0000ffff);

        return n;
    }
}
