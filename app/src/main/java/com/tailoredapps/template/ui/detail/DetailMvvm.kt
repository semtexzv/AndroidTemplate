package com.tailoredapps.template.ui.detail

import android.databinding.ObservableBoolean
import android.databinding.ObservableField

import com.tailoredapps.template.ui.ICountryViewModel
import com.tailoredapps.template.ui.base.view.MvvmView

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
interface DetailMvvm {

    interface View : MvvmView

    interface ViewModel : ICountryViewModel<View> {
        // Properties

        val isLoaded: ObservableBoolean
        val borders: ObservableField<CharSequence>
        val currencies: ObservableField<CharSequence>
        val languages: ObservableField<CharSequence>
        val nameTranslations: ObservableField<CharSequence>
    }
}