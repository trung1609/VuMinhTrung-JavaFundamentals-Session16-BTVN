package Session16.gioi2;

import java.util.DoubleSummaryStatistics;
import java.util.List;

public class ProductProcessorImpl implements ProductProcessor<Product> {
    @Override
    public double calculateTotalValue(List<Product> items) {
        DoubleSummaryStatistics total = items.stream().mapToDouble(Product::getPrice).summaryStatistics();
        return total.getSum();
    }
}
