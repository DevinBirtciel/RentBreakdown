package com.devin.model;

public class RentBreakdown {
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
			"sharedUtilityCost":"sharedCostOfUtility"
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
			],
			"utilities":[
				{
					"utilityName":"nameOfUtility",
					"utilityCost":"costOfUtility"
				}
			]
		}
	]
	
}
	  
	 */
	public static void main(String[] args) {
		
	}
}
