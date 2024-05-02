package com.hotelbooking.dto;

import com.hotelbooking.entity.Property;
import com.hotelbooking.entity.PropertyUser;

public class FavouriteDto {
    private boolean isFavourite;
    private Property property;
    private PropertyUser propertyUser;

    public boolean getIsFavourite() {
        return isFavourite;
    }

    public void setIsFavourite(boolean favourite) {
        isFavourite = favourite;
    }

    public Property getProperty() {
        return property;
    }

    public void setProperty(Property property) {
        this.property = property;
    }

    public PropertyUser getPropertyUser() {
        return propertyUser;
    }

    public void setPropertyUser(PropertyUser propertyUser) {
        this.propertyUser = propertyUser;
    }
}
