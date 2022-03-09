package com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.User;

import androidx.room.Dao;
import androidx.room.Query;

import com.mostafa.ustask_mostafaibrahim.Repository.Database.Models.BaseDao.BaseDao;


@Dao
public interface UserDao extends BaseDao<User> {

    @Query("SELECT * FROM User")
    User getUser();

    @Query("DELETE FROM User")
    void deleteAll();


}
