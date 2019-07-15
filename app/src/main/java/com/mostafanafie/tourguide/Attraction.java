package com.mostafanafie.tourguide;

public class Attraction {

    private String mName;
    private String mDescription;
    private int mImageResourceId;

    // Constructor
    public Attraction(String name, String description, int imageResourceId) {
        mName = name;
        mDescription = description;
        mImageResourceId = imageResourceId;
    }

    // Get the attraction name
    public String getName() {
        return mName;
    }

    // Get the attraction description
    public String getDescription() {
        return mDescription;
    }

    // Get the image resource ID
    public int getImageResourceId() {
        return mImageResourceId;
    }

}
