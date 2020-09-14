package com.twu.refactoring;

public class OrderReceipt {
    private Order order;

    public OrderReceipt(Order order) {
        this.order = order;
	}

	public String printReceipt() {
		StringBuilder output = new StringBuilder();

		final String HEADERS = "======Printing Orders======\n";
		output.append(HEADERS);

        output.append(order.getCustomerName());
        output.append(order.getCustomerAddress());

		double totalSalesTax = 0d;
		double total = 0d;

		for (LineItem lineItem : order.getLineItems()) {
			output.append(lineItem.getDescription());
			output.append('\t');
			output.append(lineItem.getPrice());
			output.append('\t');
			output.append(lineItem.getQuantity());
			output.append('\t');
			output.append(lineItem.totalAmount());
			output.append('\n');

			final double TAXRATE = 0.10;
            double salesTax = lineItem.totalAmount() * TAXRATE;
			totalSalesTax += salesTax;

			total += lineItem.totalAmount() + salesTax;
		}

		output.append("Sales Tax").append('\t').append(totalSalesTax);

		output.append("Total Amount").append('\t').append(total);
		return output.toString();
	}


}