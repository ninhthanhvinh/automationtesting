package com.tvinh.test1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import static com.tvinh.test1.AutomationTesting.baseuri;

public class Controller implements Initializable {

    public String api = new String();
    @FXML
    private TextArea textAreaGUI;
    static TextArea staticTxtArea;
    @FXML
    private Label menuLabel;

    @FXML
    private Label uriLabel;

    @FXML
    private Label apiLabel;

    @FXML
    private ChoiceBox<String> uriChoice;

    @FXML
    private ChoiceBox<String> apiChoice;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        uriChoice.getItems().addAll("heroku2", "heroku3");
        uriChoice.setOnAction(this::setUriChoice);
        apiChoice.getItems().addAll("Login", "Edit", "Sign Up", "Log Out", "Get Categories", "Auction Create", "Edit Auction", "Contact", "Create Comment",
            "Create Item", "Get Brands", "Get Details Auction", "Get List Auction By Type",
                "Get List Auction By User", "Get List Auction By Status", "Get List Comment", "Get List Likes",
                "Get News", "Get Total Likes Of Auction");
        apiChoice.setOnAction(this::setApiChoice);
        staticTxtArea = textAreaGUI;
    }

    public void Test(){

    }

    public void setUriChoice(ActionEvent event){
        String choice = uriChoice.getValue();
        if (Objects.equals(choice, "heroku2")) baseuri = "https://auction-app-2.herokuapp.com/api";
        else baseuri = "https://auction-app3.herokuapp.com/api";
    }
    public void setApiChoice(ActionEvent event){
        String choice = apiChoice.getValue();
        if (Objects.equals(choice, "Login")) {
            LoginTest lt = new LoginTest();
            lt.call();
        }
        else if (Objects.equals(choice, "Sign Up")) {
            SignUpTest sut = new SignUpTest();
            sut.call();
        }
        else if (Objects.equals(choice, "Edit")) {
            EditTest et = new EditTest();
            et.call();
        }
        else if (Objects.equals(choice, "Log Out")) {
            LogOutTest lot = new LogOutTest();
            lot.call();
        }
        else if (Objects.equals(choice, "Get Categories")){
            GetCategoriesTest gct = new GetCategoriesTest();
            gct.call();
        }
        else if (Objects.equals(choice, "Auction Create")){
            AuctionCreateTest act = new AuctionCreateTest();
            act.call();
        }
        else if (Objects.equals(choice, "Edit Auction")){
            EditAuctionTest call = new EditAuctionTest();
            call.call();
        }
        else if (Objects.equals(choice, "Contact")){
            ContactUsTest call = new ContactUsTest();
            call.call();
        }
        else if (Objects.equals(choice, "Create Comment")){
            CreateCommentTest call = new CreateCommentTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get List Auction By User")){
            GetListAuctionsByUser call = new GetListAuctionsByUser();
            call.call();
        }
        else if (Objects.equals(choice, "Create Item")){
            CreateItemTest call = new CreateItemTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get Brands")){
            GetBrandsTest call = new GetBrandsTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get Details Auction")){
            GetDetailsAutionTest call = new GetDetailsAutionTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get List Auction By Type")){
            GetListAuctionByTypeTest call = new GetListAuctionByTypeTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get List Auction By Status")){
            GetListAuctionsByStatusTest call = new GetListAuctionsByStatusTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get News")){
            GetNewsTest call = new GetNewsTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get List Comment")){
            GetListCommentTest call = new GetListCommentTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get List Likes")){
            GetListLikesTest call = new GetListLikesTest();
            call.call();
        }
        else if (Objects.equals(choice, "Get Total Likes Of Auction")){
            GetTotalLikeOfAuctionTest call = new GetTotalLikeOfAuctionTest();
            call.call();
        }
    }
}