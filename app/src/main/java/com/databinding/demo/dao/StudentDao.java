package com.databinding.demo.dao;


import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.databinding.demo.entity.Student;

import java.util.List;


@Dao
public interface StudentDao {

    @Query("SELECT * FROM student ORDER BY studentId DESC")
    List<Student> loadAll();

//    LiveData<List<Student>> loadAll();

    @Query("SELECT * FROM student WHERE studentId IN (:studentIds)")
    List<Student> loadAllByIds(int[] studentIds);

    @Query("SELECT * FROM student WHERE name LIKE :name AND age > :age ")
    List<Student> findByName(String name, int age);


    /**
     * onConflict：默认值是OnConflictStrategy.ABORT，表示当插入有冲突的时候的处理策略。OnConflictStrategy封装了Room解决冲突的相关策略：
     * <p>
     * 1. OnConflictStrategy.REPLACE：冲突策略是取代旧数据同时继续事务。
     * <p>
     * 2. OnConflictStrategy.ROLLBACK：冲突策略是回滚事务。
     * <p>
     * 3. OnConflictStrategy.ABORT：冲突策略是终止事务。
     * <p>
     * 4. OnConflictStrategy.FAIL：冲突策略是事务失败。
     * <p>
     * 5. OnConflictStrategy.IGNORE：冲突策略是忽略冲突。
     *
     * @param student
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Student... student);

    @Delete
    void delete(Student student);

    @Update
    void update(Student student);
}
