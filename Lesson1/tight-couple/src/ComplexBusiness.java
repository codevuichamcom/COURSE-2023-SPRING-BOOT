public class ComplexBusiness {

    private ISortAlgorithm algorithm;

    public ComplexBusiness(ISortAlgorithm algorithm){
        this.algorithm = algorithm;
    }
    public void complexFunc(int [] numbers){

        // Sắp xếp (Tăng dần)
        algorithm.sort(numbers);

        //Thực hiện các logic phức tạp khác

    }
}
