package com.teamttdvlp.memolang.di.module

import androidx.room.Room
import com.google.firebase.auth.FirebaseAuth
//import com.google.firebase.firestore.FirebaseFirestore
import com.teamttdvlp.memolang.di.MemoLang
import com.teamttdvlp.memolang.database.MemoLangSqliteDataBase
import com.teamttdvlp.memolang.database.MemoLangSqliteDataBase.Companion.DB_NAME
import com.teamttdvlp.memolang.database.sql.repository.FlashcardRepository
import com.teamttdvlp.memolang.database.sql.repository.UserRepository
import com.teamttdvlp.memolang.database.sql.repository.UserSearchHistoryRepository
import com.teamttdvlp.memolang.model.RecentAddedFlashcardManager
import com.teamttdvlp.memolang.view.activity.MenuActivity
import com.teamttdvlp.memolang.viewmodel.auth.AuthManager
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {

    @Provides
    @Singleton
    fun providesUserRepository (dataBase: MemoLangSqliteDataBase) : UserRepository {
        return UserRepository(dataBase)
    }

    @Provides
    @Singleton
    fun providesFlashcardRepository (dataBase: MemoLangSqliteDataBase) : FlashcardRepository{
        return FlashcardRepository(dataBase)
    }

    @Provides
    @Singleton
    fun provideUserSearchHistoryRepository (database : MemoLangSqliteDataBase) : UserSearchHistoryRepository {
        return UserSearchHistoryRepository(database)
    }

    @Provides
    @Singleton
    fun providesSqliteDatabase (application: MemoLang) : MemoLangSqliteDataBase {
        return Room
            .databaseBuilder(application, MemoLangSqliteDataBase::class.java, DB_NAME)
            .build()
    }


    @Provides
    @Singleton
    fun providesFirebaseAuthManager (firebaseAuth: FirebaseAuth, application: MemoLang) : AuthManager {
        return AuthManager(firebaseAuth, application)
    }

    @Provides
    @Singleton
    fun providesFirebaseAuth () : FirebaseAuth{
        return FirebaseAuth.getInstance()
    }


    @Provides
    @Singleton
    fun provideRecentAddedCardManager (context : MemoLang, flashcardRepository: FlashcardRepository) : RecentAddedFlashcardManager {
        return RecentAddedFlashcardManager(context, flashcardRepository)
    }
}