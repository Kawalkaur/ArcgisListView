package com.example.kawal.arcgislistview;

import android.net.Uri;

/**
 * Created by kawaldeep on 1/29/2018.
 */

public class Util {

    public static final int DB_VERSION = 1;
    public static final String DB_NAME = "arcgislist.db";

    public static final String TAB_NAME = "Users";
    public static final String ID = "ID";
    public static final String NAME = "NAME";
    public static final String EMAIL = "EMAIL";
    public static final String PHONE = "PHONE";
    public static final String PASSWORD = "PASSWORD";



    public static final String CREATE_TEB_QUERY = "create table Users(" +
            "_ID integer primary key autoincrement," +
            "Name text,"+
            "Email text,"+
            "Phone text,"+
            "Password text"+
            ")";

    public static final Uri User_URI = Uri.parse("content://com.example.kawal.arcgislistview.usercontentprovider/"+TAB_NAME);


}
