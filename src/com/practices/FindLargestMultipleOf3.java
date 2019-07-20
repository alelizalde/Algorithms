package com.practices;

public class FindLargestMultipleOf3 {

    public static void main (String[] args) {
        int[] arr = new int[] {1, 1, 6, 3, 9};
        System.out.println(findLargestMultipleOf3(arr));
    }

    public static int  findLargestMultipleOf3(int[] arr){
        int[] repetitions = findRepetitions(arr);
        int result = calculateSum(repetitions, null);
        int reminder = (result % 3);
        if (reminder == 0) return  result;

        int[] rem1 = new int[] {-1};
        int[] rem2 = new int[] {-1,-1};

        for(int num=0;num<10;num++){
            int count = repetitions[num];
            while(count>0){

                if(reminder == 1){
                    if(num % 3 == 1){
                        rem1[0] = 1;
                        return calculateSum(repetitions, rem1);
                    }
                    if(num % 3 == 2){
                        if(rem2[0] == -1){
                            rem2[0] = num;
                        } else if(rem2[1] == -1){
                            rem2[1] = num;
                        }
                    }
                }

                if(reminder == 2){
                    if(num % 3 == 2){
                        rem1[0] = num;
                        return calculateSum(repetitions, rem1);
                    }
                    if(num % 3 == 1){
                        if(rem2[0] == -1){
                            rem2[0] = num;
                        } else if(rem2[1] == -1){
                            rem2[1] = num;
                        }
                    }
                }
                count--;
            }
        }

        if(rem2[0] != -1 && rem2[1] != -1){
            return calculateSum(repetitions, rem2);
        }

        return -1;
    }

    public static int[]  findRepetitions(int[] arr){

        int[] possibilities = new int[10];

        for(int element:arr) {
            possibilities[element]++;
            //System.out.println(element + "," + possibilities[element]);

        }
        return possibilities;
    }

    public static int calculateSum(int[] repetitions, int[] nums){
        if(nums!=null){
            for(int num:nums){
                repetitions[num]--;
            }
        }
        int totalSum = 0;
        int power = 0;
        for(int element = 0; element < repetitions.length; element++){
            int count=repetitions[element];
            while(count>0){
                totalSum += element * Math.pow(10,power);
                power++;
                count--;
            }


        }
        return totalSum;
    }
}
