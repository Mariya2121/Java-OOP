package OOPExams.onlineShop.models.products.components;

public class VideoCard extends BaseComponent{
    protected VideoCard(int id, String manufacturer, String model, double price, double overallPerformance, int generation) {
        super(id, manufacturer, model, price, overallPerformance, generation);
    }
    @Override
    public double getOverallPerformance() {
        return this.getOverallPerformance() * 1.15;
    }
}
