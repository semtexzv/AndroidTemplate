/* Copyright 2017 Tailored Media GmbH
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
 * limitations under the License.*/

package com.tailoredapps.template.ui.base.feedback

import android.app.Activity
import android.support.annotation.StringRes


interface Snacker {
    val activity: Activity
    val defaultActionText: CharSequence

    fun show(title: CharSequence, action: (() -> Unit)? = null, actionText: CharSequence? = null)
    fun show(title: CharSequence, action: (() -> Unit)? = null, @StringRes actionText: Int? = null)

    fun show(@StringRes titleRes: Int, action: (() -> Unit)? = null, actionText: CharSequence? = null)
    fun show(@StringRes titleRes: Int, action: (() -> Unit)? = null, @StringRes actionText: Int? = null)

    fun hideActionSnack()
    fun hideSnack()
}