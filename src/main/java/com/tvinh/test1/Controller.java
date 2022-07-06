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
        apiChoice.getItems().addAll("Login", "Edit", "Sign Up", "Log Out",
                "get_list_auctions", "get_list_auctions_by_status", "get_list_auctions_by_Type",
                "get_list_auctions_by_User", "get_detail_auction", "create_auction", "edit_auction",
                "create_item", "create_comment", "get_list_comment", "create_bid",
                "Get_list_bids", "Get_list_categories", "Get_list_brands", "Accept_max_bid",
                "Contact_us", "Like_auction", "Get_list_like", "Total_likes_of_auction",
                "Get_news", "Read_new", "Get_notifications", "Read_notifications",
                "Get_slider", "search", "delete_comment");
        apiChoice.setOnAction(this::setApiChoice);
        staticTxtArea = textAreaGUI;
    }

    public void Test(){
        if (Objects.equals(api, "login")){
            LoginTest lt = new LoginTest();
            lt.call();
        }
        else if (Objects.equals(api, "signup")){
            SignUpTest sut = new SignUpTest();
            sut.call();
        }
        else if (Objects.equals(api, "edit")){
            EditTest et = new EditTest();
            et.call();
        }
        else if (Objects.equals(api, "logout")){
            LogOutTest lot = new LogOutTest();
            lot.call();
        }
        else if (Objects.equals(api, "get_list_auctions")){
            GetListAuctionTest getAuction = new GetListAuctionTest();
            getAuction.call();
        }
        else if (Objects.equals(api, "get_list_auctions_by_status")){
            GetListAuctionsByStatusTest getAuctionStatus = new GetListAuctionsByStatusTest();
            getAuctionStatus.call();
        }
        else if (Objects.equals(api, "get_list_auctions_by_user")){
            GetListAuctionsByUser getAuctionUser = new GetListAuctionsByUser();
            getAuctionUser.call();
        }
        else if (Objects.equals(api, "get_list_auctions_by_Type")){
            GetListAuctionByTypeTest getAuctionType = new GetListAuctionByTypeTest();
            getAuctionType.call();
        }
        else if (Objects.equals(api, "get_detail_auction")){
            GetDetailsAutionTest getDetail= new GetDetailsAutionTest();
            getDetail.call();
        }
        else if (Objects.equals(api, "create_auction")){
            AuctionCreateTest createAuction = new AuctionCreateTest();
            createAuction.call();
        }
        else if (Objects.equals(api, "edit_auction")){
            EditAuctionTest editAuction = new EditAuctionTest();
            editAuction.call();
        }
        else if (Objects.equals(api, "create_item")){
            CreateItemTest createItem = new CreateItemTest();
            createItem.call();
        }
        else if (Objects.equals(api, "create_comment")){
            CreateCommentTest createComment = new CreateCommentTest();
            createComment.call();
        }
        else if (Objects.equals(api, "get_list_comment")){
            GetListCommentTest GetComment = new GetListCommentTest();
            GetComment.call();
        }
        else if (Objects.equals(api, "create_bid")){
            Create_bid createBid = new Create_bid();
            createBid.call();
        }
        else if (Objects.equals(api, "Get_list_bids")){
            Get_list_bids GetBid = new Get_list_bids();
            GetBid.call();
        }
        else if (Objects.equals(api, "Get_list_categories")){
            GetCategoriesTest GetCategories = new GetCategoriesTest();
            GetCategories.call();
        }
        else if (Objects.equals(api, "Get_list_brands")){
            GetBrandsTest getBrand = new GetBrandsTest();
            getBrand.call();
        }
        else if (Objects.equals(api, "Accept_max_bid")){
            Accept_max_bid acp = new Accept_max_bid();
            acp.call();
        }
        else if (Objects.equals(api, "Contact_us")){
            ContactUsTest Contact = new ContactUsTest();
            Contact.call();
        }
        else if (Objects.equals(api, "Like_auction")){
            Like_auction like_auc = new Like_auction();
            like_auc.call();
        }
        else if (Objects.equals(api, "Get_list_like")){
            GetListLikesTest GetLike = new GetListLikesTest();
            GetLike.call();
        }
        else if (Objects.equals(api, "Total_likes_of_auction")){
            GetTotalLikeOfAuctionTest hien = new GetTotalLikeOfAuctionTest();
            hien.call();
        }
        else if (Objects.equals(api, "Get_news")){
            Get_news hien = new Get_news();
            hien.call();
        }
        else if (Objects.equals(api, "Read_new")){
            Read_new hien = new Read_new();
            hien.call();
        }
        else if (Objects.equals(api, "Get_notifications")){
            Get_notifications hien = new Get_notifications();
            hien.call();
        }
        else if (Objects.equals(api, "Read_notifications")){
            Read_notifications hien = new Read_notifications();
            hien.call();
        }
        else if (Objects.equals(api, "Get_slider")){
            Get_slider hien = new Get_slider();
            hien.call();
        }
        else if (Objects.equals(api, "search")){
            Search hien = new Search();
            hien.call();
        }
        else if (Objects.equals(api, "delete_comment")){
            Delete_comment hien = new Delete_comment();
            hien.call();
        }
    }

    public void setUriChoice(ActionEvent event){
        String choice = uriChoice.getValue();
        if (choice == "heroku2") baseuri = "https://auction-app-2.herokuapp.com/api";
        else baseuri = "https://auction-app3.herokuapp.com/api";
    }
    public void setApiChoice(ActionEvent event){
        String choice = apiChoice.getValue();
        if (choice == "Login") api = "login";
        else if (choice == "Sign Up") api = "signup";
        else if (choice == "Edit") api = "edit";
        else if (choice == "Log Out") api = "logout";
        else if (choice == "get_list_auctions") api = "get_list_auctions";
        else if (choice == "get_list_auctions_by_status") api = "get_list_auctions_by_status";
        else if (choice == "get_list_auctions_by_Type") api = "get_list_auctions_by_Type";
        else if (choice == "get_list_auctions_by_User") api = "get_list_auctions_by_user";
        else if (choice == "get_detail_auction") api = "get_detail_auction";
        else if (choice == "create_auction") api = "create_auction";
        else if (choice == "edit_auction") api = "edit_auction";
        else if (choice == "create_item") api = "create_item";
        else if (choice == "create_comment") api = "create_comment";
        else if (choice == "get_list_comment") api = "get_list_comment";
        else if (choice == "create_bid") api = "create_bid";
        else if (choice == "Get_list_bids") api = "Get_list_bids";
        else if (choice == "Get_list_categories") api = "Get_list_categories";
        else if (choice == "Get_list_brands") api = "Get_list_brands";
        else if (choice == "Accept_max_bid") api = "Accept_max_bid";
        else if (choice == "Contact_us") api = "Contact_us";
        else if (choice == "Like_auction") api = "Like_auction";
        else if (choice == "Get_list_like") api = "Get_list_like";
        else if (choice == "Total_likes_of_auction") api = "Total_likes_of_auction";
        else if (choice == "Get_news") api = "Get_news";
        else if (choice == "Read_new") api = "Read_new";
        else if (choice == "Get_notifications") api = "Get_notifications";
        else if (choice == "Read_notifications") api = "Read_notifications";
        else if (choice == "Get_slider") api = "Get_slider";
        else if (choice == "search") api = "search";
        else if (choice == "delete_comment") api = "delete_comment";
    }
}