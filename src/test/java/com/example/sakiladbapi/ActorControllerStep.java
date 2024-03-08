package com.example.sakiladbapi;

import com.example.sakiladbapi.controllers.ActorController;
import com.example.sakiladbapi.entities.Actor;
import com.example.sakiladbapi.services.ActorService;
import io.cucumber.java.*;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.mock;

public class ActorControllerStep {
    private ActorService actorService;
    private Actor actorModel;
    private final Short expectedId = 1;
    private final Actor actor = new Actor(expectedId, "John", "Doe");

    @Before
    public void setUp(){
        actorService = mock(ActorService.class);
    }

    @Given("the actor with id {short} exists")
    public void givenActorOneExists(Short id){
        doReturn(actor).when(actorService).getActorById(id);
    }

    @When("a GET request is made for an actor with ID {short}")
    public void whenRequestWithId(Short id){
        final ActorController actorController = new ActorController(actorService);
        try{
            actorModel = actorController.getActor(id);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Then("an actor is returned")
    public void thenActorIsReturned(){
        assertNotNull(actorModel);
        assertEquals("John", actorModel.getFirstName());
        assertEquals("Doe", actorModel.getLastName());
    }
}
