package edu.neu.csye7374;

public interface DiscountStrategyAPI {
	double CalculateDiscount(double price);
/*	
	public void showStoreDiscountAlgorithms() {
		System.out.println("\n\t" + Driver.class.getName() + ".showStoreDiscountAlgorithms()...");

		// TODO BY STUDENT execute all discount algorithms
		double initialprice= ShopNStop.itemList.get(0).getPrice();
		DiscountStrategyAPI salediscount = new SaleDiscount();
		ShopNStop.itemList.get(0).setPrice(salediscount.CalculateDiscount(initialprice));
		System.out.println("initial Price:"+initialprice+"  After Discount Price:"+ShopNStop.itemList.get(0).getPrice());

		DiscountStrategyAPI presidentsDayDiscount = new PresidentsDayDiscount();
		ShopNStop.itemList.get(0).setPrice(presidentsDayDiscount.CalculateDiscount(initialprice));
		System.out.println("initial Price:"+initialprice+"  After Discount Price:"+ShopNStop.itemList.get(0).getPrice());
		}
*/
}
