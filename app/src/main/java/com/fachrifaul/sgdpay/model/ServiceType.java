package com.fachrifaul.sgdpay.model;

import android.graphics.drawable.Drawable;

public class ServiceType {

    private String serviceName;
    private Drawable serviceImage;

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public Drawable getServiceImage() {
        return serviceImage;
    }

    public void setServiceImage(Drawable serviceImage) {
        this.serviceImage = serviceImage;
    }
}