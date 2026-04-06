package prob1.rulesets;

import java.awt.Component;

import prob1.gui.CDWindow;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {
	@Override
	public void applyRules(Component ob) throws RuleException {
		CDWindow cdw = (CDWindow) ob;

		String title = cdw.getTitleValue().trim();
		String price = cdw.getPriceValue().trim();
		String artist = cdw.getArtistValue().trim();

		// 1. All fields must be nonempty
		nonEmptyRule(title, price, artist);

		// 2. Price must be a floating point number with two decimal places
		priceTwoDecimalRule(price);

		// 3. Price must be a number greater than 0.49.
		priceGreaterThanRule(price);
	}

	private void nonEmptyRule(String title, String price, String artist) throws RuleException {
		if (title.isEmpty() || price.isEmpty() || artist.isEmpty()) {
			throw new RuleException("All fields must be nonempty.");
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
