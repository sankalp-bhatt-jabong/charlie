package com.jabong.services.response.fields.bundle;

import java.util.List;

public class BundleToSkuFields {
    private int id;
    private List<?> skuList;
    public int getId()
    {
        return id;
    }
    public void setId(int id)
    {
        this.id = id;
    }
    public List<?> getSkuList()
    {
        return skuList;
    }
    public void setSkuList(List<?> skuList)
    {
        this.skuList = skuList;
    }
    
    
}