package com.practices;

public class droneV2 {
    static int calcDroneMinEnergy(int[][] route) {
        int maxHeight = route[0][2];
        for(int position=1;position<route.length;position++){
            if(maxHeight<route[position][2]){
                maxHeight = route[position][2];
            }
            //System.out.println(route[position][2] +" : "+maxHeight);
        }

        return maxHeight - route[0][2];
    }

    public static void main(String[] args) {
    /*int[][] route = new int[][] { {0,   2, 10},
                               {3,   5,  0},
                                {9,  20,  6},
                                 {10, 12, 15},
                                  {10, 10,  8} };
   */
        int[][] route = new int[][] {{0,2,6},{10,10,20}};
        System.out.println(calcDroneMinEnergy(route));
    }
}
