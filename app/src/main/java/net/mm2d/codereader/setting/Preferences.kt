/*
 * Copyright (c) 2021 大前良介 (OHMAE Ryosuke)
 *
 * This software is released under the MIT License.
 * http://opensource.org/licenses/MIT
 */

package net.mm2d.codereader.setting

import android.content.Context
import net.mm2d.codereader.BuildConfig

class Preferences<K>(
    context: Context,
    name: String,
) where K : Enum<*>,
        K : Key {
    val dataStore: SharedPreferenceDataStore =
        SharedPreferenceDataStore(
            context.getSharedPreferences(
                BuildConfig.APPLICATION_ID + "." + name,
                Context.MODE_PRIVATE,
            ),
        )

    fun remove(key: K): Unit =
        dataStore.remove(key.name)

    operator fun contains(key: K): Boolean =
        dataStore.contains(key.name)

    fun readBoolean(key: K, default: Boolean): Boolean {
        key.checkSuffix(default)
        return dataStore.getBoolean(key.name, default)
    }

    fun writeBoolean(key: K, value: Boolean) {
        key.checkSuffix(value)
        dataStore.putBoolean(key.name, value)
    }

    fun readInt(key: K, default: Int): Int {
        key.checkSuffix(default)
        return dataStore.getInt(key.name, default)
    }

    fun writeInt(key: K, value: Int) {
        key.checkSuffix(value)
        dataStore.putInt(key.name, value)
    }

    fun readLong(key: K, default: Long): Long {
        key.checkSuffix(default)
        return dataStore.getLong(key.name, default)
    }

    fun writeLong(key: K, value: Long) {
        key.checkSuffix(value)
        dataStore.putLong(key.name, value)
    }

    fun readString(key: K, default: String): String {
        key.checkSuffix(default)
        return dataStore.getString(key.name, default)!!
    }

    fun writeString(key: K, value: String) {
        key.checkSuffix(value)
        dataStore.putString(key.name, value)
    }
}
