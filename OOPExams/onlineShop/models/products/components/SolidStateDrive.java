package OOPExams.onlineShop.models.products.components;

public class SolidStateDrive extends BaseComponent{
    protected SolidStateDrive(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
    }
    @Override
    public double getOverallPerformance() {
        return this.getOverallPerformance() * 1.20;
    }
}
