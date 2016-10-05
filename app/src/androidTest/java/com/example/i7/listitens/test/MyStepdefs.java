package com.example.i7.listitens.test;

import com.example.i7.listitens.ItemListaActivity;
import com.robotium.solo.Solo;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

/**
 * Created by i7 on 23/09/2016.
 */
public class MyStepdefs extends Instrumentation{

    @Before
    public void setUp(){
        solo = new Solo(getInstrumentation(),getActivity());
    }

    @Given("^Lista de Itens application is opened$")
    public void Lista_de_Itens_application_is_open(){
        solo.assertCurrentActivity("Wrong Activity",ItemListaActivity.class);
    }

    @And("^visualize the Home screen of the application$")
    public void visualize_the_Home_screen_of_the_application(){
        Boolean HomeTitle = solo.searchText("Lista de Itens");
        assertTrue(HomeTitle);
    }

    @After
    public void tearDown(){
        solo.finishOpenedActivities();
    }
}
