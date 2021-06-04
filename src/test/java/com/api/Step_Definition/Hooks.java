/*
 * package com.api.Step_Definition;
 * 
 * import cucumber.api.java.Before;
 * 
 * public class Hooks {
 * 
 * @Before("@DeletePlace") public void beforeScenario() throws Throwable{
 * 
 * Place_Step_Definition sd = new Place_Step_Definition();
 * 
 * if(Place_Step_Definition.place_id == null) { sd.add_place_payload("Test10",
 * "Tamil", "address10");
 * sd.user_calls_something_with_post_http_request("addPlaceAPI", "POST");
 * sd.verify_placeid_created_maps_to_something_using_something("Test10",
 * "getPlaceAPI"); } }
 * 
 * }
 */