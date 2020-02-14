package com.teamttdvlp.memolang.di.builder

import com.teamttdvlp.memolang.di.module.activity.*
import com.teamttdvlp.memolang.di.module.activity.view_flashcard_list.ViewFlashcardListActivityModule
import com.teamttdvlp.memolang.view.activity.*
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder {

//    @ContributesAndroidInjector(modules = [AuthActivityModule::class])
//    abstract fun injectAuthActivity() : AuthActivity

//    @ContributesAndroidInjector(modules = [SignUpActivityModule::class])
//    abstract fun injectSignUpActivity() : SignUpActivity

    @ContributesAndroidInjector(modules = [AddFlashcardActivityModule::class])
    abstract fun injectAddFlashcardActivity() : AddFlashcardActivity

    @ContributesAndroidInjector(modules = [LanguageActivityModule::class])
    abstract fun injectLanguageActivity() : LanguageActivity

    @ContributesAndroidInjector(modules = [EditFlashcardActivityModule::class])
    abstract fun injectEditFlashcardActivity() : EditFlashcardActivity

    @ContributesAndroidInjector(modules = [MenuActivityModule::class])
    abstract fun injectMenuActivity() : MenuActivity

    @ContributesAndroidInjector(modules = [ViewFlashcardListActivityModule::class])
    abstract fun injectViewFlashCardListActivity() : ViewFlashCardListActivity

    @ContributesAndroidInjector(modules = [SearchEditFlashcardActivityModule::class])
    abstract fun injectSearchEditFlashcardActivity() : SearchEditFlashcardActivity

    @ContributesAndroidInjector(modules = [SetUpAccountActivityModule::class])
    abstract fun ịnjectSetUpAccountActivity() : SetUpAccountActivity

    @ContributesAndroidInjector(modules = [SearchVocabularyActivityModule::class])
    abstract fun ịnjectSearchVocabularyActivity() : SearchVocabularyActivity

    @ContributesAndroidInjector(modules = [UseFlashcardActivityModule::class])
    abstract fun ịnjectUseFlashcardActivity() : UseFlashcardActivity

    @ContributesAndroidInjector(modules = [UseFlashcardDoneActivityModule::class])
    abstract fun injectUseFlashcardDoneActivity() : UseFlashcardDoneActivity

    @ContributesAndroidInjector(modules = [SearchEngVNDictionaryModule::class])
    abstract fun injectSearchEngVNActivity() : SearchEngVNDictionaryActivity

    @ContributesAndroidInjector(modules = [SeeVocabularyActivityModule::class])
    abstract fun injectSeeVocabularyAcitivty() : SeeVocabularyActivity

    @ContributesAndroidInjector(modules = [ReviewFlashcardActivityModule::class])
    abstract fun injectReviewFlashcardActivity() : ReviewFlashcardActivity

    @ContributesAndroidInjector(modules = [ReviewFlashcardEasyActivityModule::class])
    abstract fun injectReviewFlashcardEasyActivity() : ReviewFlashcardEasyActivity

}