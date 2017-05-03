package com.tailoredapps.template;

import android.app.Application;
import android.content.res.Resources;

import com.squareup.leakcanary.LeakCanary;
import com.tailoredapps.template.injection.components.AppComponent;
import com.tailoredapps.template.injection.components.DaggerAppComponent;
import com.tailoredapps.template.injection.modules.AppModule;

import io.reactivex.plugins.RxJavaPlugins;
import io.realm.Realm;
import timber.log.Timber;

/* Copyright 2016 Patrick Löwenstein
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License. */
public class CountriesApp extends Application {

    private static CountriesApp sInstance = null;

    private static AppComponent sAppComponent = null;

    @Override
    public void onCreate() {
        super.onCreate();
        if(LeakCanary.isInAnalyzerProcess(this)) return;

        Timber.plant(new Timber.DebugTree());

        sInstance = this;
        sAppComponent = DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();

        sAppComponent.encryptionKeyManager().initEncryptedRealm();

        RxJavaPlugins.setErrorHandler(Timber::e);
    }

    public static CountriesApp getInstance() { return sInstance; }

    public static AppComponent getAppComponent() { return sAppComponent; }

    public static Realm getRealm() { return sAppComponent.realm(); }

    public static Resources getRes() { return sInstance.getResources(); }
}
