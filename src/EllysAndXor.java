public class EllysAndXor {
    int max =0;


    private void tryNext(int[] numbers, int i, int r) {

        if(i == numbers.length){
            max = Math.max(max, r);
            return;
        }

        tryNext(numbers, i+1, r & numbers[i]);
        tryNext(numbers, i+1, r ^ numbers[i]);
    }


    public int getMax(int[] numbers) {
        tryNext(numbers, 1, numbers[0]);
        return max;
    }

    static public void main(String[] args){
        EllysAndXor ellysAndXor = new EllysAndXor();
        System.out.println(ellysAndXor.getMax(new int[]{42, 27, 38}));
    }
}