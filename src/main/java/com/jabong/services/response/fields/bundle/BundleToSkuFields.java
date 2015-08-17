package com.jabong.services.response.fields.bundle;

import java.util.List;

public class BundleToSkuFields
{
    private int id;
    private List<String> sku_list;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public List<String> getSku_list()
    {
        return sku_list;
    }

    public void setSku_list(List<String> sku_list)
    {
        this.sku_list = sku_list;
    }

}