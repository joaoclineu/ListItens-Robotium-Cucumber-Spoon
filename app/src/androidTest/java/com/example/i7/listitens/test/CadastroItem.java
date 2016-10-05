package com.example.i7.listitens.test;

import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.i7.listitens.R;

import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * Created by i7 on 23/09/2016.
 */
public class CadastroItem extends Instrumentation{
    @When("^type the item name \"([^\"]*)\"$")
    public void type_the_item_name(String ItemName){
        solo.typeText((EditText) solo.getView(R.id.edit_text_nome_item), ItemName);
    }

    @Given("^form item is opened$")
    public void form_item_is_opened(){
        solo.clickOnMenuItem("Adicionar");
    }

    @And("^chose the category \"([^\"]*)\"$")
    public void chose_the_category(String arg1) {
        solo.pressSpinnerItem(0, 0); //Alimentos
    }

    @And("^type the quantity \"([^\"]*)\"$")
    public void type_the_quantity(String Quantity) {
        solo.typeText((EditText) solo.getView(R.id.edit_text_quantidade_item), Quantity);
    }

    @And("^type the unit price \"([^\"]*)\"$")
    public void type_the_unit_price(String Price) {
        solo.typeText((EditText) solo.getView(R.id.edit_text_preco_item), Price);
    }


    @And("^check the total price item \"([^\"]*)\"$")
    public void check_the_total_price_item(String TotalPrice) {
        TextView totalPriceResult = (TextView)solo.getView(R.id.text_view_preco_total);
        assertEquals(TotalPrice, totalPriceResult.getText());
    }

    @And("^click on save button$")
    public void click_on_save_button() {
        //Button saveButton = (Button)solo.getView(R.id.button_salvar);
        solo.clickOnButton("Salvar");
        //solo.clickOnView(saveButton)
    }

    @Then("^verify the item \"([^\"]*)\" save with success$")
    public void verify_the_item_save_with_success(String itemName) throws Throwable {
        TextView nameItemSaved = (TextView)solo.getView(R.id.text_view_nome_item_list);
        assertEquals(itemName, nameItemSaved.getText());
    }

}
