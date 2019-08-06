package com.practices;

import static java.lang.System.out;


class ByteProblems {

    private static String convertToBinary(int num) {

        StringBuilder output = new StringBuilder();
        while (num >= 1) {
            output.append(num % 2 != 0 ? "1" : "0");
            num /= 2;
        }

        return output.reverse().toString();
    }

    private static int countOnesInBinaryNumber (int num) {
        int count = 0;

        while (num > 0) {
            num = num & (num - 1);
            count++;
        }

        return count;
    }
    private static boolean powerOfTwo(int num) {
        return num > 0 && (num & num -1) == 0;
    }

    public static void main(String[] args) {

        assert !powerOfTwo(0);
        assert !powerOfTwo(6);
        assert powerOfTwo(8);

        assert convertToBinary(5).equals("101");
        assert convertToBinary(8).equals("1000");
        assert convertToBinary(14).equals("1110");

        assert countOnesInBinaryNumber(3) == 2;
        assert countOnesInBinaryNumber(4) == 1;
        /*
        Count number of 1 in a binary 115:
        1110011 - 115 & 1110010 - 114 = 1110010 = 114 -> 1
        1110010 = 114 & 1110001 - 113 = 1110000 = 112 -> 2
        1110000 - 112 & 1101111 - 111 = 1100000 = 96 -> 3
        1100000 - 96  & 1011111 - 95  = 1000000 = 64 -> 4
        1000000 - 64  & 0111111 - 63  = 0000000 = 0 -> 5
        */
        assert countOnesInBinaryNumber(115) == 6;

    }
}


