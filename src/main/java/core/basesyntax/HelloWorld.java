package core.basesyntax;

public class HelloWorld {

    public interface DiscountService {
        double getDiscount();
    }

    public static class DefaultDiscountService implements DiscountService {
        @Override
        public double getDiscount() {
            return 0;
        }
    }

    public static class NewYearDiscountService implements DiscountService {
        @Override
        public double getDiscount() {
            return 20;
        }
    }

    public static class BirthdayDiscountService implements DiscountService {
        @Override
        public double getDiscount() {
            return 33;
        }
    }

    public static class BlackFridayDiscountService implements DiscountService {
        @Override
        public double getDiscount() {
            return 45;
        }
    }

    public static class DiscountStrategy {
        public DiscountService getDiscountServiceBySpecialEvent(String specialEvent) {
            if (specialEvent == null) {
                return new DefaultDiscountService();
            }
            switch (specialEvent) {
                case "Birthday":
                    return new BirthdayDiscountService();
                case "Black Friday":
                    return new BlackFridayDiscountService();
                case "New Year":
                    return new NewYearDiscountService();
                default:
                    return new DefaultDiscountService();
            }
        }
    }
}

