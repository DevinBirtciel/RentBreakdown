package com.devin.rent.controller;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.devin.rent.model.Breakdown;
import com.devin.rent.model.Calculator;
import com.devin.rent.model.Summary;
import com.google.gson.Gson;

/*
 * Goals for this project:
 * Read from local JSON file on my machine containing information about people.
 * Process the JSON file and calculate rent breakdowns for each person.
 * Email a full rent breakdown to each person, and send them a text message with a short summary.
 * 
 * Requirements:
 * Must appropriately split rent.
 * Must handle pets, pet fees, and taxes on pet fees so only pet owner pays for pet.
 * Must handle variable number of utilities per person
 * Must email a detailed rent breakdown
 * Must text a summary total with which bills were included
 * 
 * JSON format:
{
	"baseRent":"rentAmount",
	"taxRate":"taxRate",
	"utilities":[
		{
			"utilityName":"nameOfUtility",
			"utilityCost":"costOfUtility",
			"splitBill":["name1","name2"]
		}
	],
	"people":[
		{
			"name":"personName",
			"number":"phoneNumber",
			"email":"emailAddress",
			"pets":[
				{
					"petName":"nameOfPet",
					"petCost":"costOfPet"
				}
			]
		}
	]
}
 */
//TODO See if it's possible to refactor additional fields into RentBreakdown
// so that I don't have to pass as many local variables around.
public class RentBreakdown {
	
	private static final String jsonFilePath = "C:/Users/DevinB/Desktop/RentBreakdown.txt";
	private static final Logger LOGGER = LoggerFactory.getLogger(RentBreakdown.class);
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = readFile();
		Breakdown breakdown = gson.fromJson(br, Breakdown.class);
		// Make calculations
		List<Summary> tallies = Calculator.calculateRents(breakdown);
		// Create reports
		LOGGER.info("\n\n");
		for(Summary summary : tallies){
			LOGGER.info("{}", summary);
		}
		// TODO Send emails
		// TODO Send text messages
	}

	

	private static BufferedReader readFile() {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new FileReader(jsonFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return br;
	}
}
