package streamAPI;

/**
 * On peut creer nos propres Collectors
 */
public class SalaryCollector {
    private int total=0;
    private int count = 0;

    public int getTotal() {
        return total;
    }

    public void accept(int salary){
        this.total+=salary;
        count++;
    }
    //on va combiner les differents stream parrallele ici
    public void combine(SalaryCollector salaryCollector){
        total+= salaryCollector.total;
        count += salaryCollector.count;
    }
}
