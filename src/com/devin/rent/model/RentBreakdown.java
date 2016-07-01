package com.devin.rent.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

import com.google.gson.Gson;


/*
 * Goals for this project:
 * Read from local JSON file on my machine containing information about people.
 * Process the JSON files and calculate rent breakdowns for each person.
 * Email a full rent breakdown to the person, and send them a text message with a short summary.
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
	"sharedUtilities":[
		{
			"sharedUtilityName":"sharedNameOfUtility",
			"sharedUtilityCost":"sharedCostOfUtility",
			"peopleToSplitBill":[
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				},
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				},
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				}
			]
		},
		{
			"sharedUtilityName":"sharedNameOfUtility",
			"sharedUtilityCost":"sharedCostOfUtility",
			"peopleToSplitBill":[
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				},
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				},
				{ 
					"person":"nameOfPersonWhoMustBeInListPeople" 
				}
			]
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
public class RentBreakdown {
	
	private static final String jsonFilePath = "C:/Users/DevinB/Desktop/RentBreakdown.txt";
	
	public static void main(String[] args) {
		Gson gson = new Gson();
		BufferedReader br = readFile();
		Breakdown rb = gson.fromJson(br, Breakdown.class);
		// Create objects
		// Make calculations
		// Create reports
		// Send emails
		// Send text messages
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
