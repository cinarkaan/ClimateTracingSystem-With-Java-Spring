package com.weather.forecast.Model.DB.TemplateMethod;

import com.weather.forecast.Model.DB.DAO.UserPublishedDao;
import com.weather.forecast.Model.DB.Entity.UserData;

import java.util.ArrayList;

public class GetUserData extends Data {

    ArrayList <UserData> userDataList;
    UserPublishedDao userPublishedDao;

    public GetUserData () {
        run();
    }

    @Override
    public void Initialize () {
        userPublishedDao = new UserPublishedDao();
        System.out.println("Veritabanina erişim hazırlandı");
    }

    @Override
    public void prepareData () {
        userDataList = new ArrayList<>();
        System.out.println("Veri listesi hazırlandı");
    }

    @Override
    public void Finish () {
        userDataList = userPublishedDao.Read();
    }


    @Override
    public void run () {
           Initialize();
           prepareData();
           Finish();
    }

    public ArrayList<UserData> getList () {
        return userDataList;
    }

}
