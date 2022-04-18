/*
 * Copyright 2021 Paulo Pereira
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge.domain.models

import com.example.androiddevchallenge.presentation.searchbarcomponents.autocomplete.AutoCompleteEntity
import java.util.Locale

data class Quiz(
    val name: String,
    val description: String
) : AutoCompleteEntity
{
    override fun filter(query: String): Boolean
    {
        return name.toLowerCase(Locale.getDefault())
            .startsWith(query.toLowerCase(Locale.getDefault()))
    }
}
