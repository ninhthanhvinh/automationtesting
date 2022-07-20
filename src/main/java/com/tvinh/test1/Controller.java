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
        apiChoice.getItems().addAll("1, Login", "2, Edit", "3, Sign Up", "4, Log Out",
                "5, Change_PassWord", "6, Info", "7, get_list_auctions", "8, get_list_auctions_by_status",
                "9, get_detail_auction", "10, create_auction", "11, edit_auction", "12, create_item",
                "13, get_list_comment", "14, create_bid", "15, Get_list_bids", "16, Get_list_categories",
                "17, Get_list_brands", "18, Accept_max_bid", "19, Contact_us", "20, Like_auction",
                "21, Get_list_like", "22, Total_likes_of_auction", "23, Get_news", "24, Read_new",
                "25, Get_notifications", "26, Get_slider", "27, search", "28, UploadStatus",
                "29, Info_auction", "30, Info_Item");
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
        else if (Objects.equals(api, "ChangePass")){
            ChangePassTest hien = new ChangePassTest();
            hien.call();
        }
        else if (Objects.equals(api, "info")){
            InfoTest hien = new InfoTest();
            hien.call();
        }
        else if (Objects.equals(api, "get_list_auctions")){
            GetListAuctionTest getAuction = new GetListAuctionTest();
            getAuction.call();
        }
        else if (Objects.equals(api, "get_list_auctions_by_status")){
            GetListAuctionsByStatusTest getAuctionStatus = new GetListAuctionsByStatusTest();
            getAuctionStatus.call();
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
        else if (Objects.equals(api, "Get_slider")){
            Get_slider hien = new Get_slider();
            hien.call();
        }
        else if (Objects.equals(api, "search")){
            Search hien = new Search();
            hien.call();
        }
        else if (Objects.equals(api, "UploadStatus")){
            UploadStatusTest hien = new UploadStatusTest();
            hien.call();
        }
        else if (Objects.equals(api, "Info_auction")){
            Info_auction hien = new Info_auction();
            hien.call();
        }
        else if (Objects.equals(api, "Info_Item")){
            Info_Item hien = new Info_Item();
            hien.call();
        }
    }

    public void setUriChoice(ActionEvent event){
        String choice = uriChoice.getValue();
        if (choice == "heroku2") baseuri = "https://auctions-app-2.herokuapp.com/api";
        else baseuri = "https://auction-app3.herokuapp.com/api";
    }
    public void Clear(){
        textAreaGUI.clear();
    }
    public void setApiChoice(ActionEvent event){
        String choice = apiChoice.getValue();
        if (choice == "1, Login") api = "login";
        else if (choice == "2, Sign Up") api = "signup";
        else if (choice == "3, Edit") api = "edit";
        else if (choice == "4, Log Out") api = "logout";
        else if (choice == "5, Change_PassWord") api = "ChangePass";
        else if (choice == "6, Info") api = "info";
        else if (choice == "7, get_list_auctions") api = "get_list_auctions";
        else if (choice == "8, get_list_auctions_by_status") api = "get_list_auctions_by_status";
        else if (choice == "9, get_detail_auction") api = "get_detail_auction";
        else if (choice == "10, create_auction") api = "create_auction";
        else if (choice == "11, edit_auction") api = "edit_auction";
        else if (choice == "12, create_item") api = "create_item";
        else if (choice == "13, get_list_comment") api = "get_list_comment";
        else if (choice == "14, create_bid") api = "create_bid";
        else if (choice == "15, Get_list_bids") api = "Get_list_bids";
        else if (choice == "16, Get_list_categories") api = "Get_list_categories";
        else if (choice == "17, Get_list_brands") api = "Get_list_brands";
        else if (choice == "18, Accept_max_bid") api = "Accept_max_bid";
        else if (choice == "19, Contact_us") api = "Contact_us";
        else if (choice == "20, Like_auction") api = "Like_auction";
        else if (choice == "21, Get_list_like") api = "Get_list_like";
        else if (choice == "22, Total_likes_of_auction") api = "Total_likes_of_auction";
        else if (choice == "23, Get_news") api = "Get_news";
        else if (choice == "24, Read_new") api = "Read_new";
        else if (choice == "25, Get_notifications") api = "Get_notifications";
        else if (choice == "26, Get_slider") api = "Get_slider";
        else if (choice == "27, search") api = "search";
        else if (choice == "28, UploadStatus") api = "UploadStatus";
        else if (choice == "29, Info_auction") api = "Info_auction";
        else if (choice == "30, Info_Item") api = "Info_Item";
    }
}