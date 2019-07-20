package com.practices;


class drone {

    static int calcDroneMinEnergy(int[][] route) {
        int energy = 0;
        int min_energy = 0;
        boolean start = true;
        int previous_pos = -1;
        for(int[] position:route){
            if(start){
                previous_pos = position[2];
                start = false;
            } else {
                energy += (previous_pos - position[2]);
                min_energy = Math.min(energy, min_energy);
                System.out.println(position[2] + " - " + (previous_pos - position[2]) + " - " + energy + " - " + min_energy);
                previous_pos =position[2];
            }

        }

        return min_energy*(-1);
    }

    public static void main(String[] args) {
    /*int[][] route = new int[][] { {0,   2, 10},
                               {3,   5,  0},
                                {9,  20,  6},
                                 {10, 12, 15},
                                  {10, 10,  8} };
   */
        int[][] route = new int[][] {{0,2,10},{3,5,0},{9,20,6},{10,12,15},{10,10,8}};
        System.out.println(calcDroneMinEnergy(route));
    }

}

//10, 4, -5, 2
//{{0,2,10},{3,5,0},{9,20,6},{10,12,15},{10,10,8}}
//{{0,2,10},{3,5,9},{9,20,6},{10,12,2},{10,10,10},{10,10,2}}

