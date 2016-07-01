package com.devin.rent.model;

import static org.junit.Assert.assertNotNull;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


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
		// Read JSON file
		JSONParser parser = new JSONParser();
		JSONObject obj = null;
		try {
			obj = (JSONObject) parser.parse(new FileReader(jsonFilePath));
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ParseException e) {
			e.printStackTrace();
		}
		assertNotNull(obj);
		String rentString = (String) obj.get("baseRent");
		double rent = Double.parseDouble(rentString);
		System.out.println(rent);
		// Create objects
		// Make calculations
		// Create reports
		// Send emails
		// Send text messages
	}
}
