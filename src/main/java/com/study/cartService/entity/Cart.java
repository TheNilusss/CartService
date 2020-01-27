package com.study.cartService.entity;

import org.springframework.data.annotation.Id;

import java.util.ArrayList;
import java.util.List;

public class Cart {

    @Id
    String ID;

    String CID; //CustomerID
    ArrayList<String> selectedItems = new ArrayList<String>(); //selectedIDs

    public Cart() {
    }

    public Cart(String customer_id) {
        CID = customer_id;
    }

    public List<String> getSelectedItems() {
        return selectedItems;
    }

    public void setSelectedItems(ArrayList<String> selectedItems) {
        this.selectedItems = selectedItems;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    @Override
    public String toString() {
        String l_string = "";
        l_string = "CartID= " + ID +
                " CustomerID= " + CID +
                " SelectedIDs= " + selectedItems.size() + " == ";

        for (int i = 0; i < selectedItems.size(); i++)
        {
            l_string = l_string + selectedItems.get(i) + ",";
        }

        return l_string;
    }
}