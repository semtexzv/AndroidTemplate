package com.patloew.countries.dagger;

import android.app.Application;

import com.patloew.countries.dagger.scopes.PerApplication;
import com.patloew.countries.viewmodel.MainActivityViewModel;

import javax.inject.Named;

import dagger.Component;
import io.realm.Realm;

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
@PerApplication
@Component(modules={AppModule.class, NetModule.class})
public interface AppComponent {
    void inject(MainActivityViewModel mainActivityViewModel);

    Application app();
    Realm realm();

    @Named("mapsAvailable") boolean mapsAvailable();
}
