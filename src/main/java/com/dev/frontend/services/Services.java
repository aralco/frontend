package com.dev.frontend.services;

import java.util.ArrayList;
import java.util.List;

import com.alligator.MyRestClient;
import com.dev.frontend.panels.ComboBoxItem;
import com.oracle.javafx.jmx.json.JSONWriter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Services 
{
	public static final int TYPE_PRODUCT = 1;
	public static final int TYPE_CUSTOMER = 2;
	public static final int TYPE_SALESORDER = 3;
	
	
	public static Object save(Object object,int objectType)
	{
		//TODO by the candidate 
		/*
		 * This method is called eventually after you click save on any edit screen
		 * object parameter is the return object from calling method guiToObject on edit screen
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER 
		 */
        JSONObject result=new JSONObject();
        if(objectType==TYPE_PRODUCT) {
            System.out.println("***********************SAVE " + object.toString());
            result=MyRestClient.postRequest(MyRestClient.BASEURL + "backend/products",
                    object.toString());
        }

        return result;
	}
	public static Object readRecordByCode(String code,int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you select record in list view of any entity
		 * and also called after you save a record to re-bind the record again
		 * the code parameter is the first column of the row you have selected
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER */

        JSONObject result=new JSONObject();
        if(objectType==TYPE_PRODUCT) {
            System.out.println("***********************READ " + code);
            result=MyRestClient.getRequest(MyRestClient.BASEURL + "backend/products/" + code);
        }

        return result;
	}
	public static boolean deleteRecordByCode(String code,int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you click delete button on an edit view
		 * the code parameter is the code of (Customer - PRoduct ) or order number of Sales Order
		 * and the type is identifier of the object type and may be TYPE_PRODUCT ,
		 * TYPE_CUSTOMER or TYPE_SALESORDER
		 */
        JSONObject result=new JSONObject();
        if(objectType==TYPE_PRODUCT) {
            System.out.println("***********************READ " + code);
            result=MyRestClient.deleteRequest(MyRestClient.BASEURL + "backend/products/" + code);
            System.out.println("**********************DELETE RESULT: "+result.toString());
        }

		return true;
	}
	
	public static List<Object> listCurrentRecords(int objectType)
	{
		//TODO by the candidate
		/*
		 * This method is called when you open any list screen and should return all records of the specified type
		 */
        JSONArray result=new JSONArray();
        if(objectType==TYPE_PRODUCT) {
            System.out.println("***********************LIST ");
            result=MyRestClient.getRequestForArray(MyRestClient.BASEURL + "backend/products");

        }
        System.out.println("LIST RESULT: "+result.toString());
        return result;
	}
	public static List<ComboBoxItem> listCurrentRecordRefernces(int objectType) 
	{	
		//TODO by the candidate
		/*
		 * This method is called when a Combo Box need to be initialized and should
		 * return list of ComboBoxItem which contains code and description/name for all records of specified type
		 */
		return new ArrayList<ComboBoxItem>();
	}
	public static double getProductPrice(String productCode) {
		//TODO by the candidate
		/*
		 * This method is used to get unit price of product with the code passed as a parameter
		 */
		return 1;
	}
}
