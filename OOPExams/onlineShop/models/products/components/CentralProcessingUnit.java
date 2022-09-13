package OOPExams.onlineShop.models.products.components;

public class CentralProcessingUnit extends BaseComponent{
    protected CentralProcessingUnit(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
    }
    @Override
    public double getOverallPerformance() {
        return super.getOverallPerformance() * 1.25;
    }
}
