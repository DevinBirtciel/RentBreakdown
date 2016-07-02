package com.devin.rent.model;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Calculator {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Calculator.class);
	private static DecimalFormat format = new DecimalFormat("$#,##0.00");
	
	public static List<Summary> calculateRents(Breakdown breakdown){
		// Get objects out of Breakdown
		double baseRent = breakdown.getBaseRent();
		LOGGER.info("Base rent is: {}", format.format(baseRent));
		double taxRate = breakdown.getTaxRate();
		LOGGER.info("Tax rate is: {}", taxRate);
		List<Utility> utilities = breakdown.getUtilities();
		List<Tenant> tenants = breakdown.getTenants();
		int numberTenants = tenants.size();
		// Calculate Rents
		List<Summary> tallies = new ArrayList<Summary>();
		for(Tenant tenant : tenants){
			String name = tenant.getName();
			LOGGER.info("\n\nCalculating Rent for {}", name);
			double total = calculateRent(tenant, baseRent, taxRate, numberTenants);
			total = addUtilities(name, total, utilities, numberTenants);
			LOGGER.info("Total for {} is {}", name, format.format(total));
			String bills = "Rent";
			bills += constructBillsString(name, utilities);
			Summary summary = new Summary(name, bills, total);
			tallies.add(summary);
		}
		return tallies;
	}
	
	

	private static String constructBillsString(String name, List<Utility> utilities) {
		String bills = "";
		for(Utility utility : utilities){
			if(utility.getSplitBill().contains(name)){
				bills += ", " + utility.getUtilityName();
			}
		}
		return bills;
	}

	private static double addUtilities(String name, double total, List<Utility> utilities, int numberTenants) {
		for(Utility utility : utilities){
			if(utility.getSplitBill().contains(name)){
				double tempTotal = total;
				double utilityCost = utility.getUtilityCost();
				LOGGER.info("Adding in {} bill", utility.getUtilityName());
				total += utilityCost / numberTenants;
				LOGGER.info("{} + {} / {} = {}", format.format(tempTotal), format.format(utilityCost), numberTenants, format.format(total));
			}
		}
		return total;
	}

	private static double calculateRent(Tenant tenant, double baseRent, double taxRate, int numberTenants) {
		double total = baseRent / numberTenants * taxRate;
		LOGGER.info("{} / {} * {} = {}", format.format(baseRent), numberTenants, taxRate, format.format(total));
		List<Pet> pets = tenant.getPets();
		for(Pet pet : pets){
			double tempTotal = total;
			double petCost = pet.getPetCost();
			total += petCost * taxRate;
			LOGGER.info("Adding in rent for {}.", pet.getPetName());
			LOGGER.info("{} + {} * {} = {}", format.format(tempTotal), format.format(petCost), taxRate, format.format(total));
		}
		return total;
	}
}
