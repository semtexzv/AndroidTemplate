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

import android.support.annotation.StringRes
import android.support.v4.app.FragmentActivity
import android.widget.Toast


class ActivityToaster(override val activity: FragmentActivity) : Toaster {
    private var toast: Toast? = null

    override fun show(title: String) {
        showInternal(title)
    }

    override fun show(@StringRes titleRes: Int) {
        showInternal(activity.getString(titleRes))
    }

    private fun showInternal(title: String) {
        toast = Toast.makeText(activity, title, Toast.LENGTH_LONG)
        toast?.show()
    }

    override fun hide() {
        toast?.cancel()
        toast = null
    }
}