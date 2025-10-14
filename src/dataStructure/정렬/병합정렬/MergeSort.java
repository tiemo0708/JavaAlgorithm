package src.dataStructure.정렬.병합정렬;

public class MergeSort {
    private static void mergeSort(int[] arr) {
        int[] tmp = new int[arr.length]; //임시저장 배열
        mergeSort(arr, tmp, 0, arr.length -1);
    }
    private static void mergeSort(int[] arr, int[] tmp, int start, int end) {
        if (start < end) { //정렬할 구간에 2개 이상의 원소가 있을 때만
            int mid = (start + end) / 2;
            mergeSort(arr, tmp, start, mid);
            mergeSort(arr, tmp, mid + 1, end);
            merge(arr, tmp, start, mid, end);
        }
    }
    private static void merge(int[] arr, int[] tmp, int start, int mid, int end) {
        for (int i = start; i <= end; i++) {
            tmp[i] = arr[i];
        }
        int part1 = start;
        int part2 = mid + 1;
        int index = start; //결과배열 어디에 저장 해야하는지
        while (part1 <= mid && part2 <= end) {
            if (tmp[part1] <= tmp[part2]) {
                arr[index] = tmp[part1];
                part1++;
            }
            else{
                arr[index] = tmp[part2];
                part2++;
            }
            index++;
        }
        for (int i = 0; i <= mid -part1; i++){ // 왼쪽 부분 배열이 아직 남은경우에만 복사, 오른쪽은 남아 있기 때문
            arr[index + i] = tmp[part1 + i];
        }
    }

    private static void printArray(int[] arr) {
        for(int data : arr){
            System.out.print(data + ", ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {3,9,4,7,5,0,1,6,8,2};
        printArray(arr);
        mergeSort(arr);
        printArray(arr);
    }
}
