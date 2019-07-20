package com.practices;
import java.util.*;


class Sort { /*
    //Bubble Sort
    private static void bubble(List<Integer> arr) {
        boolean swap = false
        int curr = 0
        int limit = arr.size() - 1
        while (true) {
            if (arr[curr] > arr[curr + 1]) {
                int sum = arr[curr] + arr[curr + 1]
                arr[curr] = sum - arr[curr]
                arr[curr + 1] = sum - arr[curr + 1]
                swap = true
            }

            curr++

            if (curr >= limit) {
                if (!swap) break curr = 0
                swap = false
                limit--
            }
        }
    }

    //Selection Sort
    private static void selection(arr:List<Integer>) {
        var minPos = 0

        for (curr in 0 until arr.count()){
            var min = Integereger.MAX_VALUE
            for (i in curr + 1 until arr.count()){
                if (arr[i] < min) {
                    min = arr[i]
                    minPos = i
                }
            }
            if (arr[curr] > min) {
                val tmp = arr[curr]
                arr[curr] = min
                arr[minPos] = tmp
            }
        }
    }

    //Insertion Sort
    private static void insertion(items:List<Integer>):List<Integer>

    {

        if (items.isEmpty() || items.count() < 2) {
            return items
        }

        for (curr in 1 until items.count()){
        // prIntegerln(items)
        val item = items[curr]
        var i = curr
        while (i > 0 && item < items[i - 1]) {
            items[i] = items[i - 1]
            i--
        }
        items[i] = item
    }
        return items
    }

    //Merge Sort
    private static void merge(arr:List<Integer>):List<Integer>

    {
        if (arr.count() <= 1) return arr
        val middle = arr.count() / 2
        val left = arr.subList(0, middle)
        val right = arr.subList(middle, arr.count())
        return merge(merge(left), merge(right))

    }

    private static void merge(left:List<Integer>, right:List<Integer>):List<Integer>

    {
        var indexLeft = 0
        var indexRight = 0
        val newList :List<Integer> =ListOf()

        while (indexLeft < left.count() && indexRight < right.count()) {
            if (left[indexLeft] <= right[indexRight]) {
                newList.add(left[indexLeft])
                indexLeft++
            } else {
                newList.add(right[indexRight])
                indexRight++
            }
        }

        while (indexLeft < left.count()) {
            newList.add(left[indexLeft])
            indexLeft++
        }

        while (indexRight < right.count()) {
            newList.add(right[indexRight])
            indexRight++
        }

        return newList
    }

    //Quick Sort
    private static void quickSort(arr:List<Integer>, p:Integer, r:Integer) {
        if (p < r) {
            var q:Integer = partition(arr, p, r)
            quickSort(arr, p, q - 1)
            quickSort(arr, q + 1, r)

        }
    }

    private static void partition(arr:List<Integer>, p:Integer, r:Integer):Integer

    {
        var x = arr[r]
        var i = p - 1
        for (j in p until r){
        if (arr[j] <= x) {
            i++
            exchange(arr, i, j)
        }
    }
        exchange(arr, i + 1, r)
        return i + 1
    }

    private static void exchange(arr:List<Integer>, i:Integer, j:Integer) {
        val temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    //Heap Sort
    var heapSize = 0

    private static void left(i:Integer):Integer

    {
        return 2 * i
    }

    private static void right(i:Integer):Integer

    {
        return 2 * i + 1
    }

    private static void swap(arr:List<Integer>, i:Integer, j:Integer) {
        var temp = arr[i]
        arr[i] = arr[j]
        arr[j] = temp
    }

    private static void maxHeapify(arr:List<Integer>, i:Integer) {
        var l = left(i)
        var r = right(i)
        var largest:Integer

        if ((l <= heapSize - 1) && (arr[l] > arr[i])) {
            largest = l
        } else
            largest = i

        if ((r <= heapSize - 1) && (arr[r] > arr[l])) {
            largest = r
        }

        if (largest != i) {
            swap(arr, i, largest)
            maxHeapify(arr, largest)
        }
    }

    private static void buildMaxheap(arr:List<Integer>) {
        heapSize = arr.size
        for (i in heapSize / 2 downTo 0){
            maxHeapify(arr, i)
        }
    }

    private static void heapSort(arr:List<Integer>) {
        buildMaxheap(arr)
        for (i in arr.size - 1 downTo 1){
            swap(arr, i, 0)
            heapSize--
            maxHeapify(arr, 0)

        }
    }

    private static void main() {
        val bubbleArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        var time:Long
                time = measureNanoTime {
            bubble(bubbleArr)
        }
        prIntegerln("Bubble sort $bubbleArr took $time")

        val selectionArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        time = measureNanoTime {
            selection(selectionArr)
        }
        prIntegerln("Selection sort $selectionArr took $time")

        val insertionArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        time = measureNanoTime {
            insertion(insertionArr)
        }
        prIntegerln("Insertion sort $insertionArr took $time")

        val quickArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        time = measureNanoTime {
            quickSort(quickArr, 0, quickArr.count() - 1)
        }
        prIntegerln("Quick sort $quickArr took $time")

        val heapArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        time = measureNanoTime {
            heapSort(heapArr)
        }
        prIntegerln("Heap sort $heapArr took $time")

        val mergeArr = ListOf(8, 3, 4, 6, 7, 1, 2, 5)
        var mergeRes = List(0) {
            0
        }
        time = measureNanoTime {
            mergeRes = merge(mergeArr)
        }
        prIntegerln("Merge sort $mergeRes took $time")
    }
*/
}