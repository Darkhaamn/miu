package prob1.rulesets;

import java.awt.Component;

import prob1.gui.*;

/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places 
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {
	@Override
	public void applyRules(Component ob) throws RuleException {
		BookWindow bw = (BookWindow) ob;

		String title = bw.getTitleValue().trim();
		String price = bw.getPriceValue().trim();
		String isbn = bw.getIsbnValue().trim();

		 // * 1. All fields must be nonempty
		nonEmptyRule(title, price, isbn);

		//  2. Isbn must be numeric and consist of either 10 or 13 characters
		isbnNumericAndLengthRule(isbn);

		// 3. If Isbn has length 10, the first digit must be 0 or 1
		isbnLength10Rule(isbn);

		// 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
		isbnLength13Rule(isbn);

		// 5. Price must be a floating point number with two decimal places
		priceTwoDecimalRule(price);

		// 6. Price must be a number greater than 0.49.
		priceGreaterThanRule(price);
	}

	private void nonEmptyRule(String title, String price, String isbn) throws RuleException {
		if (title.isEmpty() || price.isEmpty() || isbn.isEmpty()) {
			throw new RuleException("All fields must be nonempty.");
		}
	}

	private void isbnNumericAndLengthRule(String isbn) throws RuleException {
		if (!isbn.matches("\\d+")) {
			throw new RuleException("ISBN must be numeric.");
		}
		if (!(isbn.length() == 10 || isbn.length() == 13)) {
			throw new RuleException("ISBN must consist of either 10 or 13 digits.");
		}
	}

	private void isbnLength10Rule(String isbn) throws RuleException {
		if (isbn.length() == 10) {
			char first = isbn.charAt(0);
			if (!(first == '0' || first == '1')) {
				throw new RuleException("If ISBN has length 10, the first digit must be 0 or 1.");
			}
		}
	}

	private void isbnLength13Rule(String isbn) throws RuleException {
		if (isbn.length() == 13) {
			String prefix = isbn.substring(0, 3);
			if (!(prefix.equals("978") || prefix.equals("979"))) {
				throw new RuleException("If ISBN has length 13, the first 3 digits must be 978 or 979.");
			}
		}
	}

	private void priceTwoDecimalRule(String price) throws RuleException {
		if (!price.matches("\\d+\\.\\d{2}")) {
			throw new RuleException("Price must be a floating point number with exactly two decimal places.");
		}
	}

	private void priceGreaterThanRule(String price) throws RuleException {
		double p = Double.parseDouble(price);
		if (p <= 0.49) {
			throw new RuleException("Price must be greater than 0.49.");
		}
	}

}
