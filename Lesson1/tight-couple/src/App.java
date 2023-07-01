public class App {

    //Giả sử ta cần thực hiện 1 logic phức tạp nhất vũ trụ
    public static void main(String[] args) {
        int numbers [] = new int[]{1,4,3,2,5};
        ISortAlgorithm bubbleSort = new BubbleSort();
        ISortAlgorithm quickSort = new QuickSort();
        ISortAlgorithm quanSort = new QuanSort();
        ComplexBusiness business = new ComplexBusiness(quanSort);
        business.complexFunc(numbers);
    }
}
