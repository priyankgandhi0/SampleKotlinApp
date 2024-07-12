/*
package com.demo.structure.application
import android.app.Application
import com.example.sampleapp.injection.component.ApplicationComponent
import com.example.sampleapp.injection.component.SubAppComponent

*/
/**
 * Created By Hardik Koladiya,Android,UNIKWORD LLP
 *//*

class MyApplication : Application() {
    var applicationComponent: ApplicationComponent? = null
    var subAppComponent: SubAppComponent? = null
    var value: Boolean = false

    override fun onCreate() {
        super.onCreate()


        */
/**
         * `RULES` :-
         * 1) @Component defines with @Singleton here creates Application level @Singleton
         * 2) make sure to give @Singleton tag to @Component defined here to make application level @Singleton
         * 3) all rules applicable to @SubComponent
         * 4) is you crate @Component or @SubComponent object in activity is activity wide @Singleton if class declared @Singleton
         * 5) `factory().create()` is method for pass value in component or component throught module
         * 6) do not create @SubComponent @Singleton if parent @Compoentn is @Singleton
         * 7)
         *//*

        */
/**
         * initialise @Component object  *//*

        applicationComponent = DaggerApplicationComponent.factory().create(this)


        */
/**
         * `NOTE`:
         * 1) inject this application class in component thats why we use any object of component and module in this class
         *//*

        applicationComponent!!.inject(this)
        */
/***
         * initialise @SubComponent object  *//*

        subAppComponent = applicationComponent!!.subAppComponent!!.create(2)
    }

    */
/**
     * `NOTES`:-
     * get @@@SubComponent from here
     * 1) I can get all dependencies of @Component from this @SubComponent
     * 2) i can't get dependencies of @SubComponent from @Component
     *//*

    */
/**
     * get @@@Component from here
     *//*

    fun applicationComponent(): ApplicationComponent? {
        return applicationComponent
    }

    */
/**
     * get @@@SubComponent from here
     *//*

    fun subAppComponent(): SubAppComponent? {
        return subAppComponent
    }


}*/
