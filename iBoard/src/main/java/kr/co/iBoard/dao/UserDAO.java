package kr.co.iBoard.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserDAO {
    public void insertUser();
    public void selectUser();
    public void updateUser();
    public void deleteUser();
}
