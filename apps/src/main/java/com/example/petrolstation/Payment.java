package com.example.petrolstation;

public class Payment {
    int _id;
    String _fuelType;
    String _fuelQuantity;
    String _totalPrice;

    public Payment(){   }
    public Payment(int _id,String fuelType, String fuelQuantity, String totalPrice){
        this._id = _id;
        this._fuelType = _fuelType;
        this._fuelQuantity = _fuelQuantity;
        this._totalPrice = _totalPrice;
    }

    public Payment(String s, String string, String cursorString){
        this._fuelType = _fuelType;
        this._fuelQuantity = _fuelQuantity;
        this._totalPrice = _totalPrice;
    }


    public int getID(){
        return this._id;
    }

    public void setID(int id){
        this._id = id;
    }

    public String getFuelType(){
        return this._fuelType;
    }

    public void setFuelType(String fuelType){
        this._fuelType = fuelType;
    }

    public String getFuelQuantity(){
        return this._fuelQuantity;
    }

    public void setFuelQuantity(String fuelQuantity){
        this._fuelQuantity = fuelQuantity;
    }

    public String getTotalPrice(){
        return this._totalPrice;
    }

    public void setTotalPrice(String totalPrice){
        this._totalPrice = totalPrice;
    }

}