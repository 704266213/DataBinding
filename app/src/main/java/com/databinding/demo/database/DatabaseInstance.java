package com.databinding.demo.database;

import androidx.room.Room;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.databinding.demo.DataBindApplication;

public class DatabaseInstance {

    private AppDatabase appDatabase;


    private DatabaseInstance() {
        /**
         *   * 默认值是FrameworkSQLiteOpenHelperFactory，设置数据库的factory。比如我们想改变数据库的存储路径可以通过这个函数来实现
         *  public RoomDatabase.Builder<T> openHelperFactory(@Nullable SupportSQLiteOpenHelper.Factory factory);
         *
         *    * 设置数据库升级(迁移)的逻辑
         *    public RoomDatabase.Builder<T> addMigrations (@NonNull Migration...migrations);
         *
         *    * 设置是否允许在主线程做查询操作
         *    public RoomDatabase.Builder<T> allowMainThreadQueries ();
         *
         *    * 设置数据库的日志模式
         *    public RoomDatabase.Builder<T> setJournalMode (@NonNull JournalMode journalMode);
         *
         *    * 设置迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
         *    public RoomDatabase.Builder<T> fallbackToDestructiveMigration ();
         *
         *    * 设置从某个版本开始迁移数据库如果发生错误，将会重新创建数据库，而不是发生崩溃
         *    public RoomDatabase.Builder<T> fallbackToDestructiveMigrationFrom ( int...startVersions);
         *
         *   * 监听数据库，创建和打开的操作
         *   public RoomDatabase.Builder<T> addCallback (@NonNull RoomDatabase.Callback callback);
         */
        appDatabase = Room.databaseBuilder(DataBindApplication.getDataBindContext(), AppDatabase.class, "room.db")
               . allowMainThreadQueries()
                .addMigrations(MIGRATION_1_2,MIGRATION_2_3)
                .build();
    }

    private static class DatabaseHolder {
        static DatabaseInstance databaseInstance = new DatabaseInstance();
    }

    public static DatabaseInstance getDatabaseInstance() {
        return DatabaseHolder.databaseInstance;
    }

    public AppDatabase getAppDatabase() {
        return appDatabase;
    }


    /**
     * 数据库版本 1->2 user表格新增了age列
     */
    static final Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE student ADD COLUMN sex INTEGER NOT NULL DEFAULT ((1))");
        }
    };

    /**
     * 数据库版本 2->3 新增book表格
     */
    static final Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(SupportSQLiteDatabase database) {
            database.execSQL(
                    "CREATE TABLE IF NOT EXISTS `teacher` (`id` INTEGER PRIMARY KEY autoincrement NOT NULL, `teacherName` TEXT)");
        }
    };

}
