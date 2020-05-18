package com.weather.forecast.Model.DB.Facade;

import com.weather.forecast.Model.DB.DAO.UserPublishedDao;
import com.weather.forecast.Model.DB.DAO.UsersDao;
import com.weather.forecast.Model.DB.DAO.UserPropertiesDao;
import com.weather.forecast.Model.DB.Entity.UserProperties;
import com.weather.forecast.Model.DB.Entity.UserPublished;
import com.weather.forecast.Model.DB.Entity.Users;

public class Facade {

    private String id;
    private String password;
    private boolean isHasSuccesfuly;

    private UserProperties userProperties;
    private UserPropertiesDao userPropertiesDao;
    private UsersDao usersDao;
    private Users usersEntity;
    private UserPublished userPublished;
    private UserPublishedDao userPublishedDao;

    public Facade () {
        this.userProperties = new UserProperties();
        this.userPropertiesDao = new UserPropertiesDao();
        this.usersEntity = new Users();
        this.usersDao = new UsersDao();
        this.userPublished = new UserPublished();
        this.userPublishedDao = new UserPublishedDao();
    }

    public boolean signIn () {
        usersEntity.setId(id);
        usersEntity.setPassword(password);
        isHasSuccesfuly = usersDao.Read(usersEntity);
        usersEntity.setUser_id(usersDao.getUser_id(id));
        userProperties.setUser_id(usersEntity.getUser_id());
        this.userProperties = userPropertiesDao.Read(userProperties);
        System.out.println("Record has been find on database!!!!");
        return isHasSuccesfuly;
    }

    public boolean signUp () {
        usersEntity.setId(id);
        usersEntity.setPassword(password);
        isHasSuccesfuly = usersDao.Create(usersEntity);
        usersEntity.setUser_id(usersDao.getUser_id(id));
        userProperties.setUser_id(usersEntity.getUser_id());
        isHasSuccesfuly = (isHasSuccesfuly && userPropertiesDao.Create(userProperties))==true ? true : false;
        return isHasSuccesfuly;
    }

    public void updateProfile (Long user_id) {
        userProperties.setUser_id(user_id);
        userPropertiesDao.Update(userProperties);
    }

    public boolean CreatePublish (Long user_id) {
        userPublished.setUser_id(user_id);
        return userPublishedDao.Create(userPublished);
    }

    public boolean UpdatePublish (Long user_id) {
        userPublished.setUser_id(user_id);
        return userPublishedDao.Update(userPublished);
    }

    // Encapsulations
    public UserProperties getUserProperties() {
        return userProperties;
    }

    public UserPropertiesDao getUserPropertiesDao() {
        return userPropertiesDao;
    }

    public UsersDao getUsersDao() {
        return usersDao;
    }

    public Users getUsersEntity() {
        return usersEntity;
    }

    public UserPublished getUserPublished() {
        return userPublished;
    }

    public UserPublishedDao getUserPublishedDao() {
        return userPublishedDao;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
